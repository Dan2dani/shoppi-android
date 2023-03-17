package com.shoppi.app.data.datasource

import com.shoppi.app.data.model.Category

interface CategoryDataSource {
    suspend fun getCategories(): List<Category>
}