/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtask;

import java.io.IOException;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.*;

public class RTask {

    public static void main(String[] args) {
        try {
            //Please, read the readme.md on GitHub for a extended explanation of the used items(Dataset and Algorithm)
            //
            //Creating the object connection
            RConnection c = null;
            //Creating the object Util
            Utils util = new Utils();
            //Open the conection
            c = util.openCon(c);
            //Calling the function
            util.path1(c);
            //Closing the conection
            util.closeCon(c);
        } catch (RserveException | REXPMismatchException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
