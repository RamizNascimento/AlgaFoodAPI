package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class AlteracaoRestauranteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
			
			RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
			
			Restaurante restaurante = new Restaurante();
			restaurante.setId(1L);
			restaurante.setNome("Chavitos");
			BigDecimal taxaFrete = new BigDecimal("1.5");
			restaurante.setTaxaFrete(taxaFrete);
			
			restauranteRepository.salvar(restaurante);
		
			
	}

}
