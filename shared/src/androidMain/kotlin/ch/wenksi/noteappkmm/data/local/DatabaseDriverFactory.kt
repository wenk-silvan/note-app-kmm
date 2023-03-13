package ch.wenksi.noteappkmm.data.local

import android.content.Context
import ch.wenksi.noteappkmm.database.NoteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        schema = NoteDatabase.Schema,
        context = context,
        name = "note.db"
    )
}