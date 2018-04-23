package br.senai.sp.info.pweb.jucacontrol.dao;

import java.util.List;

import br.senai.sp.info.pweb.jucacontrol.models.BuscaPorSituacaoOcorrencia;
import br.senai.sp.info.pweb.jucacontrol.models.Ocorrencia;

public interface OcorrenciaDAO extends DAO<Ocorrencia> {
	
	public List<Ocorrencia> buscarPorSituacao(BuscaPorSituacaoOcorrencia situacao);
	
}
