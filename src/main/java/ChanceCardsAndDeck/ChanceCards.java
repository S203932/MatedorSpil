package ChanceCardsAndDeck;

import Fields.*;
import SupportClasses.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;


public class ChanceCards {
    private int type;
    private String description;
    private int moveTo;
    private int moveUpTo;
    private int transaction;

    private int houserate;

    private int hotelrate;
    private Color color;
    private int Offset;

    public ChanceCards() {
        initilalizeType();
        initilalizeDescription();
        initilalizeMoveTo();
        initilalizeMoveUpTo();
        initilalizeTransaction();
        setColor(Color.BLACK);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void initilalizeType() {
        this.type = -1;
    }

    public void initilalizeDescription() {
        this.description = "An empty description";
    }

    public void initilalizeMoveTo() {
        this.moveTo = -1;
    }

    public void initilalizeMoveUpTo() {
        this.moveUpTo = -1;
    }

    public void initilalizeTransaction() {
        this.transaction = 0;
    }

    public void initializeOffset() {
        this.Offset = 3;
    }

    public void setOffset(int offset) {
        Offset = offset;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMoveTo() {
        return this.moveTo;
    }

    public void setMoveTo(int moveTo) {
        this.moveTo = moveTo;
    }

    public int getMoveUpTo() {
        return this.moveUpTo;
    }

    public void setMoveUpTo(int moveUpTo) {
        this.moveUpTo = moveUpTo;
    }

    public int getTransaction() {
        return this.transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public int getHouserate() {
        return houserate;
    }

    public void setHouserate(int houserate) {
        this.houserate = houserate;
    }

    public int getHotelrate() {
        return hotelrate;
    }

    public void setHotelrate(int hotelrate) {
        this.hotelrate = hotelrate;
    }

    // Switch case for the different chancecards
    public void cardAction(Player player, GUI gui, FieldList fieldList, GUI_Field[] fields, GUI_Player gui_player, Player[] Participants) {

        switch (type) {
            // Add amount to player account.
            case 1:
                gui.displayChanceCard(description);
                player.getAccount().additionAccount(transaction);
                break;

            // Moves the player on the board.
            case 2:
                if (transaction > 0) {
                    if (player.getFreejail() == 1) {
                        gui.showMessage("Gode nyheder. De ejer løsladelseskort");
                        player.setFreejail(0);
                    } else {
                        if (player.getPosition() > 10) {
                            player.getAccount().subtractionAccount(5000);
                        } else {
                            player.getAccount().subtractionAccount(1000);
                        }
                    }
                }
                gui.displayChanceCard(description);
                player.setPosition(moveTo);

                gui_player.getCar().setPosition(fields[moveTo]);
                break;

            // Receive x * money from each player
            case 3:
                gui.displayChanceCard(description);
                player.getAccount().additionAccount(Participants.length * transaction);
                for (int i = 0; i < Participants.length; i++) {
                    if (Participants[i] != null) {
                        Participants[i].getAccount().subtractionAccount(transaction);
                    }
                }
                break;

            // Moves the player +- 3 places on the board.
            case 4:
                gui.displayChanceCard(description);
                player.setPosition(player.getPosition() + Offset);
                gui_player.getCar().setPosition(fields[player.getPosition()]);
                break;

            // Moves the player to the nearest ferry
            case 5:
                gui.displayChanceCard(description);
                if (player.getPosition() == 17 || player.getPosition() == 22) {
                    player.setPosition(25);
                } else if (player.getPosition() == 33) {
                    player.setPosition(35);
                } else if (player.getPosition() == 36 || player.getPosition() == 2) {
                    player.setPosition(5);
                } else if (player.getPosition() == 7) {
                    player.setPosition(16);
                }
                gui_player.getCar().setPosition(fields[moveTo]);
                break;

            // Moves the player to the nearest ferry and pay double
            case 6:
                gui.displayChanceCard(description);
                if (player.getPosition() == 17 || player.getPosition() == 22) {
                    player.setPosition(25);
                } else if (player.getPosition() == 33) {
                    player.setPosition(35);
                } else if (player.getPosition() == 36 || player.getPosition() == 2) {
                    player.setPosition(5);
                } else if (player.getPosition() == 7) {
                    player.setPosition(15);
                }


                if (!(((Ferry) fieldList.getFieldIndex(player.getPosition())).getAvailability())) {
                    ((Ferry) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList);
                    ((Ferry) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList);

                }
                gui_player.getCar().setPosition(fields[player.getPosition()]);
                break;

            // Get out of jail free.
            case 7:
                gui.displayChanceCard(description);
                player.setFreejail(1);

                // Pay X amount per house and hotel the player owns
            case 8:
                gui.displayChanceCard(description);
                int house = 0;
                int hotel = 0;
                int temp = 0;
                for (int i = 0; i < player.getProperty().length; i++) {
                    if (player.getProperty()[i] != null) {
                        if (player.getProperty()[i].getClass().equals(RealEstate.class)) {
                            temp = ((RealEstate) player.getProperty()[i]).getUpgrade();
                            if (temp == 5) {
                                hotel++;
                            } else {
                                house += temp;
                            }
                        }
                    }
                }
                player.getAccount().subtractionAccount(houserate * house + hotelrate * hotel);
                break;
            // Check if the player owns less than 15 K
            case 9:
                gui.displayChanceCard(description);

                int playertotal = 0;
                int tomp = 0;
                for (int i = 0; i < player.getProperty().length; i++) {
                    if (player.getProperty()[i] != null) {
                        if (player.getProperty()[i].getClass().equals(RealEstate.class)) {
                            tomp = ((RealEstate) player.getProperty()[i]).getUpgrade();
                            playertotal += tomp * ((RealEstate) player.getProperty()[i]).getUpgradeValue();
                            playertotal += player.getProperty()[i].getPrice();
                        } else {
                            playertotal += player.getProperty()[i].getPrice();
                        }
                    }
                }
                playertotal += player.getAccount().getAmount();
                if (playertotal <= 15000) {
                    player.getAccount().additionAccount(40000);
                    gui.showMessage("De modtager Matador legattet grundet de har mindre end 15 tusind kr. til deres navn.");
                } else {
                    gui.showMessage("De modtager IKKE Matador legattet grundet de har mere end 15 tusind kr. til deres navn.");
                }
            default:
                break;
        }
    }

    public String toString() {
        return "This card has the following type: " + this.type + "\nThe following description: " + this.description + "\nThe following MoveTo: " + this.moveTo + "\nThe following MoveUpTo: " + this.moveUpTo + "\n And the " + "the following transaction: " + this.transaction;
    }
}
