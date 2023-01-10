package Game;
// Class is written by Patrick Machalet s203932

import Fields.FieldList;
import GUIController.GUIController;
import SupportClasses.Player;
import gui_fields.GUI_Player;

public class Game {
    public static void main(String[] args){


        GUIController guiController= new GUIController();

        String language="Dansk.txt";

        System.out.println(language);
        guiController.GUIController(language);
        int amountPlayers = guiController.getGui().getUserInteger("Indsat antal spiller", 3, 6);
        Player[] players = new Player[amountPlayers];
        GUI_Player[] gui_players = guiController.setupPlayers(players);
        FieldList fieldList = new FieldList();
        fieldList.setupField(language);
        int end = 0;
        while (end!=1){
            for(int j = 0; j<players.length;j++){
                gui_players[j].setBalance(players[j].getAccount().getAmount());
            }
            for(int i = 0;i<players.length;i++){
                if(players[i].getForfeit()==0){
                    guiController.takeTurn(players[i],guiController.getGui(),gui_players[i],fieldList, guiController.getGUI_Fields(), players);
                    System.out.println(players[i].toString());
                    System.out.println();
                    System.out.println(players[i].getNamesOfProperties());

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



        //for(int i=0;gui_players.length>i;i++){
        //    gui_players[i].setBalance(players[i].getAccount().getPengebeholdning());
        //}








    }
}
