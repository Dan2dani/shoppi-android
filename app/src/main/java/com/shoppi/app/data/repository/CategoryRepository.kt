package com.shoppi.app.data.repository

import com.shoppi.app.data.datasource.CategoryRemoteDataSource
import com.shoppi.app.data.model.Category

class CategoryRepository(
    private val categoryRemoteDataSource: CategoryRemoteDataSource
) {
    suspend fun getCategories(): List<Category> {
        return categoryRemoteDataSource.getCategories()
    }
}