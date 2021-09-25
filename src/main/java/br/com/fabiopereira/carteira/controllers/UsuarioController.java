package br.com.fabiopereira.carteira.controllers;

import br.com.fabiopereira.carteira.models.*;
import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import br.com.fabiopereira.carteira.models.dtos.usuario.*;
import br.com.fabiopereira.carteira.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid UsuarioForm usuarioForm) {
        usuarioService.cadastrar(usuarioForm);
    }
}
