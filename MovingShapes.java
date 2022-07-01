import java.awt.*;
import java.util.*;



public class MovingShapes{

  final static Scanner scnr = new Scanner(System.in);
  public static int drawingPanelWidth;
  public static int drawingPanelHeight;
  public static int numShapes;
  public static int numMove;
  
  public static String[] shapeAt = new String[20];
  public static int[] sizeOfShape = new int[20];
  public static String[] shapeColor = new String[20];
  public static int[] shapeDirection = new int[20];
  public static int[] shapeSpeed = new int[20]; 
  public static int[] x = new int[20];
  public static int[] y = new int[20];
  
  
  


 public static void getShapeInformation (){ 
   for(int i = 0; i < numShapes; i++){
     shapeAt[i] = scnr.next();
     sizeOfShape[i] = scnr.nextInt();
     shapeColor[i] = scnr.next();
     shapeDirection[i] = scnr.nextInt();
     shapeSpeed[i] = scnr.nextInt();
    
  }
 }


 public static void intialPosition(DrawingPanel Cbox){
   for(int i = 0; i < numShapes; i++){
     x[i]= drawingPanelWidth/2 - (sizeOfShape[i]/2);
     y[i]= drawingPanelHeight/2 - (sizeOfShape[i]/2);
   }
   showShapes(Cbox, true);
   Cbox.sleep(100);
}

 public static void showShapesMoving(DrawingPanel Cbox){

   for(int i = 0; i < numMove; i++){
     showShapes(Cbox, false);
     changePositions();
     showShapes(Cbox, true);
     Cbox.sleep(100);
   }
 }

 public static void changePositions(){ 
   for(int i = 0; i < numShapes; i++){
     if(shapeDirection[i] == 0){
      x[i]= x[i] - shapeSpeed[i];
     }
     else if (shapeDirection[i] == 1){
       x[i] = x[i] - (shapeSpeed[i]/2);
       y[i] = y[i] - (shapeSpeed[i]/2);
     }
     else if (shapeDirection[i] == 2){
       y[i] = y[i] - shapeSpeed[i];
     }
     else if (shapeDirection[i] == 3){
       x[i] = (x[i] + (shapeSpeed[i])/2);
       y[i] = y[i] - (shapeSpeed[i]/2);
     }
     else if (shapeDirection[i] == 4){
       x[i] = x[i] + shapeSpeed[i];
     }
     else if (shapeDirection[i] == 5){
       x[i] = x[i] + (shapeSpeed[i]*2);
       y[i] = y[i] + (shapeSpeed[i]*2);
     }
     else if (shapeDirection[i] == 6){
       y[i] = y[i] + shapeSpeed[i];
     }
     else if (shapeDirection[i] == 7){
       x[i] = x[i] - shapeSpeed[i];
       y[i] = y[i] + shapeSpeed[i];
     }
   }
       
   
}

 public static void showShapes(DrawingPanel Cbox, Boolean colorSet){
   for (int i = 0; i < numShapes; i++){
     if(colorSet){
       graphicSetcolor(Cbox, i);
     }
     else {
         setNoColor(Cbox);
       }
   if (shapeAt[i].charAt(0) == 'S'){
     showSquare(Cbox, i, colorSet);
   }
   else{
     showCircle(Cbox, i, colorSet);
   }  
}
 }   
 

 public static void setNoColor(DrawingPanel box){ 
   Graphics g = box.getGraphics();
   g.setColor(Color.WHITE);
}

 public static void graphicSetcolor(DrawingPanel box, int i){ 

   Graphics g = box.getGraphics();
   switch (shapeColor[i].charAt(0)){
   
    case 'R':
      g.setColor(Color.RED);
      break;
    
      case 'B':
      if(shapeColor[i].charAt(2) == 'u'){
      g.setColor(Color.BLUE);
    }
      break;
   
    case 'P':
      g.setColor(Color.PINK);
      break;
    
    case 'Y':
      g.setColor(Color.YELLOW);
      break;
    
    case 'G':
          if(shapeColor[i].charAt(2) == 'e'){
      g.setColor(Color.GREEN);
      }else{
        g.setColor(Color.GRAY);
  }
        break;
    
    case 'M':
      g.setColor(Color.MAGENTA);
      break;
    
    case 'C':
      g.setColor(Color.CYAN);
      break;
    
    case 'O':
      g.setColor(Color.ORANGE);
      break;
    
    case 'D':
      g.setColor(Color.DARK_GRAY);
      break;
    
    case 'L':
      g.setColor(Color.LIGHT_GRAY);
      break;
      
}
 }
 public static void showSquare(DrawingPanel box,int i, Boolean colorSet){

    Graphics g = box.getGraphics();
    g.fillRect(x[i], y[i],  sizeOfShape[i], sizeOfShape[i]);
    if(colorSet){
      g.setColor(Color.BLACK);
      g.drawRect(x[i], y[i],  sizeOfShape[i], sizeOfShape[i]);
    }
    else{
       g.drawRect(x[i], y[i],  sizeOfShape[i], sizeOfShape[i]);
    }
      
}
 public static void showCircle(DrawingPanel Cbox, int i, Boolean colorSet){

   Graphics g = Cbox.getGraphics();
    g.fillOval(x[i], y[i],  sizeOfShape[i], sizeOfShape[i]);
}
 
  public static void main (String[] args){
   
    System.out.println("UTSA - Spring 2022 written by Syed Saqib");
    System.out.println("Please input width, height of the panel, # of shapes, # of times to move followed by the shape, size, color direction, and speed of every shape:");
    drawingPanelWidth = scnr.nextInt();
    drawingPanelHeight = scnr.nextInt();
    numShapes = scnr.nextInt();
    numMove = scnr.nextInt();
   
    getShapeInformation();
    DrawingPanel Cbox = new DrawingPanel(drawingPanelWidth, drawingPanelHeight);
    intialPosition(Cbox);
    showShapesMoving(Cbox);
  }
 
}