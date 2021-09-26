package br.com.fabiopereira.carteira.repositories;

import br.com.fabiopereira.carteira.models.Transacao;
import br.com.fabiopereira.carteira.models.dtos.relatorio.ItemCarteiraDto;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query("""
            select new br.com.fabiopereira.carteira.models.dtos.relatorio.ItemCarteiraDto(
            t.ticker,
            sum(t.quantidade),
            sum(t.quantidade)* 1.0 / (select sum(t2.quantidade) from Transacao t2) * 1.0)
            from Transacao t
            group by t.ticker
            """)
    List<ItemCarteiraDto> relatorioPosicoesPorcentagem();
}
