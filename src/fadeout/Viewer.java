/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadeout;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author pau
 */
public class Viewer extends Canvas {

    private MyFrame v;
    private MyBufferedImg img1;

    public Viewer(MyFrame v) {
        this.v = v;
    }

    public void showImage(String imgSrc) {

        //intenta buscar la imagen
        try {
            this.img1 = new MyBufferedImg(ImageIO.read(new File(imgSrc)), this.getGraphics());
           

        } catch (IOException ex) {
            System.out.println("Imagen no cargada");
        }
    }

    public void doFadeVie(String src, int numFrames) throws InterruptedException {
        this.img1.doFade(src, numFrames);  
    }

    /*
    @Override
    public void paint(Graphics g) {
        //Graphics2D g2d = (Graphics2D) g;
        
        this.imgz = createImage(this.getWidth(), this.getHeight());
        this.gbd = this.imgz.getGraphics();
        this.paintComp(gbd);
        
        //g2d.drawImage(this.imgOriginal, 0, 0, 700, 500, null);
        g.drawImage(this.imgz, 800, 0, 700, 500, null);
    
        
    }
    
    
    public void paintComp(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
     
        g.drawImage(this.img1, 800, 0, 700, 500, null);
    }
    
     */
}

/*
    private BufferedImage[] srcImgs;

    private byte[] baRaster;
    private byte[] baRasterFade;
    private Raster rasImgSrc;
    private Raster rasImgFade;
    //  private Integer[] iaDiferencia;
    private Integer[] iaImgSrcRaster;
    private Integer[] iaImgFadeRasRter;

    public Lienzo(Ventana v) {
        this.v = v;
    }

    public void setBufferImageFade(String imgToFade) {

        try {
            this.srcImgFade = ImageIO.read(new File(imgToFade));

            //obtener raster de la imagen
            this.rasImgFade = this.srcImgFade.getRaster();

            //obtener byte array del raster de la imagen
            this.baRasterFade = this.convertDataRasterToByteArray(this.rasImgFade);

            //obtener int array del byte array de la imagen (sacada del raster)
            this.iaImgFadeRasRter = this.convertDataRasterToIntArray(this.rasImgFade);

        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sumarDiferencia(int numFrames) {

    }

    public void doFadeOut(String imgToFade) {

        int numFrames = 3;
        Integer[] arrDiferencia; 

        //recoge el raster y lo pasa a distintos tipos de arrays
        this.setBufferImageFade(imgToFade);
       
        arrDiferencia = devolverDiferenciaImgs(numFrames);

        for (int frame = 0; frame < numFrames; frame++) {
            for (int pos = 0; pos < arrDiferencia.length; pos++) {
                
                this.iaImgSrcRaster[pos] += arrDiferencia[pos];
            }

            try {
                Thread.sleep(60);
                this.updateBaRaster(this.iaImgSrcRaster);
                this.repaint();

            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Integer[] devolverDiferenciaImgs(int numFrames) {
        Integer[] iaDiferencia = new Integer[this.iaImgSrcRaster.length];

        for (int i = 0; i < iaDiferencia.length; i++) {
            iaDiferencia[i] = (iaImgFadeRasRter[i] - iaImgSrcRaster[i]) / numFrames;
        }

        return iaDiferencia;
    }

    public void setImg(String srcImg) {
        try {
            //guarda como buffImg el archivo en el directorio "srcImg"
            this.srcImg = ImageIO.read(new File(srcImg));

            //obtener raster de la imagen
            this.rasImgSrc = this.srcImg.getRaster();

            //obtener byte array del raster de la imagen
            this.baRaster = this.convertDataRasterToByteArray(this.rasImgSrc);

            //obtener int array del byte array de la imagen (sacada del raster)
            this.iaImgSrcRaster = this.convertDataRasterToIntArray(this.rasImgSrc);

        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(this.srcImg, 0, 0, this);
    }

    private byte[] convertDataRasterToByteArray(Raster ras) {

        byte[] baDataRasterSource;

        baDataRasterSource = ((DataBufferByte) ras.getDataBuffer()).getData();
        return baDataRasterSource;
    }

    private byte[] copyIntArrayToByteArray(Integer[] biSource) {

        byte[] isCopy = new byte[biSource.length];

        for (int i = 0; i < biSource.length; i++) {
            isCopy[i] = biSource[i].byteValue();
        }

        return isCopy;
    }

    private Integer[] convertDataRasterToIntArray(Raster ras) {

        byte[] baDataRasterSource = ((DataBufferByte) ras.getDataBuffer()).getData();
        Integer[] iaRaster = new Integer[baDataRasterSource.length];

        for (int i = 0; i < baDataRasterSource.length; i++) {
            iaRaster[i] = Byte.toUnsignedInt(baDataRasterSource[i]);
        }

        return iaRaster;
    }

    /*private Integer[] convertByteArrayToIntArray(byte[] baSource) {

        Integer[] isCopy = new Integer[baSource.length];

        for (int i = 0; i < baSource.length; i++) {
            isCopy[i] = Byte.toUnsignedInt(baSource[i]);
        }

        return isCopy;
    }
    
    
    private void updateBaRaster(Integer[] iaSource) {
        byte[] bArray = this.copyIntArrayToByteArray(iaSource);

        for (int i = 0; i < bArray.length; i++) {
            this.baRaster[i] = bArray[i];
        }
    }*/
