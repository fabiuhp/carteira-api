package br.com.fabiopereira.carteira.controllers;

import br.com.fabiopereira.carteira.models.dtos.usuario.*;
import br.com.fabiopereira.carteira.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm,
                                                UriComponentsBuilder uriComponentsBuilder) {
        UsuarioDto usuarioDto = usuarioService.cadastrar(usuarioForm);

        return ResponseEntity.created(uriComponentsBuilder
                        .path("/usuarios/{id}")
                        .buildAndExpand(usuarioDto.getId())
                        .toUri())
                .body(usuarioDto);
    }
}
