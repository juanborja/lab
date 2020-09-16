/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
    
    public static String  getArtist(String name) throws IOException{
        StringBuffer response = new StringBuffer();
        try {      
        URL url = new URL("https://api.spotify.com/v1/search?q="+name.trim().replaceAll(" ", "%20")+"&type=artist&limit=1&offset=0");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization","Bearer "+"BQBZyrb0-w-z3gd_ulC8ipSAo2D0pygiodJ1b_Ym6K9LnYHZMeN4ZNb-AT0OTR_EC7au2vjPTlbMDrZ139kygyu8NBkwOOoYXSyvKQOHQj4ptr1CmjcjIO5zKQ36Z_FevHKH71TF8vkq");
      

        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        
        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        in.close();
        } catch (MalformedURLException ex) {
            System.err.println(ex);
            
        }
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(response.toString()).getAsJsonObject();
        JsonObject artista = o.getAsJsonObject("artists");
        JsonObject aux = artista.getAsJsonArray("items").get(0).getAsJsonObject();
        return aux.get("name")+" - "+aux.get("popularity"); 
    }
}
