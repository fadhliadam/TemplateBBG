package com.example.templetebbg.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.templetebbg.data.dataclass.Item

object DataDummy {

    fun generateDummyListItem() : LiveData<List<Item>> {
        val list: MutableList<Item> = arrayListOf()
        val result = MutableLiveData<List<Item>>()
        for (i in 0..10){
            val item = Item(i, "TITLE", "lorem ipsum")
            list.add(item)
        }
        result.value = list
        return result
    }
}