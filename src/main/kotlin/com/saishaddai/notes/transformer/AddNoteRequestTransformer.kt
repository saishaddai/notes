package com.saishaddai.notes.transformer

import com.saishaddai.notes.dto.AddNoteRequest
import com.saishaddai.notes.domain.Note
import org.springframework.stereotype.Component

@Component
class AddNoteRequestTransformer: Transformer<AddNoteRequest, Note > {

    override fun transform(source: AddNoteRequest) =
        Note(title = source.title,
            description = source.description)
}