package ChanceCardsAndDeck;
import Fields.Ferry;
import Fields.FieldList;
import Fields.RealEstate;
import SupportClasses.Player;
import gui_fields.GUI_Player;
import gui_main.GUI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ChanceCardsTest {
    // Testing for addition
    @Test
        void cardActionType1() {
            ChanceCards chanceCards = new ChanceCards();
            Player player = new Player();
            FieldList fieldList = new FieldList();
            GUI gui = new GUI();
            GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
            Player[] Participants = new Player[1];

            CardDeck cardDeck = new CardDeck();
            cardDeck.setCards();
            ChanceCards card = cardDeck.getCard(0);

            player.getAccount().setAccount(200);
            card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
            assertEquals(400, player.getAccount().getAmount());

        }

        // Testing for moving player
        @Test
        void cardActionType2(){
            ChanceCards chanceCards = new ChanceCards();
            Player player = new Player();
            FieldList fieldList = new FieldList();
            GUI gui = new GUI();
            GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
            Player[] Participants = new Player[1];

            CardDeck cardDeck = new CardDeck();
            cardDeck.setCards();
            ChanceCards card = cardDeck.getCard(28);

            player.setPosition(10);
            card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
            assertEquals(0, player.getPosition());
        }

   @Test
    void cardActionType3(){
        int type = 3;
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        FieldList fieldList = new FieldList();
        GUI gui = new GUI();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[2];
        chanceCards.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);

        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(22);

        //player.getAccount().additionAccount(Participants.length*200);
        player.getAccount().setAccount(200);
        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(600, player.getAccount().getAmount());
    }
    // Testing if moving position works
   @Test
    public void testCardActionType4() {
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        FieldList fieldList = new FieldList();
        GUI gui = new GUI();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getPosition());
        Player[] Participants = new Player[1];
        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(37);

        player.setPosition(5);
        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(8, player.getPosition());
    }


    // Moves player to nearest ferry in case the position is 17
    @Test
    void cardActionType5(){
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        FieldList fieldList = new FieldList();
        GUI gui = new GUI();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[1];

        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(36);

        player.setPosition(17);
        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(25, player.getPosition());
    }
    @Test
    void cardActionType6(){
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        Player player1 = new Player();
        GUI gui = new GUI();
        FieldList fieldList = new FieldList();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[2];
        player.setPlayerName("Peter");
        player1.setPlayerName("Thomas");

        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(42);


        player1.setPosition(2);

        fieldList.setupField("Dansk.txt");
        ((Ferry) fieldList.getFieldIndex(5)).setPlayer(player);
        ((Ferry) fieldList.getFieldIndex(5)).setAvailability(false);

        ((Ferry) fieldList.getFieldIndex(15)).setPlayer(player);
        ((Ferry) fieldList.getFieldIndex(15)).setAvailability(false);


        player.getAccount().setAccount(0);
        player1.getAccount().setAccount(2000);


        card.cardAction(player1, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(5, player1.getPosition());
        assertEquals(2000, player.getAccount().getAmount());
        assertEquals(0, player1.getAccount().getAmount());
    }

    @Test
    void cardActionType7(){
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        FieldList fieldList = new FieldList();
        GUI gui = new GUI();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getFreejail());
        Player[] Participants = new Player[1];

        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(44);

        player.setFreejail(0);
        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(1, player.getFreejail());
    }

    // Gets 500 for each house and 2000 for each hotel
    @Test
    void cardActionType8() {
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        FieldList fieldList = new FieldList();
        GUI gui = new GUI();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[1];

        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(25);

        fieldList.setupField("Dansk.txt");
        ((RealEstate) fieldList.getFieldIndex(1)).setPlayer(player);
        ((RealEstate) fieldList.getFieldIndex(1)).setAvailability(false);
        ((RealEstate) fieldList.getFieldIndex(1)).setUpgrade(1);
        player.setProperty((RealEstate) fieldList.getFieldIndex(1));

        ((RealEstate) fieldList.getFieldIndex(3)).setPlayer(player);
        ((RealEstate) fieldList.getFieldIndex(3)).setAvailability(false);
        ((RealEstate) fieldList.getFieldIndex(3)).setUpgrade(5);
        player.setProperty((RealEstate) fieldList.getFieldIndex(3));

        player.getAccount().setAccount(2500);
        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(0, player.getAccount().getAmount());
    }

    // Receive 40K if player has less than 15K
    @Test
   void cardActionType9(){
       ChanceCards chanceCards = new ChanceCards();
       Player player = new Player();
       FieldList fieldList = new FieldList();
       GUI gui = new GUI();
       GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getFreejail());
       Player[] Participants = new Player[1];

       CardDeck cardDeck = new CardDeck();
       cardDeck.setCards();
       ChanceCards card = cardDeck.getCard(27);

       player.getAccount().setAccount(1000);
       card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
       assertEquals(41000, player.getAccount().getAmount());

    }
}