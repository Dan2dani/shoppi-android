package com.shoppi.app.data.datasource

import com.shoppi.app.data.model.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}