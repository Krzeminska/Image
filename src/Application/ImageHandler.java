package Application;

//import com.idrsolutions.image.tiff.TiffDecoder;
//import com.idrsolutions.image.tiff.TiffEncoder;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageHandler 
{
    private final int alpha = BufferedImage.TYPE_INT_ARGB;
    private final int nonAlpha = BufferedImage.TYPE_INT_RGB;    
    
    public ImageObject readImage()
    {
        File file;
        String path = "";
        final JFileChooser picChooser = new JFileChooser();
        javax.swing.filechooser.FileFilter picFilter = new FileNameExtensionFilter("Image files (.bmp, .png)", new String[] {"bmp","tif","png"});
        picChooser.setFileFilter(picFilter);
        picChooser.addChoosableFileFilter(picFilter);
        picChooser.setDialogTitle("Select image");
        picChooser.setAcceptAllFileFilterUsed(false);
        int returnVal = picChooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.CANCEL_OPTION)
        {   
            System.out.println("CANCEL OPTION");
            return null;
        }
        
        file = picChooser.getSelectedFile();
        if(file == null)
        {
           System.out.println("File not found");
            return null;
        }
        path = file.getName();
        
        String fileNameGlobal = file.getName();
        String filePathGlobal = file.getPath();
        
        int i = path.lastIndexOf('.');
        int p = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        String extension = "";
        Image image = null;
        if(i > 0)
            extension = path.substring(i + 1);
        if( !(extension.equals("bmp") || extension.equals("png")))
        {
            System.out.println("Not supported file extension. Supported for now: \".bmp\", \".png\"");
            return null;
        }
       else
       {
            try {
                image = ImageIO.read(file);                    
            } catch (IOException ex) {
                System.out.println("File error");
                return null;
            }           
       }
       
       return new ImageObject(image, fileNameGlobal, filePathGlobal, extension, toBufferedImage(image, alpha).getWidth(), toBufferedImage(image, alpha).getHeight());
       
    }
    
    public void saveImage(Image photoToSave)
    {   
        JFileChooser chooser = new JFileChooser(){
            @Override
            public void approveSelection(){
                File f = getSelectedFile();                
                if(f.exists() && getDialogType() == SAVE_DIALOG){
                    int result = JOptionPane.showConfirmDialog(this,"The file exists, overwrite?","Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
                    switch(result){
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.NO_OPTION:
                            return;
                        case JOptionPane.CLOSED_OPTION:
                            return;
                        case JOptionPane.CANCEL_OPTION:
                            cancelSelection();
                            return;
                    }
                }
                super.approveSelection();
            }        
        };
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(".png", "png"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(".bmp", "bmp"));
        chooser.setAcceptAllFileFilterUsed(false);
        
        int returnVal = chooser.showSaveDialog(null);
        if(chooser.getSelectedFile() == null)
        {
            return;
        }
        String ext = chooser.getFileFilter().getDescription();
        
        String fileName = chooser.getSelectedFile().getName();
        File file = null;
        if( fileName.lastIndexOf('.') > 0 && fileName.substring(fileName.lastIndexOf('.')).equals(ext))
        {
           file = chooser.getSelectedFile();
        }
        else
        {
            file = new File(chooser.getSelectedFile().getPath() + ext);
        }
        
        BufferedImage bImg = null;
        Image i = null;
        
       
        
            if(ext.equals(".png") || ext.equals(".tif"))
                bImg = toBufferedImage(photoToSave, alpha);
            else
            {
                photoToSave = ImageOperation.toBMPSave(photoToSave);
                bImg = toBufferedImage(photoToSave.getScaledInstance(toBufferedImage(photoToSave, nonAlpha).getWidth(), toBufferedImage(photoToSave, nonAlpha).getHeight(), java.awt.Image.SCALE_SMOOTH), nonAlpha);
            }
       
        switch(ext)
        {
            case ".bmp":
                ext = "BMP";
                break;
            case ".png":
                ext = "PNG";
                break;
        }
            try {
                ImageIO.write(bImg, ext, file);
            } catch (IOException ex) {
                System.out.println("Saving \"." + ext + "\" error");
                return;
            }
        JOptionPane.showMessageDialog(chooser, "Saving done");
    }
    
    public static BufferedImage toBufferedImage(Image img, int rgbType)
    {  
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), rgbType);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return bufferedImage;
    }
    
    public static Image iconToImage(ImageIcon icon) 
    {  
        return icon.getImage();        
    }
}
