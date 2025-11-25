package com.ryndenkov.notepad.domain

class AddNoteUseCase(
    private val repository: NotesRepository
) {
    operator fun invoke(note: Note) {
        repository.addNote(note)
    }
}