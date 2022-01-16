package br.com.apisicred.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisicred.model.Eleicao;

@Repository
public interface EleicaoRepository extends JpaRepository<Eleicao, Integer> {

}
