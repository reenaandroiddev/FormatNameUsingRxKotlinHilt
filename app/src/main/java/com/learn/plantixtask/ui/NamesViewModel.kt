package com.learn.plantixtask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.plantixtask.domain.GetNamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NamesViewModel @Inject constructor(private val getNamesUseCase: GetNamesUseCase) :
    ViewModel() {

    val namesList = MutableLiveData<List<String>>()
    val error = MutableLiveData<String>()

    lateinit var disposable: Disposable

    fun getNames() {
        disposable = getNamesUseCase.getNames().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Observable.fromIterable(it).map { it.capitalize(Locale.ROOT) }.toList()
                    .toObservable()
            }
            .subscribe(this::onGetNamesSuccess, this::onApiError)
    }

    private fun onGetNamesSuccess(names: List<String>) {
        namesList.value = names
    }

    private fun onApiError(t: Throwable) {
        error.value = t.message
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}