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
import javax.swing.JOptionPane;


/**
 *
 * @author vburm001
 */
public class Asignment2_Slava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean vitamin = false;
        //Gets the colony name
        String CN = JOptionPane.showInputDialog(null,"What is the name of your "
                + "colony?");
        //Gets the user name
        String YN = JOptionPane.showInputDialog(null,"What is your name?");
        //Gets the size as a String
        String sizeS = JOptionPane.showInputDialog(null,"What is the size of"
                + " your colony?");
        //Makes it an int
        int size = Integer.parseInt(sizeS);
        //Gets the color of the butterflies
        String CB = JOptionPane.showInputDialog(null,"What is the color of "
                + "your butterflies?");
        //Assigns it to an object
        ButterflyClony colony = new ButterflyClony(CN, YN, size, CB);
        
        //Checks the status
        JOptionPane.showMessageDialog(null, "So your name is : " 
                + colony.GetCareName() 
                + "\nThe name of your colony is : " + colony.GetColonyName() 
                + "\nIts size is : " + colony.GetSize() 
                + "\nand their color is : " + colony.GetColor());
        
        String expand  = JOptionPane.showInputDialog(null,"Would you like to "
                + "add a new color to you colony? \nType (1) for yes and (2) "
                + "for no.");
        int ex = Integer.parseInt(expand);
        
        if (ex == 1){
            String newColor = JOptionPane.showInputDialog(null,"What color "
                    + "would you like to add?");
            colony.expandColony();
            colony.AddColor(newColor);
        }
        
        //Checks the status
        JOptionPane.showMessageDialog(null, "So your name is : " 
                + colony.GetCareName() 
                + "\nThe name of your colony is : " + colony.GetColonyName() 
                + "\nIts size is : " + colony.GetSize() 
                + "\nand their color is : " + colony.GetColor());
        
        String feed  = JOptionPane.showInputDialog(null,"Type the number of how"
                + " many times you want"
                + " to feed them, \nor type (0) if you do not want to.");
        int fd = Integer.parseInt(feed);
        colony.feedColony(fd);
        JOptionPane.showMessageDialog(null,"You fed them "
        + colony.GetFoodLevel() + " times");
        
        String breed  = JOptionPane.showInputDialog(null,"Type the number "
                + "of how many "
                + "days you want them to breed, \nor type (0) if "
                + "do not want to.");
        int br = Integer.parseInt(breed);
        colony.breedColony(br);
        
        String vitamins  = JOptionPane.showInputDialog(null,"Vitamins can "
                + "help your butterflies stay healthy. \n Would you like to "
                + "give them some? \n Type (1) for yes and (2) "
                + "for no.");
        int vt = Integer.parseInt(vitamins);
            if(vt == 1){
                vitamin = true;
                }
        colony.giveVitamins(vitamin);
        colony.sickness();
        
        //Checks the status
        JOptionPane.showMessageDialog(null, "So your name is : " 
                + colony.GetCareName() 
                + "\nThe name of your colony is : " + colony.GetColonyName() 
                + "\nIts size is : " + colony.GetSize() 
                + "\nIts original size was : " + colony.GetSizeO()
                + "\nand their color is : " + colony.GetColor()
                + "\nThey were fed : " + colony.GetFoodLevel() + " times."
                + "\nYou wanted them to breed " + colony.GetBreed() + " times"
                + "\nThey scuccessfully bred " + colony.GetSucBreed() + " times"
                + "\n" + colony.GetKilled() + " died from sickness.");
        
        JOptionPane.showMessageDialog(null, "Thank you for playing!");
    }
    
}
