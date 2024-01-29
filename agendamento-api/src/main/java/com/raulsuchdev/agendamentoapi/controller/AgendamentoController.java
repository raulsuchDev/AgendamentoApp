package com.raulsuchdev.agendamentoapi.controller;

import com.raulsuchdev.agendamentoapi.dto.AgendamentoDTO;
import com.raulsuchdev.agendamentoapi.dto.BaseResponseDTO;
import com.raulsuchdev.agendamentoapi.dto.NovoAgendamento;
import com.raulsuchdev.agendamentoapi.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> listarAgendamentos() {
        return ResponseEntity.ok(agendamentoService.listarAgendamentos());
    }

    @PostMapping
    public ResponseEntity<BaseResponseDTO> criarAgendamento(@Valid @RequestBody NovoAgendamento novoAgendamento) {
        agendamentoService.criarAgendamento(novoAgendamento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BaseResponseDTO(HttpStatus.CREATED, "Agendamento criado com sucesso!"));
    }
}
