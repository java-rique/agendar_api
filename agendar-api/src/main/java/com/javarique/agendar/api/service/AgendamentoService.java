package com.javarique.agendar.api.service;

import com.javarique.agendar.api.dto.AgendamentoRequestDTO;
import com.javarique.agendar.api.dto.AgendamentoResponseDTO;
import com.javarique.agendar.api.entity.Agendamento;
import com.javarique.agendar.api.repository.AgendamentoRepository;
import com.javarique.agendar.api.status.StatusAgendamento;
import com.javarique.agendar.api.status.TipoComunicacao;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoResponseDTO agendar(AgendamentoRequestDTO agendamentoRequestDTO) {
        Agendamento agendamento = Agendamento.builder()
                .destinatario(agendamentoRequestDTO.destinatario())
                .mensagem(agendamentoRequestDTO.mensagem())
                .dataHoraEnvio(agendamentoRequestDTO.dataHoraEnvio())
                .tipoComunicacao(TipoComunicacao.valueOf(agendamentoRequestDTO.tipoComunicacao()))
                .statusAgendamento(StatusAgendamento.AGENDADO)
                .build();
        return responseSave(agendamentoRepository.save(agendamento));

    }

    public AgendamentoResponseDTO buscarPorId(UUID id) {
    Agendamento agendamento = agendamentoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com o ID: " + id));

    return responseSave(agendamento);
    }

    public void deletarAgendamento(UUID id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com o ID: " + id));
        agendamentoRepository.delete(agendamento);
    }

    public List<AgendamentoResponseDTO> buscarTodos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();

        return agendamentos.stream()
                .map(this::responseSave)
                .toList();
    }
    public AgendamentoResponseDTO atualizarAgendamento(UUID id, AgendamentoRequestDTO agendamentoRequestDTO) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com o ID: " + id));

        agendamento.setDestinatario(agendamentoRequestDTO.destinatario());
        agendamento.setMensagem(agendamentoRequestDTO.mensagem());
        agendamento.setDataHoraEnvio(agendamentoRequestDTO.dataHoraEnvio());
        agendamento.setTipoComunicacao(TipoComunicacao.valueOf(agendamentoRequestDTO.tipoComunicacao()));

        return responseSave(agendamentoRepository.save(agendamento));
    }


    public AgendamentoResponseDTO responseSave(Agendamento agendamento) {
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getDestinatario(),
                agendamento.getMensagem(),
                agendamento.getDataHoraEnvio(),
                agendamento.getTipoComunicacao(),
                agendamento.getStatusAgendamento()
                );
    }


}
