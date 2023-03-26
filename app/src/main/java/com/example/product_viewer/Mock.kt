package com.example.product_viewer

class Mock : DataManager  {
    private val products = listOf(
        Product.CollapsedProduct(
            R.drawable.avatar,"Header",
            "Subhead", R.drawable.media_low,"1",
            0,R.drawable.media,"Title"
        ),
        Product.ExpandProduct(
            R.drawable.avatar,"Subhead",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            "Header",
            "Subhead", "2",1,R.drawable.media,"Title"
        ),
        Product.CollapsedProduct(
            R.drawable.avatar,"Header",
            "Subhead", R.drawable.media_low,"3",
            0,R.drawable.media,"Title"
        ),
        Product.ExpandProduct(
            R.drawable.avatar,"Subhead",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            "Header",
            "Subhead", "2",1,R.drawable.media,"Title"
        ),
        Product.ExpandProduct(
            R.drawable.avatar,"Subhead",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            "Header",
            "Subhead", "2",1,R.drawable.media,"Title"
        ),
    )
    public override fun getProducts(): List<Product> {
        return this.products
    }
    public override fun getProduct(id: String): Product? {
        return this.products.find { it.id == id }
    }
}