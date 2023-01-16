package id.gustonecrush.androidquranapp.Retrofit.API

import id.gustonecrush.androidquranapp.Retrofit.Responses.QuranResponse
import id.gustonecrush.androidquranapp.Retrofit.Responses.SurahResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface QuranAPI {

    @GET("quran")
    fun getQuran(): Call<QuranResponse>

    @GET("quran/{surahID}")
    fun getSurah(
        @Path("surahID") surahID: Int?
    ): Call<SurahResponse>

}