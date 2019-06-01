/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author poolm
 */
public class ModeloBusqueda {
     Conexion con;
    PreparedStatement pstmt;
    ResultSet rs;

    public ModeloBusqueda() {
        con = new Conexion();
    }
    public Object [] [] getTable(String [] colName, String sql, String tablas){
        int registros=0;
        String sentencia= "Select count(*) as total from "+tablas;
        try {
            con.conectar();
            pstmt=con.connection.prepareStatement(sentencia);
            rs=pstmt.executeQuery();
            rs.next();
            registros=rs.getInt("Total");
            rs.close();
        } catch (SQLException ex) {
            System.out.println("SQLException"+ex);
        }
        Object [][] data = new String [registros][colName.length];
        String col[]=new String [colName.length];
        try {
            con.conectar();
            pstmt = con.connection.prepareStatement(sql);
            rs=pstmt.executeQuery();
            int i=0;
            while (rs.next()) {
             for (int j = 0; j < colName.length; j++) {
                 col[j]=rs.getString(colName[j]);
                 data[i][j]=col[j];
             }
             i++;
        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("SQLException"+ex);
        }
         return data;
        
    }
}
