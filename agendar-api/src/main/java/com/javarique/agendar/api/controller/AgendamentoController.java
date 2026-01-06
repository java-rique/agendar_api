package com.javarique.agendar.api.controller;

import com.javarique.agendar.api.dto.AgendamentoRequestDTO;
import com.javarique.agendar.api.dto.AgendamentoResponseDTO;
import com.javarique.agendar.api.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;


    @PostMapping("/create")
    public ResponseEntity<AgendamentoResponseDTO> agendar(@Valid @RequestBody AgendamentoRequestDTO requestDTO) {
        AgendamentoResponseDTO responseDTO = agendamentoService.agendar(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping("/{id} ")
    public ResponseEntity<AgendamentoResponseDTO> buscarPorId(@PathVariable UUID id) {
        AgendamentoResponseDTO responseDTO = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AgendamentoResponseDTO>> buscarTodos() {
        List<AgendamentoResponseDTO> responseDTOList = agendamentoService.buscarTodos();
        return ResponseEntity.ok(responseDTOList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable UUID id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<AgendamentoResponseDTO> atualizarAgendamento(@PathVariable UUID id, @RequestBody AgendamentoRequestDTO requestDTO) {
        if (requestDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        AgendamentoResponseDTO responseDTO = agendamentoService.atualizarAgendamento(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
