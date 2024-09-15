package com.saishaddai.notes.transformer

interface Transformer <A, B> {
    fun transform(source: A) : B
}