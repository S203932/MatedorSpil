package ChanceCardsAndDeck;
// Class is written by Patrick Machalet s203932 and Nataliia Khaiko s224295

import CreateAndWriteToAndFromTXT.ReadFile;

import java.util.ArrayList;

public class CardDeck {
    private ChanceCards[] card;
    private int length=46;


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

        // Positive transactions from the Bank to the player
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

        card[19] = new ChanceCardsAndDeck.ChanceCards();
        card[19].setType(1); // Pay 2000 kr
        card[19].setTransaction(-2000);
        card[19].setDescription(stringArrayList.get(19));

        card[20] = new ChanceCardsAndDeck.ChanceCards();
        card[20].setType(1); // Pay 3000 kr
        card[20].setTransaction(-3000);
        card[20].setDescription(stringArrayList.get(20));

        card[21] = new ChanceCardsAndDeck.ChanceCards();
        card[21].setType(1); // Pay 3000 kr
        card[21].setTransaction(-3000);
        card[21].setDescription(stringArrayList.get(21));


        // Special transaction cases
        card[22] = new ChanceCardsAndDeck.ChanceCards();
        card[22].setType(3); // Receive 200 kr from each player
        card[22].setTransaction(+200);
        card[22].setDescription(stringArrayList.get(22));

        card[23] = new ChanceCardsAndDeck.ChanceCards();
        card[23].setType(3); // Receive 500 kr from each player
        card[23].setTransaction(+500);
        card[23].setDescription(stringArrayList.get(23));

        card[24] = new ChanceCardsAndDeck.ChanceCards();
        card[24].setType(3); // Receive 500 kr from each player
        card[24].setTransaction(+500);
        card[24].setDescription(stringArrayList.get(24));

        card[25] = new ChanceCardsAndDeck.ChanceCards();
        card[25].setType(8); // Pay 500 kr for each house and 2000 kr for each hotel
        card[25].setHouserate(500);
        card[25].setHotelrate(2000);
        card[25].setDescription(stringArrayList.get(25));

        card[26] = new ChanceCardsAndDeck.ChanceCards();
        card[26].setType(8); // Pay 800 kr for each house and 2300 kr for each hotel
        card[26].setHouserate(800);
        card[26].setHotelrate(2300);
        card[26].setDescription(stringArrayList.get(26));

        card[27] = new ChanceCardsAndDeck.ChanceCards();
        card[27].setType(1); // Receive 40000 kr if owning less than 15000
        card[27].setTransaction(+40000);
        card[27].setDescription(stringArrayList.get(27));


        // Move to locations
        card[28] = new ChanceCards();
        card[28].setType(2); // move to start
        card[28].setMoveTo(0);
        card[28].setDescription(stringArrayList.get(28));

        card[29] = new ChanceCards();
        card[29].setType(2); // move to start
        card[29].setMoveTo(0);
        card[29].setDescription(stringArrayList.get(29));

        card[30] = new ChanceCards();
        card[30].setType(2); // move to Rådhuspladsen
        card[30].setMoveTo(39);
        card[30].setDescription(stringArrayList.get(30));

        card[31] = new ChanceCards();
        card[31].setType(2); // move to Vimmelskaftet
        card[31].setMoveTo(32);
        card[31].setDescription(stringArrayList.get(31));

        card[32] = new ChanceCards();
        card[32].setType(2); // move to Grønningen
        card[32].setMoveTo(24);
        card[32].setDescription(stringArrayList.get(32));

        card[33] = new ChanceCards();
        card[33].setType(2); // move to Frederiksberg Allé
        card[33].setMoveTo(11);
        card[33].setDescription(stringArrayList.get(33));

        card[34] = new ChanceCards();
        card[34].setType(2); // move to Strandvejen
        card[34].setMoveTo(19);
        card[34].setDescription(stringArrayList.get(34));

        card[35] = new ChanceCards();
        card[35].setType(2); // move to Mols-ferry
        card[35].setMoveTo(15);
        card[35].setDescription(stringArrayList.get(35));

        card[36] = new ChanceCards();
        card[36].setType(5); // move to nearest ferry
        card[36].setMoveTo(15);
        card[36].setDescription(stringArrayList.get(36));


        // Move Special cases
        card[37] = new ChanceCards();
        card[37].setType(2); // move +3
        card[37].setOffset(+3);
        card[37].setDescription(stringArrayList.get(37));

        card[38] = new ChanceCards();
        card[38].setType(2); // move -3
        card[38].setOffset(-3);
        card[38].setDescription(stringArrayList.get(38));

        card[39] = new ChanceCards();
        card[39].setType(2); // move -3
        card[39].setOffset(-3);
        card[39].setDescription(stringArrayList.get(39));

        card[40] = new ChanceCards();
        card[40].setType(2); // move to jail
        card[40].setMoveTo(30);
        card[40].setDescription(stringArrayList.get(40));

        card[41] = new ChanceCards();
        card[41].setType(2); // move to jail
        card[41].setMoveTo(30);
        card[41].setDescription(stringArrayList.get(41));

        card[42] = new ChanceCards();
        card[42].setType(6); // move to nearest Ferry
        card[42].setDescription(stringArrayList.get(42));

        card[43] = new ChanceCards();
        card[43].setType(6); // move to nearest Ferry
        card[43].setDescription(stringArrayList.get(43));


        // Get out of jail free
        card[44] = new ChanceCards();
        card[44].setType(7); // Get out of jail free
        card[44].setDescription(stringArrayList.get(44));

        card[45] = new ChanceCards();
        card[45].setType(7); // Get out of jail free
        card[45].setDescription(stringArrayList.get(45));



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
