/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;

/**
 * <h1>clase que controla el mapa</h1>
 * la clase Mapa guarda todas las posiciones de los barcos y asigna las imagenes

 */
public class Mapa {
    public static int w = 0;

    private int x,y;
    public static int mapa[][]= new int[15][15];
    public static int mapaLog[][]= new int[15][15];
    public static int propio[][]= new int[15][15];

    public static int[][] getPropio() {
        return propio;
    }

    public static void setPropio(int[][] propio) {
        Mapa.propio = propio;
    }

    public static int[][] getEnemigo() {
        return enemigo;
    }

    public static void setEnemigo(int[][] enemigo) {
        Mapa.enemigo = enemigo;
    }
    public static int enemigo[][]= new int[15][15];
    public static int giro=0;
    private static int z=0;
    
    private Image fondo,barco1,barco2,barco3,barco4,barco2Rot,imagen7,imagen8,imagen9,
            imagen10,imagen11,imagen12,imagen13,imagen14,imagen15,imagen16,imagen17,imagen18,imagen19;
    public int tenerX() {
        return this.x;
    }

    public int tenerY() {
        return this.y;
    }

    public Image tenerImagen() {
        return fondo;
    }
    public Image tenerImagen2() {
        return barco1;
    }
    public Image tenerImagen3() {
        return barco2;
    }
    public Image tenerImagen4() {
        return barco3;
    }
    public Image tenerImagen5() {
        return barco4;
    }
    public Image tenerImagen6() {
        return barco2Rot;
    }
    public Image tenerImagen7() {
        return imagen7;
    }
    public Image tenerImagen8() {
        return imagen8;
    }
    public Image tenerImagen9() {
        return imagen9;
    }
    public Image tenerImagen10() {
        return imagen10;
    }
    public Image tenerImagen11() {
        return imagen11;
    }
    public Image tenerImagen12() {
        return imagen12;
    }
    public Image tenerImagen13() {
        return imagen13;
    }
    public Image tenerImagen14() {
        return imagen14;
    }
    public Image tenerImagen15() {
        return imagen15;
    }
    public Image tenerImagen16() {
        return imagen16;
    }
    public Image tenerImagen17() {
        return imagen17;
    }
    public Image tenerImagen18(){
        return imagen18;
    }
    public Image tenerImagen19(){
        return imagen19;
    }
    public int[][] getMapaLog(){
        return this.mapaLog;
    }
    /**
     * metodo que inicializa los valores de ataque
     * @param x guarda la posicion del fondo
     * @param y guarda la posicion del fondo
     * @param mapa[][] guarda la poscion de los barcos para la parte grafica
     * @param mapaLog[][] guarda la posicion de los barcos para la parte logica
     */
    public Mapa() {
        x = 0;
        y = 0;
        
        ImageIcon imga = new ImageIcon(this.getClass().getResource("/Imagenes/Fondo.png"));
        fondo = imga.getImage();
        ImageIcon imga2 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco2.png"));
        barco1 = imga2.getImage();
        ImageIcon imga3 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco3.png"));
        barco2 = imga3.getImage();
        ImageIcon imga4 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco4.png"));
        barco3 = imga4.getImage();
        ImageIcon imga5 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco5.png"));
        barco4 = imga5.getImage();
        ImageIcon imga6 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco2 rot.png"));
        barco2Rot = imga6.getImage();
        ImageIcon imga7 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco3 rot.png"));
        imagen7 = imga7.getImage();
        ImageIcon imga8 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco4 rot.png"));
        imagen8 = imga8.getImage();
        ImageIcon imga9 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco5 rot.png"));
        imagen9 = imga9.getImage();
        ImageIcon imga10 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco2 inv.png"));
        imagen10 = imga10.getImage();
        ImageIcon imga11 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco3 inv.png"));
        imagen11 = imga11.getImage();
        ImageIcon imga12 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco4 inv.png"));
        imagen12 = imga12.getImage();
        ImageIcon imga13 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco5 inv.png"));
        imagen13 = imga13.getImage();
        ImageIcon imga14 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco2 inv rot.png"));
        imagen14 = imga14.getImage();
        ImageIcon imga15 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco3 inv rot.png"));
        imagen15 = imga15.getImage();
        ImageIcon imga16 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco4 inv rot.png"));
        imagen16 = imga16.getImage();
        ImageIcon imga17 = new ImageIcon(this.getClass().getResource("/Imagenes/Barco5 inv rot.png"));
        imagen17 = imga17.getImage();
        ImageIcon imga18 = new ImageIcon(this.getClass().getResource("/Imagenes/acerto.png"));
        imagen18 = imga18.getImage();
        ImageIcon imga19 = new ImageIcon(this.getClass().getResource("/Imagenes/fallo.png"));
        imagen19 = imga19.getImage();
    }
}
