package presentacion;

import logica.Mapa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <h1>L parte grafica del programa</h1>
 * la clase Graficos muestra cada una de las imagenes en la ventana segun se lo
 * indica la logica
 */
public class Graficos extends JPanel implements ActionListener {

    private Mapa fondo;
    private Mapa imagen2;
    private Mapa imagen3;
    private Mapa imagen4;
    private Mapa imagen5;
    private Mapa imagen6;
    private Mapa imagen7;
    private Mapa imagen8;
    private Mapa imagen9;
    private Mapa imagen10;
    private Mapa imagen11;
    private Mapa imagen12;
    private Mapa imagen13;
    private Mapa imagen14;
    private Mapa imagen15;
    private Mapa imagen16;
    private Mapa imagen17;
    private Mapa imagen18;
    private Mapa imagen19;
    

    private static int control1[][] = new int[15][15];
    private Timer velocidad;

    /**
     * este metodo inicializa cada una de las imagenes e incia el hilo
     *
     * @param velocidad controla la velocidad del hilo
     */
    public Graficos() {
        setBackground(Color.BLACK);
        setFocusable(true);
        fondo = new Mapa();
        imagen2 = new Mapa();
        imagen3 = new Mapa();
        imagen4 = new Mapa();
        imagen5 = new Mapa();
        imagen6 = new Mapa();
        imagen7 = new Mapa();
        imagen8 = new Mapa();
        imagen9 = new Mapa();
        imagen10 = new Mapa();
        imagen11 = new Mapa();
        imagen12 = new Mapa();
        imagen13 = new Mapa();
        imagen14 = new Mapa();
        imagen15 = new Mapa();
        imagen16 = new Mapa();
        imagen17 = new Mapa();
        imagen18 = new Mapa();
        imagen19 = new Mapa();
        velocidad = new Timer(5, this);
        velocidad.start();

    }

    /**
     * este metodo grafica cada una de las imagenes
     * @param mep es el constructor de la clase Mapa
     * @param control1[][] guarda los valores de la logica para mantener graficados los barcos
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Mapa mep = new Mapa();
        g2.drawImage(fondo.tenerImagen(), fondo.tenerX(), fondo.tenerY(), null);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                if (mep.mapa[i][j] == 1) {
                    g2.drawImage(imagen5.tenerImagen5(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 1;
                }
                if (mep.mapa[i][j] == 10&&mep.w==0) {
                    g2.drawImage(imagen13.tenerImagen13(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (mep.propio[i][j] == 7) {
                    g2.drawImage(imagen19.tenerImagen19(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (mep.enemigo[i][j] == 7) {
                    g2.drawImage(imagen19.tenerImagen19(), (i * 28) + 440, (j * 28) + 7, null);
                }
                if (mep.propio[i][j] == 8) {
                    g2.drawImage(imagen18.tenerImagen18(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (mep.enemigo[i][j] == 8) {
                    g2.drawImage(imagen18.tenerImagen18(), (i * 28) + 440, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 2) {
                    g2.drawImage(imagen4.tenerImagen4(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 2;
                }
                if (mep.mapa[i][j] == 10&&mep.w==1) {
                    g2.drawImage(imagen12.tenerImagen12(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 3) {
                    g2.drawImage(imagen3.tenerImagen3(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 3;
                }
                if (mep.mapa[i][j] == 10&&mep.w==2) {
                    g2.drawImage(imagen11.tenerImagen11(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 4) {
                    g2.drawImage(imagen3.tenerImagen3(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 4;
                }
                if (mep.mapa[i][j] == 10&&mep.w==3) {
                    g2.drawImage(imagen11.tenerImagen11(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 5) {
                    g2.drawImage(imagen2.tenerImagen2(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 5;
                }
                if (mep.mapa[i][j] == 10&&mep.w==4) {
                    g2.drawImage(imagen10.tenerImagen10(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 6) {
                    g2.drawImage(imagen2.tenerImagen2(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 6;
                }
                if (mep.mapa[i][j] == 10&&mep.w==5) {
                    g2.drawImage(imagen10.tenerImagen10(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (mep.mapa[i][j] == 11) {
                    g2.drawImage(imagen9.tenerImagen9(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 11;
                }
                if (mep.mapa[i][j] == 20&&mep.w==0) {
                    g2.drawImage(imagen17.tenerImagen17(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 12) {
                    g2.drawImage(imagen8.tenerImagen8(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 12;
                }
                if (mep.mapa[i][j] == 20&&mep.w==1) {
                    g2.drawImage(imagen16.tenerImagen16(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 13) {
                    g2.drawImage(imagen7.tenerImagen7(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 13;
                }
                if (mep.mapa[i][j] == 20&&mep.w==2) {
                    g2.drawImage(imagen15.tenerImagen15(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 14) {
                    g2.drawImage(imagen7.tenerImagen7(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 14;
                }
                if (mep.mapa[i][j] == 20&&mep.w==3) {
                    g2.drawImage(imagen15.tenerImagen15(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 15) {
                    g2.drawImage(imagen6.tenerImagen6(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 15;
                }
                if (mep.mapa[i][j] == 20&&mep.w==4) {
                    g2.drawImage(imagen14.tenerImagen14(), (i * 28) + 7, (j * 28) + 7, null);
                }

                if (mep.mapa[i][j] == 16) {
                    g2.drawImage(imagen6.tenerImagen6(), (i * 28) + 7, (j * 28) + 7, null);
                    control1[i][j] = 16;
                }
                if (mep.mapa[i][j] == 20&&mep.w==5) {
                    g2.drawImage(imagen14.tenerImagen14(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 1) {
                    g2.drawImage(imagen5.tenerImagen5(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 2) {
                    g2.drawImage(imagen4.tenerImagen4(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 3) {
                    g2.drawImage(imagen3.tenerImagen3(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 4) {
                    g2.drawImage(imagen3.tenerImagen3(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 5) {
                    g2.drawImage(imagen2.tenerImagen2(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 6) {
                    g2.drawImage(imagen2.tenerImagen2(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 11) {
                    g2.drawImage(imagen9.tenerImagen9(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 12) {
                    g2.drawImage(imagen8.tenerImagen8(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 13) {
                    g2.drawImage(imagen7.tenerImagen7(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 14) {
                    g2.drawImage(imagen7.tenerImagen7(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 15) {
                    g2.drawImage(imagen6.tenerImagen6(), (i * 28) + 7, (j * 28) + 7, null);
                }
                if (control1[i][j] == 16) {
                    g2.drawImage(imagen6.tenerImagen6(), (i * 28) + 7, (j * 28) + 7, null);
                }
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
