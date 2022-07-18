package com.patel.retrofit.api

import com.patel.retrofit.Module.Post
import okhttp3.Response
import retrofit2.http.*

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost() : retrofit2.Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number : Int
    ):retrofit2.Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId : Int,
        @Query("sort") sort : String,
        @Query("order") order : String

    ) : retrofit2.Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPost2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String,String>
    ): retrofit2.Response<List<Post>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ) : retrofit2.Response<Post>
}