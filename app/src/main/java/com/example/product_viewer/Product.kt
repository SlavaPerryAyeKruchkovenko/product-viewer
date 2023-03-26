package com.example.product_viewer

data class Product (
    val id: String,
    val viewType :Int,
    val avatarId : Int,
    val headerText: String,
    val subheadText: String,
    val titleText: String,
    val titleSubHeadText: String,
    val descriptionText : String,
    val imageId : Int,
    val image80dpId: Int){
}