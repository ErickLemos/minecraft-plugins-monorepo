package org.cabradati.reinos.subscribers

interface Subscriber<T> {
    fun subscribe(event: T)
}