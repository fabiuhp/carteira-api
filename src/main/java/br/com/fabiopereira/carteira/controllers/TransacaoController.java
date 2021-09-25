package br.com.fabiopereira.carteira.controllers;

import br.com.fabiopereira.carteira.models.Transacao;
import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import br.com.fabiopereira.carteira.services.TransacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<TransacaoDto> listar() {
        return transacaoService.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid TransacaoForm transacaoForm) {
        transacaoService.cadastrar(transacaoForm);
    }
}
