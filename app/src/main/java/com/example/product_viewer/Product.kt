package com.example.product_viewer

sealed class Product(
    open val id: String,
    open val viewType :Int,
    open val imageId : Int,
    open val titleText: String
){
    data class ExpandProduct(
        val avatarId : Int,
        val titleSubHeadText: String,
        val descriptionText : String,
        val headerText: String,
        val subheadText: String,
        override val id: String,
        override val viewType: Int,
        override val imageId: Int,
        override val titleText: String
    ): Product(id, viewType, imageId, titleText)
    data class CollapsedProduct(
        val avatarId : Int,
        val headerText: String,
        val subheadText: String,
        val image80dpId: Int,
        override val id: String,
        override val viewType: Int,
        override val imageId: Int,
        override val titleText: String
    ): Product(id, viewType, imageId, titleText)
}