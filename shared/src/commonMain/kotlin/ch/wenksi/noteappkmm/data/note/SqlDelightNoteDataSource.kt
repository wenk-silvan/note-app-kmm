package ch.wenksi.noteappkmm.data.note

import ch.wenksi.noteappkmm.database.NoteDatabase
import ch.wenksi.noteappkmm.domain.note.Note
import ch.wenksi.noteappkmm.domain.note.NoteDataSource
import ch.wenksi.noteappkmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created),
        )
    }

    override suspend fun getNote(id: Long): Note? = queries
        .getNoteById(id)
        .executeAsOneOrNull()
        ?.toNote()

    override suspend fun getAllNotes(): List<Note> = queries
        .getAllNotes()
        .executeAsList()
        .map { it.toNote() }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }
}