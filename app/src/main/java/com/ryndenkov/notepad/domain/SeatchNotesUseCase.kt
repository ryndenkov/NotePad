package com.ryndenkov.notepad.domain

import kotlinx.coroutines.flow.Flow

class SeatchNotesUseCase {
    operator fun invoke(query: String): Flow<List<Note>> {
        TODO()
    }
}