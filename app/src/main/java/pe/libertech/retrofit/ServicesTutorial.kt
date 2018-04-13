package pe.libertech.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ServicesTutorial {

    @GET("usersFake")
    fun getUsersGet(): Call<List<ResponseService>>

    @POST("usersFake")
    fun getUsersPost(): Call<List<ResponseService>>

}