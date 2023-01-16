package id.gustonecrush.androidquranapp.Retrofit.API

import id.gustonecrush.androidquranapp.Retrofit.Responses.QuranResponse
import retrofit2.Call
import retrofit2.http.GET

interface QuranAPI {

    @GET("quran")
    fun getQuran(): Call<QuranResponse>

}