package br.com.fabiopereira.carteira.services;

import br.com.fabiopereira.carteira.models.Transacao;
import br.com.fabiopereira.carteira.models.dtos.relatorio.ItemCarteiraDto;
import br.com.fabiopereira.carteira.models.dtos.transacao.*;
import br.com.fabiopereira.carteira.repositories.TransacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<TransacaoDto> listar(Pageable pageable) {
        return transacaoRepository.findAll(pageable)
                .map(transacao -> modelMapper.map(transacao, TransacaoDto.class));
    }

    @Transactional
    public TransacaoDto cadastrar (TransacaoForm transacaoForm) {
        Transacao transacao = modelMapper.map(transacaoForm, Transacao.class);
        transacao.setId(null);
        transacaoRepository.save(transacao);

        return modelMapper.map(transacao, TransacaoDto.class);
    }


    public List<ItemCarteiraDto> relatorioPosicoesPorcentagem() {
        return transacaoRepository.relatorioPosicoesPorcentagem();
    }
}
