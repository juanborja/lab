/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.patrones;

import java.io.IOException;

/**
 *
 * @author darian
 */
public class main {

    public static void main(String[] args) throws IOException {
        //Works as client
        TranslatorApp translatorApp = new TranslatorApp();

        String []toTranslate = {"I am english", "Ich bin Deutscher", "je suis Français","Hola mundo, soy español","Ciao mondo","Olá mundo, sou portugues","Jeg er norsk","卵"};
       
        for (String text : toTranslate) {
            translatorApp.translateToSp(text);
        }
        //translatorApp.translateToSp("Ciao mondo");
        
    }

}
