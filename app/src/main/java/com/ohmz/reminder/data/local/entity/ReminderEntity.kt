package com.ohmz.reminder.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "reminders")
data class ReminderEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val isCompleted: Boolean = false,
    val dueDate: LocalDateTime? = null,
    val listId: Long? = null // Foreign key to ReminderListEntity
)