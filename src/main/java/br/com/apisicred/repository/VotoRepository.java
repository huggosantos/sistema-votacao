package br.com.apisicred.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.apisicred.model.Eleicao;
import br.com.apisicred.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
	  Boolean existsByEleicaoAndCpfAssociado(Eleicao eleicao, String cpfAssociado);
	  
	  @Query(value = "select v.cpf_associado as cpfAss from voto v where v.id_eleicao= :idEleicao and v.cpf_associado= :cpfAssociado",nativeQuery = true)
	  public String verificaAssociado(@Param("idEleicao") Integer codEleicao, @Param("cpfAssociado")String cpf);
}
