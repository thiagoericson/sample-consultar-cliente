package br.com.treinamento.consultarcliente.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.consultarcliente.model.Cliente;
import br.com.treinamento.consultarcliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
    @Autowired
    ClienteService clienteService;

    @GetMapping("")
    public Page<Cliente> list(@PageableDefault(page = 0, size = 10) Pageable page, @RequestParam(required = false) String nome) {
    	return clienteService.listAllCliente(nome, page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Integer id) {
        try {
            Cliente cliente = clienteService.getCliente(id);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }
}