package logica;

import java.awt.Color;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import presentacion.Modelo;

/**
 *
 * @author Estudiantes
 */
public class Cliente implements Runnable {

    //Declaramos las variables necesarias para la conexion y comunicacion
    private Socket cliente;
    private DataOutputStream out;
    private DataInputStream in;
    private int soy;
    private int cont = 0;
    private int puerto;
    //Si estamos en nuestra misma maquina usamos localhost si no la ip de la maquina servidor
    private String host;

    //Variables del frame 
    private String mensaje;

    private Modelo modelo;
    private int[][] propio;
    private int[][] enemigo;

    //Variables para cargar las imagenes de la X y O
    //private Color X;
    //private Color O;

    private boolean turno;

    public void setPuerto(int pue) {
        this.puerto = pue;
    }

    public void setHost(String ho) {
        this.host = ho;
    }

    //Constructor recibe como parametro la ventana (Frame), para poder hacer modificaciones sobre los botones
    public Cliente(Modelo mod) {
        propio=new int[15][15];
        enemigo=new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int k = 0; k < 15; k++) {
                propio[i][k]=0;
                enemigo[i][k]=0;
            }
        }
        
    }

    public void lanzarConexion(Modelo mod) {
        try {

            this.modelo = mod;
            //Cargamos las imagenes de la X y O
            //X = Color.RED;
            //O = Color.BLUE;
            //Creamos el socket con el host y el puerto, declaramos los streams de comunicacion
            cliente = new Socket(host, puerto);
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());

            //Tomamos una matriz con los 9 botones del juego
            //propio = this.modelo.getControlVP().getVentanaPrincipal().getJugador();
            //enemigo = this.modelo.getControlVP().getVentanaPrincipal().getEnemigo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    @Override
    public void run() {
        try {
            //Cuando conectamos con el servidor, este nos devuelve el turno de juego
            mensaje = in.readUTF();
            String split[] = mensaje.split(";");
            soy = Integer.parseInt(split[0]);
            turno = Boolean.valueOf(split[1]);
            this.modelo.getV().setTitle("Batalla Naval Jugador "+soy);
            System.out.println("mi turno:"+soy+"bool:"+turno);

            //Ciclo infinito, para estar escuchando por los movimientos de los jugadores
            while (true) {
                //Recibimos el mensaje
                mensaje = in.readUTF();
                /*
                El mensaje esta compuesto por una cadena separada por ; cada separacion representa un dato
                    mensaje[0] : representa jugador 
                    mensaje[1] : el cambio que se va a hacer
                    mensaje[2] : representa fila del tablero
                    mensaje[3] : representa columna del tablero
                    mensaje[4] : representa estado del juego [Perdiste, Ganaste, Empate]
                 */

                String[] mensajes = mensaje.split(";");
                int xo = Integer.parseInt(mensajes[0]);
                int cambio = Integer.parseInt(mensajes[1]);
                System.out.println(cambio);
                int f = Integer.parseInt(mensajes[2]);
                int c = Integer.parseInt(mensajes[3]);


                /*
                Modificamos el boton que se apretro poniendo la imagen de acuerdo al turno que estaba jugando
                 */
                if (xo == 1 && soy == 1) {
                    enemigo[f][c] = cambio;
                } else if (xo == 1 && soy == 2) {
                    propio[f][c] = cambio;

                } else if (xo == 2 && soy == 1) {
                    propio[f][c] = cambio;
                } else if (xo == 2 && soy == 2) {
                    enemigo[f][c] = cambio;
                }
                this.modelo.getVentana().ajustarMatriz(enemigo, propio);
                this.modelo.getVentana().cambarColores();
                /*
                Blockeamos el clik al boton que se jugo, para que no se pueda volver a enviar la misma jugada y pasamos el turno
                 */
                //botones[f][c].removeActionListener(botones[f][c].getActionListeners()[0]);
                turno = !turno;

                /*
                Dependiendo del mensajes[3] que nos dice el estado del juego, mostramos el mensaje
                 */
                if (String.valueOf(soy) == mensajes[4]) {
                    JOptionPane.showMessageDialog(this.modelo.getV(), "GANASTEEEEEE!");
                    new Modelo();
                    this.modelo.getV().dispose();
                } else if (!"NADIE".equals(mensajes[4]) && !(soy!=Integer.parseInt(mensajes[4]))) {
                    JOptionPane.showMessageDialog(this.modelo.getV(), "PERDISTE BUUUUU!");
                    new Modelo();
                    this.modelo.getV().dispose();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Funcion sirve para enviar la jugada al servidor
    public void enviarTurno(int f, int c) {
        /*
        Comprobamos que sea nuestro turno para jugar, si no es devolmemos un mensaje
        Si es el turno entonces mandamos un mensaje al servidor con los datos de la jugada que hicimos
         */
        try {
            if (cont < 17) {
                String datos = " ";
                datos += f + ";";
                datos += c + ";";
                datos += soy;
                out.writeUTF(datos);
                cont++;
                System.out.println("cadna: " + datos + "contador: " + cont);
            } else if (!turno) {
                String datos = "";
                datos += f + ";";
                datos += c + ";";
                datos += soy;
                out.writeUTF(datos);
                System.out.println(datos);
            } else {
                JOptionPane.showMessageDialog(this.modelo.getV(), "Espera tu turno");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void enviarBarco(int f,int c){
        try{
            String datos = "";
            datos += f + ";";
            datos += c + ";";
            datos += soy;
            out.writeUTF(datos);
            cont++;
            
        }
        catch(IOException ex){
            System.out.println(ex.getStackTrace());
        }
        
    }

    public String getSoy() {
        return String.valueOf(soy);
    }
    
}
