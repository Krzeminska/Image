
package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class ImageObject 
{
    private final Image originalImage;
    private Image image;
    private final String name;
    private final String path;
    private final String extension;
    private int width, height;
    
    public ImageObject(Image _image, String _name, String _path, String _extension, int _width, int _height)
    {
        this.originalImage = _image;
        this.image = _image;
        this.name = _name;
        this.path = _path;
        this.extension = _extension;
        this.width = _width;
        this.height = _height;
    }
    
    public int getBitsPerPixel()
    {
        return toBufferedImage(image, BufferedImage.TYPE_INT_ARGB).getColorModel().getPixelSize();
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getPath()
    {
        return this.path;
    }
    
    public String getExtension()
    {
        return this.extension;
    }
    
    public void setImage(Image img)
    {
        this.image = img;
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public Dimension getDimension()
    {
        return new Dimension(this.width, this.height);
    }
    
    public Image getImage()
    {
        return this.image;
    }
    
    public Image getOriginalImage()
    {
        return this.originalImage;
    }
    
    public Image getOriginalImageScaled()
    {
        return this.originalImage.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    }
    
    public ImageIcon getIcon()
    {
        return new ImageIcon(image);
    }
            
    
    public void reverseAllChanges()
    {
        this.image = this.originalImage;
        this.width = toBufferedImage(this.image, BufferedImage.TYPE_INT_ARGB).getWidth();
        this.height = toBufferedImage(this.image, BufferedImage.TYPE_INT_ARGB).getHeight();
    }
    
    public static BufferedImage toBufferedImage(Image img, int rgbType)
    {  
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), rgbType);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bufferedImage;
    }
    
    public void scaleImage(int w, int h)
    {
        this.width = w;
        this.height = h;
        image = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    }
}
