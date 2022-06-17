package com.danp.lab06_paging.utils

import com.danp.lab06_paging.data.api.response.PopularTvItem
import com.danp.lab06_paging.data.api.response.PopularTvResponse
import com.danp.lab06_paging.data.local.entity.PopularTvDatabaseModel

fun PopularTvResponse.mapDataToPopularTvItem(): PopularTvItem =
    with(this) {
        PopularTvItem(
            total_pages = total_pages,
            page = page,
            popularTvList = results?.map {
                PopularTvDatabaseModel(
                    it.id ?: -1,
                    it.name ?: "",
                    it.original_language?: "",
                    it.poster_path?: ""
                )
            } ?: arrayListOf()
        )
    }