package org.example;


import java.util.Scanner;

public class GameRunner {

    private Deck deck, discarded;



    private int wins, losses, pushes;

    private Dealer dealer;
    private Player player;


    public GameRunner() {
        deck = new Deck(true);

        discarded = new Deck();

        dealer = new Dealer();
        player = new Player();

        deck.shuffle();
        gameStart();

        this.wins = 0;
        this.losses = 0;
        this.pushes = 0;
    }
    private void gameStart(){
        System.out.println("players balance is: " + player.getBal());

        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting game  Wins: " + wins + "   Losses: " + losses + "   Pushes: " + pushes);
            System.out.println("players balance is: " + player.getBal());
            dealer.getHand().discardHand(discarded);
            player.getHand().discardHand(discarded);
        }
        if (deck.cardsLeft() < 4){
            deck.reloadDiscard(discarded);
        }
        dealer.getHand().takeCard(deck);
        dealer.getHand().takeCard(deck);

        player.getHand().takeCard(deck);
        player.getHand().takeCard(deck);
        dealer.printFirstHand();

        player.printHand();

        if (dealer.has21()){
            dealer.printHand();
            if (player.has21()){
                System.out.println("you both have 21, push");
                pushes++;
                gameStart();
            }else {
                System.out.println("dealer has 21. Sucks to suck");
                dealer.printHand();
                losses++;
                gameStart();
            }
        }

        if(player.has21()){
            System.out.println("21! you win!");
            wins++;
            gameStart();
        }


        player.makeDecision(deck,discarded);
        if (player.getHand().calcVal()>21){
            System.out.println("BUST! you lose:(");
            losses++;
            gameStart();
        }

        dealer.printHand();

        while(dealer.getHand().calcVal()<17){
            dealer.hit(deck,discarded);
        }

        if (dealer.getHand().calcVal()>21){
            System.out.println("Dealer busts");
            player.incBal();
            wins++;
        } else if (dealer.getHand().calcVal() > player.getHand().calcVal()){
            System.out.println("you lose");
            player.decBal();
            losses++;
        } else if (player.getHand().calcVal() > dealer.getHand().calcVal()){
            System.out.println("you win");
            wins++;
            player.incBal();
        } else{
            System.out.println("Push");
            pushes++;
        }
        gameStart();

    }

    public static void main(String[] args) {

        System.out.println("Welcome to 21 / Black Jack!");


        GameRunner game = new GameRunner();

    }
}

