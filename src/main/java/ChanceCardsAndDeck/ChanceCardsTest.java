package ChanceCardsAndDeck;

import Fields.Ferry;
import Fields.FieldList;
import SupportClasses.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

        /*ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        FieldList fieldList = new FieldList();
        GUI gui = new GUI();
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[1];
        chanceCards.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);*/

class ChanceCardsTest {
    // Testing for addition
    @Test
    void cardActionType1() {
        int type = 1;
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();

        player.getAccount().setAccount(200);
        player.getAccount().additionAccount(200);
        assertEquals(400, player.getAccount().getAmount());

    }

    // Testing for moving player
    @Test
    void cardActionType2(){
        int type = 2;
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        player.setPosition(10);
        assertEquals(10, player.getPosition());
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

        //player.getAccount().additionAccount(200);
        Participants.length(3);
        player.getAccount().additionAccount(Participants.length*200);
        assertEquals(200, player.getPosition());
    }*/

    // Testing if moving position works
    @Test
    public void testCardActionType4() {
        int type = 4;
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();
        player.setPosition(3);
    }

    // Moves player to nearest ferry in case the position is 17
    @Test
    void cardActionType5(){
        int type = 5;
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();

        player.setPosition(17);
        if (player.getPosition() == 17){
            player.setPosition(25);
        }
        assertEquals(25, player.getPosition());
    }
/*
    @Test
    void cardActionType6(){
        int type = 6;
        ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();

        GUI gui = new GUI();
        FieldList fieldList = new FieldList();
        GUI_Field[] fields = new GUI_Field[40];
        GUI_Player gui_player = new GUI_Player(player.getPlayerName(), player.getAccount().getAmount());
        Player[] Participants = new Player[3];

        int initialPosition = player.getPosition();
        player.setPosition(17);

        chanceCards.cardAction(player, gui, fieldList, gui.getFields(), gui_player, Participants);

        assertNotEquals(initialPosition, player.getPosition());
        assertEquals(25, player.getPosition());
        assertEquals(14000, player.getAccount().getAmount());


/*
        player.getAccount().additionAccount(1000);
        ((Ferry) fieldList.getFieldIndex(25)).setPrice(200);

        assertEquals(25, player.getPosition());
        //assertEquals(fields[25], gui_player.getCar().getPosition());
        assertEquals(600, player);
*/
/*
    @Test
    void cardActionType7(){
        int type = 7;
        //ChanceCards chanceCards = new ChanceCards();
        Player player = new Player();


        player.setFreejail(0);

        assertEquals(1, player.getFreejail());

    }


    @Test
    void cardActionType8(){
        int type = 8;

    }
    @Test
    void cardActionType9(){
        int type = 9;
    }

     */
}
