// Ruben van Breda 2017
package pat.pkg17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Manage the Draw objects and add more functionality to the classes
public class DrawManager {
    
    Draw dr[] = new Draw[10000]; // An Array of Draw objects
    int arrayCount = 0; // To keep track of the array count
    File currentFile = new File("initialzing"); // A File for the saving functionality of the program 
    public Color currentColor = Color.green;
    public String brushType = "square";
    Graphics g; // variable needed to draw graphics on the canvas
    JPanel canvas = null; // The canvas the user interacts with to draw.
    
    private int drawLimit = 0; // Keep count of the amount of drawings. If this limit is greater than 10000 then stop drawing.

    //Constructor
    public DrawManager(Graphics g) {
        
        this.g = g;
        
    }
    // Draw Method
    public void draw(int x,int y,int sizeX,int sizeY,String nbrushFill,String nbrushType,Color color)
    {
        // Check that the memory for the array is not exeded, max array lenth is 10000
        if(drawLimit>10000)
        {
            System.out.println("Out of  Draw memory.");
                
            JOptionPane.showMessageDialog(null, "Storage full. Can Not draw more, try making a new drawing ;) ");
           
            return;
        }
        
        else if(drawLimit<=10000)
        {
            // This method is to render the drawings to the canvas

            // set the graphics color to color parsed in the parameter
            g.setColor(color);

            // Check the shape of the drawing
            if (nbrushType.equalsIgnoreCase("oval")) {
                // Check if the drawing was drawn with the color fill or asset fill.
                if (nbrushFill.equalsIgnoreCase("Color")) {
                    // render and draw the drawing to the canvas
                    g.fillOval(x, y, sizeX, sizeY);
                } // if the brushFill was an asset and not a color.
                else if (!nbrushFill.equalsIgnoreCase("Color")) {
                    // Create an Image object and get the appropriate image using the brushType and brushFill.
                    Image image = Toolkit.getDefaultToolkit().
                            getImage("/Users/Ruben_Macbook/Documents/Programming/NetbeansProjects/PAT 17/src/Images/" + nbrushType.toUpperCase() + "/" + nbrushFill + nbrushType + ".png");
                    // Ensure that the image is found and not null, defensive programming.
                    if (image != null) {
                        // draw the image using the Graphics object.
                        g.drawImage(image, x, y, sizeX, sizeY, canvas);

                    }
                }
            } // If the brushType is Square
            else if (nbrushType.equalsIgnoreCase("square")) {
                // Check if the drawing was drawn with the color fill or asset fill.
                if (nbrushFill.equalsIgnoreCase("Color")) {
                    // render and draw the drawing to the canvas
                    g.fillRect(x, y, sizeX, sizeY);
                } // if the brushFill was an asset and not a color.
                else if (!nbrushFill.equalsIgnoreCase("Color")) {

                    // Create an Image object and get the appropriate image using the brushType and brushFill.
                    Image image = Toolkit.getDefaultToolkit().getImage("/Users/Ruben_Macbook/Documents/Programming/NetbeansProjects/PAT 17/src/Images/" + nbrushType.toUpperCase() + "/" + nbrushFill + nbrushType + ".png");
                    // Ensure that the image is found and not null
                    if (image != null) {
                        g.drawImage(image, x, y, sizeX, sizeY, canvas);
                    } // If image was not found
                    else if (image == null) {

                        Image defaultImage = Toolkit.getDefaultToolkit().getImage("/Users/Ruben_Macbook/Documents/Programming/NetbeansProjects/PAT 17/src/Images/yellowOval.png");
                        g.drawImage(defaultImage, x, y, sizeX, sizeY, canvas);
                        //Display the information to the user.
                        JOptionPane.showMessageDialog(null, "Image not found - Draw()");
                    }

                }

            }
            drawLimit++;
        }
        
        
        
        
        
       
       
        
       
       
       
    }
    
