/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examentwitter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author ddizoya
 */
public class ExamenTwitter {

    /** Main de la clase para testear que el código funcione.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {
        FuncionesTwitter objetoDePrueba = new FuncionesTwitter();
        
        objetoDePrueba.loguearse();
        objetoDePrueba.buscarTuit();
        objetoDePrueba.postearTuit();
        objetoDePrueba.mostrarLineaTiempo();
        
       
        
        
    }
    
}
