package com.shoppi.app.data.datasource

import com.google.gson.Gson
import com.shoppi.app.AssetLoader
import com.shoppi.app.data.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {
    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}