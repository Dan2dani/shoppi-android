package com.shoppi.app.data.repository

import com.shoppi.app.data.datasource.CategoryDetailRemoteDataSource
import com.shoppi.app.data.model.CategoryDetail

class CategoryDetailRepository(private val categoryDetailRemoteDataSource: CategoryDetailRemoteDataSource) {
    suspend fun getCategoryDetail(): CategoryDetail{
        return categoryDetailRemoteDataSource.getCategoryDetail()
    }
}