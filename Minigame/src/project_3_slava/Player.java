/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_3_slava;

import javax.swing.JOptionPane;

/**
 *
 * @author Slava
 */
public class Player {

    private String name;
    private String backPack;

    public Player() {
    }

    public void SetPlayerName() {
        name = JOptionPane.showInputDialog(null, "What is your name?");
    }

    public void SetPackItem(String x) {
        backPack = x;
        JOptionPane.showMessageDialog(null, backPack + " has been put in "
                + "your backpack.");
    }

    public String GetPlayerName() {
        return name;
    }

    public String GetPackItem() {
        return backPack;
    }

    public void DeathScreen() {
        JOptionPane.showMessageDialog(null, name + " had died while holding "
                + backPack);
    }
}
