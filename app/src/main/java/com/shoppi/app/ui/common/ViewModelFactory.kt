package com.shoppi.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppi.app.AssetLoader
import com.shoppi.app.data.datasource.HomeAssetDataSource
import com.shoppi.app.data.repository.HomeRepository
import com.shoppi.app.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(HomeRepository(HomeAssetDataSource(AssetLoader(context)))) as T
        } else {
            throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}