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
        ((Neutral)fieldList[0]).setColor(Color.WHITE);

        fieldList[1] = new RealEstate();
        ((Property)fieldList[1]).setName(stringArrayList.get(2));
        ((Property)fieldList[1]).setPrice(1200);
        ((Property)fieldList[1]).setColor(Color.ORANGE);

        fieldList[2] = new Chance();
        ((Property)fieldList[2]).setName(stringArrayList.get(3));
        ((Property)fieldList[2]).setColor(Color.ORANGE);

        fieldList[3] = new RealEstate();
        ((Chance)fieldList[3]).setName(stringArrayList.get(4));
        ((Property)fieldList[3]).setPrice(1200);
        ((Chance)fieldList[3]).setColor(Color.LIGHT_GRAY);

        //tax
        fieldList[4] = new Chance();
        ((Property)fieldList[4]).setName(stringArrayList.get(5));
        ((Property)fieldList[4]).setColor(Color.CYAN);

        fieldList[5] = new Ferry();
        ((Property)fieldList[5]).setName(stringArrayList.get(6));
        ((Property)fieldList[5]).setPrice(4000);
        ((Property)fieldList[5]).setColor(Color.CYAN);

        fieldList[6] = new RealEstate();
        ((Neutral)fieldList[6]).setName(stringArrayList.get(7));
        ((Property)fieldList[6]).setPrice(2000);
        ((Neutral)fieldList[6]).setColor(Color.GRAY);

        fieldList[7] = new Chance();
        ((Property)fieldList[7]).setName(stringArrayList.get(8));
        ((Property)fieldList[7]).setColor(Color.MAGENTA);

        fieldList[8] = new RealEstate();
        ((Property)fieldList[8]).setName(stringArrayList.get(9));
        ((Property)fieldList[8]).setPrice(2000);
        ((Property)fieldList[8]).setColor(Color.MAGENTA);

        fieldList[9] = new RealEstate();
        ((Chance)fieldList[9]).setName(stringArrayList.get(10));
        ((Property)fieldList[9]).setPrice(2400);
        ((Chance)fieldList[9]).setColor(Color.LIGHT_GRAY);

        fieldList[10] = new Neutral();
        ((Property)fieldList[10]).setName(stringArrayList.get(11));
        ((Property)fieldList[10]).setColor(Color.PINK);

        fieldList[11] = new RealEstate();
        ((Property)fieldList[11]).setName(stringArrayList.get(12));
        ((Property)fieldList[11]).setPrice(2800);
        ((Property)fieldList[11]).setColor(Color.PINK);

        fieldList[12] = new Brewery();
        ((Neutral)fieldList[12]).setName(stringArrayList.get(13));
        ((Property)fieldList[12]).setPrice(3000);
        ((Neutral)fieldList[12]).setColor(Color.BLACK);

        fieldList[13] = new RealEstate();
        ((Property)fieldList[13]).setName(stringArrayList.get(14));
        ((Property)fieldList[13]).setPrice(2800);
        ((Property)fieldList[13]).setColor(Color.RED);

        fieldList[14] = new RealEstate();
        ((Property)fieldList[14]).setName(stringArrayList.get(15));
        ((Property)fieldList[14]).setPrice(3200);
        ((Property)fieldList[14]).setColor(Color.RED);

        fieldList[15] = new Ferry();
        ((Chance)fieldList[15]).setName(stringArrayList.get(16));
        ((Property)fieldList[15]).setPrice(4000);
        ((Chance)fieldList[15]).setColor(Color.LIGHT_GRAY);

        fieldList[16] = new RealEstate();
        ((Property)fieldList[16]).setName(stringArrayList.get(17));
        ((Property)fieldList[16]).setPrice(3600);
        ((Property)fieldList[16]).setColor(Color.YELLOW);

        fieldList[17] = new Chance();
        ((Property)fieldList[17]).setName(stringArrayList.get(18));
        ((Property)fieldList[17]).setColor(Color.YELLOW);

        fieldList[18] = new RealEstate();
        ((GoJail)fieldList[18]).setName(stringArrayList.get(19));
        ((Property)fieldList[18]).setPrice(3600);
        ((GoJail)fieldList[18]).setColor(Color.DARK_GRAY);

        fieldList[19] = new RealEstate();
        ((Property)fieldList[19]).setName(stringArrayList.get(20));
        ((Property)fieldList[19]).setPrice(4000);
        ((Property)fieldList[19]).setColor(Color.GREEN);

        fieldList[20] = new Neutral();
        ((Property)fieldList[20]).setName(stringArrayList.get(21));
        ((Property)fieldList[20]).setColor(Color.GREEN);

        fieldList[21] = new RealEstate();
        ((Chance)fieldList[21]).setName(stringArrayList.get(22));
        ((Property)fieldList[21]).setPrice(4400);
        ((Chance)fieldList[21]).setColor(Color.LIGHT_GRAY);

        fieldList[22] = new Chance();
        ((Property)fieldList[22]).setName(stringArrayList.get(23));
        ((Property)fieldList[22]).setColor(Color.BLUE);

        fieldList[23] = new RealEstate();
        ((Property)fieldList[23]).setName(stringArrayList.get(24));
        ((Property)fieldList[23]).setPrice(4400);
        ((Property)fieldList[23]).setColor(Color.BLUE);


        fieldList[24] = new RealEstate();
        ((Property)fieldList[24]).setName(stringArrayList.get(25));
        ((Property)fieldList[24]).setPrice(4800);
        ((Property)fieldList[24]).setColor(Color.BLUE);

        fieldList[25] = new Ferry();
        ((Property)fieldList[25]).setName(stringArrayList.get(26));
        ((Property)fieldList[25]).setPrice(4000);
        ((Property)fieldList[25]).setColor(Color.BLUE);

        fieldList[26] = new RealEstate();
        ((Property)fieldList[26]).setName(stringArrayList.get(27));
        ((Property)fieldList[26]).setPrice(5200);
        ((Property)fieldList[26]).setColor(Color.BLUE);

        fieldList[27] = new RealEstate();
        ((Property)fieldList[27]).setName(stringArrayList.get(28));
        ((Property)fieldList[27]).setPrice(5200);
        ((Property)fieldList[27]).setColor(Color.BLUE);

        fieldList[28] = new Brewery();
        ((Property)fieldList[28]).setName(stringArrayList.get(29));
        ((Property)fieldList[28]).setPrice(3000);
        ((Property)fieldList[28]).setColor(Color.BLUE);

        fieldList[29] = new RealEstate();
        ((Property)fieldList[29]).setName(stringArrayList.get(30));
        ((Property)fieldList[29]).setPrice(5600);
        ((Property)fieldList[29]).setColor(Color.BLUE);

        fieldList[30] = new GoJail();
        ((Property)fieldList[30]).setName(stringArrayList.get(31));
        ((Property)fieldList[30]).setColor(Color.BLUE);

        fieldList[31] = new RealEstate();
        ((Property)fieldList[31]).setName(stringArrayList.get(32));
        ((Property)fieldList[31]).setPrice(6000);
        ((Property)fieldList[31]).setColor(Color.BLUE);

        fieldList[32] = new RealEstate();
        ((Property)fieldList[32]).setName(stringArrayList.get(33));
        ((Property)fieldList[32]).setPrice(6000);
        ((Property)fieldList[32]).setColor(Color.BLUE);

        fieldList[33] = new Chance();
        ((Property)fieldList[33]).setName(stringArrayList.get(34));
        ((Property)fieldList[33]).setColor(Color.BLUE);

        fieldList[34] = new RealEstate();
        ((Property)fieldList[34]).setName(stringArrayList.get(35));
        ((Property)fieldList[34]).setPrice(6400);
        ((Property)fieldList[34]).setColor(Color.BLUE);

        fieldList[35] = new Ferry();
        ((Property)fieldList[35]).setName(stringArrayList.get(36));
        ((Property)fieldList[35]).setPrice(4000);
        ((Property)fieldList[35]).setColor(Color.BLUE);

        fieldList[36] = new Chance();
        ((Property)fieldList[36]).setName(stringArrayList.get(37));
        ((Property)fieldList[36]).setColor(Color.BLUE);


        fieldList[37] = new RealEstate();
        ((Property)fieldList[37]).setName(stringArrayList.get(38));
        ((Property)fieldList[37]).setPrice(7000);
        ((Property)fieldList[37]).setColor(Color.BLUE);


        // tax
        fieldList[38] = new Chance();
        ((Property)fieldList[38]).setName(stringArrayList.get(39));
        //((Property)fieldList[38]).setPrice(4400);
        ((Property)fieldList[38]).setColor(Color.BLUE);

        fieldList[39] = new RealEstate();
        ((Property)fieldList[39]).setName(stringArrayList.get(40));
        ((Property)fieldList[39]).setPrice(8000);
        ((Property)fieldList[39]).setColor(Color.BLUE);


    }
    public Field getFieldIndex(int index){
        return fieldList[index];
    }

    public Field[] getFieldList(){
        return this.fieldList;
    }
}
