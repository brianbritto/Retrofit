package pe.libertech.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://androidtutorials.herokuapp.com/"

        val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service : ServicesTutorial = retrofit.create(ServicesTutorial::class.java)

        val call = service.findUserGet(1)

        call.enqueue(object : Callback<ResponseService>{
            override fun onResponse(call: Call<ResponseService>?, response: Response<ResponseService>?) {
                val user : ResponseService = response?.body()!!
                Log.e("User: ", "${user.id} ${user.name}" )
            }

            override fun onFailure(call: Call<ResponseService>?, t: Throwable?) {
                Log.e("onFailure", t.toString())
            }
        })

        /* val call : Call<List<ResponseService>> = service.getUsersPost()

        call.enqueue(object : Callback<List<ResponseService>>{

            override fun onResponse(call: Call<List<ResponseService>>?, response: Response<List<ResponseService>>?) {
                if (response != null) {
                    for (res: ResponseService in response.body()!!){
                        Log.e("Usuario", "${res.id} ${res.nickName}")
                    }
                }
            }

            override fun onFailure(call: Call<List<ResponseService>>?, t: Throwable?) {
                Log.e("onFailure", t.toString())
            }
        })*/

        // Peticion().execute()

    }

     /* class Peticion : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg params: Unit) {
            val url = "https://androidtutorials.herokuapp.com/"

            val retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create(ServicesTutorial::class.java)

            val response = service.getUsersPost()

            try {
                for (user: ResponseService in response.execute().body()!!){
                    Log.e("Respuesta:   ", "${user.name} ${user.nickName}")
                }
            }catch (e : IOException){
                e.printStackTrace()
            }


        }

    }*/
}
