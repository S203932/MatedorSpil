package Game;
// Class is written by Patrick Machalet s203932

import Fields.FieldList;
import Fields.Property;
import GUIController.GUIController;
import SupportClasses.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Game {
    public static void main(String[] args){


        GUIController guiController= new GUIController();

        String language="Dansk.txt";

        System.out.println(language);

        FieldList fieldList = new FieldList();
        fieldList.setupField(language);

        guiController.GUIController(language, fieldList);
        int amountPlayers = guiController.getGui().getUserInteger("Indsat antal spiller", 3, 6);
        Player[] players = new Player[amountPlayers];
        GUI_Player[] gui_players = guiController.setupPlayers(players);

        int end = 0;
        while (end!=1){
            for(int j = 0; j<players.length;j++){
                gui_players[j].setBalance(players[j].getAccount().getAmount());
            }
            for(int i = 0;i<players.length;i++){
                if(players[i].getForfeit()==0){
                    guiController.takeTurn(players[i],guiController.getGui(),gui_players[i],fieldList, guiController.getGUI_Fields(), players);
                    System.out.println(players[i].toString());

                    for(int j = 0; j<players.length;j++){
                        gui_players[j].setBalance(players[j].getAccount().getAmount());
                    }
                }


                if(players[i].getAccount().getAmount() <= 0){
                    end = 1;
                    break;
                }
            }

        }
        guiController.getGui().showMessage("Game is over.");

    }
    //The method below is the menu for the player after they've rolled the dice
    //It is supposed to offer the player option to do, mortgage, buy house/hotel and end turn
    // Mortgage, buy house/hotel and endturn should each have their own method
    public void endMenu(Player player, GUI gui, GUI_Player gui_player, FieldList fieldList, GUI_Field[] fields, Player[] players){
        // Checks if the player has properties and they are not all mortgaged
        if(player.getProperty()[0] != null || player.mortgageCheck()){
            // Checks if the player has three properties of the same color otherwise they should not
            // be allowed to buy houses/hotels
            if(player.eligbleForHouse()){
                //An array with RealEstate eligble for upgrade
                Property[] UpgradeableRealEstate = player.eligbleRealEstate();

            }
        }

    }
}
