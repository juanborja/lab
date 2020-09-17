/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia.Spotify;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class ApiCall {
    public static Artist  getArtist(String name) {
        final String token = "BQDgHYEh9JHdMxaMHmCWycD6Ii2WaNFax1p2ahjCEMSxEhABNgenZDRzTqntVnl99VbjIkgVu15n91BHLZMIDAN0hJxRqp_A-7xBdvCB7Vpv-PNn6lcHqdOVu4h4TXjLQ3XN3z-wxE9p";
        StringBuffer response = new StringBuffer();
        try {      
        URL url = new URL("https://api.spotify.com/v1/search?q="+name.trim().replaceAll(" ", "%20")+"&type=artist&limit=1&offset=0");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization","Bearer "+token);
      

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
            
        } catch (IOException ex) {
            System.err.println("Renovar token");
        }
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(response.toString()).getAsJsonObject();
        JsonObject artista = o.getAsJsonObject("artists");
        JsonObject aux = artista.getAsJsonArray("items").get(0).getAsJsonObject();
        int pop = Integer.parseInt(aux.get("popularity").getAsString());
        Artist artist = new Artist(aux.get("name").getAsString(),aux.get("id").getAsString(), pop );
        return artist; 
    }
}
