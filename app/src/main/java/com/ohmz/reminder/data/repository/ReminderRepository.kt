package com.ohmz.reminder.data.repository

import com.ohmz.reminder.domain.model.ReminderList
import kotlinx.coroutines.flow.Flow

interface ReminderRepository {
    fun getLists(): Flow<List<ReminderList>>
    fun saveReminder(title: String): Flow<Unit>
    fun createList(name: String): Flow<Unit>
}