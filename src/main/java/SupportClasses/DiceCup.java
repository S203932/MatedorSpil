package SupportClasses;
// Class is written by Kristian Urban 163301
public class DiceCup {
    private Die[] dice;

    public DiceCup(int numberOfDie) {
        dice = new Die[numberOfDie];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }
    public void rollDice() {
        for (Die d : dice) {
            d.roll();
        }
    }
    // Shoving a rolled die in GUI
  /* public void showDice(GUI gui){
        int faceValue = getIndexDie(0);
        int x=7;
        int y=7;
        int rotation=5;
        gui.setDice(faceValue,x,y,rotation,faceValue,x,y,rotation);}
    */

    public int getIndexDie(int index){
        if(dice.length<=index){
            return 0;
        }else{
            return dice[index].get();
        }
    }

    public int result(){
        int sum = 0;
        for (Die d: dice) {
            sum += d.get();
        }
        return sum;
    }

}
