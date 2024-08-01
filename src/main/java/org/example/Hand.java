package org.example;

import java.util.ArrayList;
import java.util.Scanner;


//implementation of blackjack player
public class Hand {

    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }



    public void takeCard(Deck deck){
        hand.add(deck.takeCard());
    }

    public int calcVal() {
        int value = 0;
        int aceCount = 0;

        for (Card card: hand){
            value += card.getValue();
            if (card.getValue() == 11){
                aceCount ++;
            }

        }
        if (value > 21 && aceCount > 0){
            while (aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;
            }
        }
        return value;
    }


    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
        }
        return output;
    }




}