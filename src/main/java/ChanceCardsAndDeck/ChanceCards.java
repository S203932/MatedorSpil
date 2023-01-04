package ChanceCardsAndDeck;
// Class is written by Patrick Machalet s203932 and Nataliia Khaiko s224295
import Fields.Field;
import Fields.Property;
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

    private Color color;

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

    public void cardAction(Player player, GUI gui, Field[] fieldList, GUI_Field[] fields, GUI_Player gui_player){
        switch (type){
            case 2:
                gui.showMessage(description);
                player.setPosition(moveTo);
                gui_player.getCar().setPosition(fields[moveTo]);
                break;

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

            case 3:
                gui.showMessage(description);
                player.getAccount().additionKonto(transaction);
                break;

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
            default: break;
        }
    }

    public String toString(){
        return "This card has the following type: "+this.type+"\nThe following description: "+this.description+
                "\nThe following MoveTo: "+this.moveTo+"\nThe following MoveUpTo: "+this.moveUpTo+"\n And the " +
                "the following transaction: "+this.transaction;
    }




}
