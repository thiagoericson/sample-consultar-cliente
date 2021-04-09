package br.com.treinamento.consultarcliente.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  br.com.treinamento.consultarcliente.model.ClienteMock;

@RestController
@RequestMapping("/mock")
public class ClienteMockController {

	private Map<Long, ClienteMock> clientes;

	public ClienteMockController() {
		clientes = new HashMap<Long, ClienteMock>();

		ClienteMock c1 = new ClienteMock(99912345678L, "Luiz Otávio", "29/11/1983", "M", 3900.00, "Operador");
		ClienteMock c2 = new ClienteMock(88812345678L, "Antonio Mendes", "16/10/1983", "M", 2500.00, "Auxiliar");
		ClienteMock c3 = new ClienteMock(77712345678L, "Joaquim Silva", "10/04/1983", "M", 3300.00, "Atendente");
		ClienteMock c4 = new ClienteMock(66612345678L, "Maria Antonia", "28/02/1983", "F", 4100.00, "Vendedora");
		ClienteMock c5 = new ClienteMock(55512345678L, "Vanessa Oliveira", "08/09/1983", "F", 5200.00, "Supervisora");

		clientes.put(99912345678L, c1);
		clientes.put(88812345678L, c2);
		clientes.put(77712345678L, c3);
		clientes.put(66612345678L, c4);
		clientes.put(55512345678L, c5);
	}

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteMock>> listarMock() {
		return new ResponseEntity<List<ClienteMock>>(new ArrayList<ClienteMock>(clientes.values()), HttpStatus.OK);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteMock> buscarMock(@PathVariable("id") Long cpf) {
		ClienteMock cliente = clientes.get(cpf);
		
		if(cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ClienteMock>(cliente, HttpStatus.OK);
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> adicionar(@RequestBody ClienteMock novoCliente) {

		ClienteMock cliente = clientes.get(novoCliente.getCpf());

		if(cliente != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		clientes.put(novoCliente.getCpf(), novoCliente);

		cliente = clientes.get(novoCliente.getCpf());

		return new ResponseEntity<ClienteMock>(cliente, HttpStatus.OK);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> atualizar(@PathVariable("id") Long cpf, @RequestBody ClienteMock clienteAtualizado) {

		ClienteMock cliente = clientes.get(cpf);

		if(cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		cliente.setNome(clienteAtualizado.getNome());
		cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
		cliente.setSexo(clienteAtualizado.getSexo());
		cliente.setSalario(clienteAtualizado.getSalario());
		cliente.setProfissao(clienteAtualizado.getProfissao());

		clientes.replace(cpf, cliente);

		cliente = clientes.get(cpf);

		return new ResponseEntity<ClienteMock>(cliente, HttpStatus.OK);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> remover(@PathVariable("id") Long cpf) {
		ClienteMock cliente = clientes.remove(cpf);
		if (cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
