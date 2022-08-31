package com.example.connecttointernet.data.database

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import com.example.connecttointernet.data.Note

@Database(
    entities = [Note::class],
    version = 2,
    autoMigrations = [AutoMigration(from = 1, to = 2, spec = NoteDatabase.MIGRATE_1_2spec::class)]
)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getDao(): NoteDao

    companion object {

        private const val DATABASE_NAME = "NotesDatabase"

        @Volatile
        private var instance: NoteDatabase? = null

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME)
                /**.fallbackToDestructiveMigration()**///Allows Room to destructively recreate database
//                tables if Migrations that would migrate old database schemas to the latest schema version are not found.
                /**.addMigrations(MIGRATION_1_2)**/
                .build()

        fun getInstance(context: Context) =
            instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }

        fun getInstanceWithoutContext() = instance!!

//        private val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE Note ADD COLUMN archived INTEGER NOT NULL DEFAULT 0")
//            }
//        }

    }

    @RenameColumn(
        tableName = "Note",
        fromColumnName = "archived",
        toColumnName = "isArchived"
    )
    class MIGRATE_1_2spec : AutoMigrationSpec


}