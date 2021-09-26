package br.com.fabiopereira.carteira.models.dtos.usuario;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class UsuarioForm {

    @NotBlank(message = "{campo.not.blank}")
    String nome;
    @NotBlank(message = "{campo.not.blank}")
    String login;
}
