package com.danp.lab06_paging.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.danp.lab06_paging.data.api.service.ServiceInterface
import com.danp.lab06_paging.data.local.database.PopularTvDatabase
import com.danp.lab06_paging.data.local.entity.PopularTvDatabaseModel
import com.danp.lab06_paging.data.remote.PopularTvRemoteMediator
import com.danp.lab06_paging.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val serviceInterface: ServiceInterface,
    private val popularTvDatabase: PopularTvDatabase
) : ViewModel() {
    @ExperimentalPagingApi
    fun getAllPopularTv(): Flow<PagingData<PopularTvDatabaseModel>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5,
            initialLoadSize = 40
        ),
        pagingSourceFactory = { popularTvDatabase.getPopularTvDao().getPopularTvAll() },
        remoteMediator = PopularTvRemoteMediator(
            serviceInterface,
            popularTvDatabase,
            Constant.API_KEY
        )
    ).flow.cachedIn(viewModelScope).flowOn(Dispatchers.IO)
}