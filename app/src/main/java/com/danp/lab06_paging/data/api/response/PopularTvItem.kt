package com.danp.lab06_paging.data.api.response

import com.danp.lab06_paging.data.local.entity.PopularTvDatabaseModel

data class PopularTvItem(
    val total_pages: Int = 0,
    val page: Int = 0,
    val popularTvList: List<PopularTvDatabaseModel>
) {
    val isEndOfListReached = total_pages == page
}