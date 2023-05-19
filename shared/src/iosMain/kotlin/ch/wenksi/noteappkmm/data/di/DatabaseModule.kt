package ch.wenksi.noteappkmm.data.di

import ch.wenksi.noteappkmm.data.local.DatabaseDriverFactory
import ch.wenksi.noteappkmm.data.note.SqlDelightNoteDataSource
import ch.wenksi.noteappkmm.database.NoteDatabase
import ch.wenksi.noteappkmm.domain.note.NoteDataSource

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}