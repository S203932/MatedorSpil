package Fields;

import SupportClasses.Player;

public class RealEstate extends Property {
    private int upgrade;
    private int upgradeValue;
    private int rent0;
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;
    private int rent5;

    public RealEstate() {
        setUpgrade(-1);
        setUpgradeValue(-1);
        setRent0(-1);
        setRent1(-1);
        setRent2(-1);
        setRent3(-1);
        setRent4(-1);
        setRent5(-1);
    }

    // Upgrade is the amount of houses you have
    public void setUpgrade(int upgrade) {
        this.upgrade = upgrade;
    }

    // How much it costs to buy house or hotel
    public void setUpgradeValue(int upgradeValue) {
        this.upgradeValue = upgradeValue;
    }

    public int getUpgrade() {
        return this.upgrade;
    }

    public int getUpgradeValue() {
        return this.upgradeValue;
    }



    public void buyProperty(Player player) {
        super.buyProperty(player);
    }

    public void mortgageEstimation(Player player) {
        super.mortgageProperty(player);
    }

    // Getters and setters for rent
    public int getRent0() {
        return rent0;
    }

    public void setRent0(int rent0) {
        this.rent0 = rent0;
    }

    public int getRent1() {
        return rent1;
    }

    public void setRent1(int rent1) {
        this.rent1 = rent1;
    }

    public int getRent2() {
        return rent2;
    }

    public void setRent2(int rent2) {
        this.rent2 = rent2;
    }

    public int getRent3() {
        return rent3;
    }

    public void setRent3(int rent3) {
        this.rent3 = rent3;
    }

    public int getRent4() {
        return rent4;
    }

    public void setRent4(int rent4) {
        this.rent4 = rent4;
    }

    public int getRent5() {
        return rent5;
    }

    public void setRent5(int rent5) {
        this.rent5 = rent5;
    }

    //Paying and receiving rent depending on different circumstances
    public void rent(Player player) {
        if (upgrade == 0){
            player.getAccount().subtractionAccount(rent0);
            super.getPlayer().getAccount().additionAccount(rent0);
        } else if (upgrade == 1) {
            player.getAccount().subtractionAccount(rent1);
            super.getPlayer().getAccount().additionAccount(rent1);
        } else if (upgrade == 2) {
            player.getAccount().subtractionAccount(rent2);
            super.getPlayer().getAccount().additionAccount(rent2);
        } else if (upgrade == 3) {
            player.getAccount().subtractionAccount(rent3);
            super.getPlayer().getAccount().additionAccount(rent3);
        } else if (upgrade == 4) {
            player.getAccount().subtractionAccount(rent4);
            super.getPlayer().getAccount().additionAccount(rent4);
        } else  {
            player.getAccount().subtractionAccount(rent5);
            super.getPlayer().getAccount().additionAccount(rent5);
        }
    }
}



