package com.example.product_viewer

class Mock : DataManager  {
    private val products = listOf(
        Product(
            "1",
            0,R.drawable.avatar,"Header",
            "Subhead", "Title", "Subhead",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            R.drawable.media,R.drawable.media_low
        ),
        Product(
            "2",
            1,R.drawable.avatar,"Header",
            "Subhead", "Title", "Subhead",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            R.drawable.media,R.drawable.media_low
        ),
        Product(
            "3",
            0,R.drawable.avatar,"Header",
            "Subhead", "Title", "Subhead",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            R.drawable.media,R.drawable.media_low
        ),
    )
    public override fun getProducts(): List<Product> {
        return this.products
    }
    public override fun getProduct(id: String): Product? {
        return this.products.find { it.id == id }
    }
}