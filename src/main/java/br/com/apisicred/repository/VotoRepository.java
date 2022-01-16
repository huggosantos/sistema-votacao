package br.com.apisicred.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisicred.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
}
