package com.aplication.canes;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aplication.canes.entities.ClienteEntitie;
import com.aplication.canes.entities.FornecedorEntitie;
import com.aplication.canes.entities.OperadorCliente;
import com.aplication.canes.entities.UsuarioEntitie;
import com.aplication.canes.entities.enums.Setor;
import com.aplication.canes.repositories.ClienteRepository;
import com.aplication.canes.repositories.FornecedorRepository;
import com.aplication.canes.repositories.OperadorClienteRepository;
import com.aplication.canes.repositories.UsuarioRepository;

@SpringBootApplication
public class CanesApplication implements CommandLineRunner{

	@Autowired
	private FornecedorRepository  forRepo;

	@Autowired
	private UsuarioRepository  useRepo;

	@Autowired
	private ClienteRepository cliRepo;

	@Autowired
	private OperadorClienteRepository operClieRepo;

	

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

		
		UsuarioEntitie use1 = new UsuarioEntitie(null, Setor.VENDA, "Willian black", "black", Instant.now(), "1234");
		UsuarioEntitie use2 = new UsuarioEntitie(null, Setor.ADMINISTRATIVO, "Sebastião Yellon", "yellon", Instant.parse("2025-05-10T10:00:00Z"), "1234");
		UsuarioEntitie use3 = new UsuarioEntitie(null,Setor.GERENCIA, "João Pink", "pink", Instant.parse("2025-04-10T11:00:00Z"), "1234");

		

		ClienteEntitie cli1 = new ClienteEntitie(null,"Karla Blue",Instant.parse("2025-05-10T10:00:00Z"));
		ClienteEntitie cli2 = new ClienteEntitie(null,"David Orange",Instant.parse("2025-05-10T17:00:00Z"));
		ClienteEntitie cli3 = new ClienteEntitie(null,"Denise Gray",Instant.parse("2025-03-10T15:00:00Z"));

		OperadorCliente operCli1 = new OperadorCliente(use1, cli1);
		OperadorCliente operCli2 = new OperadorCliente(use1, cli2);
		OperadorCliente operCli3 = new OperadorCliente(use2, cli3);

		
		cliRepo.saveAll(Arrays.asList(cli1,cli2,cli3));
		useRepo.saveAll(Arrays.asList(use1,use2,use3));
		operClieRepo.saveAll(Arrays.asList(operCli1, operCli2, operCli3));
	}	
}
