package br.com.fabiopereira.carteira.services;

import br.com.fabiopereira.carteira.models.Usuario;
import br.com.fabiopereira.carteira.models.dtos.usuario.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    private ModelMapper modelMapper = new ModelMapper();
    private List<Usuario> usuarios = new ArrayList<>();

    public List<UsuarioDto> listar() {
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDto.class))
                .toList();
    }

    public void cadastrar (UsuarioForm usuarioForm) {
        Usuario usuario = modelMapper.map(usuarioForm, Usuario.class);

        usuario.setSenha(new Random().nextInt(999999) + "");
        usuarios.add(usuario);
    }
}
