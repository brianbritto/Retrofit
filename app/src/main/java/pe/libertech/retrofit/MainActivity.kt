package pe.libertech.retrofit

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Peticion().execute()

    }

    class Peticion : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg params: Unit) {
            val URL = "https://androidtutorials.herokuapp.com/"

            val retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create(ServicesTutorial::class.java)

            val response = service.getUsersPost()

            for (user: ResponseService in response.execute().body()!!){
                Log.e("Respuesta:   ", "${user.name} ${user.nickName}")
            }


        }

    }
}
