package com.ryndenkov.notepad.domain

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val updatedAd: Long,
    val isPinned: Boolean
)
