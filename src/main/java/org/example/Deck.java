package org.example;


import java.util.ArrayList;
import java.util.Objects;


public class Deck implements DeckActions{

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if (makeDeck) {
            for (Suits suit: Suits.values()){
                for (Rank rank: Rank.values()){
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    private Objects/* you can change this to any type you want*/ myCards;
    private int numCards;

    public ArrayList<Card> getCards() {
        return deck;
    }

    public void addCard(Card card){
        deck.add(card);
    }
    public boolean hasCard(){
        if (deck.size() > 0){
            return true;
        }else{
            return false;
        }

    }

    public int cardsLeft(){
        return deck.size();
    }

    public void emptyDeck(){
        deck.clear();
    }

    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }


    public void reloadDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("ran outa cards, shuffling for more...");
    }




    public Card takeCard(){
        Card cardtoTake = new Card(deck.get(0));
        deck.remove(0);
        return cardtoTake;
    }

    @Override
    public void shuffle() {
        ArrayList<Card> shuffled = new ArrayList<>();

        while (deck.size()>0){
           int cardToPull = (int)(Math.random()*(deck.size()-1));
           shuffled.add(deck.get(cardToPull));
           deck.remove(cardToPull);
        }
        deck = shuffled;
    }

    @Override
    public Card dealNextCard() {
        return null;
    }

    @Override
    public void printDeck(int numToPrint) {

    }

    @Override
    public String toString() {
        String output = "";

        for(Card card: deck){
            output += card;
            output += "\n";
        }
        return output;
    }


}
