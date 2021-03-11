package com.klinger.JavaProjectOne.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.klinger.JavaProjectOne.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date daPagamento;
	
	public PagamentoComBoleto() {		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date daPagamento) {
		super(id, estado, pedido);
		this.daPagamento = daPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDaPagamento() {
		return daPagamento;
	}

	public void setDaPagamento(Date daPagamento) {
		this.daPagamento = daPagamento;
	}
	
	
}
