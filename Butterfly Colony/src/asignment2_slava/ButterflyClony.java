//************************************
// PantherID:  5909727
// CLASS: COP 2210 – 2019
// ASSIGNMENT # 2
// DATE: 10/09/2019
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//************************************
package asignment2_slava;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author vburm001
 */
public class ButterflyClony {
    private final String colonyName;
    private final String careName;
    private int sizeColony;
    private int sizeColonyO; 
    private String colorColony;
    private boolean cure = false;
    private int foodLevel;
    private int risk;
    private int sick;
    private int killed;
    private double expandD;
    private int expand;
    private final double THE_10_PERCENT = 0.1;
    private int breed;
    private int sucBreed;
    Random randGen = new Random();
    
public ButterflyClony(String CN, String YN, int size, String CB){
    colonyName = CN; //gives name
    careName = YN; //your name
    sizeColony = size; // gives size to the colony
    colorColony = CB; //Gives color
    sizeColonyO = sizeColony;
}
public void AddColor(String newColor){
    colorColony = colorColony + ", " + newColor; //Adds new color
}
public void expandColony(){
    double sizeCD = sizeColony; //Makes int to double
    expandD = sizeCD * THE_10_PERCENT; //Calculates
     expand = (int)expandD; //Makes it back to int
    JOptionPane.showMessageDialog(null, "You colony has increased by " + expand);
    sizeColony =  sizeColony + expand; //Increases the size by 10%
}
public void feedColony(int f){
    foodLevel = f; //How many times did you feed
}
public void breedColony(int y){
    breed = y;
    if (y > 0){
        if(foodLevel > 0 && y > 0){ //cheacks if the user met the req.
            if(foodLevel < y || foodLevel == y ){ //if food is more
            sizeColony = (sizeColony * 2) * foodLevel;
            sucBreed = foodLevel;
            }
            else if(foodLevel > y){
            sizeColony = (sizeColony * 2) * y;
            sucBreed = y;
            }
        }
        else{
         //needs text
        }
    }
    else{
        //needs text
    }
}
public void giveVitamins(boolean v){ //gives them vitamins
    cure = v;
    
}
public void sickness(){
    if(cure == true){
        risk = 5; // lower chance
    }
    else{
        risk = 4; //higher chance
    }
    sick  = randGen.nextInt(risk); //calculates sickness 
    if(sick == 1){
        JOptionPane.showMessageDialog(null,"OH NO! Your colony got sick!");
        double sizeCD = sizeColony; //makes int a double
        expandD = sizeCD * THE_10_PERCENT; //Calculates
        killed = (int)expandD; //makes it int again
        JOptionPane.showMessageDialog(null,"The sickness killed " + killed
        + " butterfiles");
        sizeColony = sizeColony - killed; //dies off by 10%
    }
    else{
    JOptionPane.showMessageDialog(null,"YES! Your colony did not get sick!");
    }
}
// Get Methods----------------
public String GetColonyName(){
   return colonyName;
}
public String GetCareName(){
    return careName;
}
public int GetSize(){
    return sizeColony;
}
public int GetSizeO(){
    return sizeColonyO;
}
public String GetColor(){
    return colorColony;
}
public int GetFoodLevel(){
    return foodLevel;
}
public int GetKilled(){
    return killed;
}
public int GetBreed(){
    return breed;
}
public int GetSucBreed(){
    return sucBreed;
}

}
