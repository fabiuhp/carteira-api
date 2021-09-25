package br.com.fabiopereira.carteira.services;

import br.com.fabiopereira.carteira.models.*;
import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import br.com.fabiopereira.carteira.models.dtos.usuario.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransacaoService {

    private ModelMapper modelMapper = new ModelMapper();
    private List<Transacao> transacaoList = new ArrayList<>();

    public List<TransacaoDto> listar() {
        return transacaoList.stream().map(transacao -> modelMapper.map(transacao, TransacaoDto.class)).toList();
    }

    public void cadastrar (TransacaoForm transacaoForm) {
        transacaoList.add(modelMapper.map(transacaoForm, Transacao.class));
    }
}
