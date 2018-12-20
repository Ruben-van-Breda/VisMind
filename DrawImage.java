package pat.pkg17;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import static jdk.nashorn.tools.ShellFunctions.input;


public class DrawImage {
    
    public BufferedImage image;
    
    public DrawImage()
    {
        
    }
    
    public void Screen(Graphics g)
    {
        Image image = Toolkit.getDefaultToolkit().getImage("Images\\oval.png");
        //g.drawImage(image, 0, 0, this);
    }
    
}
