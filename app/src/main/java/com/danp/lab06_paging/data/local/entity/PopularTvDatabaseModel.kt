package com.danp.lab06_paging.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popularTv")
data class PopularTvDatabaseModel(
    val popularTvId: Int,
    @PrimaryKey
    val name: String,
    val original_language: String,
    val poster_path: String,
)