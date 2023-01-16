package id.gustonecrush.androidquranapp.Retrofit.Responses

import com.google.gson.annotations.SerializedName

data class SurahResponse(

    @field:SerializedName("status")
    val status: Int? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("data")
    val data: Surah? = null,

)

data class Surah(

    @field:SerializedName("number")
    val number: Int? = null,

    @field:SerializedName("ayahCount")
    val ayahCount: Int? = null,

    @field:SerializedName("sequence")
    val sequence: Int? = null,

    @field:SerializedName("asma")
    val asma: Asma? = null,

    @field:SerializedName("preBismillah")
    val preBismillah: DataPreBismillah? = null,

    @field:SerializedName("type")
    val type: DataType? = null,

    @field:SerializedName("tafsir")
    val tafsir: DataTafsir? = null,

    @field:SerializedName("recitation")
    val recitation: DataRecitation? = null,

    @field:SerializedName("ayahs")
    val ayahs: ArrayList<Ayahs>? = null,

)

data class Ayahs(

    @field:SerializedName("number")
    val number: DataNumber? = null,

    @field:SerializedName("juz")
    val juz: Int? = null,

    @field:SerializedName("manzil")
    val manzil: Int? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("ruku")
    val ruku: Int? = null,

    @field:SerializedName("sajda")
    val sajda: DataSajda? = null,

    @field:SerializedName("text")
    val text: DataText? = null,

    @field:SerializedName("translation")
    val translation: DataTranslation? = null,

    @field:SerializedName("tafsir")
    val tafsir: DataTafsir? = null,

    @field:SerializedName("audio")
    val audio: DataAudio? = null

)

data class DataNumber(

    @field:SerializedName("inquran")
    val inquran: Int? = null,

    @field:SerializedName("insurah")
    val insurah: Int? = null

)

data class DataSajda(

    @field:SerializedName("recommended")
    val recommended: Boolean? = null,

    @field:SerializedName("obligatory")
    val obligatory: Boolean? = null

)

data class DataAudio(

    @field:SerializedName("audio")
    val audio: String? = null,

)
