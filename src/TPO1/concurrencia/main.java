/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.concurrencia;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author juan
 */
public class main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int [] data = {1,2,3,4,5,6,7,8,9,10,23,32};
        SimpleExample app = new SimpleExample(data, 0, data.length);
        pool.invoke(app);
        System.out.println(app.result);
    }
}
