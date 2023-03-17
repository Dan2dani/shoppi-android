package com.shoppi.app.data.datasource

import com.shoppi.app.data.model.CategoryDetail

interface CategoryDetailDataSource {
    suspend fun getCategoryDetail(): CategoryDetail
}