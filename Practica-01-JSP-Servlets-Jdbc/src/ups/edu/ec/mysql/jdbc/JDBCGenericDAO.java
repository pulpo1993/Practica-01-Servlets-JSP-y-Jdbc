/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.mysql.jdbc;

import ups.edu.ec.dao.GenericDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID>{
    protected ContextJDBC conexionUno = ContextJDBC.getJDBC1();
    protected ContextJDBC conexionDos = ContextJDBC.getJDBC2();
}
