package br.com.karanmelo.mc.sevices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.karanmelo.mc.domain.Categoria;
import br.com.karanmelo.mc.repositories.CategoriaRepository;
import br.com.karanmelo.mc.sevices.exception.ObjectNotFoundException;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {  
		Optional<Categoria> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName(), null)); 
	} 
	
	public Categoria insert(Categoria obj) {
		obj.setID(null);
		return repo.save(obj);
	}
}
