package ChanceCardsAndDeck;
import Fields.Ferry;
import Fields.FieldList;
import Fields.Property;
import SupportClasses.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import org.jetbrains.annotations.Nullable;
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

   /* @Test
    void cardActionType3(){
        int type = 3;
        // ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        //FieldList fieldList = new FieldList();
        //GUI gui = new GUI();
        //GUI_Field[] fields = new GUI_Field[40];
        //GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getPosition());
        Player[] Participants = new Player[1];
        // chanceCards.cardAction(player, gui, fieldList, fields, gui_player, Participants);
       ChanceCards chanceCards = new ChanceCards();
       Player player = new Player();
       FieldList fieldList = new FieldList();
       GUI gui = new GUI();
       GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
       Player[] Participants = new Player[3];


       CardDeck cardDeck = new CardDeck();
       cardDeck.setCards();
       ChanceCards card = cardDeck.getCard(22);

        //player.getAccount().additionAccount(200);
        Participants.length(3);
        player.getAccount().additionAccount(Participants.length*200);
        assertEquals(200, player.getPosition());
    }

        player.getAccount().setAccount(200);
        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(200, player.getAccount().getAmount());
    }
*/
    // Testing if moving position works
   /* @Test
    public void testCardActionType4() {
        int type = 4;
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        FieldList fieldList = new FieldList();
        GUI gui = new GUI();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[1];

        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(28);
        player.setPosition(3);
        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(0, player.getPosition());
    }
    */

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

   /* @Test
    void cardActionType6(){
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        GUI gui = new GUI();
        FieldList fieldList = new FieldList();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[3];

        CardDeck cardDeck = new CardDeck();
        cardDeck.setCards();
        ChanceCards card = cardDeck.getCard(42);

        player.setPosition(17);
        player.getAccount().setAccount(50000);

        card.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);
        assertEquals(25, player.getPosition());
        assertEquals(14000, player.getAccount().getAmount());
    }
*/

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


    //@Test
   /* void cardActionType8(){
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

    }*/
    //@Test
   /* void cardActionType9(){
        int type = 9;
    }*/
}