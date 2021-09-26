package br.com.fabiopereira.carteira.services;

import br.com.fabiopereira.carteira.models.Usuario;
import br.com.fabiopereira.carteira.models.dtos.usuario.*;
import br.com.fabiopereira.carteira.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<UsuarioDto> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDto.class))
                .toList();
    }

    public void cadastrar (UsuarioForm usuarioForm) {
        Usuario usuario = modelMapper.map(usuarioForm, Usuario.class);

        usuario.setSenha(new Random().nextInt(999999) + "");
        usuarioRepository.save(usuario);
    }
}
