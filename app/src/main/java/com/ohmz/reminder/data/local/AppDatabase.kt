package com.ohmz.reminder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ohmz.reminder.data.local.dao.ReminderDao
import com.ohmz.reminder.data.local.dao.ReminderListDao
import com.ohmz.reminder.data.local.entity.ReminderEntity
import com.ohmz.reminder.data.local.entity.ReminderListEntity

@Database(
    entities = [ReminderEntity::class, ReminderListEntity::class], // List all your entities here
    version = 1, // Increment this version if you change the schema
    exportSchema = false // Set to true if you want to export schema for version control
)
@TypeConverters(Converters::class) // Add TypeConverters if needed
abstract class AppDatabase : RoomDatabase() {

    // Define DAOs as abstract methods
    abstract fun reminderDao(): ReminderDao
    abstract fun listDao(): ReminderListDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Singleton pattern to ensure only one instance of the database
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "reminder_database" // Name of the database file
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}