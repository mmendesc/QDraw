/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.qdraw;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author notebook
 */
public class Parametros implements Serializable {
    int x1,x2,y1,y2,raio,altura,largura,forma;
    public String path;
    public Parametros(int x1, int x2, int y1, int y2, int raio, int altura, int largura, int forma) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.raio = raio;
        this.altura = altura;
        this.largura = largura;
        this.forma = forma;
        
    }

    public Parametros(int x1, int x2, int y1, int y2, int raio, int altura, int largura, int forma, String path) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.raio = raio;
        this.altura = altura;
        this.largura = largura;
        this.forma = forma;
        this.path = path;
    }

    public Parametros(String path) {
        this.path = path;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public int getRaio() {
        return raio;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getForma() {
        return forma;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

   
    
    
     
}
