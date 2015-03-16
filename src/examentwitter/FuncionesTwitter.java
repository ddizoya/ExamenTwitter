/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examentwitter;

import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author ddizoya
 */
public class FuncionesTwitter {
    
    public Twitter twitter;
    
    public void loguearse() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthAuthenticationURL("https://api.twitter.com/oauth2/token")
                .setOAuthAuthorizationURL("https://api.twitter.com/oauth/authorize")
                .setOAuthAccessTokenURL("https://api.twitter.com/oauth/access_token")
                .setRestBaseURL("https://api.twitter.com/1.1/");
        
        twitter = new TwitterFactory(cb.build()).getInstance();
        
    }
    
    public void ConfiguracionInicial() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("0PHckXrWZHkSEy90Bz5L3iSt5")
                .setOAuthConsumerSecret("icwhQudxPi2pvDBTOctbY7XjqZ8SSvri2WQTmXQ9OlGgwsWbvp")
                .setOAuthAccessToken("3071806397-KTOfFKLZIpzEPqX9rNJVdALRhdyyAD8ySHPU92E")
                .setOAuthAccessTokenSecret("CaH64RTown2lt9Szwc0Js845NAoxm1tObi9KQ7q5GxpjI");
        
        twitter = new TwitterFactory(cb.build()).getInstance();
        
    }
    
    public void mostrarLineaTiempo() throws TwitterException {
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Mostrando los tuits de Inicio.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }
    }
    
    public void postearTuit() throws TwitterException {
        String respuesta = JOptionPane.showInputDialog("Introduce nuevo tuit.");
        Status status = twitter.updateStatus(respuesta);
        System.out.println("Has posteado con éxito [" + status.getText() + "].");
    }
    
    public void buscarTuit() throws TwitterException {
        
        String resp = JOptionPane.showInputDialog("Introduce criterio de búsqueda.");
        Query miquery = new Query(resp);
        QueryResult result = twitter.search(miquery);
        List<Status> tweets = result.getTweets();
        
        for (Status status : tweets) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
        
    }
    
}
