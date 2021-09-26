package br.com.fabiopereira.carteira.models.dtos.usuario;

import lombok.*;

@Getter
@Setter
public class UsuarioDto {

    private Long id;
    private String nome;
    private String login;
}
