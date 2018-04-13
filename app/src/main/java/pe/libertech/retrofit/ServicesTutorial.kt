package pe.libertech.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ServicesTutorial {

    @GET("usersFake")
    fun getUsersGet(): Call<List<ResponseService>>

    @POST("usersFake")
    fun getUsersPost(): Call<List<ResponseService>>

    // https://androidtutorials.herokuapp.com/findUser?id=1
    @GET("findUser")
    fun findUserGet(@Query("id") idUser:Int) : Call<ResponseService>

}