package br.com.karanmelo.mc.sevices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.karanmelo.mc.domain.Pedido;
import br.com.karanmelo.mc.repositories.PedidoRepository;
import br.com.karanmelo.mc.sevices.exception.ObjectNotFoundException;

@Service
public class PedidoServices {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {  
		Optional<Pedido> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getSimpleName(), null)); 
	} 
}
