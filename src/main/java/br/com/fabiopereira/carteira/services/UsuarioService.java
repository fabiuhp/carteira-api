package br.com.fabiopereira.carteira.services;

import br.com.fabiopereira.carteira.models.Usuario;
import br.com.fabiopereira.carteira.models.dtos.usuario.*;
import br.com.fabiopereira.carteira.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<UsuarioDto> listar(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(usuario -> modelMapper.map(usuario, UsuarioDto.class));
    }

    @Transactional
    public void cadastrar (UsuarioForm usuarioForm) {
        Usuario usuario = modelMapper.map(usuarioForm, Usuario.class);

        usuario.setSenha(new Random().nextInt(999999) + "");
        usuarioRepository.save(usuario);
    }
}
