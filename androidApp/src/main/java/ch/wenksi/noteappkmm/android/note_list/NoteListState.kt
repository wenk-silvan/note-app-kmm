package ch.wenksi.noteappkmm.android.note_list

import ch.wenksi.noteappkmm.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false,
)