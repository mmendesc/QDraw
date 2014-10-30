/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.qdraw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import static my.qdraw.Imagem.Copiar;
import static my.qdraw.Imagem.desfazer;

/**
 *
 * @author JoaoCito
 */
public class Imagem implements java.io.Serializable{
    static  BufferedImage buffer1 = new BufferedImage( 400, 298, BufferedImage.TYPE_INT_RGB );
    static  BufferedImage buffer2 = new BufferedImage( 400, 298, BufferedImage.TYPE_INT_RGB );
    static  BufferedImage buffer3 = new BufferedImage( 400, 298, BufferedImage.TYPE_INT_RGB );
    static  ArrayList<BufferedImage> desfazer = new ArrayList<BufferedImage>();
    static  ArrayList<BufferedImage> objetos = new ArrayList<BufferedImage>();
    static ArrayList<Integer> forma = new ArrayList<Integer>() ;
    public static boolean flag=true;
    public String n = "";
    static Color cor = Color.BLACK;
    static ArrayList<Parametros> parametros= new ArrayList<Parametros>();
    public ImageIcon criarImagem() {  
        //int width=500, height=500;  
          
        Graphics g = buffer1.createGraphics();  
        g.setColor( Color.WHITE );  
        g.fillRect( 0, 0, 400, 298);  
        //g.setColor( cor );  
        //g.drawLine( 0, 0,100, 30 );  
        //g.drawOval(100, 100, 40, 40);
        //g.drawRect(50, 50, 30, 70);
       // buffer2=buffer1;
        //desfazer.add(Copiar(buffer1));
        return new ImageIcon( buffer1 );  
    }  

     public static ImageIcon criaCirculo(int x, int y, int w,int w1){
        forma.add(1);
        Graphics2D g = buffer2.createGraphics();
        Graphics2D g2= buffer3.createGraphics();
        g.drawImage(buffer1, 0,0 , null);
        //g.setColor( Color.WHITE );
        g.setColor( cor );  
        g.setStroke(new BasicStroke(2.0f));
        //g.fillRect( 0, 0, 300, 200 );  
        g.drawOval(x, y, w, w1);
        g2.setColor( cor );  
        g2.setStroke(new BasicStroke(2.0f)); 
        g2.drawOval(x, y, w, w1);
        objetos.add(Copiar(buffer3));
        //if(desfazer.size() == 2)
            //desfazer.add(Copiar(desfazer.get(0)));
        if(flag){
        buffer1=buffer2;
        desfazer.add(Copiar(buffer1));
        } else{
        desfazer.add(Copiar(buffer1));
        buffer1=buffer2;}
        
        g.dispose();
        return new ImageIcon(buffer1);
    }
     public static ImageIcon criaRetangulo(int x, int y, int w,int w1){
         forma.add(2);
        Graphics2D g2= buffer3.createGraphics();
        Graphics2D g = buffer2.createGraphics();
        g.drawImage(buffer1, 0,0 , null);
        //g.setColor( Color.WHITE );
        g.setColor( cor );  
        g.setStroke(new BasicStroke(2.0f));
        //g.fillRect( 0, 0, 300, 200 );  
        g.drawRect(x, y, w, w1);
        g2.setColor( cor );  
        g2.setStroke(new BasicStroke(2.0f)); 
        g2.drawRect(x, y, w, w1);
        objetos.add(Copiar(buffer3));
        if(flag){
        buffer1=buffer2;
        desfazer.add(Copiar(buffer1));
        } else{
        desfazer.add(Copiar(buffer1));
        buffer1=buffer2;}
        
        g.dispose();
        return new ImageIcon(buffer1);
    }
    public static ImageIcon criaLinha(int x, int y, int w,int w1){
        forma.add(3);
        Graphics2D g2= buffer3.createGraphics();
        Graphics2D g = buffer2.createGraphics();
        g.drawImage(buffer1, 0,0 , null);
        //g.setColor( Color.WHITE );
        g.setColor( cor );  
        g.setStroke(new BasicStroke(2.0f));
        //g.fillRect( 0, 0, 300, 200 );  
        g.drawLine(x, y, w, w1);
        g2.setColor( cor );  
        g2.setStroke(new BasicStroke(2.0f)); 
        g2.drawLine(x, y, w, w1);
        objetos.add(Copiar(buffer3));
        if(flag){
        buffer1=buffer2;
        desfazer.add(Copiar(buffer1));
        } else{
        desfazer.add(Copiar(buffer1));
        buffer1=buffer2;}
        
        g.dispose();
        return new ImageIcon(buffer1);
    }
    static BufferedImage Copiar(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}

class Serializavel{
 public void carregar(JLabel jLabel1,Imagem imagem){
       // Imagem layout=null;
        try {
 
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
 
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
 
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream is = new ObjectInputStream(fis);
 
            Imagem.parametros = (ArrayList) is.readObject();
 
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        
        redesenha(jLabel1, imagem);
 
       // return layout;
    }
 
 
 
    public void serializar(Imagem layout){
        try {
 
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(null);
 
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
 
            FileOutputStream fileStream = new FileOutputStream(file);
 
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(Imagem.parametros);
             os.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    public static void redesenha(JLabel jLabel1,Imagem imagem){
        for(int i=0;i<Imagem.parametros.size();i++){
            if(Imagem.parametros.get(i).getForma()==1)
               jLabel1.setIcon(imagem.criaCirculo(Imagem.parametros.get(i).getX1(), Imagem.parametros.get(i).getY1(), Imagem.parametros.get(i).getRaio(), Imagem.parametros.get(i).getRaio()));
            if(Imagem.parametros.get(i).getForma()==2)
                jLabel1.setIcon(imagem.criaLinha(Imagem.parametros.get(i).getX1(), Imagem.parametros.get(i).getY1(), Imagem.parametros.get(i).getX2(), Imagem.parametros.get(i).getY2()));
            if(Imagem.parametros.get(i).getForma()==3)
                jLabel1.setIcon(imagem.criaRetangulo(Imagem.parametros.get(i).getX1(), Imagem.parametros.get(i).getY1(), Imagem.parametros.get(i).largura, Imagem.parametros.get(i).getAltura()));
        }
    }
}
