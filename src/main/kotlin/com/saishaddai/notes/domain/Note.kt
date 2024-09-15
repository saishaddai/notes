package com.saishaddai.notes.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
data class Note(
    @Id
    @SequenceGenerator(name = NOTE_SEQUENCE, sequenceName = NOTE_SEQUENCE, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NOTE_SEQUENCE)
    val id: Long = 1,
    var title: String,
    var description: String?) {

    companion object {
        const val NOTE_SEQUENCE = "NOTE_SEQUENCE"
    }
}
