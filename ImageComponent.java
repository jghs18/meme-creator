import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.*;
import javax.swing.JComponent;
public class ImageComponent extends JComponent
{
    BufferedImage img;//declaring instance field variable img as a BufferedImage
    public ImageComponent(File n)
    {
        img = null;//try catch statement to create imageIcon from a file
        try {
            img = ImageIO.read(n);//initializing img to the BufferedImage returned by invoking static accessor method read with explicit
            //parameter of type File invoked on the class ImageIO
        } catch (IOException ee) {//prevents crashing
        }
    }

    public void paintComponent(Graphics g)//example of overriding the paintComponent method in the JComponent superclass
    {        
        int x = (this.getWidth() - img.getWidth(null)) / 2;//initializing int x and assigning it to the int that is the result of the int
        //returned by accessor method getWidth invoked on this instance of the class subtracted from the int that resulted from the
        //accesor method getWidth invoked on the img with
        int y = (this.getHeight() - img.getHeight(null)) / 2;//initializing int x and assigning it to the int that is the result of the int
        //returned by accessor method getWidth invoked on this instance of the class subtracted from the int that resulted from the
        //accesor method getWidth invoked on the img with
        g.drawImage(img, x, y, null);//invoking mutator method drawImage on the object referenced by g with explicit parameters of type
        //bufferedImages, int, int, null
    }
}
