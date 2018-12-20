
package pat.pkg17;

import java.awt.Color;

// Manage the properties of each drawing in the VisMind Application

public class Draw {
    
    
    // Variables
    public int x = 0; // x coordinate
    public int y = 0; // y coordinate
    public int sizeX = 10; // width of drawing
    public int sizeY = 5; // length of drawing
    public String brushType = "Square"; // brushType to determine the shape of the drawing
    public String brushFill = "lightGreen"; // the fill of the shape of the drawing
    
    public Color col = Color.blue; // color of the drawing
    
    // Constructor to initalilze the properties and allow this fuction to be created in other classes as an object.
    public Draw(int pX,int pY,int sizeX,int sizeY,String brushFill,String brushType,Color color){
        this.x = pX;
        this.y = pY;
        this.col = color;
        this.brushType = brushType;
        this.brushFill = brushFill;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    
    // All getters to access the variables outside this class.
    public Integer getX()
    {
        return x;
    }
    
    public Integer getY()
    {
        return y;
    }
    public Integer getSizeX()
    {
        return sizeX;
    }
     public Integer getSizeY()
    {
        return sizeY;
    }
     
    public Color getColor()
    {
        return col;
    }

      public String getBrushType()
    {
        return this.brushType;
    }
    
    public String getBrushFill()
    {
        return this.brushFill;
    }
    
    // Setters to manipulate the properties of the draw object.
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
     public void setSizeX(int size) {
        this.sizeX = size;
    }
    
    public void setSizeY(int size) {
        this.sizeY = size;
    }
    
    public void setBrushType(String bT)
    {
        this.brushType = bT;
    }
    
    public void setBrushFill(String bF)
    {
        this.brushFill = bF;
    }
   
    public void setColor(Color col) {
        this.col = col;
    }    
    
    // Summerize the data of the draw object to allow use of this later in other classes to save and load the data....
    @Override
    public String toString()
    {
        return x+"#"+y+"#"+sizeX+"#"+sizeY+"#"+brushFill+"#"+brushType+"#"+col;
    }
    
    
    
}
