package org.example;

public abstract class Person {

    private Hand hand;
    private String name;
    private int balance;

    public Person() {
        this.hand = new Hand();
        this.name = "";
        this.balance = 5;
    }

    public int getBal(){
        return this.balance;
    }

    public void incBal(){
        this.balance += 5;
    }

    public void decBal(){
        this.balance -= 5;
    }


    public void setHand(Hand hand){
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public void setName(String name){
        this.name = name;
    }

    public void printHand(){
        System.out.println(this.name + "'s hand:");
        System.out.println(this.hand + " valued at: " + this.hand.calcVal());
    }

    public void hit(Deck deck, Deck discard){
        if (!deck.hasCard()){
            deck.reloadDiscard(discard);
        }
        this.hand.takeCard(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();
    }



    public String getName(){
        return name;
    }
    public boolean has21(){
        if (this.getHand().calcVal() == 21){
            return true;
        } else {
            return false;
        }
    }






}

