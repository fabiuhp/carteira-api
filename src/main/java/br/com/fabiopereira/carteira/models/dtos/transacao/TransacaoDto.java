package br.com.fabiopereira.carteira.models.dtos.transacao;

import br.com.fabiopereira.carteira.models.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class TransacaoDto {

    private String ticker;
    private BigDecimal preco;
    private int quantidade;
    private TipoTransacao tipo;
}
