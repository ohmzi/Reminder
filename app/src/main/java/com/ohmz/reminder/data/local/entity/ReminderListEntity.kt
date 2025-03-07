package com.ohmz.reminder.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lists")
data class ReminderListEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val color: Int // Store color as an integer (e.g., ARGB format)
)