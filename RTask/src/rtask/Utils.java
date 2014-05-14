/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 *
 * @author JoseAntonio
 */
public class Utils {

    //Exp: Public function to open the connection 
    //IN-Param: The connection object
    //Out-Param: The connection object
    public RConnection openCon(RConnection c) throws RserveException {
        boolean check = false;
        c = new RConnection();
        if (c.isConnected()) {
            check = true;
            System.out.println("Connection Established");
            decorationText();
        }
        return c;
    }

    //Exp: Public function to close the connection
    //IN-Param: The connection object
    //Out-Param: Bool object to guarantee the process
    public boolean closeCon(RConnection c) {
        boolean check = false;
        if (c.isConnected()) {
            if (c.close()) {
                check = true;
                decorationText();
                System.out.println("Connection Closed");
            }
        } else {
            System.out.println("Rserve could not connected");
        }
        return check;
    }

    //Exp: Private funcion to add a text decoration
    //IN-Param: No
    //Out-Param: Void
    private void decorationText() {
        System.out.println("======================");
    }

    //Exp: It is described in readme.md on GitHub 
    //IN-Param: The connection object and X,Y,Z (readme.md for descriptions)
    //Out-Param: No
    public void path1(RConnection c,double x,int y,int z) throws IOException, RserveException, REXPMismatchException {
        REXP re = new REXP();

        c.eval("#function 1 - it is used to load a sample training data\n"
                + "fun1<-function(x){\n"
                + "idx <- sample(1:nrow(iris), as.integer(x * nrow(iris)))\n"
                + "return (idx)\n"
                + "}\n"
                + "#function 2 - test the KNN algorithm\n"
                + "fun2<-function(x,y,z){\n"
                + "#loading library\n"
                + "library(class)\n"
                + "#loading dataset\n"
                + "data(iris)\n"
                + "#loading training object thought function 1. \"X\" = % of dataset used for the training\n"
                + "idx <-fun1(x)\n"
                + "#loading the KNN where \"Y\" = columns and \"Z\" = number of neighbours considered\n"
                + "tr <- iris[idx, ]\n"
                + "ts <- iris[-idx, ]\n"
                + "preds <- knn(tr[, -y], ts[, -y], tr[, y], k = z)\n"
                + "#return the value\n"
                + "return (preds)\n"
                + "}");

        evaluation(re, c,x,y,z);

    }
    
    //Exp: It is described in readme.md on GitHub 
    //IN-Param: The connection object and X,Y,Z (readme.md for descriptions)
    //Out-Param: No
    public void path2(RConnection c,double x,int y,int z) throws IOException, RserveException, REXPMismatchException {
        REXP re = new REXP();
        String root = System.getProperty("user.dir") + System.getProperty("file.separator");

        c.eval("source(" + root + "exe.R)");
        System.out.println("Reading script");

        evaluation(re, c,x,y,z);
    }

    //Exp: Private function to present the results
    //IN-Param: The connection and EXP objects
    //Out-Param: No
    private void evaluation(REXP re, RConnection c,double x,int y,int z) throws RserveException, REXPMismatchException {
        c.eval("ejecution<-fun2("+x+","+y+","+z+")");
        re = c.eval("table(ejecution)");

        System.out.println("Class 1:" + re.asIntegers()[0]);
        System.out.println("Class 2:" + re.asIntegers()[1]);
        System.out.println("Class 3:" + re.asIntegers()[2]);
    }
}
