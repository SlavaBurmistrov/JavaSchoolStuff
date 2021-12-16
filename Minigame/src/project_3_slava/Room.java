package project_3_slava;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Slava
 */
public class Room {

    private String nameRoom;
    private String[] optionsArray = new String[3]; //If three decisions
    private ArrayList options;
    private String img  = "";
    private int outPut = 3;
    Player player = new Player();

    public Room(String x, String y) {
        options = new ArrayList();
        nameRoom = x;
        img = y;
    }

    public void AddOptions(String x){
        options.add((Object)x);
    }
    

    public void makeDecision() {
            outPut = JOptionPane.showOptionDialog(null, "You are at " + nameRoom
                    + ". "
                    + "Where would you like to go to?",
                    nameRoom,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(img), //do not use a custom Icon
                    options.toArray(), //the titles of buttons
                    0); //default button title
        } 
    

    //------GetFunctions------
    public int GetOutPut() {
        return outPut;
    }

   /* public String GetOption(int x) {
        return options.get(x);
    }
    */
}
