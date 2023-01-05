package Fields;

import SupportClasses.Player;

public class RealEstate extends Property{
    private int upgrade;
    private int upgradeValue;
    public RealEstate (){
        setUpgrade(-1);
        setUpgradeValue(-1);
    }
    public void setUpgrade (int upgrade){
        this.upgrade=upgrade;
    }

    public void setUpgradeValue (int upgradeValue){
        this.upgradeValue=upgradeValue;
    }

    public int getUpgrade(){
        return this.upgrade;
    }

    public int getUpgradeValue() {
        return this.upgradeValue;
    }

    public void rent(Player player){}
}
