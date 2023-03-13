package ch.wenksi.noteappkmm.data.local

import ch.wenksi.noteappkmm.database.NoteDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver = NativeSqliteDriver(
        schema = NoteDatabase.Schema,
        name = "note.db"
    )
}