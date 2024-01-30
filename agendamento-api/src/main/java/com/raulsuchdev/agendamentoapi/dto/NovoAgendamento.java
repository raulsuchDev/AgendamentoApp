package com.raulsuchdev.agendamentoapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class NovoAgendamento {

    @NotBlank(message = "Inserir conta de origem!")
    @Size(min = 10, max = 10, message = "O campo deve ter 10 caracteres")
    private String contaOrigem;

    @NotBlank(message = "Inserir conta de destino!")
    @Size(min = 10, max = 10, message = "O campo deve ter 10 caracteres")
    private String contaDestino;

    @NotNull(message = "Inserir valor da transferência")
    @DecimalMin(value = "0.01", message = "O valor da transferência deve à partir R$ 0,01!")
    private BigDecimal valorTransferencia;

    @NotNull(message = "Inserir data de transferência!")
    private LocalDate dataTransferencia;

}
