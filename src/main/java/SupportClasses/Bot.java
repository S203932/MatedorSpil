package SupportClasses;


import java.lang.*;
import ChanceCardsAndDeck.CardDeck;
import ChanceCardsAndDeck.ChanceCards;
import Fields.*;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;


public class Bot extends Player {
    private DiceCup dice = new DiceCup(2);
    public Bot() {
        setPlayerName("Player two");
        startAccount();
        setPosition(0);
        instantiateProperty();
        setJail(0);
        setFreejail(0);
        setForfeit(0);
    }
    public void BotTakeTurn(Player player, GUI gui, GUI_Player gui_player, FieldList fieldList, GUI_Field[] fields, Player[] players) throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("Dice has been rolled");
        dice.rollDice();
        gui.setDice(dice.getIndexDie(0), dice.getIndexDie(1));
        player.diceRollPosition(dice.result());
        GUI_Field field = gui.getFields()[player.getPosition()];
        gui_player.getCar().setPosition(field);
        Thread.sleep(2000);
        int position = player.getPosition();
        // Check availability and buying free Property such as RealEstate, Ferry and Brewery
        if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(RealEstate.class) ||
                fieldList.getFieldIndex(player.getPosition()).getClass().equals(Ferry.class) ||
                fieldList.getFieldIndex(player.getPosition()).getClass().equals(Brewery.class)) {
            System.out.println("Field is a property");

            if (((Property) fieldList.getFieldIndex(player.getPosition())).getAvailability()) {
                System.out.println("property is not owned");

                ((Property) fieldList.getFieldIndex(player.getPosition())).buyProperty(player);
                player.setProperty(((Property) fieldList.getFieldIndex(player.getPosition())));
                fields[player.getPosition()].setSubText(player.getPlayerName());
                gui_player.setBalance(player.getAccount().getAmount());

            } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(RealEstate.class) &&
                    !((Property) fieldList.getFieldIndex(position)).getMortgage()) {           //Checking if property is pawned
                System.out.println("RealEstate is owned");
                ((RealEstate) fieldList.getFieldIndex(player.getPosition())).rent(player);

                // Pay rent for owned Ferry
            } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Ferry.class) &&
                    !((Property) fieldList.getFieldIndex(position)).getMortgage()) {           //Checking if property is pawned
                System.out.println("Ferry is owned");
                ((Ferry) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList);

                // Pay rent for owned Brewery
            } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Brewery.class) &&
                    !((Property) fieldList.getFieldIndex(position)).getMortgage()) {        //Checking if property is pawned
                System.out.println("Brewery is owned");
                ((Brewery) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList, dice);
            }
        } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Chance.class)) {
            Thread.sleep(2000);
            System.out.println("Field is a chance field");
            Chance chance = new Chance();
            CardDeck cardDeck = chance.getCardDeck();
            int randomNumber = (int) (Math.random() * 45) + 0;
            cardDeck.setCards();
            ChanceCards chanceCard = cardDeck.getCard(randomNumber);
            System.out.println(chanceCard.getDescription());
            chanceCard.cardAction(player, gui, fieldList, fields, gui_player, players);

        } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Neutral.class)) {
            System.out.println("Field is of type Neutral");

        } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Tax5.class) ||
                fieldList.getFieldIndex(player.getPosition()).getClass().equals(Tax39.class)) {
            System.out.println("Field is of type Tax");

            if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(Tax5.class)) {
                System.out.println("Field is of type TAX5");
                int taxchoice = (((int) Math.round(Math.random()* 10) + 1));
                if (taxchoice > 5) {
                    ((Tax5) fieldList.getFieldIndex(player.getPosition())).rent(player, 1);
                } else {
                    ((Tax5) fieldList.getFieldIndex(player.getPosition())).rent(player, 2);
                }
            } else {
                System.out.println("Field is of type TAX39");
                ((Tax39) fieldList.getFieldIndex(player.getPosition())).rent(player);
            }

        } else if (fieldList.getFieldIndex(player.getPosition()).getClass().equals(GoJail.class)) {
            System.out.println("Field is of type GoJail");
            GoJail goJail = new GoJail();
            goJail.GoToJail(player);
            if (player.getJail() == 1) {
                player.getAccount().additionAccount(-1);
            }
            player.setPosition(10);
            gui_player.getCar().setPosition(fields[10]);
        } else {
            player.setForfeit(1);

        }
    }
    }

