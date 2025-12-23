package com.ryndenkov.notepad.domain

import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun addNote(
        title: String,
        content: String,
        isPinned: Boolean,
        updatedAt: Long
    )

    suspend fun deleteNote(nodeId: Int)
    suspend fun editNote(note: Note)
    fun getAllNotes(): Flow<List<Note>>
    suspend fun getNote(noteId: Int): Note
    fun searchNotes(query: String): Flow<List<Note>>
    suspend fun switchPinStatus(nodeId: Int)
}