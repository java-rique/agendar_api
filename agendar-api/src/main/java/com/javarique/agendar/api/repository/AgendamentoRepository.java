package com.javarique.agendar.api.repository;

import com.javarique.agendar.api.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}
