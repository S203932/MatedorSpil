package SupportClasses;

public class DiceCup {
    private final Die[] dice;

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


    public int getIndexDie(int index) {
        if (dice.length <= index) {
            return 0;
        } else {
            return dice[index].get();
        }
    }

    public int result() {
        int sum = 0;
        for (Die d : dice) {
            sum += d.get();
        }
        return sum;
    }

    public void setDice(int index, int setDieValue) {
        this.dice[index].setValue(setDieValue);
    }
}
