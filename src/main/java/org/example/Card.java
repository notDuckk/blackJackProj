package org.example;

public class Card {


    private Suits suit;
    private Rank rank;

    // constructor
    public Card(Suits suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Card (Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }



    public int getValue(){
        return rank.rankValue;
    }

    public Suits getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return (rank + " of " + suit + "("+rank.rankValue+")");
    }


}