package com.patel.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patel.retrofit.Module.Post
import com.patel.retrofit.repository.Repository
import kotlinx.coroutines.launch
import okhttp3.Response
import retrofit2.http.OPTIONS
import retrofit2.http.POST

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<retrofit2.Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<retrofit2.Response<Post>> = MutableLiveData()
    val myCustomResponse : MutableLiveData<retrofit2.Response<List<Post>>> = MutableLiveData()
    val myCustomResponse2 : MutableLiveData<retrofit2.Response<List<Post>>> = MutableLiveData()

    fun pushPost(post: POST){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response

        }
    }

    fun getPost(){
        viewModelScope.launch {
            val response: retrofit2.Response<Post> = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response:retrofit2.Response<Post> = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPost(userId : Int, sort : String, order : String){
        viewModelScope.launch {
            val response:retrofit2.Response<List<Post>> = repository.getCustomPost(userId,sort, order)
            myCustomResponse.value = response
        }
    }

    fun getCustomPost2(userId: Int,options: Map<String,String>){
        viewModelScope.launch {
            val response:retrofit2.Response<List<Post>> = repository.getCustomPost2(userId,options)
            myCustomResponse2.value = response
        }
    }




}