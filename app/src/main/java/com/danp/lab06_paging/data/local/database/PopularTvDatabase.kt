package com.danp.lab06_paging.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danp.lab06_paging.data.local.dao.PopularTvDao
import com.danp.lab06_paging.data.local.dao.PopularTvRemoteDao
import com.danp.lab06_paging.data.local.entity.PopularTvDatabaseModel
import com.danp.lab06_paging.data.local.entity.PopularTvRemoteKeys

@Database(entities = [PopularTvDatabaseModel::class,PopularTvRemoteKeys::class], version = 1, exportSchema = false)
abstract class PopularTvDatabase : RoomDatabase() {

    abstract fun getPopularTvDao(): PopularTvDao
    abstract fun getPopularTvRemoteDao(): PopularTvRemoteDao
}