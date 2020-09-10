/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia;

import static TPO1.concurrencia.utiles.getMovie;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class Downloader extends RecursiveAction{

    String data[];
    Downloader(String[] data) {
	this.data = data;	  
    }
    @Override
    protected void compute() {
        if(data.length ==1){
            try {
                String auxi = getMovie(data[0]);
                System.out.println(auxi);
            } catch (IOException ex) {
                Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            int mid = data.length/2;
            if(data.length % 2 !=0){
                mid++;
            }
            invokeAll(new Downloader(Arrays.copyOfRange(data, 0, mid)), 
                 new Downloader(Arrays.copyOfRange(data, mid, data.length)));
        }
    }
    
}
