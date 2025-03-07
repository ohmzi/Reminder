package com.ohmz.reminder.data.repository

import com.ohmz.reminder.data.local.AppDatabase
import com.ohmz.reminder.data.local.entity.ReminderEntity
import com.ohmz.reminder.data.local.entity.ReminderListEntity
import com.ohmz.reminder.domain.model.ReminderList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ReminderRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : ReminderRepository {
    override fun getLists(): Flow<List<ReminderList>> {
        // Implement actual data source
        return flowOf(listOf(ReminderList("Reminders", 14)))
    }

    override fun saveReminder(title: String): Flow<Unit> {
        return flow {
            db.reminderDao().insert(ReminderEntity(title = title))
            emit(Unit)
        }
    }

    override fun createList(name: String): Flow<Unit> {
        return flow {
            db.listDao().insert(ReminderListEntity(name = name, color = 0))
            emit(Unit)
        }
    }

}