package com.ohmz.reminder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ohmz.reminder.data.local.entity.ReminderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {
    @Insert
    suspend fun insert(reminder: ReminderEntity): Long

    @Query("SELECT * FROM reminders WHERE listId = :listId")
    fun getRemindersByList(listId: Long): Flow<List<ReminderEntity>>
}