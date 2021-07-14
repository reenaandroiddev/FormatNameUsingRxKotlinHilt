package com.learn.plantixtask.data.repository

import com.learn.plantixtask.data.mockdata.MockDataProvider
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

class NamesRepositoryTest {
    private val mockDataProvider: MockDataProvider = mock()

    lateinit var namesRepository: NamesRepository

    @Before
    fun setUp() {
        namesRepository = NamesRepository(mockDataProvider)
    }

    @Test
    fun `get names from source and send observable to observer`() {
        //Arrange
        whenever(mockDataProvider.getNames()).thenReturn(
            Observable.just(
                listOf(
                    "sam",
                    "jack",
                    "john",
                    "jimmy",
                    "reena"
                )
            )
        )

        //Act
        namesRepository.getNames()

        //Assert
        verify(mockDataProvider, times(1)).getNames()

    }

}