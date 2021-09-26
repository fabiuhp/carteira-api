package br.com.fabiopereira.carteira.services;

import br.com.fabiopereira.carteira.models.Transacao;
import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import br.com.fabiopereira.carteira.repositories.TransacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public List<TransacaoDto> listar() {
        return transacaoRepository.findAll()
                .stream()
                .map(transacao -> modelMapper.map(transacao, TransacaoDto.class))
                .toList();
    }

    public void cadastrar (TransacaoForm transacaoForm) {
        transacaoRepository.save(modelMapper.map(transacaoForm, Transacao.class));
    }
}
