package app.bacecek.defaultassistant

import androidx.room.Database
import androidx.room.RoomDatabase
import app.bacecek.defaultassistant.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?
}
