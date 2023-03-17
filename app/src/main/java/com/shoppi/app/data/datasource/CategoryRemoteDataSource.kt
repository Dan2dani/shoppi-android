package com.shoppi.app.data.datasource

import com.shoppi.app.data.model.Category
import com.shoppi.app.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}