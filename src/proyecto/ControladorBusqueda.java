/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author poolm
 */
public class ControladorBusqueda {
    ModeloBusqueda modelo;
    public ControladorBusqueda(){
        modelo = new ModeloBusqueda();
    }
    public Object [][]muestraUsuario(){
        String seleccion="Select * from ";
        String tabla="registrocomputadora";
        String sentencia= seleccion + tabla;
        Object [][] datos=null;
        String[] columnas={"idComputadora","PlacaBase","Procesador","Ram","TarjetaVideo","DiscoDuro","FuentePoder","Gabinete"};
        datos=modelo.getTable(columnas, sentencia, tabla);
        return datos;
    }
    
    public Object[][] busqueda(String busqueda){
        String seleccion = "Select * from ";
        String tablas = "registrocomputadora where idComputadora like '%"+busqueda+"%'";
        String[] columnas = {"idComputadora","PlacaBase","Procesador","Ram","TarjetaVideo","DiscoDuro","FuentePoder","Gabinete"};
        String sentencia = seleccion + tablas;
        Object[][] datos=null;
        datos = modelo.getTable(columnas, sentencia, tablas);
        return datos;
    } 
}
