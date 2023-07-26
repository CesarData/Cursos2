package com.bedu.cursos.data.model

import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("id") var id: Int,
    @SerializedName("imageUrl")var image: Int,
    @SerializedName("family")var category: String,
    @SerializedName("firstname")var name: String,
    @SerializedName("id")var duration: Float,
    @SerializedName("id")var price: Float,
    @SerializedName("id")var rating: Float
    )

