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
    public void buyProperty(Player player){
        super.buyProperty(player);
    }
    public void mortgageEstimation(Player player, int mortgagePrice) {
        super.mortgageProperty(player, mortgagePrice);
    }

    public void rent(Player player){
        player.getAccount().subtractionAccount(1);
        super.getPlayer().getAccount().additionAccount(1);

    }
}
