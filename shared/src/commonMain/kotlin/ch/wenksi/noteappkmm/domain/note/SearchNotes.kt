package ch.wenksi.noteappkmm.domain.note

import ch.wenksi.noteappkmm.domain.time.DateTimeUtil

class SearchNotes {

    fun execute(notes: List<Note>, query: String): List<Note> {
        if (query.isBlank()) {
            return notes
        }
        return notes.filter {
            it.title.search(query) || it.content.search(query)
        }.sortedBy {
            DateTimeUtil.toEpochMillis(it.created)
        }
    }

    private fun String.search(query: String) =
        this.trim().lowercase().contains(query.lowercase())
}