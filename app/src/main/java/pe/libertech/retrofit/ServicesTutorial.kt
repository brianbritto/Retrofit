package pe.libertech.retrofit

import retrofit2.Call
import retrofit2.http.*

interface ServicesTutorial {

    @GET("usersFake")
    fun getUsersGet(): Call<List<ResponseService>>

    @POST("usersFake")
    fun getUsersPost(): Call<List<ResponseService>>

    // https://androidtutorials.herokuapp.com/findUser?id=1
    @GET("findUser")
    fun findUserGet(@Query("id") idUser:Int) : Call<ResponseService>

    @FormUrlEncoded
    @POST("findUserPost")
    fun findUserPost(@Field("name") nombre :String) : Call<String>

}