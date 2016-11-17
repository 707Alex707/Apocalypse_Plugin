package group.wilson.apocalypse;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by s201021621 on 2016-11-17.
 */
public class Scoreboard {


    public Scoreboard(int kills) {

        kills++;

        try(  PrintWriter out = new PrintWriter( "kills.txt" )  ){
            out.println( kills );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    //Returns the score of the players kills and writes the score to a txt file called "kills.txt"

}
