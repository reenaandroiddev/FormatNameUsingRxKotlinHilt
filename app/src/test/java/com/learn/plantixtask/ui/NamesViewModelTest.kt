package com.learn.plantixtask.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learn.plantixtask.domain.GetNamesUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class NamesViewModelTest {

    @get:Rule
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val getNamesUseCase: GetNamesUseCase = mock()
    lateinit var namesViewModel: NamesViewModel

    @Before
    fun setUp() {
        namesViewModel = NamesViewModel(getNamesUseCase)
    }

    @Test
    fun `get names from source and notify  to UI`() {
        //Arrange
        whenever(getNamesUseCase.getNames()).thenReturn(
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
        namesViewModel.getNames()

        //Assert
        val nameList = namesViewModel.namesList.value
        assertEquals("Sam", nameList?.get(0))
    }

    @Test
    fun `get names from source and throw error`() {
        //Arrange
        whenever(getNamesUseCase.getNames()).thenReturn(
            Observable.error(Throwable("error"))
        )

        //Act
        namesViewModel.getNames()

        //Assert
        assertEquals("error", namesViewModel.error.value)
    }
}


class RxImmediateSchedulerRule : TestRule {

    override fun apply(base: Statement, d: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
                RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
                RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }
}