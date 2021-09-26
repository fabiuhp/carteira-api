package br.com.fabiopereira.carteira.repositories;

import br.com.fabiopereira.carteira.models.Transacao;
import br.com.fabiopereira.carteira.models.dtos.relatorio.ItemCarteiraDto;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query("""
            select 
            new br.com.fabiopereira.carteira.models.dtos.relatorio.ItemCarteiraDto(
            t.ticker,
            sum(case when(t.tipo='COMPRA') then t.quantidade ELSE (t.quantidade * -1) end),
            (select sum(case when(t2.tipo='COMPRA') then t2.quantidade ELSE (t2.quantidade * -1) end) from Transacao t2))
            from Transacao t
            group by t.ticker
            """)
    List<ItemCarteiraDto> relatorioPosicoesPorcentagem();
}
