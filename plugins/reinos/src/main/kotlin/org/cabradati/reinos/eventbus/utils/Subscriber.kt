package org.cabradati.reinos.eventbus.utils

interface Subscriber<T> {
    fun subscribe(event: T)
}