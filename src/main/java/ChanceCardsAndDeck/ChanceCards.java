package ChanceCardsAndDeck;
// Class is written by Patrick Machalet s203932 and Nataliia Khaiko s224295
import Fields.*;
import SupportClasses.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import javax.swing.text.Position;
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

    public ChanceCards(){
        initilalizeType();
        initilalizeDescription();
        initilalizeMoveTo();
        initilalizeMoveUpTo();
        initilalizeTransaction();
        setColor(Color.BLACK);
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public void initilalizeType(){
        this.type = -1;
    }

    public void initilalizeDescription(){
        this.description = "An empty description";
    }

    public void initilalizeMoveTo(){
        this.moveTo = -1;
    }

    public void initilalizeMoveUpTo(){
        this.moveUpTo = -1;
    }

    public void initilalizeTransaction(){
        this.transaction = 0;
    }

    public void initializeOffset() {this.Offset = 3;}

    public void setType(int type){
        this.type = type;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setMoveTo(int moveTo){
        this.moveTo = moveTo;
    }

    public void setMoveUpTo(int moveUpTo){
        this.moveUpTo = moveUpTo;
    }

    public void setTransaction(int transaction){
        this.transaction = transaction;
    }

    public void setOffset(int offset) {
        Offset = offset;
    }

    public int getType(){
        return this.type;
    }

    public String getDescription(){
        return this.description;
    }

    public int getMoveTo(){
        return this.moveTo;
    }

    public int getMoveUpTo(){
        return this.moveUpTo;
    }

    public int getTransaction(){
        return this.transaction;
    }

    public int getHouserate() {
        return houserate;
    }

    public void setHouserate(int houserate) {
        this.houserate = houserate;
    }
    public void setHotelrate(int hotelrate) {
        this.hotelrate = hotelrate;
    }

    public int getHotelrate() {
        return hotelrate;
    }


    public void cardAction(Player player, GUI gui, FieldList fieldList, GUI_Field[] fields, GUI_Player gui_player, Player[] Participants){

        switch (type){
            // Add amount to player account.
            case 1:
                gui.displayChanceCard(description);
                player.getAccount().additionAccount(transaction);
                break;

            // Moves the player on the board.
            case 2:
                gui.displayChanceCard(description);
                player.setPosition(moveTo);
                gui_player.getCar().setPosition(fields[moveTo]);
                break;

            // Receive x * money from each player
            case 3:
                gui.displayChanceCard(description);
                player.getAccount().additionAccount(Participants.length*transaction);
                for (int i = 0; i < Participants.length; i++) {
                    Participants[i].getAccount().subtractionAccount(transaction);
                }
                break;

            // Moves the player +- 3 places on the board.
            case 4:
                gui.displayChanceCard(description);
                player.setPosition(player.getPosition()+Offset);
                gui_player.getCar().setPosition(fields[moveTo]);
                break;

            // Moves the player to the nearest ferry
            case 5:
                gui.displayChanceCard(description);
                if (player.getPosition() == 17 || player.getPosition() == 22)
                {
                    player.setPosition(25);
                }
                else if (player.getPosition() == 33)
                {
                    player.setPosition(35);
                }
                else if (player.getPosition() == 36 || player.getPosition() == 2)
                {
                    player.setPosition(5);
                }
                else if (player.getPosition() == 7)
                {
                    player.setPosition(16);
                }
                gui_player.getCar().setPosition(fields[moveTo]);
                break;

            // Moves the player to the nearest ferry and pay double
            case 6:
                gui.displayChanceCard(description);
                if (player.getPosition() == 17 || player.getPosition() == 22)
                {
                    player.setPosition(25);
                }
                else if (player.getPosition() == 33)
                {
                    player.setPosition(35);
                }
                else if (player.getPosition() == 36 || player.getPosition() == 2)
                {
                    player.setPosition(5);
                }
                else if (player.getPosition() == 7)
                {
                    player.setPosition(15);
                }

                if (!((Property) fieldList.getFieldIndex(player.getPosition())).getAvailability()) {
                    ((Ferry) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList);
                    ((Ferry) fieldList.getFieldIndex(player.getPosition())).rent(player, fieldList);
                }
                gui_player.getCar().setPosition(fields[moveTo]);
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
                    if (player.getProperty()[i] != null){
                        if (player.getProperty()[i].getClass().equals(RealEstate.class)){
                        temp = ((RealEstate)player.getProperty()[i]).getUpgrade();
                            if (temp == 5) {
                                hotel++;
                            } else {
                                house += temp;
                            }
                    }
                }
                }
                player.getAccount().subtractionAccount(houserate*house+hotelrate*hotel);

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
                        }
                    }
                }
                playertotal += player.getAccount().getAmount();
                if (playertotal <= 15000) {
                    player.getAccount().additionAccount(40000);
                    gui.showMessage("De modtager Matador legattet grundet de har mindre 15 tusind kr. til deres navn.");
                }
                else {
                    gui.showMessage("De modtager IKKE Matador legattet grundet de har mere end 15 tusind kr. til deres navn.");
                }

            /*
            case 1:
                String chosenButton = gui.getUserButtonPressed(
                        "Choose what field you want to move to:",
                        "Burger Place", "Pizza");
                if(chosenButton.equalsIgnoreCase("Burger Place")){
                    player.setPosition(1);
                    gui_player.getCar().setPosition(fields[1]);
                    Boolean available=((Property)fieldList[1]).getAvailability();
                    if(available){
                        gui.showMessage("The property is not owned, press the button to buy it.");
                        ((Property)fieldList[1]).buyProperty(player);
                    }else{
                        gui.showMessage("The property is owned, press the button to pay rent.");
                        ((Property)fieldList[1]).PayRentProperty(player);
                    }
                }else {
                    player.setPosition(2);
                    gui_player.getCar().setPosition(fields[2]);
                    Boolean available=((Property)fieldList[2]).getAvailability();
                    if(available){
                        gui.showMessage("The property is not owned, press the button to buy it.");
                        ((Property)fieldList[2]).buyProperty(player);
                    }else{
                        gui.showMessage("The property is owned, press the button to pay rent.");
                        ((Property)fieldList[2]).PayRentProperty(player);
                    }
                }
                // position.setPosition(card.getMoveTo());
                break;
            */

            /*
            case 4:
                String chosenButton2 = gui.getUserButtonPressed(
                        "Choose what field you want to move to:",
                        "Slikbutikken", "Iskiosken");
                if(chosenButton2.equalsIgnoreCase("Slikbutikken")){
                    player.setPosition(4);
                    gui_player.getCar().setPosition(fields[4]);
                    Boolean available=((Property)fieldList[4]).getAvailability();
                    if(available){
                        gui.showMessage("The property is not owned, press the button to buy it.");
                        ((Property)fieldList[4]).buyProperty(player);
                    }else{
                        gui.showMessage("The property is owned, press the button to pay rent.");
                        ((Property)fieldList[4]).PayRentProperty(player);
                    }
                }else {
                    player.setPosition(5);
                    gui_player.getCar().setPosition(fields[5]);
                    Boolean available=((Property)fieldList[5]).getAvailability();
                    if(available){
                        gui.showMessage("The property is not owned, press the button to buy it.");
                        ((Property)fieldList[5]).buyProperty(player);
                    }else{
                        gui.showMessage("The property is owned, press the button to pay rent.");
                        ((Property)fieldList[5]).PayRentProperty(player);
                    }
                }
                break;

             */

            /*
            case 5:
                String chosenButton3 = gui.getUserButtonPressed(
                        "Choose what field you want to move to:",
                        "Spillehallen", "Biografen");
                if(chosenButton3.equalsIgnoreCase("Spillehallen")){
                    player.setPosition(13);
                    gui_player.getCar().setPosition(fields[13]);
                    Boolean available=((Property)fieldList[13]).getAvailability();
                    if(available){
                        gui.showMessage("The property is not owned, press the button to buy it.");
                        ((Property)fieldList[13]).buyProperty(player);
                    }else{
                        gui.showMessage("The property is owned, press the button to pay rent.");
                        ((Property)fieldList[13]).PayRentProperty(player);
                    }
                }else {
                    player.setPosition(14);
                    gui_player.getCar().setPosition(fields[14]);
                    Boolean available=((Property)fieldList[14]).getAvailability();
                    if(available){
                        gui.showMessage("The property is not owned, press the button to buy it.");
                        ((Property)fieldList[14]).buyProperty(player);
                    }else{
                        gui.showMessage("The property is owned, press the button to pay rent.");
                        ((Property)fieldList[14]).PayRentProperty(player);
                    }
                }


                // position.setPosition(card.getMoveTo());
                break;

             */
            default: break;
        }


    }

    public String toString(){
        return "This card has the following type: "+this.type+"\nThe following description: "+this.description+
                "\nThe following MoveTo: "+this.moveTo+"\nThe following MoveUpTo: "+this.moveUpTo+"\n And the " +
                "the following transaction: "+this.transaction;
    }




}
