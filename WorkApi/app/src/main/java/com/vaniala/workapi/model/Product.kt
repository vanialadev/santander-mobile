package com.vaniala.workapi.model

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("id")
    val id: String,
    @SerializedName("prname")
    val prNAme: String,
    @SerializedName("primage")
    val prImage: String,
)