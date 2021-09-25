package br.com.fabiopereira.carteira.controllers;

import br.com.fabiopereira.carteira.models.Transacao;
import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private ModelMapper modelMapper = new ModelMapper();
    private List<Transacao> transacaoList = new ArrayList<>();

    @GetMapping
    public List<TransacaoDto> listar() {
        return transacaoList.stream().map(transacao -> modelMapper.map(transacao, TransacaoDto.class)).toList();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid TransacaoForm transacaoForm) {
        transacaoList.add(modelMapper.map(transacaoForm, Transacao.class));
    }
}
