/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject.optionpane;

import javax.swing.JOptionPane;

/**
 *
 * @author Fahad_G4
 */
public class CustomJoptionPane {

    public CustomJoptionPane() {
    }
    
    public static void showErrorOptionPane(String title,String message){
        JOptionPane.showMessageDialog(null, message);
    }
    public static void showSuccessOptionPane(String title,String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
