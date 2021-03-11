package com.klinger.JavaProjectOne;

import java.util.ArrayList;
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
import com.klinger.JavaProjectOne.domain.Produto;
import com.klinger.JavaProjectOne.domain.enums.TipoCliente;
import com.klinger.JavaProjectOne.repositories.CategoriaRepository;
import com.klinger.JavaProjectOne.repositories.CidadeRepository;
import com.klinger.JavaProjectOne.repositories.ClienteRepository;
import com.klinger.JavaProjectOne.repositories.EnderecoRepository;
import com.klinger.JavaProjectOne.repositories.EstadoRepository;
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
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
	}

}

