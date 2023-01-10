package Fields;

import SupportClasses.DiceCup;
import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreweryTest {

    @Test
    void buyProperty() {
        Brewery brewery = new Brewery();
        brewery.setPrice(3000);
        Player player = new Player();
        player.getAccount().setAccount(10000);
        brewery.buyProperty(player);
        assertEquals(7000, player.getAccount().getAmount());
    }

    @Test
    void rent() {
        Brewery brewery = new Brewery();
        Player player = new Player();
        Player player1 = new Player();
        DiceCup diceCup = new DiceCup(2);
        FieldList fieldList = new FieldList();
        player.getAccount().setAccount(10000);
        player1.getAccount().setAccount(10000);
        fieldList.setupField("Dansk.txt");
        player.setPlayerName("Peter");
        player1.setPlayerName("Thomas");
        ((Brewery)fieldList.getFieldIndex(12)).setAvailability(false);
        ((Brewery)fieldList.getFieldIndex(28)).setAvailability(false);
        ((Brewery)fieldList.getFieldIndex(12)).setPlayer(player1);
        ((Brewery)fieldList.getFieldIndex(28)).setPlayer(player1);
        diceCup.setDice(0, 1);
        diceCup.setDice(1,5);
        brewery.rent(player, fieldList, diceCup);
        assertEquals(8800, player.getAccount().getAmount());
        assertEquals(11200, player1.getAccount().getAmount());

    }
}