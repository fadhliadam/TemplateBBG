package com.example.templetebbg.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.templetebbg.data.Repository
import com.example.templetebbg.domain.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _listData = MutableLiveData<List<Entity>>()
    val listData: LiveData<List<Entity>> = _listData

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            // Call a suspend function from the repository to fetch the list data
            //val result = repository.getListData()

            // Update the LiveData variable with the fetched data
            //_listData.postValue(result)
        }
    }
}