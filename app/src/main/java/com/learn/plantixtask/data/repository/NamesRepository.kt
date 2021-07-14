package com.learn.plantixtask.data.repository

import com.learn.plantixtask.data.mockdata.MockDataProvider
import io.reactivex.Observable
import javax.inject.Inject

/**
 *To support dynamic content we need to inject API service (Remote Data) and DataSource (Local DB)
 * currently we are using only mock data hence fetching data from MockDataProvider
 */
class NamesRepository @Inject constructor(private val mockDataProvider: MockDataProvider) {

    /**
     *Before returning list of names we need to check if the names are present in local DB .
     *  If not then make api call  to fetch the names and store them in to local db like Room.
     */
    fun getNames(): Observable<List<String>> {
        return mockDataProvider.getNames()
    }
}