package com.saishaddai.notes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class NotesApplication {

	@GetMapping
	fun defaultMapping(): ResponseEntity<String> {
		return ResponseEntity.ok("nothing to see here")
	}
}

fun main(args: Array<String>) {
	runApplication<NotesApplication>(*args)
}
