package com.ryndenkov.notepad.domain

class SwitchPinnedStatusUseCase(
    private val repository: NotesRepository
) {
    suspend operator fun invoke(noteId: Int) {
        repository.switchPinStatus(noteId)
    }
}