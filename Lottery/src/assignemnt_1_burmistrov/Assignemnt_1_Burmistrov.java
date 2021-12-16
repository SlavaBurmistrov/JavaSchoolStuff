//********************************************************************************
// PantherID:  5909727
// CLASS: COP 2210 – 2019
// ASSIGNMENT #1
// DATE: 9/12/19
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//********************************************************************************



      
package assignemnt_1_burmistrov;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Slava
 */
public class Assignemnt_1_Burmistrov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int select;
        Scanner scnr = new Scanner(System.in);
        Random r = new Random();
        JOptionPane.showMessageDialog(null, "Hi Mom! Thank you for choosing this program! ");
        JOptionPane.showMessageDialog(null, "First, I need to know what you are playing today. ");
        
        String ones = JOptionPane.showInputDialog("For Fantasy 5 type (5) and for Regular lottery type (6)! ");
        select = Integer.parseInt(ones);
        
        if (select == 5){
            System.out.println("You have selected Fantasy 5!");
        int one;
        int two;
        int three;
        int four;
        int five;
        
        one = 1 + r.nextInt(36);
        two = 1 + r.nextInt(36);
        three = 1 + r.nextInt(36);
        four = 1 + r.nextInt(36);
        five = 1 + r.nextInt(36);
        
        JOptionPane.showMessageDialog(null, "Here are your winning numbers ---> "
                + one + " " + two
                + " " + three + " " + four + " " + five + " ");
        
        }
        
        if (select == 6){
            System.out.println("You have selected Regular lottery!");
        int one;
        int two;
        int three;
        int four;
        int five;
        int six;
        
        one = 1 + r.nextInt(53);
        two = 1 + r.nextInt(53);
        three = 1 + r.nextInt(53);
        four = 1 + r.nextInt(53);
        five = 1 + r.nextInt(53);
        six= 1 + r.nextInt(53);
        
        JOptionPane.showMessageDialog(null, "Here are your winning numbers ---> " + one +
                " " + two + " " + three + " " + four + " " + five + " " + six);
        }
        if(select < 5 || select > 6)
        {
            JOptionPane.showMessageDialog(null, "Read the instructions! You have to select 5 OR 6");
            JOptionPane.showMessageDialog(null, "Try again!");
    }
        
    }
    
}
