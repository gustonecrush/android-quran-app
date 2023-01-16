package id.gustonecrush.androidquranapp.Retrofit.Responses

import com.google.gson.annotations.SerializedName

data class QuranResponse(

    @field:SerializedName("status")
    val status: Int? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("data")
    val data: ArrayList<Surahs>? = null

)

data class Surahs(

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
    val recitation: DataRecitation? = null

)

data class Asma(

    @field:SerializedName("ar")
    val ar: DataAsma? = null,

    @field:SerializedName("en")
    val en: DataAsma? = null,

    @field:SerializedName("id")
    val id: DataAsma? = null,

    @field:SerializedName("translation")
    val translation: DataTranslation? = null,

)

data class DataAsma(

    @field:SerializedName("short")
    val short: String? = null,

    @field:SerializedName("long")
    val long: String? = null,

)

data class DataTranslation(

    @field:SerializedName("en")
    val en: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

)

data class DataPreBismillah(

    @field:SerializedName("text")
    val text: DataText? = null,

    @field:SerializedName("translation")
    val translation: DataTranslation? = null,

)

data class DataText(

    @field:SerializedName("ar")
    val ar: String? = null,

    @field:SerializedName("read")
    val read: String? = null,

)

data class DataType(

    @field:SerializedName("ar")
    val ar: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("en")
    val en: String? = null,

)

data class DataTafsir(

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("en")
    val en: String? = null,

    )

data class DataRecitation(

    @field:SerializedName("full")
    val full: String? = null,

    )