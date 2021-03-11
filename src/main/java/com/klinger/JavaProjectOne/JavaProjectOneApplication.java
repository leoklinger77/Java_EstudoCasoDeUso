package com.klinger.JavaProjectOne;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klinger.JavaProjectOne.domain.Categoria;
import com.klinger.JavaProjectOne.domain.Cidade;
import com.klinger.JavaProjectOne.domain.Cliente;
import com.klinger.JavaProjectOne.domain.Endereco;
import com.klinger.JavaProjectOne.domain.Estado;
import com.klinger.JavaProjectOne.domain.ItemPedido;
import com.klinger.JavaProjectOne.domain.Pagamento;
import com.klinger.JavaProjectOne.domain.PagamentoComBoleto;
import com.klinger.JavaProjectOne.domain.PagamentoComCartao;
import com.klinger.JavaProjectOne.domain.Pedido;
import com.klinger.JavaProjectOne.domain.Produto;
import com.klinger.JavaProjectOne.domain.enums.EstadoPagamento;
import com.klinger.JavaProjectOne.domain.enums.TipoCliente;
import com.klinger.JavaProjectOne.repositories.CategoriaRepository;
import com.klinger.JavaProjectOne.repositories.CidadeRepository;
import com.klinger.JavaProjectOne.repositories.ClienteRepository;
import com.klinger.JavaProjectOne.repositories.EnderecoRepository;
import com.klinger.JavaProjectOne.repositories.EstadoRepository;
import com.klinger.JavaProjectOne.repositories.ItemPedidoRepository;
import com.klinger.JavaProjectOne.repositories.PagamentoRepository;
import com.klinger.JavaProjectOne.repositories.PedidoRepository;
import com.klinger.JavaProjectOne.repositories.ProdutoRepository;

@SpringBootApplication
public class JavaProjectOneApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JavaProjectOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));		
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3601856548", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("1147894789","1123562356"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "381256825", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "SAla 800", "Centro", "066222580", cli1, c2);		
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/20217 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 10:32"), cli1, e2);
		
		Pagamento pagt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagt1);
		
		
		Pagamento pagt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagt2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagt1,pagt2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
	}

}

