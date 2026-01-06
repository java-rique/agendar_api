package com.javarique.agendar.api.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        @NotBlank(message = "A mensagem não pode ser nula ou vazia")
        String mensagem,
        @NotBlank(message = "O destinatário não pode ser nulo ou vazio")
        String destinatario,
        @NotNull(message = "A data de envio não pode ser nula ou vazia")
        @Future(message = "A data de envio deve ser no futuro")
        LocalDateTime dataHoraEnvio,
        @NotBlank(message = "O tipo de comunicação não pode ser nulo ou vazio")
        String tipoComunicacao

) {
}
