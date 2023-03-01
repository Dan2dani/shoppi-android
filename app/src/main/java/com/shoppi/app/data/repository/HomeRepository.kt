package com.shoppi.app.data.repository

import com.shoppi.app.data.model.HomeData
import com.shoppi.app.data.datasource.HomeAssetDataSource

class HomeRepository(
    private val homeAssetDataSource: HomeAssetDataSource
) {
    fun getHomeData(): HomeData? {
        return homeAssetDataSource.getHomeData()
    }
}