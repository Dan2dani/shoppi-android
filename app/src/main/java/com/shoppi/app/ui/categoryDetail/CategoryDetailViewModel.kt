package com.shoppi.app.ui.categoryDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.app.data.model.Promotion
import com.shoppi.app.data.model.TopSelling
import com.shoppi.app.data.repository.CategoryDetailRepository
import kotlinx.coroutines.launch

class CategoryDetailViewModel(private val categoryDetailRepository: CategoryDetailRepository): ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling get() = _topSelling
    private val _promotion = MutableLiveData<Promotion>()
    val promotion get() = _promotion

    init {
        loadCateogryDetail()
    }

    private fun loadCateogryDetail(){
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotion.value = categoryDetail.promotions
        }
    }
}