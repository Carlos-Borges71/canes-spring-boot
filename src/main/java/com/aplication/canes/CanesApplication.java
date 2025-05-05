package com.aplication.canes;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aplication.canes.entities.FornecedorEntitie;
import com.aplication.canes.entities.UsuarioEntitie;

import com.aplication.canes.repositories.FornecedorRepository;
import com.aplication.canes.repositories.UsuarioRepository;

@SpringBootApplication
public class CanesApplication implements CommandLineRunner{

	@Autowired
	private FornecedorRepository  forRepo;

	@Autowired
	private UsuarioRepository  useRepo;

	

	public static void main(String[] args) {
		SpringApplication.run(CanesApplication.class, args);
	}

	// inserindo dados no banco h2 //
	//fornecedores
	@Override
	public void run(String... args) throws Exception {

		FornecedorEntitie for1 = new FornecedorEntitie(null, "Cia Roupas", "02.232.412/0001-02");
		FornecedorEntitie for2 = new FornecedorEntitie(null, "TCI Roupas", "10.236.589/0001/01");
		FornecedorEntitie for3 = new FornecedorEntitie(null, "HD Fabrica", "25.698.897/001-02");

		forRepo.saveAll(Arrays.asList(for1,for2,for3));

		
		UsuarioEntitie use1 = new UsuarioEntitie(null, null, "Willian black", "black", null, "1234");
		UsuarioEntitie use2 = new UsuarioEntitie(null, null, "Sebastião Yellon", "yellon", null, "1234");
		UsuarioEntitie use3 = new UsuarioEntitie(null, null, "João Pink", "pink", null, "1234");

		useRepo.saveAll(Arrays.asList(use1,use2,use3));
	}
}
