import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    //maak een deck van 52 kaarten
    //maak een methode die die 52 kaarten schudt
    //en zo een stapel kaarten geeft (List)

    public static List<Card> gameDeck = new ArrayList<>();

    public static void main(String[] args) {
        initializeDeck();
        //System.out.println(gameDeck.size());

        shuffleDeck();


        //Nu kan het spel beginnen
        //Je speelt tegen de computer

        //Je krijgt de 1e 2 kaarten
        startGame();

        //Dealer krijgt 1 kaart
        //Je bekijkt jouw kaarten
        //Dealer bekijkt zijn kaart /
        //Check of je hebt gewonnen
        //Ja klaar
        //Anders dealer krijgt nog een kaart

    }

    private static void startGame() {
    }

    public static void shuffleDeck() {
        Collections.shuffle(gameDeck);
        //System.out.println(gameDeck.size());
    }

    public static void initializeDeck() {
        //een loop die precies 52 kaarten maakt
        //van elk type 1, dus alle enums,

        //System.out.println(Card.Waarde.values()[0]);

        for (Card.Waarde waarde: Card.Waarde.values()) {
            for (Card.Symbool symbool: Card.Symbool.values()) {
                Card kaart = new Card(symbool,waarde);
                gameDeck.add(kaart);
            }

        }

    }

}
