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

import mx.tecnm.piedad.dao.GenerosJDBC;
import mx.tecnm.piedad.models.Generos;

@RestController

@RequestMapping("/api/generos")



@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class GeneroWS {

	
	@Autowired
	GenerosJDBC repo;
	
	
	@PostMapping()
	public ResponseEntity<?> AgregaGenero(@RequestBody Generos nuevo_genero){
		try {
			repo.AgregarGenero(nuevo_genero);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>( HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/{genero-id}")
	public ResponseEntity<?> ModificaGenero(@PathVariable("genero-id") int generoid, @RequestBody Generos genero){
		
		
		try {
			repo.ModificaGenero(genero, generoid);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DataAccessException e) {
			
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}
	
	@GetMapping()
	public ResponseEntity<?> CatalogoGeneros(){
		try {
		List<Generos> resultado= repo.CatalogoGeneros();
		return new ResponseEntity<>(resultado, HttpStatus.OK);
		} catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		}
	
	@DeleteMapping("/{genero-id}")
	public ResponseEntity<?> DesactivaGenero (@PathVariable("genero-id") int generoid){
		try {
			repo.EliminaGenero(generoid);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}
	
	
}