    // Load the data from a saved file.
    public void loadData(String filePath) throws FileNotFoundException
    {
        // current File var is set to the new file path
        currentFile = new File(filePath);
        // Create an Scanner Object.
        Scanner scFile = new Scanner(new File(filePath));
        
        // Loop through the file
        while(scFile.hasNext())
        {
            // line = the new line in the file.
            String line = scFile.nextLine();
            // String array to split the line at each #
            // This allows the line to split into different strings allowing to set the variables of the line to the draw object properties.
            String[] fd = line.split("#");
            
            // Parse the string- Color - to an Color object.
            Scanner sc = new Scanner(fd[6]);
            sc.useDelimiter("\\D+");
            Color scColor = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
            
            // populate the Draw object array with the new data recieved from the textfile.
            dr[arrayCount] = new Draw(Integer.parseInt(fd[0]),Integer.parseInt(fd[1]), Integer.parseInt(fd[2]), Integer.parseInt(fd[3]),
                    fd[4],fd[5],Color.red);
            // Set Draw Properties
            dr[arrayCount].setColor(scColor);
            dr[arrayCount].setSizeX(Integer.parseInt(fd[2]));
            dr[arrayCount].setSizeY(Integer.parseInt(fd[3]));
            dr[arrayCount].setBrushFill(fd[4]);
            dr[arrayCount].setBrushType(fd[5]);
            
            
           // Increase the array count.
            arrayCount++;
            
        }
       
        
    }
        // Through 
    public String RawData() 
    {
        try {
            // load the raw data from the temporary file used in the program.
            Scanner scFile = new Scanner(new File("VisMindtemp.txt"));
            String line = "";
            
            // loop through the file using the Scanner.hasNext() method
            while(scFile.hasNext())
            {
                line = line + scFile.nextLine()+"\n";
                
                
            }
            
            return line;
        } 
        // If an error occured.
        catch (FileNotFoundException ex) {
            Logger.getLogger(DrawManager.class.getName()).log(Level.SEVERE, null, ex);
            //Display a message to the user notifing the user of the error that occured.
            JOptionPane.showMessageDialog(null, "Error found when trying to access the temporary file of the application - VisMindtemp.txt"+ex);
        }
        return null;
        
    }
         
         
   public void createEntry(int x,int y,int sizeX,int sizeY,String nbrushFill,String nbrushType,Color color) 
    {
        // Create a String for the new data
        String newData = RawData()+x+"#"+y+"#"+sizeX+"#"+sizeY+"#"+nbrushFill+"#"+nbrushType+"#"+color.toString();
        // BufferedWriter to write to the textfile.
        
        // Check that the drawLimit has not been exceeded
       if(drawLimit <= 10000)
       {  
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("VisMindtemp.txt"));
            // Add the new data the textfile.
                    bw.append(newData);
                    bw.close(); // close the BufferedWriter
                    
        } 
        // If an error occures
        catch (IOException ex) {
            Logger.getLogger(DrawManager.class.getName()).log(Level.SEVERE, null, ex);
            // Display a message to the user about the error occured
            JOptionPane.showMessageDialog(null, "Faled to createEntry , "+ex);
        }
       }
       
       else if (drawLimit>10000)
       {
           JOptionPane.showMessageDialog(null, "Can not creat new Entry as the drawLimit has been reached, createEntry().");
       }
       
       
       
        //System.out.println(x+"#"+y+"#"+sizeX+"#"+sizeY+"#"+nbrushFill+"#"+nbrushType+"#"+color.toString());

        
    }
   
   // Clear the temporary file.
   public void ClearTempFile()
   {
       drawLimit = 0;
       // PrintWriter Object to flush the contents of the textfile.
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("VisMindTemp.txt"));
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            // Display a error message.
            JOptionPane.showMessageDialog(null, "Failed to clear the temp file - VisMindtemp.txt\n"+ex);
        }
        
   }
   
   // Save the data to a file.
   public void SaveToFile(String filePath) 
   {
      
      /*  Scanner scFile;
        String line = "";
        try {
            scFile = new Scanner(new File("VisMindtemp.txt"));
             while(scFile.hasNext())
        {
            line = line + scFile.nextLine()+"\n";
            
          
            
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawManager.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
       // Get the data
       String line = RawData();
        
       
        // BufferedWriter object to write to file.
        BufferedWriter bw;
        try {
            // Write to the file with the file path passed with the parameters
            bw = new BufferedWriter(new FileWriter(filePath));
            // Write the line.
                    bw.append(line);
                    bw.close();
                    
                    System.out.println("Save - Complete.");
        } catch (IOException ex) {
            Logger.getLogger(DrawManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falied to save - SaveToFile,DrawManager.java\n");
        }
        System.out.println("Data Saved: \n"+line);
     
        
        
   }
   
   public void OpenFile(String filePath) throws FileNotFoundException
   {
        /* PrintWriter pw = new PrintWriter(new File("VisMindTemp.txt"));
        pw.flush();
        pw.close();*/
        ClearTempFile();
        
        
        loadData(filePath);
        PopulateCanvasWithData();
        
                
       
        
        
   }
    
    public void PopulateCanvasWithData() 
    {
        // Loop through the Draw Array and draw the drawing to the canvas.
        
        for(int i = 0;i<arrayCount;i++)
        {
            
            // Ensure that the file is not greater than 10000 drawings - For Memory, Defensive Programming
            if(drawLimit>10000)
            {
                System.out.println("Out of memory.");
                
                JOptionPane.showMessageDialog(null, "Storage full. Can Not draw more, try making a new drawing ;) ");
                return;
        
            }
            // Get the color
            g.setColor(dr[i].getColor());
            // Draw to the canvas
            draw(dr[i].getX(), dr[i].getY(), dr[i].getSizeX(),dr[i].getSizeY(),dr[i].getBrushFill(),dr[i].getBrushType(),dr[i].getColor());
            // Create the new entry
            createEntry(dr[i].getX(), dr[i].getY(), dr[i].getSizeX(),dr[i].getSizeY(),dr[i].getBrushFill(),dr[i].getBrushType(),dr[i].getColor());
            drawLimit++;
        }
    }
    
    public Point getDrawPosition(Point startP,Point endP)
    {
        // Get startPoint.x and startPoint.y
        
        // Get difference in length between startPoint.x and endPoint.x
        float length = endP.x - startP.x;
        
        // Get height of draw, getting the difference between the startPoint.y and endPoint.y
        float height = endP.y - startP.y ;
        
        // Create a new point with the new coordinates.
        Point newPoint = new Point();
        newPoint.setLocation(length, height);
        //return the point.
        return newPoint;
        
        
    }
    
    
    
    
    
}
