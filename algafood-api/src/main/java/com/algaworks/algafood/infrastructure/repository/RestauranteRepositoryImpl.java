package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurante> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("from Restaurante", Restaurante.class)
				.getResultList();
	}

	@Override
	public Restaurante buscar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Restaurante.class, id);
	}

	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		// TODO Auto-generated method stub
		return manager.merge(restaurante);
	}

	@Override
	@Transactional
	public void remover(Restaurante restaurante) {
		// TODO Auto-generated method stub
		restaurante = buscar(restaurante.getId());
		manager.remove(restaurante);

	}

}
