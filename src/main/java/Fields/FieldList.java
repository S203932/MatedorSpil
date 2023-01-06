package Fields;
// Class is written by Kristian Urban 163301, Zainab Hameed s204747 and Patrick Machalet s203932

import CreateAndWriteToAndFromTXT.ReadFile;

import java.awt.*;
import java.util.ArrayList;
public class FieldList {

    private Field[] fieldList;

    // constructor der indeholder array
    public FieldList() {
        InitializeFieldList();
    }

    public void InitializeFieldList() {
        this.fieldList = new Field[40];
    }

    public void setupField(String filename){
        ReadFile readFile = new ReadFile();
        ArrayList<String> stringArrayList = readFile.ReadFile(filename);

        fieldList[0] = new Neutral();
        ((Neutral)fieldList[0]).setName(stringArrayList.get(1));
        ((Neutral)fieldList[0]).setColor(Color.LIGHT_GRAY);

        fieldList[1] = new RealEstate();
        ((RealEstate)fieldList[1]).setUpgrade(0);
        ((RealEstate)fieldList[1]).setName(stringArrayList.get(2));
        ((RealEstate)fieldList[1]).setPrice(1200);
        ((RealEstate)fieldList[1]).setColor(Color.BLUE);
        ((RealEstate)fieldList[1]).setRent0(50);
        ((RealEstate)fieldList[1]).setRent1(250);
        ((RealEstate)fieldList[1]).setRent2(750);
        ((RealEstate)fieldList[1]).setRent3(2250);
        ((RealEstate)fieldList[1]).setRent4(4000);
        ((RealEstate)fieldList[1]).setRent5(6000);

        fieldList[2] = new Chance();
        ((Chance)fieldList[2]).setName(stringArrayList.get(3));
        ((Chance)fieldList[2]).setColor(Color.BLACK);

        fieldList[3] = new RealEstate();
        ((RealEstate)fieldList[3]).setUpgrade(0);
        ((RealEstate)fieldList[3]).setName(stringArrayList.get(4));
        ((RealEstate)fieldList[3]).setPrice(1200);
        ((RealEstate)fieldList[3]).setColor(Color.BLUE);
        ((RealEstate)fieldList[3]).setRent0(50);
        ((RealEstate)fieldList[3]).setRent1(250);
        ((RealEstate)fieldList[3]).setRent2(400);
        ((RealEstate)fieldList[3]).setRent3(750);
        ((RealEstate)fieldList[3]).setRent4(2250);
        ((RealEstate)fieldList[3]).setRent5(6000);

        //tax
        fieldList[4] = new Tax();
        ((Tax)fieldList[4]).setName(stringArrayList.get(5));
        //((Tax)fieldList[4]).setColor(Color.CYAN);

        fieldList[5] = new Ferry();
        ((Ferry)fieldList[5]).setName(stringArrayList.get(6));
        ((Ferry)fieldList[5]).setPrice(4000);
        ((Ferry)fieldList[5]).setColor(Color.CYAN);

        fieldList[6] = new RealEstate();
        ((RealEstate)fieldList[6]).setUpgrade(0);
        ((RealEstate)fieldList[6]).setName(stringArrayList.get(7));
        ((RealEstate)fieldList[6]).setPrice(2000);
        ((RealEstate)fieldList[6]).setColor(Color.ORANGE);
        ((RealEstate)fieldList[6]).setRent0(100);
        ((RealEstate)fieldList[6]).setRent1(600);
        ((RealEstate)fieldList[6]).setRent2(1800);
        ((RealEstate)fieldList[6]).setRent3(5400);
        ((RealEstate)fieldList[6]).setRent4(8000);
        ((RealEstate)fieldList[6]).setRent5(11000);

        fieldList[7] = new Chance();
        ((Chance)fieldList[7]).setName(stringArrayList.get(8));
        ((Chance)fieldList[7]).setColor(Color.BLACK);

        fieldList[8] = new RealEstate();
        ((RealEstate)fieldList[8]).setUpgrade(0);
        ((RealEstate)fieldList[8]).setName(stringArrayList.get(9));
        ((RealEstate)fieldList[8]).setPrice(2000);
        ((RealEstate)fieldList[8]).setColor(Color.ORANGE);
        ((RealEstate)fieldList[8]).setRent0(100);
        ((RealEstate)fieldList[8]).setRent1(600);
        ((RealEstate)fieldList[8]).setRent2(1800);
        ((RealEstate)fieldList[8]).setRent3(5400);
        ((RealEstate)fieldList[8]).setRent4(8000);
        ((RealEstate)fieldList[8]).setRent5(11000);

        fieldList[9] = new RealEstate();
        ((RealEstate)fieldList[9]).setUpgrade(0);
        ((RealEstate)fieldList[9]).setName(stringArrayList.get(10));
        ((RealEstate)fieldList[9]).setPrice(2400);
        ((RealEstate)fieldList[9]).setColor(Color.ORANGE);
        ((RealEstate)fieldList[9]).setRent0(150);
        ((RealEstate)fieldList[9]).setRent1(800);
        ((RealEstate)fieldList[9]).setRent2(2000);
        ((RealEstate)fieldList[9]).setRent3(6000);
        ((RealEstate)fieldList[9]).setRent4(9000);
        ((RealEstate)fieldList[9]).setRent5(12000);

        fieldList[10] = new Neutral();
        ((Neutral)fieldList[10]).setName(stringArrayList.get(11));
        ((Neutral)fieldList[10]).setColor(Color.LIGHT_GRAY);

        fieldList[11] = new RealEstate();
        ((RealEstate)fieldList[11]).setUpgrade(0);
        ((RealEstate)fieldList[11]).setName(stringArrayList.get(12));
        ((RealEstate)fieldList[11]).setPrice(2800);
        ((RealEstate)fieldList[11]).setColor(Color.GREEN);
        ((RealEstate)fieldList[11]).setRent0(200);
        ((RealEstate)fieldList[11]).setRent1(1000);
        ((RealEstate)fieldList[11]).setRent2(3000);
        ((RealEstate)fieldList[11]).setRent3(9000);
        ((RealEstate)fieldList[11]).setRent4(12500);
        ((RealEstate)fieldList[11]).setRent5(15000);

        fieldList[12] = new Brewery();
        ((Brewery)fieldList[12]).setName(stringArrayList.get(13));
        ((Brewery)fieldList[12]).setPrice(3000);
        ((Brewery)fieldList[12]).setColor(Color.PINK);

        fieldList[13] = new RealEstate();
        ((RealEstate)fieldList[13]).setUpgrade(0);
        ((RealEstate)fieldList[13]).setName(stringArrayList.get(14));
        ((RealEstate)fieldList[13]).setPrice(2800);
        ((RealEstate)fieldList[13]).setColor(Color.GREEN);
        ((RealEstate)fieldList[13]).setRent0(200);
        ((RealEstate)fieldList[13]).setRent1(1000);
        ((RealEstate)fieldList[13]).setRent2(3000);
        ((RealEstate)fieldList[13]).setRent3(9000);
        ((RealEstate)fieldList[13]).setRent4(12500);
        ((RealEstate)fieldList[13]).setRent5(15000);

        fieldList[14] = new RealEstate();
        ((RealEstate)fieldList[14]).setUpgrade(0);
        ((RealEstate)fieldList[14]).setName(stringArrayList.get(15));
        ((RealEstate)fieldList[14]).setPrice(3200);
        ((RealEstate)fieldList[14]).setColor(Color.GREEN);
        ((RealEstate)fieldList[14]).setRent0(250);
        ((RealEstate)fieldList[14]).setRent1(1250);
        ((RealEstate)fieldList[14]).setRent2(3750);
        ((RealEstate)fieldList[14]).setRent3(10000);
        ((RealEstate)fieldList[14]).setRent4(14000);
        ((RealEstate)fieldList[14]).setRent5(18000);

        fieldList[15] = new Ferry();
        ((Ferry)fieldList[15]).setName(stringArrayList.get(16));
        ((Ferry)fieldList[15]).setPrice(4000);
        ((Ferry)fieldList[15]).setColor(Color.CYAN);

        fieldList[16] = new RealEstate();
        ((RealEstate)fieldList[16]).setUpgrade(0);
        ((RealEstate)fieldList[16]).setName(stringArrayList.get(17));
        ((RealEstate)fieldList[16]).setPrice(3600);
        ((RealEstate)fieldList[16]).setColor(Color.GRAY);
        ((RealEstate)fieldList[16]).setRent0(300);
        ((RealEstate)fieldList[16]).setRent1(1400);
        ((RealEstate)fieldList[16]).setRent2(4000);
        ((RealEstate)fieldList[16]).setRent3(11000);
        ((RealEstate)fieldList[16]).setRent4(15000);
        ((RealEstate)fieldList[16]).setRent5(19000);

        fieldList[17] = new Chance();
        ((Chance)fieldList[17]).setName(stringArrayList.get(18));
        ((Chance)fieldList[17]).setColor(Color.BLACK);

        fieldList[18] = new RealEstate();
        ((RealEstate)fieldList[18]).setUpgrade(0);
        ((RealEstate)fieldList[18]).setName(stringArrayList.get(19));
        ((RealEstate)fieldList[18]).setPrice(3600);
        ((RealEstate)fieldList[18]).setColor(Color.GRAY);
        ((RealEstate)fieldList[18]).setRent0(300);
        ((RealEstate)fieldList[18]).setRent1(1400);
        ((RealEstate)fieldList[18]).setRent2(4000);
        ((RealEstate)fieldList[18]).setRent3(11000);
        ((RealEstate)fieldList[18]).setRent4(15000);
        ((RealEstate)fieldList[18]).setRent5(19000);

        fieldList[19] = new RealEstate();
        ((RealEstate)fieldList[19]).setUpgrade(0);
        ((RealEstate)fieldList[19]).setName(stringArrayList.get(20));
        ((RealEstate)fieldList[19]).setPrice(4000);
        ((RealEstate)fieldList[19]).setColor(Color.GRAY);
        ((RealEstate)fieldList[19]).setRent0(350);
        ((RealEstate)fieldList[19]).setRent1(1600);
        ((RealEstate)fieldList[19]).setRent2(4400);
        ((RealEstate)fieldList[19]).setRent3(12000);
        ((RealEstate)fieldList[19]).setRent4(16000);
        ((RealEstate)fieldList[19]).setRent5(20000);

        fieldList[20] = new Neutral();
        ((Neutral)fieldList[20]).setName(stringArrayList.get(21));
        ((Neutral)fieldList[20]).setColor(Color.LIGHT_GRAY);

        fieldList[21] = new RealEstate();
        ((RealEstate)fieldList[21]).setUpgrade(0);
        ((RealEstate)fieldList[21]).setName(stringArrayList.get(22));
        ((RealEstate)fieldList[21]).setPrice(4400);
        ((RealEstate)fieldList[21]).setColor(Color.RED);
        ((RealEstate)fieldList[21]).setRent0(350);
        ((RealEstate)fieldList[21]).setRent1(1800);
        ((RealEstate)fieldList[21]).setRent2(5000);
        ((RealEstate)fieldList[21]).setRent3(14000);
        ((RealEstate)fieldList[21]).setRent4(17500);
        ((RealEstate)fieldList[21]).setRent5(21000);

        fieldList[22] = new Chance();
        ((Chance)fieldList[22]).setName(stringArrayList.get(23));
        ((Chance)fieldList[22]).setColor(Color.BLACK);

        fieldList[23] = new RealEstate();
        ((RealEstate)fieldList[23]).setUpgrade(0);
        ((RealEstate)fieldList[23]).setName(stringArrayList.get(24));
        ((RealEstate)fieldList[23]).setPrice(4400);
        ((RealEstate)fieldList[23]).setColor(Color.RED);
        ((RealEstate)fieldList[23]).setRent0(350);
        ((RealEstate)fieldList[23]).setRent1(1800);
        ((RealEstate)fieldList[23]).setRent2(5000);
        ((RealEstate)fieldList[23]).setRent3(14000);
        ((RealEstate)fieldList[23]).setRent4(17500);
        ((RealEstate)fieldList[23]).setRent5(21000);


        fieldList[24] = new RealEstate();
        ((RealEstate)fieldList[24]).setUpgrade(0);
        ((RealEstate)fieldList[24]).setName(stringArrayList.get(25));
        ((RealEstate)fieldList[24]).setPrice(4800);
        ((RealEstate)fieldList[24]).setColor(Color.RED);
        ((RealEstate)fieldList[24]).setRent0(400);
        ((RealEstate)fieldList[24]).setRent1(2000);
        ((RealEstate)fieldList[24]).setRent2(6000);
        ((RealEstate)fieldList[24]).setRent3(15000);
        ((RealEstate)fieldList[24]).setRent4(18500);
        ((RealEstate)fieldList[24]).setRent5(22000);

        fieldList[25] = new Ferry();
        ((Ferry)fieldList[25]).setName(stringArrayList.get(26));
        ((Ferry)fieldList[25]).setPrice(4000);
        ((Ferry)fieldList[25]).setColor(Color.CYAN);

        fieldList[26] = new RealEstate();
        ((RealEstate)fieldList[26]).setUpgrade(0);
        ((RealEstate)fieldList[26]).setName(stringArrayList.get(27));
        ((RealEstate)fieldList[26]).setPrice(5200);
        ((RealEstate)fieldList[26]).setColor(Color.WHITE);
        ((RealEstate)fieldList[26]).setRent0(450);
        ((RealEstate)fieldList[26]).setRent1(2200);
        ((RealEstate)fieldList[26]).setRent2(6600);
        ((RealEstate)fieldList[26]).setRent3(16000);
        ((RealEstate)fieldList[26]).setRent4(19500);
        ((RealEstate)fieldList[26]).setRent5(23000);

        fieldList[27] = new RealEstate();
        ((RealEstate)fieldList[27]).setUpgrade(0);
        ((RealEstate)fieldList[27]).setName(stringArrayList.get(28));
        ((RealEstate)fieldList[27]).setPrice(5200);
        ((RealEstate)fieldList[27]).setColor(Color.WHITE);
        ((RealEstate)fieldList[27]).setRent0(450);
        ((RealEstate)fieldList[27]).setRent1(2200);
        ((RealEstate)fieldList[27]).setRent2(6600);
        ((RealEstate)fieldList[27]).setRent3(16000);
        ((RealEstate)fieldList[27]).setRent4(19500);
        ((RealEstate)fieldList[27]).setRent5(23000);

        fieldList[28] = new Brewery();
        ((Brewery)fieldList[28]).setName(stringArrayList.get(29));
        ((Brewery)fieldList[28]).setPrice(3000);
        ((Brewery)fieldList[28]).setColor(Color.PINK);

        fieldList[29] = new RealEstate();
        ((RealEstate)fieldList[29]).setUpgrade(0);
        ((RealEstate)fieldList[29]).setName(stringArrayList.get(30));
        ((RealEstate)fieldList[29]).setPrice(5600);
        ((RealEstate)fieldList[29]).setColor(Color.white);
        ((RealEstate)fieldList[29]).setRent0(500);
        ((RealEstate)fieldList[29]).setRent1(2400);
        ((RealEstate)fieldList[29]).setRent2(7200);
        ((RealEstate)fieldList[29]).setRent3(17000);
        ((RealEstate)fieldList[29]).setRent4(20500);
        ((RealEstate)fieldList[29]).setRent5(24000);

        fieldList[30] = new GoJail();
        ((GoJail)fieldList[30]).setName(stringArrayList.get(31));
        ((GoJail)fieldList[30]).setColor(Color.DARK_GRAY);

        fieldList[31] = new RealEstate();
        ((RealEstate)fieldList[31]).setUpgrade(0);
        ((RealEstate)fieldList[31]).setName(stringArrayList.get(32));
        ((RealEstate)fieldList[31]).setPrice(6000);
        ((RealEstate)fieldList[31]).setColor(Color.YELLOW);
        ((RealEstate)fieldList[31]).setRent0(550);
        ((RealEstate)fieldList[31]).setRent1(2600);
        ((RealEstate)fieldList[31]).setRent2(7800);
        ((RealEstate)fieldList[31]).setRent3(18000);
        ((RealEstate)fieldList[31]).setRent4(22000);
        ((RealEstate)fieldList[31]).setRent5(25000);

        fieldList[32] = new RealEstate();
        ((RealEstate)fieldList[32]).setUpgrade(0);
        ((RealEstate)fieldList[32]).setName(stringArrayList.get(33));
        ((RealEstate)fieldList[32]).setPrice(6000);
        ((RealEstate)fieldList[32]).setColor(Color.yellow);
        ((RealEstate)fieldList[32]).setRent0(550);
        ((RealEstate)fieldList[32]).setRent1(2600);
        ((RealEstate)fieldList[32]).setRent2(7800);
        ((RealEstate)fieldList[32]).setRent3(18000);
        ((RealEstate)fieldList[32]).setRent4(22000);
        ((RealEstate)fieldList[32]).setRent5(25000);

        fieldList[33] = new Chance();
        ((Chance)fieldList[33]).setName(stringArrayList.get(34));
        ((Chance)fieldList[33]).setColor(Color.BLACK);

        fieldList[34] = new RealEstate();
        ((RealEstate)fieldList[34]).setUpgrade(0);
        ((RealEstate)fieldList[34]).setName(stringArrayList.get(35));
        ((RealEstate)fieldList[34]).setPrice(6400);
        ((RealEstate)fieldList[34]).setColor(Color.yellow);
        ((RealEstate)fieldList[34]).setRent0(600);
        ((RealEstate)fieldList[34]).setRent1(3000);
        ((RealEstate)fieldList[34]).setRent2(9000);
        ((RealEstate)fieldList[34]).setRent3(20000);
        ((RealEstate)fieldList[34]).setRent4(24000);
        ((RealEstate)fieldList[34]).setRent5(28000);

        fieldList[35] = new Ferry();
        ((Ferry)fieldList[35]).setName(stringArrayList.get(36));
        ((Ferry)fieldList[35]).setPrice(4000);
        ((Ferry)fieldList[35]).setColor(Color.CYAN);

        fieldList[36] = new Chance();
        ((Chance)fieldList[36]).setName(stringArrayList.get(37));
        ((Chance)fieldList[36]).setColor(Color.BLACK);


        fieldList[37] = new RealEstate();
        ((RealEstate)fieldList[37]).setUpgrade(0);
        ((RealEstate)fieldList[37]).setName(stringArrayList.get(38));
        ((RealEstate)fieldList[37]).setPrice(7000);
        ((RealEstate)fieldList[37]).setColor(Color.MAGENTA);
        ((RealEstate)fieldList[37]).setRent0(700);
        ((RealEstate)fieldList[37]).setRent1(3500);
        ((RealEstate)fieldList[37]).setRent2(10000);
        ((RealEstate)fieldList[37]).setRent3(22000);
        ((RealEstate)fieldList[37]).setRent4(26000);
        ((RealEstate)fieldList[37]).setRent5(30000);


        // tax
        fieldList[38] = new Tax();
        ((Tax)fieldList[38]).setName(stringArrayList.get(39));
       // ((Tax)fieldList[38]).setColor(Color.);

        fieldList[39] = new RealEstate();
        ((RealEstate)fieldList[39]).setUpgrade(0);
        ((RealEstate)fieldList[39]).setName(stringArrayList.get(40));
        ((RealEstate)fieldList[39]).setPrice(8000);
        ((RealEstate)fieldList[39]).setColor(Color.MAGENTA);
        ((RealEstate)fieldList[39]).setRent0(1000);
        ((RealEstate)fieldList[39]).setRent1(4000);
        ((RealEstate)fieldList[39]).setRent2(12000);
        ((RealEstate)fieldList[39]).setRent3(28000);
        ((RealEstate)fieldList[39]).setRent4(34000);
        ((RealEstate)fieldList[39]).setRent5(40000);
    }
    public Field getFieldIndex(int index){
        return fieldList[index];
    }

    public Field[] getFieldList(){
        return this.fieldList;
    }
}
