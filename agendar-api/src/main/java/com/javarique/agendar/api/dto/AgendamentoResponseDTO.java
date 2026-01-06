package com.javarique.agendar.api.dto;

import com.javarique.agendar.api.status.StatusAgendamento;
import com.javarique.agendar.api.status.TipoComunicacao;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponseDTO(

        UUID id,
        String destinatario,
        String mensagem,
        String dataHoraEnvio,
        String tipoComunicacao,
        String statusAgendamento
) {
    public AgendamentoResponseDTO(UUID id, String destinatario, String mensagem, LocalDateTime dataHoraEnvio, TipoComunicacao tipoComunicacao, StatusAgendamento statusAgendamento) {
        this(id, destinatario, mensagem, dataHoraEnvio.toString(), tipoComunicacao.toString(), statusAgendamento.toString());
    }
}
  