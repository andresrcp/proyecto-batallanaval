package presentacion;

import logica.Mapa;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * <h1>clase que crea la ventana</h1>
 * la clase Ventana crea cada uno de los botones de la ventana y recibe los
 * eventos del click
 */
public class Ventana extends JFrame implements MouseListener {

    JLabel posicionDF[][] = new JLabel[15][15];
    JLabel posicionAT[][] = new JLabel[15][15];
    public int[][] tableroEnemigo = new int[15][15];
    public int[][] tableropropio = new int[15][15];
    private Modelo modelo;
    private Container contenedor;

    /**
     * metodo que crea los botones y el chat
     *
     * @param posicionDF crea los botones del tableroEnemigo donde se ponen los
     * barcos
     * @param posicionAT crea los botones del tableroEnemigo donde se dispara
     *
     */
    public Ventana(Container contenedor, Modelo m) {
        this.modelo = m;
        this.contenedor = contenedor;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                posicionDF[i][j] = new JLabel();
                posicionDF[i][j].setBounds((i * 28) + 7, (j * 28) + 7, 28, 28);
                posicionDF[i][j].addMouseListener(this);
                contenedor.add(posicionDF[i][j]);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                posicionAT[i][j] = new JLabel();
                posicionAT[i][j].setBounds((28 * i) + 440, (28 * j) + 7, 28, 28);
                posicionAT[i][j].addMouseListener(this);
                contenedor.add(posicionAT[i][j]);
            }
        }

        contenedor.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new FlowLayout());

        contenedor.add(panel, BorderLayout.SOUTH);
        contenedor.add(new Graficos());

    }

    /**
     * metodo que controla los eventos de click en los botones
     *     
     * @param x controla el lugar que ocupan los barcos en la logica
     */ Mapa map = new Mapa();
        Mapa map2 = new Mapa();
    public void mouseClicked(MouseEvent evento) {

       
        //Atacar ata = new Atacar();
        int x = 0;
        if (evento.isMetaDown()) {
            if (map.giro == 0) {
                map.giro = 1;
            } else {
                map.giro = 0;
            }
            //System.out.println(map.giro);
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (evento.getSource() == posicionDF[i][j] && evento.isMetaDown() == false) {
                    switch (map.w) {
                        case 0:
                            if (map.giro == 0) {
                                map.mapa[i][j] = 1;
                                map.mapaLog[i][j] = 1;
                                int z = j;
                                while (x < 5) {
                                    map.mapaLog[i][j++] = 1;
                                    modelo.enviarBarco(i, z++);
                                    x++;
                                }
                            } else {
                                map.mapa[i][j] = 11;
                                map.mapaLog[i][j] = 1;
                                int z = i;
                                while (x < 5) {
                                    map.mapaLog[i++][j] = 1;
                                    modelo.enviarBarco(z++, j);

                                    x++;
                                }
                            }
                            map.w++;
                            break;
                        case 1:
                            if (map.giro == 0) {
                                map.mapa[i][j] = 2;
                                map.mapaLog[i][j] = 1;
                                int z = j;
                                while (x < 4) {

                                    map.mapaLog[i][j++] = 1;
                                    modelo.enviarBarco(i, z++);

                                    x++;
                                }
                            } else {
                                map.mapa[i][j] = 12;
                                map.mapaLog[i][j] = 1;
                                int z = i;
                                while (x < 4) {

                                    map.mapaLog[i++][j] = 1;
                                    modelo.enviarBarco(z++, j);

                                    x++;
                                }
                            }
                            map.w++;
                            break;
                        case 2:
                            if (map.giro == 0) {
                                map.mapa[i][j] = 3;
                                map.mapaLog[i][j] = 1;
                                int z = j;
                                while (x < 3) {
                                    map.mapaLog[i][j++] = 1;
                                    modelo.enviarBarco(i, z++);
                                    x++;
                                }
                            } else {
                                map.mapa[i][j] = 13;
                                map.mapaLog[i][j] = 1;
                                int z = i;
                                while (x < 3) {
                                    map.mapaLog[i++][j] = 1;
                                    modelo.enviarBarco(z++, j);
                                    x++;
                                }
                            }
                            map.w++;
                            break;
                        case 3:
                            if (map.giro == 0) {
                                map.mapa[i][j] = 4;
                                map.mapaLog[i][j] = 1;
                                int z = j;
                                while (x < 3) {
                                    map.mapaLog[i][j++] = 1;
                                    modelo.enviarBarco(i, z++);
                                    x++;
                                }
                            } else {
                                map.mapa[i][j] = 14;
                                map.mapaLog[i][j] = 1;
                                int z = i;
                                while (x < 3) {
                                    map.mapaLog[i++][j] = 1;
                                    modelo.enviarBarco(z++, j);
                                    x++;
                                }

                            }
                            map.w++;
                            break;
                        case 4:
                            if (map.giro == 0) {
                                map.mapa[i][j] = 5;
                                map.mapaLog[i][j] = 1;
                                int z = j;
                                modelo.enviarBarco(i, z);
                            } else {
                                map.mapa[i][j] = 15;
                                map.mapaLog[i][j] = 1;
                                int z = i;
                                modelo.enviarBarco(z, j);
                            }
                            map.w++;
                            break;
                        case 5:
                            if (map.giro == 0) {
                                map.mapa[i][j] = 6;
                                map.mapaLog[i][j] = 1;
                                int z = j;
                                modelo.enviarBarco(i, z);
                            } else {
                                map.mapa[i][j] = 16;
                                map.mapaLog[i][j] = 1;
                                int z = i;
                                modelo.enviarBarco(z, j);
                            }
                            map.w++;
                            break;
                        
                            
                    }
                }
            }
        }

        //this.agregarAtaques();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                if (evento.getSource() == posicionAT[i][j]) {
                    //System.out.println("presiono en la posicion del 2: " + i + "," + j);
                    modelo.enviarTurno(i, j);

                }
            }
        }
    }

    public void mousePressed(MouseEvent evento) {
    }

    public void mouseReleased(MouseEvent evento) {
    }

    public void mouseExited(MouseEvent evento) {
        Mapa map = new Mapa();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (evento.getSource() == posicionDF[i][j]) {
                    if (map.mapaLog[i][j] != 1) {
                        map.mapa[i][j] = 0;
                    }
                }
            }
        }
    }

    public void ajustarMatriz(int[][] a, int[][] b) {
        tableroEnemigo = a;
        tableropropio = b;
    }

    public void cambarColores() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) { 
                if (tableroEnemigo[i][j] != 0 && tableroEnemigo[i][j] == -1) {
                   map.enemigo[j][i]=7;                   
                } else if (tableroEnemigo[i][j] != 0 && tableroEnemigo[i][j] == 2) {
                    //System.out.println("llegue aquí");
                    map.enemigo[j][i]=8;
                } else if (tableropropio[i][j] != 0 && tableropropio[i][j] == -1) {
                    map.propio[j][i]=7;
                } else if (tableropropio[i][j] != 0 && tableropropio[i][j] == 2) {
                    map.propio[j][i]=8;
                }
            }
        }
    }

    public void mouseEntered(MouseEvent evento) {
        Mapa map = new Mapa();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (evento.getSource() == posicionDF[i][j]) {
                    if (map.mapaLog[i][j] != 1 && map.mapa[i][j] != 2) {
                        if (map.giro == 0) {
                            map.mapa[i][j] = 10;
                        } else {
                            map.mapa[i][j] = 20;
                        }
                    }
                }
            }
        }
    }
}
