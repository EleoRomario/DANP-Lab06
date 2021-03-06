package com.danp.lab06_paging.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danp.lab06_paging.data.local.entity.PopularTvDatabaseModel

@Dao
interface PopularTvDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(popularTvList: List<PopularTvDatabaseModel>)

    @Query("select * from popularTv")
    fun getPopularTvAll(): PagingSource<Int, PopularTvDatabaseModel>

    @Query("DELETE FROM popularTv")
    fun clearAll()
}