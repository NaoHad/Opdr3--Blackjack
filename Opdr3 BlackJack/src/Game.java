import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static List<Card> jouwHand = new ArrayList<>();
    public static int jouwWaarde = 0;

    public static List<Card> dealerHand = new ArrayList<>();
    public static int dealerWaarde = 0;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.initializeDeck();
        //System.out.println(deck.gameDeck.size());

        deck.shuffleDeck();


        //Nu kan het spel beginnen
        System.out.println("Welkom bij het spel blackjack");
        //Je speelt tegen de computer
        System.out.println("Je zult 1 tegen 1 spelen tegen de computer, veel succes!");


        //Je krijgt de 1e 2 kaarten
        boolean klaar = false;
        while(!klaar){
            System.out.println("Voer (T) in om twee kaarten te trekken!");
            Scanner input = new Scanner(System.in);

            String s = input.next();
            switch (s){
                case "T":
                    jouwHand.add(deck.gameDeck.get(0));
                    jouwHand.add(deck.gameDeck.get(1));


                    dealerHand.add(deck.gameDeck.get(2));

                    berekenWaardes();

                    System.out.println("Jij trok een " + deck.gameDeck.get(0).symbool.name() + " " + deck.gameDeck.get(0).waarde.name());
                    System.out.print("en een " + deck.gameDeck.get(1).symbool.name() + " " + deck.gameDeck.get(1).waarde.name());
                    System.out.println("");
                    System.out.println("Dat geeft een totaalwaarde van " + jouwWaarde);

                    System.out.println("De dealer trok een " + deck.gameDeck.get(2).symbool.name() + " " + deck.gameDeck.get(2).waarde.name());
                    System.out.println("Dat geeft een totaalwaarde van " + dealerWaarde);

                    if(jouwWaarde == 21 && dealerWaarde != 10 && dealerWaarde != 11) {
                        System.out.println("Gefeliciteerd, jij hebt BLACKJACK en de dealer kan niet meer winnen!");
                        klaar = true;
                        break;
                    }
                    if(dealerWaarde +11< jouwWaarde) {
                        System.out.println("Gefeliciteerd, jij wint want de dealer kan niet meer winnen!");
                        klaar = true;

                        break;
                    }
                    if(jouwWaarde > 21) {
                        System.out.println("Helaas! Je hebt verloren!");
                        klaar = true;

                        break;
                    }
                    System.out.println("Druk op (D) om de dealer zijn tweede kaart te bekijken");
                     s = input.next();
                     boolean kklaar = false;
                     while (!kklaar){
                         switch (s){
                             case "D":
                                 dealerHand.add(deck.gameDeck.get(3));
                                 kklaar = true;
                                 break;
                                 default:
                                     System.out.println("Invalide invoer. Vul aub 1 van de opties in en druk op enter.");

                         }
                     }
                     dealerWaarde = 0;
                     jouwWaarde = 0;
                     berekenWaardes();
                    System.out.println("De dealer trok een " + deck.gameDeck.get(3).symbool.name() + " " + deck.gameDeck.get(3).waarde.name());
                    System.out.println("Dat geeft een totaalwaarde  voor DEALER van " + dealerWaarde);
                    System.out.println("JIJ had een totaalwaarde van " + jouwWaarde);





                    if(dealerWaarde == 21){
                         if(jouwWaarde == 21) {
                             System.out.println("Gelijkspel, allebei blackjack!");
                             klaar = true;

                             break;
                         }
                         else {
                             System.out.println("Helaas, de dealer heeft blackjack dus jij verliest!");
                             klaar = true;

                             break;
                         }
                     }
                     if(dealerWaarde < 21){
                         if(dealerWaarde < jouwWaarde) {
                             System.out.println("Jij wint!");
                             klaar = true;

                             break;
                         }
                         else{
                             System.out.println("Helaas, de dealer heeft meer punten dan jij!");
                             klaar = true;

                             break;
                         }
                     }
                     if(dealerWaarde > 21){
                         System.out.println("Jij wint!");
                         klaar = true;

                         break;
                     }






                    klaar = true;
                    break;
                //case "X":
                //    return;
                default:
                    System.out.println("Invalide invoer. Vul aub 1 van de opties in en druk op enter.");


            }
        }



        //Dealer krijgt 1 kaart
        //Je bekijkt jouw kaarten
        //Dealer bekijkt zijn kaart /
        //Check of je hebt gewonnen
        //Ja klaar
        //Anders dealer krijgt nog een kaart

    }

    private static void berekenWaardes() {
        for (Card kaart: jouwHand) {
            switch (kaart.waarde) {
                case AAS:
                    if(jouwWaarde == 0)
                        jouwWaarde = jouwWaarde + 11;
                    else{
                        if(jouwWaarde > 10)
                            jouwWaarde = jouwWaarde + 1;
                        else {
                            jouwWaarde = jouwWaarde + 11;
                        }
                    }
                    break;
                case TWEE:
                    jouwWaarde = jouwWaarde+2;
                    break;
                case DRIE:
                    jouwWaarde = jouwWaarde+3;
                    break;
                case VIER:
                    jouwWaarde = jouwWaarde+4;
                    break;
                case VIJF:
                    jouwWaarde = jouwWaarde+5;

                    break;
                case ZES:
                    jouwWaarde = jouwWaarde+6;
                    break;
                case ZEVEN:
                    jouwWaarde = jouwWaarde+7;
                    break;
                case ACHT:
                    jouwWaarde = jouwWaarde+8;
                    break;
                case NEGEN:
                    jouwWaarde = jouwWaarde+9;
                    break;
                case TIEN:
                    jouwWaarde = jouwWaarde+10;
                    break;
                case BOER:
                    jouwWaarde = jouwWaarde+10;
                    break;
                case VROUW:
                    jouwWaarde = jouwWaarde+10;
                    break;

                case HEER:
                    jouwWaarde = jouwWaarde+10;

                    break;
            }

        }

        for (Card kaart: dealerHand) {
            switch (kaart.waarde) {
                case AAS:
                    if(dealerWaarde == 0)
                        dealerWaarde = dealerWaarde + 11;
                    else{
                        if(dealerWaarde > 10)
                            dealerWaarde = dealerWaarde + 1;
                        else {
                            dealerWaarde = dealerWaarde + 11;
                        }
                    }
                    break;
                case TWEE:
                    dealerWaarde = dealerWaarde+2;
                    break;
                case DRIE:
                    dealerWaarde = dealerWaarde+3;
                    break;
                case VIER:
                    dealerWaarde = dealerWaarde+4;
                    break;
                case VIJF:
                    dealerWaarde = dealerWaarde+5;

                    break;
                case ZES:
                    dealerWaarde = dealerWaarde+6;
                    break;
                case ZEVEN:
                    dealerWaarde = dealerWaarde+7;
                    break;
                case ACHT:
                    dealerWaarde = dealerWaarde+8;
                    break;
                case NEGEN:
                    dealerWaarde = dealerWaarde+9;
                    break;
                case TIEN:
                    dealerWaarde = dealerWaarde+10;
                    break;
                case BOER:
                    dealerWaarde = dealerWaarde+10;
                    break;
                case VROUW:
                    dealerWaarde = dealerWaarde+10;
                    break;

                case HEER:
                    dealerWaarde = dealerWaarde+10;

                    break;
            }

        }


    }
}
