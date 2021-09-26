package br.com.fabiopereira.carteira.controllers;

import br.com.fabiopereira.carteira.models.dtos.relatorio.ItemCarteiraDto;
import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import br.com.fabiopereira.carteira.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public Page<TransacaoDto> listar(@PageableDefault(size = 10) Pageable pageable) {
        return transacaoService.listar(pageable);
    }

    @PostMapping
    public ResponseEntity<TransacaoDto> cadastrar(@RequestBody @Valid TransacaoForm transacaoForm, UriComponentsBuilder uriComponentsBuilder) {
        TransacaoDto transacaoDto = transacaoService.cadastrar(transacaoForm);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .path("/transacoes/{id}").buildAndExpand(transacaoDto.getId())
                        .toUri())
                .body(transacaoDto);
    }

    @GetMapping("/relatorios/carteira")
    public List<ItemCarteiraDto> relatorioPosicoesPorcentagem() {
        return transacaoService.relatorioPosicoesPorcentagem();
    }
}
