package com.learn.plantixtask.domain

import com.learn.plantixtask.data.repository.NamesRepository
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class GetNamesUseCase @Inject constructor(private val repository: NamesRepository) {
    fun getNames(): Observable<List<String>> {
        return repository.getNames()
    }

}