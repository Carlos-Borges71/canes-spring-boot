package com.aplication.canes.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aplication.canes.entities.ClienteEntitie;
import com.aplication.canes.entities.EnderecoEntitie;
import com.aplication.canes.entities.FornecedorEntitie;
import com.aplication.canes.entities.OperadorCliente;
import com.aplication.canes.entities.TelefoneEntitie;
import com.aplication.canes.entities.UsuarioEntitie;
import com.aplication.canes.entities.enums.Setor;
import com.aplication.canes.repositories.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    // inserindo dados no banco h2 //
	//fornecedores

    @Autowired
	private FornecedorRepository  forRepo;

	@Autowired
	private UsuarioRepository  useRepo;

	@Autowired
	private ClienteRepository cliRepo;

	@Autowired
	private OperadorClienteRepository operClieRepo;

	@Autowired
	private TelefoneRepository telrepo;

	@Autowired
	private EnderecoRepository endRepo;


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
        OperadorCliente operCli4 = new OperadorCliente(use3, cli3);
		
		cliRepo.saveAll(Arrays.asList(cli1,cli2,cli3));
		useRepo.saveAll(Arrays.asList(use1,use2,use3));
		operClieRepo.saveAll(Arrays.asList(operCli1, operCli2, operCli3, operCli4));

		TelefoneEntitie t1 = new TelefoneEntitie(null, "(56)2589-8878",cli1, null, null);
		TelefoneEntitie t2 = new TelefoneEntitie(null, "(21)98563-8978)", cli2, null, null);
		TelefoneEntitie t3 = new TelefoneEntitie(null, "(61)2589-9898", cli3, null, null);
		TelefoneEntitie t4 = new TelefoneEntitie(null, "(21)9898-5858", null, null, for1);
		telrepo.saveAll(Arrays.asList(t1, t2,t3,t4));

		EnderecoEntitie end1 = new EnderecoEntitie(null, "Rua A", "25", "Vila", "Iguaçu", "Sergipe", "26000-550", cli1,null, null);
		EnderecoEntitie end2 = new EnderecoEntitie(null, "AV Atlantica", "1230", "Copacabana", "Rio de Janeiro", "Rio de Janeiro", "26000-550", cli2,null, null);
		EnderecoEntitie end3 = new EnderecoEntitie(null, "Rua J", "250", "Vila Tem", "Barro", "Sergipe", "26120-550", null, use1, null);

		endRepo.saveAll(Arrays.asList(end1, end2, end3));
	}	
}
