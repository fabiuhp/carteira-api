package br.com.fabiopereira.carteira.controllers;

import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import br.com.fabiopereira.carteira.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public Page<TransacaoDto> listar(Pageable pageable) {
        return transacaoService.listar(pageable);
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid TransacaoForm transacaoForm) {
        transacaoService.cadastrar(transacaoForm);
    }
}
