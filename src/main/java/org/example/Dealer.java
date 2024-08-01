package org.example;

public class Dealer extends Person{

    public Dealer(){
        super.setName("Dealer");
    }

    public void printFirstHand() {
        System.out.println("Dealers hand:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("the second card is face down");

    }
}
