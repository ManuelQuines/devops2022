package mx.tecnm.piedad.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.CategoriaJDBC;
import mx.tecnm.piedad.models.Categorias;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})


public class CategoriasWS {
	@Autowired
	CategoriaJDBC repo;
	
	
			@PostMapping("/categorias")
			 public ResponseEntity<?> AgregarCategoria(@RequestBody Categorias nueva_categoria){
		    	try {
		    	repo.AgrgarCategoria(nueva_categoria);
		    	return new ResponseEntity<>( HttpStatus.CREATED);
		    } catch (DataAccessException e) {
		    	System.out.println(e.getMessage());
		    	return new ResponseEntity<>(HttpStatus.CONFLICT);
		    	
		    	}
		    }
	
}
