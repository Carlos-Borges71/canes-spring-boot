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
import com.aplication.canes.entities.NotaFiscalEntitie;
import com.aplication.canes.entities.OperadorCliente;
import com.aplication.canes.entities.PagamentoEntitie;
import com.aplication.canes.entities.PedidoEntitie;
import com.aplication.canes.entities.PedidoProduto;
import com.aplication.canes.entities.ProdutoEntitie;
import com.aplication.canes.entities.TelefoneEntitie;
import com.aplication.canes.entities.UsuarioEntitie;
import com.aplication.canes.entities.enums.EstadoPedido;
import com.aplication.canes.entities.enums.Setor;
import com.aplication.canes.repositories.ClienteRepository;
import com.aplication.canes.repositories.EnderecoRepository;
import com.aplication.canes.repositories.FornecedorRepository;
import com.aplication.canes.repositories.NotaFiscalRepository;
import com.aplication.canes.repositories.OperadorClienteRepository;
import com.aplication.canes.repositories.PagamentoRepository;
import com.aplication.canes.repositories.PedidoProdutoRepository;
import com.aplication.canes.repositories.PedidoRepository;
import com.aplication.canes.repositories.ProdutoRepository;
import com.aplication.canes.repositories.TelefoneRepository;
import com.aplication.canes.repositories.UsuarioRepository;

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

	@Autowired
	private NotaFiscalRepository nfRepo;

	@Autowired
	private PedidoRepository pedRepo;

	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private PedidoProdutoRepository ppRepo;
	@Autowired
	private PagamentoRepository pgRepo;


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

		NotaFiscalEntitie n1 = new NotaFiscalEntitie(null,003,Instant.now(),for1);
		NotaFiscalEntitie n2 = new NotaFiscalEntitie(null,231,Instant.now(),for2);
		NotaFiscalEntitie n3 = new NotaFiscalEntitie(null,56,Instant.now(),for3);
		NotaFiscalEntitie n4 = new NotaFiscalEntitie(null,458,Instant.now(),for3);

		nfRepo.saveAll(Arrays.asList(n1,n2,n3,n4));

		PedidoEntitie p1 = new PedidoEntitie(null, EstadoPedido.AGUARDANDO_PAGAMENTO, 360.00, Instant.parse("2025-04-14T15:45:22Z"),cli1);
		PedidoEntitie p2 = new PedidoEntitie(null, EstadoPedido.PAGO, 320.00, Instant.parse("2025-04-18T15:00:22Z"),cli2);
		PedidoEntitie p3 = new PedidoEntitie(null, EstadoPedido.CANCELADO, 120.30, Instant.parse("2025-04-14T13:45:22Z"),cli3);

		pedRepo.saveAll(Arrays.asList(p1,p2,p3));

		ProdutoEntitie prod1 = new ProdutoEntitie( null,1010,"Calça Jeans",10, 100.00, 120.60,25, for3);
		ProdutoEntitie prod2 = new ProdutoEntitie( null,2020,"Vestido",20, 140.80, 160.60,5, for2);
		ProdutoEntitie prod3 = new ProdutoEntitie( null,3030,"Calça Esporte",40, 130.00, 180.60,15, for1);

		prodRepo.saveAll(Arrays.asList(prod1,prod2, prod3));

		PedidoProduto pp1 = new PedidoProduto(p1,prod1, 1);
		PedidoProduto pp2 = new PedidoProduto(p1, prod2, 1);
		PedidoProduto pp3 =new PedidoProduto(p1, prod2, 1);
		PedidoProduto pp4 =new PedidoProduto(p2, prod3, 1);
		PedidoProduto pp5 =new PedidoProduto(p3, prod1, 5);

		ppRepo.saveAll(Arrays.asList(pp1,pp2,pp3,pp4,pp5));


		PagamentoEntitie pg1 = new PagamentoEntitie(null, "Pix", Instant.now(),120.00, p2);
		PagamentoEntitie pg2 = new PagamentoEntitie(null, "Dinheiro", Instant.parse("2025-04-18T15:00:00Z"),360.00, p2);
		PagamentoEntitie pg3 = new PagamentoEntitie(null, "Visa", Instant.parse("2025-04-19T15:40:00Z"),136.00, p1);
		PagamentoEntitie pg4 = new PagamentoEntitie(null, "MasterCard", Instant.parse("2025-03-16T16:12:36Z"),350.00, p3);

		pgRepo.saveAll(Arrays.asList(pg1, pg2,pg3,pg4));
	}	
}
