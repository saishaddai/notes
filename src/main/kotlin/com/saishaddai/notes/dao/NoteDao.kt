package com.saishaddai.notes.dao

import com.saishaddai.notes.domain.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteDao: JpaRepository<Note, Long>