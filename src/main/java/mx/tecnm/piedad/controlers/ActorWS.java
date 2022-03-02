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

import mx.tecnm.piedad.dao.ActorJDBC;
import mx.tecnm.piedad.models.Actores;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})


public class ActorWS {

	@Autowired
	ActorJDBC repo;
	
	
			@PostMapping("/actores")
			 public ResponseEntity<?> AgregarActor(@RequestBody Actores nuevo_actor){
		    	try {
		    	repo.AgregarActor(nuevo_actor);
		    	return new ResponseEntity<>( HttpStatus.CREATED);
		    } catch (DataAccessException e) {
		    	System.out.println(e.getMessage());
		    	return new ResponseEntity<>(HttpStatus.CONFLICT);
		    	
		    	}
		    }
			

}

			
	
	


