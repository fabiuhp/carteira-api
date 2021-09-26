package br.com.fabiopereira.carteira.models.dtos.transacao;

import br.com.fabiopereira.carteira.models.TipoTransacao;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class TransacaoDto {

    private Long id;
    private String ticker;
    private BigDecimal preco;
    private Integer quantidade;
    private TipoTransacao tipo;
    private String usuarioNome;
}
