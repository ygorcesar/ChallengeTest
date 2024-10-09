package com.example.challenge.domain

import com.example.challenge.model.Data

class DataRepository {

    fun getDataEntries(): List<Data> {
        return listOf(1, 2, 3, 4, 5, 6).map { i ->
            Data(
                title = "Title: $i",
                description = "Description: $i",
            )
        }
    }
}