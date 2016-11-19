package br.ufg.inf.dao;

import br.ufg.inf.entidades.TipoIngresso;
import br.ufg.inf.interfaces.dao.InterfaceTipoIngressoDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class TipoIngressoDao implements InterfaceTipoIngressoDao {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adicionarTipoIngresso(TipoIngresso umTipoIngresso) {
		manager.persist(umTipoIngresso);
	}

	@Override
	public void removerTipoIngresso(TipoIngresso umTipoIngresso) {
		TipoIngresso TipoIngressoARemover = buscarPorNome(umTipoIngresso.getNome());
		manager.remove(TipoIngressoARemover);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoIngresso> listarTipoIngresso() {
		
		return manager.createQuery("from TipoIngresso").getResultList();
	}

	@Override
	public void alterarTipoIngresso(TipoIngresso umTipoIngresso) {
		manager.merge(umTipoIngresso);
	}

	@Override
	public TipoIngresso buscarPorNome(String nome) {
		return manager.find(TipoIngresso.class, nome);
	}
}