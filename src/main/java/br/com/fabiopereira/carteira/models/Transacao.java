package br.com.fabiopereira.carteira.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    private String ticker;
    private LocalDate data;
    private BigDecimal preco;
    private int quantidade;
    private TipoTransacao tipo;
}
