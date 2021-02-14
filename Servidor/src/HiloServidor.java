/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author X550Z
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class HiloServidor implements Runnable {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    private int XO;
    private int contador = 0;

    private int jugador1[][];
    private int jugador2[][];

    private boolean turno;
    //Lista de los usuarios conectados al servidor
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();

    //Constructor que recibe el socket que atendera el hilo y la lista de los jugadores el turno y la matriz del juego
    public HiloServidor(Socket soc, LinkedList users, int xo, int[][] j1, int[][] j2) {
        socket = soc;
        usuarios = users;
        XO = xo;
        jugador1 = j1;
        jugador2 = j2;
    }

    @Override
    public void run() {

        try {
            //Inicializamos los canales de comunicacion y mandamos el turno a cada jugador
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            turno = XO == 1;
            String msg = "";
            msg += turno ? "1;" : "2;";
            msg += turno;
            out.writeUTF(msg);

            int con = 0;

            //Ciclo infinito que estara escuchando por los movimientos de cada jugador
            //Cada que un jugador pone una X o O viene aca y le dice al otro jugador que es su turno
            while (true) {
                //Leer los datos que se mandan cuando se selecciona un boton
                String recibidos = in.readUTF();
                String recibido[] = recibidos.split(";");
                int cambio = 0;
                con++;

                /*
                    recibido[0] : fila del tablero
                    recibido[1] : columna del tablero
                
                 */
                int c = Integer.parseInt(recibido[0]);
                int f = Integer.parseInt(recibido[1]);
                int j = Integer.parseInt(recibido[2]);
                /*
                    Se guarda la jugada en la matriz
                    casilla barco: 1
                    fallo tiro : -1
                    acerto tiro : 2
                 */
                if (contador < 17) {
                    if (j == 1) {
                        jugador1[f][c] = 1;

                        cambio = 1;
                    } else if (j == 2) {
                        jugador2[f][c] = 1;

                        cambio = 1;
                    }
                    contador++;

                } else if (j == 1) {
                    if (jugador2[f][c] == 0) {
                        jugador2[f][c] = -1;
                        cambio = -1;
                    } else if (jugador2[f][c] == 1) {
                        jugador2[f][c] = 2;
                        cambio = 2;
                    }
                } else if (j == 2) {
                    if (jugador1[f][c] == 0) {
                        jugador1[f][c] = -1;
                        cambio = -1;
                    } else if (jugador1[f][c] == 1) {
                        jugador1[f][c] = 2;
                        cambio = 2;
                    }
                }
                //System.out.println(recibidos);
                /*
                Se forma una cadena que se enviara a los jugadores, que lleva informacion del movimiento que se 
                acaba de hacer
                 */
                String cad = "";
                cad += j + ";";
                cad += cambio + ";";
                cad += f + ";";
                cad += c + ";";
                /*
                Se comprueba si alguien de los jugadores gano
                y si el tablero ya se lleno... En los dos casos se notifica a los jugadores para empezar de nuevo la partida
                 */
                boolean ganador = gano(j);
                //boolean completo = lleno();

                if (!ganador) {
                    cad += "NADIE";
                } else if (ganador) {
                    cad += j == 1 ? "1" : "2";
                    //vaciarMatriz();
                }

                for (Socket usuario : usuarios) {
                    out = new DataOutputStream(usuario.getOutputStream());
                    out.writeUTF(cad);
                    //System.out.println(cad);
                }
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            //Si ocurre un excepcion lo mas seguro es que sea por que algun jugador se desconecto asi que lo quitamos de la lista de conectados
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i) == socket) {
                    usuarios.remove(i);
                    vaciarMatriz();
                    break;
                }
            }
        }
    }

    //Funcion comprueba si algun jugador ha ganado el juego
    public boolean gano(int ju) {
        int contador = 0;
        boolean gano = false;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (ju == 1) {
                    contador++;
                    gano = jugador2[i][j] == 1;
                    System.out.println(gano + " veces:" + contador);
                    break;
                } else if (ju == 2) {
                    contador++;
                    gano = jugador1[i][j] == 1;
                    System.out.println(gano + " veces:" + contador);
                    break;
                }
                if (gano) {
                    break;
                }
            }
            if (gano) {
                break;
            }
        }
        System.out.println("mtriz 1");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(jugador1[i][j]);
            }
            System.out.println("");
        }
        System.out.println("matirz 2");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(jugador2[i][j]);
            }
            System.out.println("");
        }
        return gano;
    }

    //Funcion para reiniciar la matriz del juego
    public void vaciarMatriz() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                jugador1[i][j] = 0;
                jugador2[i][j] = 0;
            }
        }
    }
}
