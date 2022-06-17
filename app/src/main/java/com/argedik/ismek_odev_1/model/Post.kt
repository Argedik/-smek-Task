package com.argedik.ismek_odev_1.model

import java.io.Serializable

data class Post (val email:String, val comment:String, val downloadUrl: String){

}

data class ImagesModel(

    val images: ArrayList<String>? = ArrayList(),
) : Serializable