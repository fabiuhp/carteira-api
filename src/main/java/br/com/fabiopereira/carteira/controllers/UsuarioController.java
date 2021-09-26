package br.com.fabiopereira.carteira.controllers;

import br.com.fabiopereira.carteira.models.dtos.usuario.*;
import br.com.fabiopereira.carteira.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<UsuarioDto> listar(@PageableDefault(size = 10) Pageable pageable) {
        return usuarioService.listar(pageable);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid UsuarioForm usuarioForm) {
        usuarioService.cadastrar(usuarioForm);
    }
}
