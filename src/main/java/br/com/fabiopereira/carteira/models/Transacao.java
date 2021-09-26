package br.com.fabiopereira.carteira.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private LocalDate data;
    private BigDecimal preco;
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @ManyToOne
    private Usuario usuario;
}
