package br.com.karanmelo.mc.sevices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.karanmelo.mc.domain.Cliente;
import br.com.karanmelo.mc.repositories.ClienteRepository;
import br.com.karanmelo.mc.sevices.exception.ObjectNotFoundException;

@Service
public class ClienteServices {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {  
		Optional<Cliente> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getSimpleName(), null)); 
	} 
}
