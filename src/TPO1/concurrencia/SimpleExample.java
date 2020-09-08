/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author juan
 */
public class SimpleExample extends RecursiveAction{
    final int LIMIT = 40;
    static int result;
    int start, end;
    int[] data;
    SimpleExample(int[] data, int start, int end) {
		   this.start = start;
		   this.end = end;
		   this.data = data;
	   }
    @Override
    protected void compute() {
        if((end - start)< LIMIT){
            for(int i= start;i<end;i++)result+= data[i]*data[i];   
            
	}
        else {
            int mid = (start + end)/2;
            SimpleExample left = new SimpleExample(data, start, mid); 
            SimpleExample right = new SimpleExample(data, mid, end);
            left.fork();
            right.fork();
            left.join();
            right.join();
	}
    }
    
}
