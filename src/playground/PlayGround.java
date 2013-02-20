/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 *
 * @author Binh Tran <mynameisbinh@gmail.com>
 */
public class PlayGround {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("/home/ankel/file1.txt", true);
        BufferedWriter w = new BufferedWriter(fw);
        w.write("Hello");
        w.newLine();
        w.close();
        w = new BufferedWriter(fw);
        w.write("World");
        w.newLine();
        w.close();
        Runtime.getRuntime().exec("cat ~/file1.txt").waitFor();
        Runtime.getRuntime().exec("rm ~/file1.txt").waitFor();
    }
}
