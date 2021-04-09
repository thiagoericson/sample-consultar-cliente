package br.com.treinamento.consultarcliente.service;

// import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.treinamento.consultarcliente.model.Cliente;
import br.com.treinamento.consultarcliente.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
    
	@Autowired
    private ClienteRepository clienteRepository;
    
	public Page<Cliente> listAllCliente(String nome, Pageable page) {
		if (nome == null)
			return clienteRepository.findAll(page);
		else
			return clienteRepository.findByPrimeiroNomeContaining(nome, page);
    }

    public Cliente getCliente(Integer id) {
        return clienteRepository.findById(id).get();
    }
}