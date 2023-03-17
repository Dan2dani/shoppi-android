package com.shoppi.app.data.datasource

import com.shoppi.app.data.model.CategoryDetail
import com.shoppi.app.network.ApiClient

class CategoryDetailRemoteDataSource(private val apiClient: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return apiClient.getCategoryDetails()
    }
}