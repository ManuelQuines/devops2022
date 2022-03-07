package mx.tecnm.piedad.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.CategoriaJDBC;
import mx.tecnm.piedad.models.Categorias;
@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})


public class CategoriasWS {
	@Autowired
	CategoriaJDBC repo;
	
	
			@PostMapping()
			 public ResponseEntity<?> AgregarCategoria(@RequestBody Categorias nueva_categoria){
		    	try {
		    	repo.AgrgarCategoria(nueva_categoria);
		    	return new ResponseEntity<>( HttpStatus.CREATED);
		    } catch (DataAccessException e) {
		    	System.out.println(e.getMessage());
		    	return new ResponseEntity<>(HttpStatus.CONFLICT);
		    	
		    	}
		    }
			
			@GetMapping()
			public ResponseEntity<?> CatalogoCategoria(){
				try {
					List<Categorias> resultado = repo.catalogoCategoria();
					return new ResponseEntity<> (resultado, HttpStatus.OK);	
				}	catch(DataAccessException e) {
					System.out.println(e.getMessage());
					return new ResponseEntity<> (HttpStatus.NO_CONTENT);
				}	
			}
			
			@GetMapping("/{categoria-id}")
			public ResponseEntity<?> ConsultaCategoria (@PathVariable ("categoria-id") int categoriaid){
				try {
					Categorias resultado = repo.ConsultaCategoria(categoriaid);
					return new ResponseEntity<> (resultado, HttpStatus.OK);
				} catch (DataAccessException e) {
					System.out.println(e.getMessage());
					return new ResponseEntity<> (HttpStatus.NO_CONTENT);
				}
			}
			
			@PutMapping("/{categoria-id}")
			public ResponseEntity<?> ModificarCategoria (@PathVariable ("categoria-id") int categoriaid, @RequestBody Categorias categoria){
		    	repo.ModificaCategoria(categoria, categoriaid);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			
			@DeleteMapping("/{categoria-id}")
			public ResponseEntity<?> EliminarCategoria (@PathVariable ("categoria-id") int categoriaid){
				repo.EliminaCategoria(categoriaid);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
	
}
