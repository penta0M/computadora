/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author poolm
 */
public class Conexion {
    String URL = "jdbc:mysql://localhost:3306/tiendacompu";
    String Usuario = "root";
    String contrasena = "TorosTec";
    Connection connection = null; 
    Connection conectar=null;
    Statement statement;
    ResultSet resultset;
    
    public boolean conectar() throws SQLException {
        boolean bandera = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection(URL, Usuario, contrasena);
           bandera = true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandera;
    }
    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacompu", "root", "TorosTec");
        } catch (Exception e) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
           return conectar;
    }
    public long registrarusuarios(Usuario clientes) throws SQLException {
        long i=0;  
        String SQL ="Insert into registrousuarios values (?,?,?,?,?,?);";
        if (conectar()) {
            try{
                PreparedStatement stmt = connection.prepareStatement(SQL);
                stmt.setInt(1,0);
                stmt.setString(2,clientes.nombre);
                stmt.setString(3,clientes.apellidos);
                stmt.setString(4,clientes.direccion);
                stmt.setLong(5,clientes.telefono);
                stmt.setString(6,clientes.correo);
                i = stmt.executeUpdate();
            }catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return i;
    }
    
    
    
//    public static int actualizarRegistro (String [] datos){
//        
//        int rsu = 0;
//        String sql = "UPDATE registrocomputadora SET" 
//                + "PlacaBase = 'jTFPlacaBase', "
//                + "Procesador = 'jTFProcesador', "
//                + "Ram = 'jTFRam, "
//                + "TarjetaVideo = 'jTFTarjetaV', "
//                + "DiscoDuro = 'jTFDd', "
//                + "FuentePoder = 'jTFFuente', "
//                + "Gabinete = 'jTFGabinete', ";
//    }
    
    public long registrarComputadora(Computadora compu) throws SQLException {
        long i=0;  
        String SQL ="Insert into registrocomputadora values (?,?,?,?,?,?,?,?);";
        if (conectar()) {
            try{
                PreparedStatement stmt = connection.prepareStatement(SQL);
                stmt.setInt(1,0);
                stmt.setString(2,compu.placaBase);
                stmt.setString(3,compu.procesador);
                stmt.setInt(4,compu.ram);
                stmt.setString(5,compu.tarjetaVideo);
                stmt.setString(6,compu.discoDuro);
                stmt.setString(7,compu.fuente);
                stmt.setString(8,compu.gabinete);
                i = stmt.executeUpdate();
            }catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return i;
    }
    public void consultar() throws SQLException{
        String SQL = "SELECT * FROM REGISTROCOMPUTADORA;";
        if (conectar()) {
            try {
                statement = connection.createStatement();
                resultset = statement.executeQuery(SQL);
                System.out.println("idcomputadora\tPlacaBase\tProcesador\tRam\tTarjetaVideo\tDiscoDuro\tFuentePoder\tGabinete");
                
                while(resultset.next()){
                 int id = resultset.getInt("idcomputadora");
                 String PlacaBase = resultset.getString("PlacaBase");
                 String Procesador = resultset.getString("Procesador");
                 String Ram = resultset.getString("Ram");
                 String Tarjeta = resultset.getString("TarjetaVideo");
                 String Disco = resultset.getString("DiscoDuro");
                 String Fuente = resultset.getString("FuentePoder");
                 String Gabinete = resultset.getString("Gabinete");
                 
                 
                 System.out.println(id+"\t"+PlacaBase+"\t"+Procesador+"\t"+Ram+"\t"+Tarjeta+"\t"+Disco+"\t"+Fuente+"\t"+Gabinete);
                }
            } 
            
            catch (SQLException ex) {
            }
        } else {
            System.out.println("Error");
        }
    }
}
