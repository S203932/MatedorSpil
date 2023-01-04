package ChanceCardsAndDeck.ChanceCardsAndDeck;
// Class is written by Patrick Machalet s203932 and Nataliia Khaiko s224295


public class CardDeck {
    private ChanceCards[] card;
    private int length=7;


    public CardDeck() {
        initilalizeCard();

    }


    public void initilalizeCard(){
        this.card=new ChanceCards[length];
    }

    public void setCard(ChanceCards[] card) {
        this.card = card;
    }

    public ChanceCards getCard(int index) {
        return card[index];
    }

      public void setCards (){
     /* type 1 - free property Orange property
        type 2 - move to
        type 3 - transaction
        type 4 - free property light blue property
        type 5 - free property red property
       */
          this.card=new ChanceCards[length];
        card[0] = new ChanceCards();
        card[0].setType(2);// move to Start
        card[0].setMoveTo(0);
        card[0].setDescription("You for some reason need to move to start, but you get cash" +
                ".\n Anyway press the button to move.");

        card[1] = new ChanceCards();
        card[1].setType(1); // free orange space
        // card.getCard(1).setMoveTo();

        card[2] = new ChanceCards();
        card[2].setType(3); // pay 2$
        card[2].setTransaction(-2);
        card[2].setDescription("You fell into a deep depression due to the workload of " +
                "your studies and now you have to pay for a psychologist. Press the button to pay.");
        card[3] = new ChanceCards();
        card[3].setType(4); // free light blue space
        //  card.getCard(3).setMoveTo();
        card[4] = new ChanceCards();
        card[4].setType(2); // move to beach
        card[4].setMoveTo(23);
        card[4].setDescription("You get the urge to watch some sealions and go to the beach" +
                "as it is the sea and they are the lions of the sea. Press the button to move.");
        card[5] = new ChanceCards();
        card[5].setType(5); // free red space
          //  card.getCard(5).setMoveTo();
        card[6] = new ChanceCards();
        card[6].setType(3); // you get 2$
        card[6].setTransaction(2);
        card[6].setDescription("Your psychologist deemed that they couldn't fix you " +
                "and gave you a full refund, press the button to receive 2.");


    }

    public int getRandomCardIndex(){
      int  index = (int) (Math.random() * length) ;
        return index;
    }

    @Override
    public String toString() {
        String string= "";
        for (int i=0; i<card.length; i++){
            string=string+card[i].toString()+"\n";
        }
        return "Chance cards" + string;
    }
}
