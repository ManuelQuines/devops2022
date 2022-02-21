package mx.tecnm.piedad.controlers;

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

import mx.tecnm.piedad.dao.cuentaJDBC;
import mx.tecnm.piedad.models.Cuenta;
import mx.tecnm.piedad.models.Plan;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class CuentaWS {

	@Autowired
	cuentaJDBC repo;
	
	@PutMapping("{cuenta-id}")
	public ResponseEntity<?> modificarCuenta(@PathVariable("cuenta-id")int cuentaid, @RequestBody Cuenta cuenta){
		repo.modificarCuenta(cuenta, cuentaid);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
    
	
	@PutMapping("/{plan-id}/cuentas/{cuenta-id}")
    public ResponseEntity<?> cambiarPlanCuenta(@PathVariable("plan-id") int planid, @PathVariable ("cuenta-id")int cuentaid){
    	repo.cambiarPlanCuenta(planid, cuentaid);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }

	
	@DeleteMapping("{cuenta-id}")
	public ResponseEntity<?> desactivaCuenta(@PathVariable ("cuenta-id")int cuentaid){
		repo.desactivaCuenta(cuentaid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody Cuenta cuenta){
			try {
				
				Cuenta resultado = repo.login(cuenta);
				return new ResponseEntity<>(resultado, HttpStatus.OK);				
				} catch (DataAccessException e) {
					
				return new ResponseEntity<>( HttpStatus.NO_CONTENT);
				}
		}
	



}
	
	
