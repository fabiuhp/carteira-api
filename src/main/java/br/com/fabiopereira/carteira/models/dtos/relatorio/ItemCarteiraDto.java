package br.com.fabiopereira.carteira.models.dtos.relatorio;

import lombok.*;

@Getter
@AllArgsConstructor
public class ItemCarteiraDto {

    private String ticker;
    private Long quantidade;
    private Double percentual;
}
