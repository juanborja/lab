/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia;

import TPO1.concurrencia.Spotify.Artist;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.Scanner;
import java.net.URL;

/**
 *
 * @author juan
 */
public class utiles {
    public static String  getMovie(String title) throws IOException{
        String response = null; 
        try {
            URLConnection connection = new URL("http://www.omdbapi.com/?apikey=a8407cda&t="+title.trim().replaceAll(" ", "+")).openConnection();
            try(Scanner scanner = new Scanner(connection.getInputStream());){
            response = scanner.useDelimiter("\\A").next();
}
        } catch (MalformedURLException ex) {
            System.err.println(ex);
            
        }
        return response; 
    }
    
    
    

}
