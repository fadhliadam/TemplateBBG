package com.example.templetebbg.data

import androidx.lifecycle.LiveData
import com.example.templetebbg.data.dataclass.Item
import com.example.templetebbg.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val apiService: ApiService
) {
    fun getListItem(): LiveData<List<Item>> {
        return DataDummy.generateDummyListItem()
    }
}