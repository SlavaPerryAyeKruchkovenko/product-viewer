package com.example.product_viewer

interface DataManager {
    public fun getProducts(): List<Product>
    public fun getProduct(id: String): Product?
}