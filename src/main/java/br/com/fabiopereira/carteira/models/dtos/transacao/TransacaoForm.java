package br.com.fabiopereira.carteira.models.dtos.transacao;

import br.com.fabiopereira.carteira.models.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Value;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class TransacaoForm {

    @NotBlank(message = "{campo.not.blank}")
    @Size(min = 5, max = 6, message = "{campo.min.max}")
    @Pattern(regexp = "[a-zA-z]{4}[0-9][0-9]?", message = "{}")
    String ticker;

    @NotNull
    BigDecimal preco;

    @PastOrPresent(message = "{data.futuro}")
    LocalDate data;

    @NotNull
    int quantidade;

    @NotNull
    TipoTransacao tipo;

    @NotNull
    @JsonAlias("usuario_id")
    Long usuarioId;
}
