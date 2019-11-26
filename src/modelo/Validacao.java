package modelo;

import java.awt.image.BufferedImage;
public class Validacao
{
  
        public String Mensagem;
        public String cor;

   public void Validaracesso(BufferedImage imagem1, BufferedImage imagem2)
    {
                 BufferedImage imgA = null; 
                 BufferedImage imgB = null; 
  
            imgA = imagem1; 
            imgB = imagem2; 
 
            int width1 = imgA.getWidth(); 
            int width2 = imgB.getWidth(); 
            int height1 = imgA.getHeight(); 
            int height2 = imgB.getHeight(); 
  
        if ((width1 != width2) || (height1 != height2)) 
            this.Mensagem="Entradas de tamnhos diferentes"; 
        else
        { 
            long diferenca = 0; 
            for (int y = 0; y < height1; y++) 
            { 
                for (int x = 0; x < width1; x++) 
                { 
                    int rgbA = imgA.getRGB(x, y); 
                    int rgbB = imgB.getRGB(x, y); 
                    int redA = (rgbA >> 16) & 0xff; 
                    int greenA = (rgbA >> 8) & 0xff; 
                    int blueA = (rgbA) & 0xff; 
                    int redB = (rgbB >> 16) & 0xff; 
                    int greenB = (rgbB >> 8) & 0xff; 
                    int blueB = (rgbB) & 0xff; 
                    diferenca += Math.abs(redA - redB); 
                    diferenca += Math.abs(greenA - greenB); 
                    diferenca += Math.abs(blueA - blueB); 
                } 
            } 
  
            double total_pixels = width1 * height1 * 3; 
            double avg_pixels_diferentes = diferenca / total_pixels; 
  
            double porcentagem = (avg_pixels_diferentes / 255) * 100; 
            
            if(porcentagem < 0.57)
            {
                this.Mensagem = "Acesso Liberado";
                this.cor = "src/apresentacao/digitalGreen.png";
                System.out.println(porcentagem);
            }
            else{
                this.Mensagem = "Acesso negado";
                this.cor = "src/apresentacao/digitalRed.png";
                System.out.println(porcentagem);
            }
           
        } 
    } 
                
                
         
}






   
    


 