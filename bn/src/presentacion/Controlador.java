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
 * @author estudiantes
 */
public class Controlador implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private Main ventanaPrincipal;
//    private Modelo modelo;
//    private String texto;
//
//    public Controlador(Modelo m) {
//        this.modelo = m;
//    }
//
//    public Main getVentanaPrincipal() {
//        if (ventanaPrincipal == null) {
//            ventanaPrincipal = new Main(this);
//        }
//        return ventanaPrincipal;
//    }
//
//    public Modelo getModelo() {
//        if (modelo == null) {
//            modelo = new Modelo();
//        }
//        return modelo;
//    }
//
//    public void setVentanaPrincipal(Main ventanaPrincipal) {
//        this.ventanaPrincipal = ventanaPrincipal;
//    }
//    
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getActionCommand().equals("M11")) {
//            getModelo().enviarTurno(0, 0);
//        } else if (e.getActionCommand().equals("M12")) {
//            getModelo().enviarTurno(0, 1);
//        } else if (e.getActionCommand().equals("M13")) {
//            getModelo().enviarTurno(0, 2);
//        } else if (e.getActionCommand().equals("M21")) {
//            getModelo().enviarTurno(1, 0);
//        } else if (e.getActionCommand().equals("M22")) {
//            getModelo().enviarTurno(1, 1);
//        } else if (e.getActionCommand().equals("M23")) {
//            getModelo().enviarTurno(1, 2);
//        } else if (e.getActionCommand().equals("M31")) {
//            getModelo().enviarTurno(2, 0);
//        } else if (e.getActionCommand().equals("M32")) {
//            getModelo().enviarTurno(2, 1);
//        } else if (e.getActionCommand().equals("M33")) {
//            getModelo().enviarTurno(2, 2);
//        } else if (e.getActionCommand().equals("reinicio")) {
//            this.getVentanaPrincipal().dispose();
//            this.getModelo().iniciar();
//        }
//    }

}
