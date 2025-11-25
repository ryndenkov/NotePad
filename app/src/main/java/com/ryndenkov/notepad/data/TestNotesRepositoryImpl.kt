package com.ryndenkov.notepad.data

import com.ryndenkov.notepad.domain.Note
import com.ryndenkov.notepad.domain.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class TestNotesRepositoryImpl : NotesRepository {

    private val notesListFlow = MutableStateFlow<List<Note>>(listOf())

    override fun addNote(note: Note) {
        notesListFlow.update {
            it + note
        }
    }

    override fun deleteNote(nodeId: Int) {
        notesListFlow.update { oldList ->
            oldList.toMutableList().apply {
                removeIf {
                    it.id == nodeId
                }
            }
        }
    }

    override fun editNote(note: Note) {
        notesListFlow.update { oldList ->
            oldList.map {
                if (it.id == note.id) {
                    note
                } else {
                    it
                }
            }
        }
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return notesListFlow.asStateFlow()
    }

    override fun getNote(noteId: Int): Note {
        return notesListFlow.value.first { it.id == noteId }
    }

    override fun searchNotes(query: String): Flow<List<Note>> {
        return notesListFlow.map { currentList ->
            currentList.filter {
                it.title.contains(query) || it.content.contains(query)
            }
        }
    }

    override fun switchPinStatus(nodeId: Int) {
        notesListFlow.update { oldList ->
            oldList.map {
                if (it.id == nodeId) {
                    it.copy(isPinned = !it.isPinned)
                } else {
                    it
                }
            }
        }
    }
}