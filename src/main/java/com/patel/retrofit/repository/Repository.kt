package com.patel.retrofit.repository

import com.patel.retrofit.Module.Post
import com.patel.retrofit.api.RetrofitInstance
import okhttp3.Response
import retrofit2.http.OPTIONS

class Repository {


     suspend fun getPost() : retrofit2.Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number : Int) : retrofit2.Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId : Int, sort : String, order : String) : retrofit2.Response<List<Post>> {
        return  RetrofitInstance.api.getCustomPost(userId,sort,order)
    }
    suspend fun getCustomPost2(userId: Int,options: Map<String,String>):retrofit2.Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost2(userId,options)
    }

    suspend fun pushPost(post: Post):retrofit2.Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }

}