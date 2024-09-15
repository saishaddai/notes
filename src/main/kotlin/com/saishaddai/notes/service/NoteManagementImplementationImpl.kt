package com.saishaddai.notes.service

import com.saishaddai.notes.dao.NoteDao
import com.saishaddai.notes.domain.Note
import com.saishaddai.notes.dto.AddNoteRequest
import com.saishaddai.notes.dto.NoteResponse
import com.saishaddai.notes.dto.UpdateNoteRequest
import com.saishaddai.notes.transformer.AddNoteRequestTransformer
import com.saishaddai.notes.transformer.toNoteResponse
import org.springframework.data.repository.findByIdOrNull

import org.springframework.stereotype.Service

@Service
class NoteManagementImplementationImpl(private val noteDao: NoteDao,
                                       private val addNoteRequestTransformer: AddNoteRequestTransformer): NoteManagementService {

    override fun findById(id: Long): NoteResponse? = findNoteById(id).toNoteResponse()

    override fun findAll(): List<NoteResponse> = noteDao.findAll().map(Note::toNoteResponse)

    override fun save(addNoteRequest: AddNoteRequest): NoteResponse =
        upsert(addNoteRequestTransformer.transform(addNoteRequest))

    override fun update(updateNoteRequest: UpdateNoteRequest): NoteResponse {
        var note = findNoteById(updateNoteRequest.id) ?: throw IllegalStateException("${updateNoteRequest.id} not found")
        return upsert(note.apply {
            title = updateNoteRequest.title
            description = updateNoteRequest.description
        })
    }

    override fun deleteById(id: Long) = noteDao.deleteById(id)

    private fun findNoteById(id: Long): Note? = this.noteDao.findByIdOrNull(id)
    private fun upsert(note: Note) : NoteResponse = noteDao.save<Note>(note).toNoteResponse()
}