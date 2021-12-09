package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class ExclusaoCozinhaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
			
			CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
			
			Cozinha cozinha = new Cozinha();
			cozinha.setId(1L);
			
			cozinhaRepository.remover(cozinha);
		
			
	}

}