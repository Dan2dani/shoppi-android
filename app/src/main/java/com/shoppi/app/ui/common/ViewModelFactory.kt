package com.shoppi.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppi.app.AssetLoader
import com.shoppi.app.data.datasource.CategoryDetailRemoteDataSource
import com.shoppi.app.data.datasource.CategoryRemoteDataSource
import com.shoppi.app.data.datasource.HomeAssetDataSource
import com.shoppi.app.data.repository.CategoryDetailRepository
import com.shoppi.app.data.repository.CategoryRepository
import com.shoppi.app.data.repository.HomeRepository
import com.shoppi.app.network.ApiClient
import com.shoppi.app.ui.category.CategoryViewModel
import com.shoppi.app.ui.categoryDetail.CategoryDetailViewModel
import com.shoppi.app.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(HomeRepository(HomeAssetDataSource(AssetLoader(context)))) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                CategoryViewModel(CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                CategoryDetailViewModel(CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))) as T
            }
            else -> {
                throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}