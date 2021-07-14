package com.learn.plantixtask.domain

import com.learn.plantixtask.data.repository.NamesRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test


class GetNamesUseCaseTest {
    private val repository: NamesRepository = mock()
    lateinit var getNamesUseCase: GetNamesUseCase

    @Before
    fun setUp() {
        getNamesUseCase = GetNamesUseCase(repository)
    }

    @Test
    fun `get names from source and send observable to observer`() {
        //Arrange
        whenever(repository.getNames()).thenReturn(
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

//        //Act
        getNamesUseCase.getNames()

        verify(repository, times(1)).getNames()

    }
}