package ChanceCardsAndDeck;
// Class is written by Patrick Machalet s203932 and Nataliia Khaiko s224295

import CreateAndWriteToAndFromTXT.ReadFile;

import java.util.ArrayList;

public class CardDeck {
    private ChanceCards[] card;
    private int length=19;


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
     /* type 1 - Transaction
        type 2 - move to
       */
          ReadFile readFile = new ReadFile();
          ArrayList<String> stringArrayList = readFile.ReadFile("chancecards.txt");
          this.card=new ChanceCards[length];

        /*
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
        */

        // Postive transactions from the Bank to the player
        card[0] = new ChanceCardsAndDeck.ChanceCards();
        card[0].setType(1); // Receive 200 kr
        card[0].setTransaction(+200);
        card[0].setDescription(stringArrayList.get(0));

        card[1] = new ChanceCardsAndDeck.ChanceCards();
        card[1].setType(1); // Receive 500 kr
        card[1].setTransaction(+500);
        card[1].setDescription(stringArrayList.get(1));

        card[2] = new ChanceCardsAndDeck.ChanceCards();
        card[2].setType(1); // Receive 500 kr
        card[2].setTransaction(+500);
        card[2].setDescription(stringArrayList.get(2));

        card[3] = new ChanceCardsAndDeck.ChanceCards();
        card[3].setType(1); // Receive 1000 kr
        card[3].setTransaction(+1000);
        card[3].setDescription(stringArrayList.get(3));

        card[4] = new ChanceCardsAndDeck.ChanceCards();
        card[4].setType(1); // Receive 1000 kr
        card[4].setTransaction(+1000);
        card[4].setDescription(stringArrayList.get(4));

        card[5] = new ChanceCardsAndDeck.ChanceCards();
        card[5].setType(1); // Receive 1000 kr
        card[5].setTransaction(+1000);
        card[5].setDescription(stringArrayList.get(5));

        card[6] = new ChanceCardsAndDeck.ChanceCards();
        card[6].setType(1); // Receive 1000 kr
        card[6].setTransaction(+1000);
        card[6].setDescription(stringArrayList.get(6));

        card[7] = new ChanceCardsAndDeck.ChanceCards();
        card[7].setType(1); // Receive 1000 kr
        card[7].setTransaction(+1000);
        card[7].setDescription(stringArrayList.get(7));

        card[8] = new ChanceCardsAndDeck.ChanceCards();
        card[8].setType(1); // Receive 1000 kr
        card[8].setTransaction(+1000);
        card[8].setDescription(stringArrayList.get(8));

        card[9] = new ChanceCardsAndDeck.ChanceCards();
        card[9].setType(1); // Receive 1000 kr
        card[9].setTransaction(+1000);
        card[9].setDescription(stringArrayList.get(9));

        card[10] = new ChanceCardsAndDeck.ChanceCards();
        card[10].setType(1); // Receive 1000 kr
        card[10].setTransaction(+1000);
        card[10].setDescription(stringArrayList.get(10));

        card[11] = new ChanceCardsAndDeck.ChanceCards();
        card[11].setType(1); // Receive 3000 kr
        card[11].setTransaction(+3000);
        card[11].setDescription(stringArrayList.get(11));


        // Negative transactions from the Bank to the player
        card[12] = new ChanceCardsAndDeck.ChanceCards();
        card[12].setType(1); // Pay 200 kr
        card[12].setTransaction(-200);
        card[12].setDescription(stringArrayList.get(12));

        card[13] = new ChanceCardsAndDeck.ChanceCards();
        card[13].setType(1); // Pay 200 kr
        card[13].setTransaction(-200);
        card[13].setDescription(stringArrayList.get(13));

        card[14] = new ChanceCardsAndDeck.ChanceCards();
        card[14].setType(1); // Pay 200 kr
        card[14].setTransaction(-200);
        card[14].setDescription(stringArrayList.get(14));

        card[15] = new ChanceCardsAndDeck.ChanceCards();
        card[15].setType(1); // Pay 300 kr
        card[15].setTransaction(-300);
        card[15].setDescription(stringArrayList.get(15));

        card[16] = new ChanceCardsAndDeck.ChanceCards();
        card[16].setType(1); // Pay 1000 kr
        card[16].setTransaction(-1000);
        card[16].setDescription(stringArrayList.get(16));

        card[17] = new ChanceCardsAndDeck.ChanceCards();
        card[17].setType(1); // Pay 1000 kr
        card[17].setTransaction(-1000);
        card[17].setDescription(stringArrayList.get(17));

        card[18] = new ChanceCardsAndDeck.ChanceCards();
        card[18].setType(1); // Pay 1000 kr
        card[18].setTransaction(-1000);
        card[18].setDescription(stringArrayList.get(18));


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
