import java.util.Scanner;

public class DogShelter{
  public static int gShelterSize;
  final static Scanner gIN = new Scanner(System.in);
  final static int gMAX_DOGS = 100;
  public static double[] gWeight = new double[gMAX_DOGS];

  public static void main(String[] args){
    int option;
    String shelterMessage = "Please, enter the idxNumber of dogs in the shelter (MAX 100): ";
    String mMessage = "MAIN MENU\n 0 - Exit, 1 - Report, 2 - Assing/Modify dogs, 3 - (Ex)Change Dog, 4 - Close shelter, 5 - List";

    System.out.print("UTSA - Spring2022 ");
    System.out.println("- Project 2 - TexasShelter - written by Syed Saqib");

    gShelterSize = getValue(shelterMessage, gMAX_DOGS);

    
    while (true){
      option = getValue(mMessage, 5);
      if (option == 1){
        report();
      }
      else if (option == 2){
        assignModifyDog();
      }
      else if (option == 3){
        changeDog();
      }
      else if (option == 4){
        closeShelter();
      }
      else if (option == 5){
        listDogs();
      }
      else if (option == 0){
        break;
      }
    }
    System.out.println("Thank you, Have a nice day");
  }

  public static int getValue(String message, int maxOption){
    int menuOption;
  
    while (true){
      System.out.println(message);
      menuOption = gIN.nextInt();
      if(menuOption > maxOption || menuOption < 0){
        System.out.println("Value out of range, please try again");
      }
      else {
        break;
      }
    }
    return menuOption;
  }

  public static void report(){
    System.out.println("DOGS' REPORT");
    int x;
    for (int i = 4; i >= 0; i--){
      x = getDogsByClassification(i);
      System.out.println(x);
    }
  }

  public static int getDogsByClassification(int classificationCode){
    int NumDog = 0;
    
    if (classificationCode == 4){
      System.out.print("XLarge: ");
      for(int i=0; i < gShelterSize; i++){
        if(gWeight[i] <= 100 && gWeight[i] > 90){
          NumDog++;
    }
  }
  }
    if (classificationCode == 3){
      System.out.print("Large: ");
      for(int i=0; i < gShelterSize; i++){
        if(gWeight[i] <= 90 && gWeight[i] > 50){
          NumDog++;
    }
  }
  }
    if (classificationCode == 2){
      System.out.print("Medium: ");
      for(int i=0; i < gShelterSize; i++){
        if(gWeight[i] <= 50 && gWeight[i] > 30){
          NumDog++;
    }
  }
  }
    if (classificationCode == 1){
      System.out.print("Small: ");
      for(int i=0; i < gShelterSize; i++){
        if(gWeight[i] <= 30 && gWeight[i] > 20){
          NumDog++;
    }
  }
  }
    if (classificationCode == 0){
      System.out.print("XSmall: ");
      for(int i=0; i < gShelterSize; i++){
        if(gWeight[i] <= 20 && gWeight[i] > 0){
          NumDog++;
    }
  }
  }
  return NumDog;
  }

  public static void assignModifyDog(){
    int index;
    double idxNum;
    String message = "Enter the index (0 to " + (gShelterSize - 1) + ") :";
   
      index = getValue (message, gShelterSize - 1);
     
      System.out.println("The current weight of the dog at " + index + " is : " + gWeight[index]);
    
    while (true){
      System.out.print(" Enter the weight of the new dog (0.00 - 100.00) :");
      idxNum= gIN.nextDouble();
      if (idxNum < 0 || idxNum > 100.0){
        System.out.print("Value out of range, please try again\n");
      }
      else{
        break;
      }
    }
      gWeight[index] = idxNum;
  }

  public static void changeDog(){
    int idxFrom;
    int idxTo;
    String idxfromMessage = "Enter the postion from (0 to " + (gShelterSize - 1) + ") :";
    idxFrom = getValue(idxfromMessage, gShelterSize - 1);
     String idxToMessage = "Enter the postion to change to (0 to " + (gShelterSize - 1) + ") that is not " + idxFrom+ " :";
    while (true){
      idxTo = getValue(idxToMessage, gShelterSize - 1);
      if (idxTo != idxFrom){
        break;
      }
       System.out.println("Value out of range, please try again");
    }
    swapValues(idxFrom, idxTo);
  }
  public static void swapValues(int f, int t){
    double temp = gWeight[f];
    gWeight[f] = gWeight[t];
    gWeight[t] = temp;
    
  }
  public static void closeShelter(){
    gWeight = new double[gMAX_DOGS];
  }

  public static void listDogs(){
    System.out.println("LIST OF DOGS' WEIGHT");
    for (int i = 0; i < gShelterSize; i++){
      System.out.println("Dog[" + i + "] : " + gWeight[i]);
    }
  }

}