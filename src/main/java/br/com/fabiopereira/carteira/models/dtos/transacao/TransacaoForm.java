package br.com.fabiopereira.carteira.models.dtos.transacao;

import br.com.fabiopereira.carteira.models.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Value;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class TransacaoForm {

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 6)
    String ticker;

    @NotNull
    BigDecimal preco;

    @PastOrPresent
    LocalDate data;

    @NotNull
    int quantidade;

    @NotNull
    TipoTransacao tipo;

    @NotNull
    @JsonAlias("usuario_id")
    Long usuarioId;
}
