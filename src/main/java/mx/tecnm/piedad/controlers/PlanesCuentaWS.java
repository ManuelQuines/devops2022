package mx.tecnm.piedad.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.cuentaJDBC;

import mx.tecnm.piedad.models.Cuenta;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class PlanesCuentaWS {

	@Autowired
	cuentaJDBC repo;

	
	
    @PostMapping("/{plan-id}/cuentas")
    public ResponseEntity<?> creaCuenta(@PathVariable("plan-id") int planid, @RequestBody Cuenta nueva_cuenta){
    	try {
    		repo.creaCuenta(planid, nueva_cuenta);
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	} catch (DataAccessException e) {
    		System.out.println(e.getMessage());
        	return new ResponseEntity<>(HttpStatus.CONFLICT);    	
    	}
    }
    
    @PutMapping("/{plan-id}/cuentas/{cuenta-id}")
    public ResponseEntity<?> cambiarPlanCuenta(@PathVariable ("plan-id")int planid, @PathVariable("cuenta-id") int cuentaid){
    	repo.cambiarPlanCuenta(planid, cuentaid);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    
}

