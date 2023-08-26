package org.cabradati.reinos.models

class Reino(
    val uidPlayerLider: String,
    val nome: String,
    val aliancas: List<Alianca> = listOf(),
    val guerras: List<Guerra> = listOf()
)