/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.mysql.jdbc;

import ups.edu.ec.dao.DAOFactory;
import ups.edu.ec.dao.TelefonoDAO;
import ups.edu.ec.modelo.Telefono;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO {
    
    @Override
    public void createTable() {
        conexionDos.update("CREATE TABLE IF NOT EXISTS telefono ("
                + "	tel_id INT NOT NULL AUTO_INCREMENT,"
                + "	tel_numero VARCHAR(20),"
                + "	tel_tipo  VARCHAR(50),"
                + "	tel_operadora VARCHAR(50),"
                + "	usu_cedula VARCHAR(10) NOT NULL,"
                + "	PRIMARY KEY (tel_id),"
                + "	FOREIGN KEY (usu_cedula) REFERENCES usuario(usu_cedula)"
                + ");");
    }
    
    @Override
    public boolean create(Telefono telefono) {
        
        return conexionDos.update("INSERT INTO telefono (tel_numero, tel_tipo, tel_operadora, usu_cedula) "
                + "VALUES ('" + telefono.getNumero() + "', '" + telefono.getTipo() + "', '" + telefono.getOperadora() + "', '" + telefono.getUsuario().getCedula() + "');");        
    }
    
    @Override
    public Telefono findById(Integer id) {
    	Telefono telefono = null;
        ResultSet rs = conexionUno.query("Select * FROM telefono WHERE tel_id = " + id + ";");
        try {
            if (rs != null && rs.next()) {
            	telefono = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
            	telefono.setId(rs.getInt("tel_id"));
            	telefono.setUsuario(DAOFactory.getDAOFactory().getUsuarioDAO().findById(rs.getString("usu_cedula")));
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCPhoneDAO:read): " + e.getMessage());
        }
        return telefono;
    }
    
    @Override
    public boolean update(Telefono telefono) {
        return conexionDos.update("UPDATE telefono SET "
                + "	tel_numero = '" + telefono.getNumero() + "',"
                + "	tel_tipo = '" + telefono.getTipo() + "',"
                + "	tel_operadora = '" + telefono.getOperadora() + "'"
                + "WHERE tel_id = '" + telefono.getId() + "' AND usu_cedula = '" + telefono.getUsuario().getCedula() + "';");
    }
    
    @Override
    public boolean delete(Telefono telefono) {
        return conexionDos.update("DELETE FROM telefono WHERE tel_id = '" + telefono.getId() + "' AND usu_cedula = '" + telefono.getUsuario().getCedula() + "';");
    }
    
    @Override
    public List<Telefono> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Telefono> findByUserId(String cedula) {
        List<Telefono> telefonos = new ArrayList<>();
        ResultSet rs = conexionDos.query("SELECT * FROM telefono WHERE usu_cedula = '" + cedula + "';");
        try {
            while (rs.next()) {
            	Telefono telefono = new Telefono(rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
            	telefono.setId(rs.getInt("tel_id"));

                telefonos.add(telefono);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCTelefonoDAO:findByShoppingBasketId): " + e.getMessage());
        }
        return telefonos;
    }

	@Override
	public List<Telefono> findByNumber(String numero, String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
