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

import mx.tecnm.piedad.dao.ActorJDBC;
import mx.tecnm.piedad.models.Actores;
@RestController

@RequestMapping("/api/actores")



@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})


public class ActorWS {

	@Autowired
	ActorJDBC repo;
	

	@PostMapping()
	 public ResponseEntity<?> AgregarActor(@RequestBody Actores nuevo_actor){
    	try {
    	repo.AgregarActor(nuevo_actor);
    	return new ResponseEntity<>( HttpStatus.CREATED);
    } catch (DataAccessException e) {
    	System.out.println(e.getMessage());
    	return new ResponseEntity<>(HttpStatus.CONFLICT);
    	
    	}
    }
	
	@GetMapping()
	public ResponseEntity<?> CatalogoActores(){
		try {
			List<Actores> resultado = repo.CatalogoActores();
			return new ResponseEntity<> (resultado, HttpStatus.OK);	
		}	catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		}	
	}
	
	
	@PutMapping("/{actor-id}")
	public ResponseEntity<?> ModificarActor (@PathVariable ("actor-id") int actorid, @RequestBody Actores actor){
    	repo.ModificaActor(actor, actorid);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{actor-id}")
	public ResponseEntity<?> EliminaActor (@PathVariable ("actor-id") int actorid){
		repo.EliminaActor(actorid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	
			

}

			
	
	


