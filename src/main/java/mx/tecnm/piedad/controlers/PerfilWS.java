package mx.tecnm.piedad.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import mx.tecnm.piedad.dao.PerfilJDBC;
import mx.tecnm.piedad.models.Perfil;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class PerfilWS {

@Autowired PerfilJDBC repo;

	@PostMapping("/{cuenta-id}/perfiles")
		public ResponseEntity<?> creaPerfil(@PathVariable("cuenta-id") int cuentaid, @RequestBody Perfil perfil){
		repo.creaPerfil(cuentaid, perfil);
		return new ResponseEntity<>(HttpStatus.CREATED);	
}
	@GetMapping("/{cuenta-id}/perfiles")
		public ResponseEntity<?> muestraPerfiles(@PathVariable ("cuenta-id") int cuentaid){
		List<Perfil> resultado = repo.muestraPerfiles(cuentaid);
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}
	
	@PutMapping("/{cuenta-id}/perfiles/{perfil-id}")
		public ResponseEntity<?> modificaPerfil(@PathVariable("cuenta-id") int cuentaid, @PathVariable("perfil-id") int perfilid, @RequestBody Perfil perfil){
		repo.modificaPerfil(cuentaid, perfilid, perfil);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{cuenta-id}/perfiles/{perfil-id}")
	public ResponseEntity<?> borrarPerfil(@PathVariable ("cuenta-id") int cuentaid, @PathVariable ("perfil-id") int perfilid){
		repo.borrarPerfil(cuentaid, perfilid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/{cuenta-id}/perfiles/{perfil-id}")
	public ResponseEntity<?> mostrarPerfil(@PathVariable ("cuenta-id")int cuentaid, @PathVariable ("perfil-id")int perfilid){
		
		
		Perfil resultado = repo.mostrarPerfil(cuentaid, perfilid);
		
		return new ResponseEntity<>(resultado, HttpStatus.OK);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
