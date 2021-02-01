package id.rdev.parsejson.data

import com.google.gson.annotations.SerializedName

data class ResultPosts(
    @field:SerializedName("userId")
    val userId : Int? = null,

    @field:SerializedName("id")
    val id : Int? = null,

    @field:SerializedName("title")
    val title : String? = null,

    @field:SerializedName("body")
    val body : String? = null

)
