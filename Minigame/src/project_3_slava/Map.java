/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_3_slava;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Slava
 */
public class Map {

    public Map() {
        JFrame app = new JFrame();
        app.setSize(1000,1000);
    }
    
    public void GetMapLiving(){
    JOptionPane.showMessageDialog(null,"+-------------------+-------------+\n" +
"|                   +  Front      |\n" +
"|                                 |\n" +
"|      Living                     |\n" +
"|      Room         +       +     |\n" +
"|                   |       |     |\n" +
"|       X           |       |     |\n" +
"|                   |       |     |\n" +
"|                   |       |     |\n" +
"|                   |       |     |\n" +
"|                   |       |     |\n" +
"|                   |       |     |\n" +
"+-------+-   +------+       |     |\n" +
"|       |           |       |     |\n" +
"| Pantry|Bathroom   |       |     |\n" +
"|       |           |       |     |\n" +
"|   +---+--------+--+       +-----+\n" +
"|                |                |\n" +
"|                |                |\n" +
"|   Kitchen      |    Dining Room |\n" +
"|                |                |\n" +
"|                |                |\n" +
"|                                 |\n" +
"|                                 |\n" +
"|                +                |\n" +
"+----------------+----------------+");
    }
}
