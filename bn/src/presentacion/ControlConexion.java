/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author X550Z
 */
public class ControlConexion implements ActionListener{
    
    private Modelo modelo;
    private Conexion ventanaConexion;
    
    public ControlConexion(Modelo m){
        this.modelo = m;
        getVentanaConexion().setVisible(true);
    }
    
    public Modelo getModelo() {
        if (modelo == null) {
            modelo = new Modelo();
        }
        return modelo;
    }
    
    public Conexion getVentanaConexion() {
        if (ventanaConexion == null) {
            ventanaConexion = new Conexion(this);
        }
        return ventanaConexion;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("conectar")){
            //getModelo().enviarDatosConex(getVentanaConexion().getHost(), getVentanaConexion().getPuerto());
            getModelo().getCliente().setHost(getVentanaConexion().getHost());
            getModelo().getCliente().setPuerto(getVentanaConexion().getPuerto());
            getModelo().iniciar();
            getVentanaConexion().dispose();
        }
    }
    
}
