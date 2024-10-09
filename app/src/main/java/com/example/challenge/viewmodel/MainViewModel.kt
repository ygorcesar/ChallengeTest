package com.example.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.challenge.domain.DataRepository
import com.example.challenge.model.Data

class MainViewModel(
    private val repository: DataRepository = DataRepository(),
) {

    private val mutableData = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>> = mutableData

    fun getData() {
        val data = repository.getDataEntries()
        mutableData.postValue(data)
    }
}