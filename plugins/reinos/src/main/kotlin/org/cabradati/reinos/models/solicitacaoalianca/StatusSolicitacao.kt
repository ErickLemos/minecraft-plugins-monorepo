package org.cabradati.reinos.models.solicitacaoalianca

enum class StatusSolicitacao(
    status: String
) {
    PENDENTE("PENDENTE"),
    ACEITO("ACEITO"),
    REJEITADO("REJEITADO");
}