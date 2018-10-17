/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadeout;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author pau
 */
public class FadeOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MyFrame v;
        try {
            v = new MyFrame();
            v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(FadeOut.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
        
    }
    
}
