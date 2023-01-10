package SupportClasses;
// Class is written by Patrick Machalet s203932
import Fields.Property;

public class Player {
    private String name;
    private Account account;

    private Property[] property;

    private int position;
    private int jail;

    private int Freejail;

    private int forfeit;

    public Player() {
        setPlayerName("Player one");
        startAccount();
        setPosition(-1);
        instantiateProperty();
        setJail(0);
        setFreejail(0);
        setForfeit(0);

    }

    public void setForfeit(int forfeit){
        this.forfeit = forfeit;
    }
    public int getForfeit(){
        return forfeit;
    }

    public void setJail(int jail){
        this.jail = jail;
    }

    public int getFreejail() {
        return Freejail;
    }

    public void setFreejail(int freejail) {
        this.Freejail = freejail;
    }

    public int getJail(){
        return jail;
    }

    public int getPosition() {
        return position;
    }

    public void diceRollPosition(int diceRoll){
        int oldPosition = this.position;
        int newPosition = oldPosition+diceRoll;
        if((newPosition)>=40){
            this.position = newPosition-40;
            this.account.additionAccount(4000);
        } else if (newPosition == 0 && oldPosition != -1) {
            this.account.additionAccount(4000);
        } else{
            this.position = newPosition;
        }
    }

    public void setPosition(int position) {
        int oldPosition = this.position;
        this.position = position;
        if(position<oldPosition){
            this.account.additionAccount(4000);
        }
    }

    public void setPlayerName(String navn) {
        this.name = navn;
    }

    public void startAccount() {
        this.account = new Account();
    }


    public Account getAccount() {
        return account;
    }

    public String getPlayerName() {
        return name;
    }

    public Property[] getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        int indexValue = 0;
        while (this.property[indexValue]!= null){
            indexValue++;
        }
        this.property[indexValue] = property;
    }

    public void instantiateProperty(){
        this.property = new Property[40];

    }

    public String getNamesOfProperties(){
        String string = "";
        int counter = 0;
        if(property[0] == null){
            string = string + name + " has no properties";
        }else{
            while(property[counter] != null){
                int i=1;
                string = string + property[counter].getName() + " - position " + property[counter].getPosition() + " på brættet" +"\n";
                counter++;
            }
        }
        return string;
    }

    public String getPropertyName(int i){
        String PropertyName=property[i].getName();
        return PropertyName;
    }

    public String toString(){
        int counter = 0;
        String string = "Player's name: " + name + "\n";
        string = string + name + "'s position: " + position + "\n";
        string = string + name + "'s balance: " + account.getAmount() + "\n";
        string = string + name + "'s jail value: " + jail + "\n";
        string = string + name + "'s forfeit value: " + forfeit + "\n";
        if(property[0] == null){
            string = string + name + " has no properties";
        }else{
            while(property[counter] != null){
                string = string + name + " has the property \" "+property[counter].getName() + "\"" +
                        " which is at postion: " + property[counter].getPosition() + " on the board \n";
                counter++;
            }
        }
        return string;
    }
}

