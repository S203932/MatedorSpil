package Fields;

import SupportClasses.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FerryTest extends Property {

    @Test
    void rent() {
        Player player = new Player();
        Player player2 = new Player();
        FieldList fieldList = new FieldList();
        player.setPlayerName("Thomas");
        player2.setPlayerName("Peter");
        fieldList.setupField("Dansk.txt");
        ((Ferry) fieldList.getFieldIndex(5)).setPlayer(player);
        ((Ferry) fieldList.getFieldIndex(5)).setAvailability(false);
        player.getAccount().setAccount(10000);
        player2.getAccount().setAccount(10000);
        ((Ferry) fieldList.getFieldIndex(5)).rent(player2, fieldList);
        assertEquals(10500, player.getAccount().getAmount());
        assertEquals(9500, player2.getAccount().getAmount());

        ((Ferry) fieldList.getFieldIndex(15)).setPlayer(player);
        ((Ferry) fieldList.getFieldIndex(15)).setAvailability(false);
        ((Ferry) fieldList.getFieldIndex(15)).rent(player2, fieldList);
        assertEquals(11500, player.getAccount().getAmount());
        assertEquals(8500, player2.getAccount().getAmount());

        ((Ferry) fieldList.getFieldIndex(25)).setPlayer(player);
        ((Ferry) fieldList.getFieldIndex(25)).setAvailability(false);
        ((Ferry) fieldList.getFieldIndex(25)).rent(player2, fieldList);
        assertEquals(13500, player.getAccount().getAmount());
        assertEquals(6500, player2.getAccount().getAmount());

        ((Ferry) fieldList.getFieldIndex(35)).setPlayer(player);
        ((Ferry) fieldList.getFieldIndex(35)).setAvailability(false);
        ((Ferry) fieldList.getFieldIndex(35)).rent(player2, fieldList);
        assertEquals(17500, player.getAccount().getAmount());
        assertEquals(2500, player2.getAccount().getAmount());
    }
}