//********************************************************************************
// PANTHERID:  5909727
// CLASS: COP 2210 – 2019
// ASSIGNMENT # 3
// DATE: 11/04/19
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//********************************************************************************
package project_3_slava;

import javax.swing.JOptionPane;

/**
 *
 * @author Slava
 */
public class Project_3_Slava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //ROOM OBJECTS 
        Room front = new Room("Front Porch", "src/project_3_slava/rooms/front.png");
        Room living = new Room("Living Room", "src/project_3_slava/rooms/Living.png");
        Room dining = new Room("Dining Room", "src/project_3_slava/rooms/Dining.png");
        Room second = new Room("Second Floor", "src/project_3_slava/rooms/Second.png");
        Room bath1 = new Room("Bathroom", "src/project_3_slava/rooms/Bath1.png");
        Room kitchen = new Room("Kitchen", "src/project_3_slava/rooms/Kitchen.png");
        Room pantry = new Room("Pantry", "src/project_3_slava/rooms/Pantry.png");
        Room master = new Room("Master Bedroom", "src/project_3_slava/rooms/Mastbed.png");
        Room mastBath = new Room("Master Bathroom", "src/project_3_slava/rooms/MastBath.png");
        Room bed1 = new Room("Bedroom One", "src/project_3_slava/rooms/Bed1.png");
        Room bed2 = new Room("Bedroom Two", "src/project_3_slava/rooms/Bed2.png");
        Room bath2 = new Room("Bathroom Two", "src/project_3_slava/rooms/Bath2.png");
        Player player = new Player();

        player.SetPlayerName();
        //---------FRONT ENTRANCE-----------
        front.AddOptions("To the Living Room");
        front.AddOptions("to The Dining Room");
        front.AddOptions("To the Second Floor");
        front.makeDecision();
        if (front.GetOutPut() == 0) { //GO TO LIVING ROOM
            living.AddOptions("to the Bathroom");
            living.AddOptions("look inside the Chest");
            living.makeDecision();
        } else if (front.GetOutPut() == 1) { //GO TO DINING ROOM
            dining.AddOptions("go to Kitchen");
            dining.AddOptions("look at the Candle");
            dining.makeDecision();
        } else if (front.GetOutPut() == 2) { //GO TO SECOND FLOOR
            second.AddOptions("go to Master Bedroom");
            second.AddOptions("go to Bedroom One");
            second.AddOptions("go to Bedroom Two");
            second.makeDecision();
        }
        //--------LIVING ROOM--------------
        if (living.GetOutPut() == 0) { //GO TO BATHROOM
            bath1.AddOptions("Look in the Mirror");
            bath1.AddOptions("Look in the Shower");
            bath1.makeDecision();
        } else if (living.GetOutPut() == 1) { //GO TO CHEST
            player.SetPackItem("a chest");
            JOptionPane.showMessageDialog(null, "Ghost escapes and scares"
                    + " you to death");
            player.DeathScreen();
        }
        //--------BATHROOM ONE--------------
        if (bath1.GetOutPut() == 0) { //GO TO MIRROR
            player.SetPackItem("a mirror");
            JOptionPane.showMessageDialog(null, "See a bloody face looking"
                    + " back at you");
            player.DeathScreen();
        } else if (bath1.GetOutPut() == 1) { //GO TO SHOWER
            player.SetPackItem("a shower head");
            JOptionPane.showMessageDialog(null, "Room suddenly steams up"
                    + " and you feel fingers touching the back "
                    + "of your neck");
            player.DeathScreen();
        }
        //----------DINING ROOM--------------
        if (dining.GetOutPut() == 0) { //GO TO KITCHEN
            kitchen.AddOptions("go to Pantry");
            kitchen.AddOptions("look in the Fridge");
            kitchen.AddOptions("look in the Cabinet");
            kitchen.makeDecision();
        } else if (dining.GetOutPut() == 1) { //LOOK AT THE CANDLE
            player.SetPackItem("a candelabra");
            JOptionPane.showMessageDialog(null, "Light up by themselves "
                    + "and see a death shadow.");
            player.DeathScreen();
        }
        //-----------KITCHEN-------------------
        if (kitchen.GetOutPut() == 0) { //GO TO PANTRY
            pantry.AddOptions("look in the Box");
            pantry.AddOptions("look at the Broom");
            pantry.makeDecision();
        } else if (kitchen.GetOutPut() == 1) { //GO TO FRIDGE
            player.SetPackItem("an egg from the Fridge");
            JOptionPane.showMessageDialog(null, "Open it and find some delicious"
                    + " soul food.");
            player.DeathScreen();
        } else if (kitchen.GetOutPut() == 2) { //GO TO CABINET
            player.SetPackItem("Mac N' Cheese");
            JOptionPane.showMessageDialog(null, "The dishes and glasses"
                    + " start flying at you as soon as you open the door."
                    + " You get hit in the head and feel yourself start moving "
                    + "towards a light.");
            player.DeathScreen();
        }
        //-----------PANTRY--------------------
        if (pantry.GetOutPut() == 0) {
            player.SetPackItem("an old receipt");
            JOptionPane.showMessageDialog(null, "The cost for entering this "
                    + "house is your soul.");
            player.DeathScreen();
        } else if (pantry.GetOutPut() == 1) {
            player.SetPackItem("a broom");
            JOptionPane.showMessageDialog(null, "It flies up as soon as you"
                    + " touch it");
            player.DeathScreen();
        }
        //---------SECOND FLOOR------------------
        if (second.GetOutPut() == 0) {
            master.AddOptions("Master Bathroom");
            master.AddOptions("Jewlery");
            master.makeDecision();
        } else if (second.GetOutPut() == 1) {
            bed1.AddOptions("Rocking Chair");
            bed1.AddOptions("Window");
            bed1.AddOptions("Bathroom");
            bed1.makeDecision();
        } else if (second.GetOutPut() == 2) {
            bed2.AddOptions("Doll House");
            bed2.AddOptions("Dresser");
            bed2.AddOptions("Bathroom");
            bed2.makeDecision();
        }
        //--------MASTER BATHROOM----------------
        if (master.GetOutPut() == 0) {
            mastBath.AddOptions("Oil Lamp");
            mastBath.AddOptions("Shower");
            mastBath.makeDecision();
        } else if (master.GetOutPut() == 1) {
            player.SetPackItem("a Ring");
            JOptionPane.showMessageDialog(null, "You find the cursed Hope"
                    + " Diamond and feel your doom.");
            player.DeathScreen();
        }
        //--------BEDROOM ONE---------------------
        if (bed1.GetOutPut() == 0) {
            player.SetPackItem("a Book");
            JOptionPane.showMessageDialog(null, "Chair starts rocking by "
                    + "itself with no one in it.");
            player.DeathScreen();
        } else if (bed1.GetOutPut() == 1) {
            player.SetPackItem("a window handle");
            JOptionPane.showMessageDialog(null, "See a child outside on a swing"
                    + " who suddenly disappears.");
            player.DeathScreen();
        } else if (bed1.GetOutPut() == 2) {
            bath2.AddOptions("Mirror");
            bath2.AddOptions("Shower");
            bath2.makeDecision();
        }
        //--------BEDROOM TWO---------------------
        if (bed2.GetOutPut() == 0) {
            player.SetPackItem("a Doll");
            JOptionPane.showMessageDialog(null, "The dolls start dancing"
                    + " on their own.");
            player.DeathScreen();
        } else if (bed2.GetOutPut() == 1) {
            player.SetPackItem("a Dress");
            JOptionPane.showMessageDialog(null, "A ghost flies out of the "
                    + "dresser as soon as you open it and goes "
                    + "right though your body.");
            player.DeathScreen();
        } else if (bed2.GetOutPut() == 2) {
            bath2.AddOptions("Mirror");
            bath2.AddOptions("Shower");
            bath2.makeDecision();
        }
        //---------BATHROOM TWO---------------------
        if (bath2.GetOutPut() == 0) {
            player.SetPackItem("a mirror");
            JOptionPane.showMessageDialog(null, "See a bloody face looking"
                    + " back at you");
            player.DeathScreen();
        } else if (bath2.GetOutPut() == 1) {
            player.SetPackItem("a shower head");
            JOptionPane.showMessageDialog(null, "Room suddenly steams up"
                    + " and you feel fingers touching the back "
                    + "of your neck");
            player.DeathScreen();
        }
    }

}
