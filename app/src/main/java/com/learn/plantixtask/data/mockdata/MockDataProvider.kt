package com.learn.plantixtask.data.mockdata

import io.reactivex.Observable
import javax.inject.Inject

class MockDataProvider @Inject constructor() {
    fun getNames(): Observable<List<String>> {
        return Observable.just(listOf("sam", "jack", "john", "jimmy", "reena"))
    }
}