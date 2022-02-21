package mx.tecnm.piedad.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Cuenta;


@Repository
public class cuentaJDBC {
	
	@Autowired
	private JdbcTemplate conexion;
	
	public void creaCuenta (int planid, Cuenta nueva_cuenta) {
	
		String sql = "INSERT INTO cuentas"
				+ "(id, email, password, activa, fecha_ultimo_pago, nombre, apellido,"
				+ "numero_tarjeta, fecha_vencimiento, codigo_seguridad, tipo_tarjeta, planes_id)"
				+ "VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?)";
				conexion.update(sql,nueva_cuenta.getId(),nueva_cuenta.getEmail(),nueva_cuenta.getPassword(),
						nueva_cuenta.getActiva(), nueva_cuenta.getFecha_ultimo_pago(), nueva_cuenta.getNombre(),
						nueva_cuenta.getApellido(),nueva_cuenta.getNumero_tarjeta(),nueva_cuenta.getFecha_vencimiento(),
						nueva_cuenta.getCodigo_seguridad(),nueva_cuenta.getTipo_tarjeta(), planid);
	}
	
	public void cambiarPlanCuenta(int planid, int idcuenta) {
		String sql = "UPDATE cuentas SET planes_id=? where id=?";
		conexion.update(sql,planid,idcuenta);
	}
	
	public void modificarCuenta (Cuenta cuenta, int cuentaid) {
		String sql = "UPDATE cuentas SET email = ?, password = ?, nombre = ?, apellido = ?,"
				+ "numero_tarjeta = ?, fecha_vencimiento = ?, codigo_seguridad = ?, tipo_tarjeta = ?"
				+ "WHERE id = ?";
		conexion.update(sql,cuenta.getEmail(),cuenta.getPassword(), cuenta.getNombre(),
				cuenta.getApellido(),cuenta.getNumero_tarjeta(),cuenta.getFecha_vencimiento(),
				cuenta.getCodigo_seguridad(),cuenta.getTipo_tarjeta(), cuentaid);	
	}
	
	public void desactivaCuenta (int cuentaid) {
		String sql = "UPDATE cuentas SET activa = 0 WHERE id = ?";
		conexion.update(sql, cuentaid);
	}
	
	
	public Cuenta login(Cuenta cuenta) {
		
		String sql = "SELECT * FROM cuentas WHERE email = ? AND password = ?  ";
		return conexion.queryForObject(sql, new CuentaRM(), cuenta.getEmail(), cuenta.getPassword());

	}
	
	
}
