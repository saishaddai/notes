package com.saishaddai.notes.transformer

import com.saishaddai.notes.domain.Note
import com.saishaddai.notes.dto.NoteResponse

fun Note?.toNoteResponse() : NoteResponse {
    return NoteResponse(
        id = this?.id ?: 1,
        fullNote = "$this.title: ${this?.description.orEmpty()}")
}