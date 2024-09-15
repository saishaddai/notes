package com.saishaddai.notes.service

import com.saishaddai.notes.dto.AddNoteRequest
import com.saishaddai.notes.dto.NoteResponse
import com.saishaddai.notes.dto.UpdateNoteRequest

interface NoteManagementService {
    fun findById(id: Long) : NoteResponse?
    fun findAll(): List<NoteResponse>
    fun save(addNoteRequest: AddNoteRequest): NoteResponse
    fun update(updateNoteRequest: UpdateNoteRequest): NoteResponse
    fun deleteById(id: Long)
}