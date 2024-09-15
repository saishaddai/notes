package com.saishaddai.notes.resource

import com.saishaddai.notes.dto.AddNoteRequest
import com.saishaddai.notes.dto.NoteResponse
import com.saishaddai.notes.dto.UpdateNoteRequest
import org.springframework.http.ResponseEntity

interface NoteResource {
    fun findById(id: Long) : ResponseEntity<NoteResponse?>
    fun findAll(): ResponseEntity<List<NoteResponse>>
    fun save(addNoteRequest: AddNoteRequest): ResponseEntity<NoteResponse>
    fun update(updateNoteRequest: UpdateNoteRequest): ResponseEntity<NoteResponse>
    fun deleteById(id: Long) : ResponseEntity<Unit>
}