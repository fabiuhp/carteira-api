package br.com.fabiopereira.carteira.models.dtos.usuario;

import lombok.Value;

import javax.validation.constraints.*;

@Value
public class UsuarioForm {

    @NotBlank
    String nome;
    @NotBlank
    String login;
}
