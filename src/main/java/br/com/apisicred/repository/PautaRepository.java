package br.com.apisicred.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisicred.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer>  {
}
