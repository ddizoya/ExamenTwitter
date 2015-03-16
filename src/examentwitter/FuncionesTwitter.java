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

    public FuncionesTwitter() {
        String fichero = "twitter4j.properties";
    }

    public FuncionesTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    /**
     * Atributo twitter, para emplearlo en los métodos.
     */
    public Twitter twitter;

    /**
     * Método inicial para loguearse. Es necesario iniciarlo para que el código
     * vaya.
     *
     * @throws TwitterException Clase propia de excepciones de Twitter.
     */
    /**
     * Mostrar la línea de tiempo de twitter.
     *
     * @throws TwitterException TwitterException Clase propia de excepciones de
     * Twitter.
     */
    public void mostrarLineaTiempo() throws TwitterException {
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Mostrando los tuits de Inicio.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }
    }

    /**
     * Método para postear un twit.
     *
     * @throws TwitterException TwitterException Clase propia de excepciones de
     * Twitter.
     */
    public void postearTuit() throws TwitterException {
        String respuesta = JOptionPane.showInputDialog("Introduce nuevo tuit.");
        Status status = twitter.updateStatus(respuesta);
        System.out.println("Has posteado con éxito [" + status.getText() + "].");
    }

    /**
     * Método para buscar un twit a través de un String.
     *
     * @throws TwitterException TwitterException Clase propia de excepciones de
     * Twitter.
     */
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
