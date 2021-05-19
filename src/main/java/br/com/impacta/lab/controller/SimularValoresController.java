package br.com.impacta.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simular")
public class SimularValoresController {

	@GetMapping
	public ResponseEntity<String> simularValores(@RequestParam(name="codigoProduto") int codigoProduto,
			@RequestParam(name="codTipoPagamento") int codTipoPagamento) {
		/*
		 * Exemplo de chamada:
		 * https://localhost:8080/simular?codigoProduto=1&codTipoPagamento=2
		 * 
		 * Elabore um algoritmo para calcular o valor final de um produto com base em seu valor REAL
		 *  e a condição de pagamento.
		 *  
		 *  A escolha do produto e sua condição de pagamento da-se através de seus códigos, faça um 
		 *  algoritmo também para realizar a escolha de cada um dos itens a partir de seus códigos.
		 *  
		 *  Tabela de produto
		 *  
		 *  CodigoProduto	descrição do Produto		Valor do Produto
		 * 	1				Camisa						70.00
		 * 	2				Shorts						57.50
		 * 	3				Meia						9.99
		 * 	4				Toca						35.00
		 * 	5				Luvas						19.50
		 * 
		 * -----------------------------------------------------------------
		 * 
		 * Tabela de condição de pagamento
		 * 
		 * 	CodTipoPagamento		descrição da condição de pagamento
		 * 	1						A vista no dinheiro com 10% de desconto
		 * 	2						A vista no cartão de crédito  com 5% de desconto
		 * 	3						Em duas parcelas sem nenhum desconto
		 * 	4						Em três vezes com 10% de juros
		 * 
		 * OBS: Considerar sempre os descontos ou juros do valor do produto
		 * A resposta do exercicio deve seguir o seguinte formato:
		 * 
		 * <descrição do produto> sendo pago <descrição da condição de pagamento> custará <valor final do produto> reais
		 * 
		 * Ex.: Camisa sendo pago A vista no dinheiro com 10% de desconto custará 63.0 reais
		 * 
		 */
		
		String produto = "";
		String desc_pagamento = "";
		double valor_base = 0;
		double valor_final = 0;



		 if(codigoProduto == 1){
			valor_base =  70.00;
			produto = "Camisa";
		 }else if(codigoProduto == 2){
			valor_base =  57.50;
			produto = "Shorts";
		}else if(codigoProduto == 3){
			valor_base =  9.99;
			produto = "Meia";
		}else if(codigoProduto == 4){
			valor_base =  35.00;
			produto = "Toca";
		}else if(codigoProduto == 5){
			valor_base =  19.50;
			produto = "Luvas";
		}

		if(codTipoPagamento == 1){
			valor_final =  valor_base - (valor_base * 0.1);
			desc_pagamento = "A vista no dinheiro com 10% de desconto";
		 }else if(codTipoPagamento == 2){
			valor_final =  valor_base - (valor_base * 0.05);
			desc_pagamento = "A vista no cartão de crédito  com 5% de desconto";
		}else if(codTipoPagamento == 3){
			valor_final =  valor_base;
			desc_pagamento = "Em duas parcelas sem nenhum desconto";
		}else if(codTipoPagamento == 4){
			valor_final =  valor_base + (valor_base * 0.1);
			desc_pagamento = "Em três vezes com 10% de juros";
		} 
		
		return ResponseEntity.ok(produto + " sendo pago " + desc_pagamento + " custará " + valor_final + " reais");
	}
	
}
