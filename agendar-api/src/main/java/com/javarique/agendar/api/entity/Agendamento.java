package com.javarique.agendar.api.entity;

import com.javarique.agendar.api.status.StatusAgendamento;
import com.javarique.agendar.api.status.TipoComunicacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String destinatario;
    @Column(nullable = false)
    private String mensagem;
    @Column(nullable = false)
    private LocalDateTime dataHoraEnvio;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComunicacao tipoComunicacao;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento statusAgendamento;
}
