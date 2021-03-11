package com.klinger.JavaProjectOne.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klinger.JavaProjectOne.domain.Pedido;
import com.klinger.JavaProjectOne.repositories.PedidoRepository;
import com.klinger.JavaProjectOne.service.exceptions.ObjectNotFoundException;

@Service
public class PedidosService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
