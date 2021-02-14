/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import logica.Cliente;

/**
 *
 * @author estudiantes
 */
public class Modelo {

    private Controlador controlVP;
    private Cliente cliente;
    private ControlConexion controlC;
    private Ventana ventana;
    private JFrame v;

    public Modelo() {
        this.getControlC();
    }

    /*public Modelo(int i){
        
    }*/
    public void iniciar() {

        try {
            this.getCliente().lanzarConexion(this);
            Thread hilo = new Thread(this.getCliente());
            creaVentana();
            hilo.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        v.setTitle("Batalla naval"+ this.cliente.getSoy());
    }
    private void creaVentana() {
        v = new JFrame();
        ventana = new Ventana(v.getContentPane(),this);
        v.pack();
        v.setVisible(true);
        v.setSize(871, 460);
        //v.setTitle("Batalla naval"+ this.cliente.getSoy());
        v.setLocationRelativeTo(null);
        v.setResizable(false);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JFrame getV() {
        return v;
    }

    public void setV(JFrame v) {
        this.v = v;
    }
     
    public void enviarDatosConex(String host, int puerto){
        this.getCliente().setHost(host);
        this.getCliente().setPuerto(puerto);
    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }



    public ControlConexion getControlC() {
        if (controlC == null) {
            controlC = new ControlConexion(this);
        }
        return controlC;
    }

    public void setControlVP(Controlador controlVP) {
        this.controlVP = controlVP;
    }

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente(this);
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void enviarTurno(int f, int c) {
        getCliente().enviarTurno(f, c);
    }
    public void enviarBarco(int f, int c){
        getCliente().enviarBarco(f,c);
    }

}
