package br.com.apisicred.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisicred.model.Eleicao;
import br.com.apisicred.model.Pauta;

@Repository
public interface EleicaoRepository extends JpaRepository<Eleicao, Integer> {
	 Optional<Eleicao> findByPauta(Pauta pauta);
}
