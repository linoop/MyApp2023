package com.linoop.myapp2023.viewmodels

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.linoop.myapp2023.getOrAwaitValue
import com.linoop.myapp2023.models.LoginResponse
import com.linoop.myapp2023.network.Api
import com.linoop.myapp2023.repository.MyRepo
import com.linoop.myapp2023.storage.MyPreference

import junit.framework.TestCase
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest : TestCase() {

    private lateinit var api: Api
    private lateinit var myPreference: MyPreference
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var context: Context

    @Before
    public override fun setUp() {
        context = mock()
        api = Mockito.mock(Api::class.java)
        myPreference = Mockito.mock(MyPreference::class.java)
        val myRepo = MyRepo(api, myPreference)
        viewModel = MainViewModel(myRepo)
    }

    @Test
    fun setupMockApi() {
        assertThat(true).isTrue()
    }

    @After
    public override fun tearDown() {
    }

    @Test
    fun signup() {
    }

    @Test
    fun login() = runBlocking {
        Mockito.`when`(api.login("syed@gmail.com", "12345"))
            .thenReturn(
                Response.success(LoginResponse(status = true, message = "Login Success", token = "12345678", id = 10, email = "syed@gmail.com"))
            )
        Mockito.`when`(api.login("linoop@gmail.com", "22222"))
            .thenReturn(
                Response.success(LoginResponse(status = false, message = "Login Failure"))
            )
        val result = viewModel.login("syed@gmail.com", "12345").getOrAwaitValue()

        assertThat(result!!.status).isTrue()
        /*val result1 = viewModel.login("linoop@gmail.com", "v").getOrAwaitValue()
        result1?.let {
            assertThat(it.status).isFalse()
        }*/
    }

    @Test
    fun testBaseUrl(){
        saveBaseUrl("12345")
    }
    fun saveBaseUrl(baseUrl: String){
        Mockito.`when`(myPreference.setBaseUrl(baseUrl)).thenReturn(true)
        Mockito.`when`(myPreference.getBaseUrl()).thenReturn(baseUrl)
        val result = viewModel.getBaseUrl()
        val setResult = viewModel.setBaseUrl(baseUrl)
        assertThat(setResult).isEqualTo(true)
        assertThat(result).isEqualTo(baseUrl)
    }
}