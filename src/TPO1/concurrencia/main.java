/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia;

import static TPO1.concurrencia.utiles.getMovie;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class main {
    public static void main(String[] args) throws IOException {
        String []titles = {"The Shawshank Redemption", "The Godfather", "The Godfather: Part II", "The Dark Knight", "12 Angry Men"};
       
        for (String title : titles) {
             String aux = getMovie(title);
            System.out.println(aux);
        }
       
   
    }
}
