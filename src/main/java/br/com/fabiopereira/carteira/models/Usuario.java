package br.com.fabiopereira.carteira.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String nome;
    private String login;
    private String senha;
}
