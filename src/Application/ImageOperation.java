package Application;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageOperation 
{
    public ImageOperation(){}
    
    
    public static Image contrastChange(Image image, int value)
    {
        if(value == 0)
            return image;
        value /= 5;
        double V = value * 1.2725;
        double V1 = 255/(255-2*V);
        double V2 = (255+2*V)/255;
        
        BufferedImage bImg = toBufferedImage(image, BufferedImage.TYPE_INT_ARGB);
        int width = bImg.getWidth();
        int height = bImg.getHeight();
        
         for(int i=0; i<width;i++)
        {
            for(int j=0 ;j<height;j++)
            {
                Color c = new Color(bImg.getRGB(i, j),true);
                int red = c.getRed();
                int blue = c.getBlue();
                int green = c.getGreen();
                int alpha = c.getAlpha();
                
                if(V > 0)
                {
                    if(red < V) red = 0;
                    else if(red > 255-V) red = 255;
                    else 
                        red = (int) (V1*(red - V));
                    
                    if(blue < V) blue = 0;
                    else if(blue > 255-V) blue = 255;
                    else 
                        blue = (int) (V1*(blue - V));
                    
                    if(green < V) green = 0;
                    else if(green > 255-V) green = 255;
                    else 
                        green = (int) (V1*(green - V));
                }
                else if(V < 0)
                {
                    red = (int) (-V + V2*red);
                    blue = (int) (-V + V2*blue);
                    green = (int) (-V + V2*green);
                }
                
                red = red > 255 ? 255 : red;
                red = red < 0 ? 0 : red;                
                blue = blue > 255 ? 255 : blue;
                blue = blue < 0 ? 0 : blue;                
                green = green > 255 ? 255 : green;
                green = green < 0 ? 0 : green;
                
                Color newColor = new Color(red, green, blue, alpha);
                
                bImg.setRGB(i, j, newColor.getRGB());
            }
        }
        return (Image)bImg;
    }
    
    
    public static Image changeBritghtness(Image image, int value)
    {
        if(value == 0)
            return image;
        BufferedImage bImg = toBufferedImage(image, BufferedImage.TYPE_INT_ARGB);
        int width = bImg.getWidth();
        int height = bImg.getHeight();
        
        for(int i=0; i<width;i++)
        {
            for(int j=0 ;j<height;j++)
            {
                Color c = new Color(bImg.getRGB(i, j), true);
                int red = c.getRed();
                int blue = c.getBlue();
                int green = c.getGreen();
                int alpha = c.getAlpha();
                
                if(value > 0)
                {
                    if(red < 255 - value)
                        red+=value;
                    else
                        red = 255;
                    if(blue < 255 - value)
                        blue+=value;
                    else
                        blue = 255;
                    if(green < 255 - value)
                        green+=value;
                    else
                        green = 255;
                }
                else if(value < 0)
                {
                    if(red + value > 0)
                        red+=value;
                    else
                        red = 0;
                    if(blue + value > 0)
                        blue+=value;
                    else
                        blue = 0;
                    if(green + value > 0)
                        green+=value;
                    else
                        green = 0;
                }
                Color newColor = new Color(red, green, blue, alpha);
                
                bImg.setRGB(i, j, newColor.getRGB());
            }
        }
        return (Image)bImg;
    }
    
    public static Image getImageInColor(String color, Image imageInColor)
    {
        if(color == null)
            return imageInColor;
        BufferedImage bImg = toBufferedImage(imageInColor, BufferedImage.TYPE_INT_ARGB);
        int width = bImg.getWidth();
        int height = bImg.getHeight();
        
        for(int i=0;i<width;i++)
        {   
            for(int j=0;j<height;j++)
            {   
                if(color.equals("grayscale"))
                {
                    Color c = new Color(bImg.getRGB(i, j), true);
                    int alpha = c.getAlpha();
                    int red = (int) (c.getRed() * 0.299);
                    int green =(int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() *0.114);
                    int sum = red+green+blue;
                    Color newColor = new Color(sum, sum, sum, alpha);
                    bImg.setRGB(i, j, newColor.getRGB());
                }
                else
                {
                    int p = bImg.getRGB(i, j);
                    int a = (p>>24)&0xff;
                    int r = (p>>16)&0xff;
                    int g = (p>>8)&0xff;                
                    int b = p&0xff;

                    switch(color)
                    {
                        case "green":
                            p = (a<<24) | (0<<16) | (g<<8) | 0; // green
                            break;
                        case "blue":
                            p = (a<<24) | (0<<16) | (0<<8) | b; // blue
                            break;
                        case "red":
                            p = (a<<24) | (r<<16) | (0<<8) | 0; // red
                            break;
                    }
                    bImg.setRGB(i, j, p);
                }
            }
        }
        return (Image)bImg;
    }
    
    public static Image toBMPSave(Image image)
    {
        
        BufferedImage bImg = toBufferedImage(image, BufferedImage.TYPE_INT_ARGB);
        int width = bImg.getWidth();
        int height = bImg.getHeight();
        
        for(int i=0; i<width;i++)
        {
            for(int j=0 ;j<height;j++)
            {
                Color c = new Color(bImg.getRGB(i, j), true);
                int red = c.getRed();
                int blue = c.getBlue();
                int green = c.getGreen();
                int alpha = c.getAlpha();
                if(alpha == 0)
                {
                    red = 255;
                    blue = 255;
                    green = 255;
                }
                Color newColor = new Color(red, green, blue);
                bImg.setRGB(i, j, newColor.getRGB());
            }
        }
        return (Image)bImg;
    }
    
    private static BufferedImage toBufferedImage(Image img, int rgbType)
    {  
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), rgbType);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bufferedImage;
    }
}
