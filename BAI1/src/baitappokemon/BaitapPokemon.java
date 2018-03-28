/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitappokemon;
/**
 *
 * @author ASUS
 */


import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
public class BaitapPokemon {

    public BaitapPokemon() {
    }
    public static void join(String inputPath,String outputPath) throws IOException{
        //Mở thư mục
        File directory= new File(inputPath);
        //
        File[] files=directory.listFiles();
        System.out.println(files.length);
        //đọc 1 spite
        BufferedImage sprite= ImageIO.read(files[0]);
        int with=sprite.getWidth()*files.length;
        int height=sprite.getHeight();
        System.out.println(with);
        System.out.println(height);
        //xây dựng spritemap(1 map gồm nhiều sprite) bằng buffered (mỗi tấm ảnh là 1 sprite)
        BufferedImage spritemap = new BufferedImage(with, height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d=spritemap.createGraphics();
       int x=0;//vị trí bắt đầu của sprite kế tiếp
       for(File file:files){
           //tải sprite lên
           sprite=ImageIO.read(file);
           //vẽ sprite lên spritemap
           g2d.drawImage(sprite, null, x,0);
           x+=sprite.getWidth();
       }
       //ghi spritemap ra ổ cứng
       ImageIO.write(spritemap, "png", new File(outputPath));
    }

public void sub(String inputPath,String outputPath) throws IOException{

        File directory= new File(inputPath);
        
        BufferedImage spritesheet = ImageIO.read(directory);
       
        int subWith=2;
        int subHeight; 
        subHeight = 2;
        int num = spritesheet.getWidth()/subWith;
         System.out.println(spritesheet.getWidth()/subWith);
        int x =0;
        for(int i = 0; i < num; i++){
            BufferedImage subimage = spritesheet.getSubimage(x, 0, 2, 2);
            ImageIO.write(subimage, "png", new File(outputPath+i+"pokemon.png"));
            x +=64;
        }
    }
    public static void main(String[] args) {
        try{
            BaitapPokemon smm = new BaitapPokemon();
            smm.sub("D:\\baitapPokemon_DH\\img\\pokemon\"D:\\baitapPokemon_DH\\img\\pokemon.png ");
            
            System.err.println(ex);}
        
    } 
}
