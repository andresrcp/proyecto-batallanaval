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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Servidor {

    private final int puerto = 2026;

    private final int noConexiones = 2;

    private LinkedList<Socket> usuarios = new LinkedList<Socket>();

    private Boolean turno = true;

    private int jugador1[][] = new int[15][15];
    private int jugador2[][] = new int[15][15];

    private int turnos = 1;

    public Servidor() {
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                jugador1[i][j] = 0;
                jugador2[i][j] = 0;
            }
        }
    }

    public void escuchar() {
        try {

            ServerSocket servidor = new ServerSocket(puerto, noConexiones);

            System.out.println("Esperando jugadores....");
            while (usuarios.size() <= 2) {

                Socket cliente = servidor.accept();

                usuarios.add(cliente);

                int xo = turnos % 2 == 0 ? 2 : 1;
                turnos++;
                Runnable run = new HiloServidor(cliente, usuarios, xo, jugador1, jugador2);
                Thread hilo = new Thread(run);
                hilo.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJugador1(int[][] jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(int[][] jugador2) {
        this.jugador2 = jugador2;
    }

    public static void main(String[] args) {
        
        Servidor servidor = new Servidor();
        servidor.escuchar();

    }

}
