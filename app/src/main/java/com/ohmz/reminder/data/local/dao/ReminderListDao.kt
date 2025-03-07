package com.ohmz.reminder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ohmz.reminder.data.local.entity.ReminderListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderListDao {
    @Insert
    suspend fun insert(list: ReminderListEntity): Long

    @Query("SELECT * FROM lists")
    fun getAllLists(): Flow<List<ReminderListEntity>>
}