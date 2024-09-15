package com.saishaddai.notes.resource

import com.saishaddai.notes.dto.AddNoteRequest
import com.saishaddai.notes.dto.NoteResponse
import com.saishaddai.notes.dto.UpdateNoteRequest
import com.saishaddai.notes.resource.NoteResourceImpl.Companion.BASE_NOTE_URL
import com.saishaddai.notes.service.NoteManagementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
@RestController
@RequestMapping(value = [BASE_NOTE_URL])
class NoteResourceImpl(private val service: NoteManagementService): NoteResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<NoteResponse?> =
        ResponseEntity.ok(service.findById(id))

    @GetMapping
    override fun findAll(): ResponseEntity<List<NoteResponse>> =
        ResponseEntity.ok(service.findAll())


    @PostMapping
    override fun save(addNoteRequest: AddNoteRequest): ResponseEntity<NoteResponse> {
        var noteResponse = service.save(addNoteRequest)
        return ResponseEntity.created(URI(BASE_NOTE_URL.plus("/${noteResponse.id}"))).body(noteResponse)
    }

    @PutMapping
    override fun update(updateNoteRequest: UpdateNoteRequest): ResponseEntity<NoteResponse> =
        ResponseEntity.ok(service.update(updateNoteRequest))

    @DeleteMapping
    override fun deleteById(id: Long): ResponseEntity<Unit> {
        service.deleteById(id)
        return ResponseEntity.noContent().build<Unit>()
    }

    companion object {
        const val BASE_NOTE_URL = "/api/v1/note"
    }
}

