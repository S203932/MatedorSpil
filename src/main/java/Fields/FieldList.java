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
        ((RealEstate)fieldList[1]).setName(stringArrayList.get(2));
        ((RealEstate)fieldList[1]).setPrice(1200);
        ((RealEstate)fieldList[1]).setColor(Color.BLUE);

        fieldList[2] = new Chance();
        ((Chance)fieldList[2]).setName(stringArrayList.get(3));
        ((Chance)fieldList[2]).setColor(Color.BLACK);

        fieldList[3] = new RealEstate();
        ((RealEstate)fieldList[3]).setName(stringArrayList.get(4));
        ((RealEstate)fieldList[3]).setPrice(1200);
        ((RealEstate)fieldList[3]).setColor(Color.BLUE);

        //tax
        fieldList[4] = new Tax();
        ((Tax)fieldList[4]).setName(stringArrayList.get(5));
        //((Tax)fieldList[4]).setColor(Color.CYAN);

        fieldList[5] = new Ferry();
        ((Ferry)fieldList[5]).setName(stringArrayList.get(6));
        ((Ferry)fieldList[5]).setPrice(4000);
        ((Ferry)fieldList[5]).setColor(Color.CYAN);

        fieldList[6] = new RealEstate();
        ((RealEstate)fieldList[6]).setName(stringArrayList.get(7));
        ((RealEstate)fieldList[6]).setPrice(2000);
        ((RealEstate)fieldList[6]).setColor(Color.ORANGE);

        fieldList[7] = new Chance();
        ((Chance)fieldList[7]).setName(stringArrayList.get(8));
        ((Chance)fieldList[7]).setColor(Color.BLACK);

        fieldList[8] = new RealEstate();
        ((RealEstate)fieldList[8]).setName(stringArrayList.get(9));
        ((RealEstate)fieldList[8]).setPrice(2000);
        ((RealEstate)fieldList[8]).setColor(Color.ORANGE);

        fieldList[9] = new RealEstate();
        ((RealEstate)fieldList[9]).setName(stringArrayList.get(10));
        ((RealEstate)fieldList[9]).setPrice(2400);
        ((RealEstate)fieldList[9]).setColor(Color.ORANGE);

        fieldList[10] = new Neutral();
        ((Neutral)fieldList[10]).setName(stringArrayList.get(11));
        ((Neutral)fieldList[10]).setColor(Color.LIGHT_GRAY);

        fieldList[11] = new RealEstate();
        ((RealEstate)fieldList[11]).setName(stringArrayList.get(12));
        ((RealEstate)fieldList[11]).setPrice(2800);
        ((RealEstate)fieldList[11]).setColor(Color.GREEN);

        fieldList[12] = new Brewery();
        ((Brewery)fieldList[12]).setName(stringArrayList.get(13));
        ((Brewery)fieldList[12]).setPrice(3000);
        ((Brewery)fieldList[12]).setColor(Color.PINK);

        fieldList[13] = new RealEstate();
        ((RealEstate)fieldList[13]).setName(stringArrayList.get(14));
        ((RealEstate)fieldList[13]).setPrice(2800);
        ((RealEstate)fieldList[13]).setColor(Color.GREEN);

        fieldList[14] = new RealEstate();
        ((RealEstate)fieldList[14]).setName(stringArrayList.get(15));
        ((RealEstate)fieldList[14]).setPrice(3200);
        ((RealEstate)fieldList[14]).setColor(Color.GREEN);

        fieldList[15] = new Ferry();
        ((Ferry)fieldList[15]).setName(stringArrayList.get(16));
        ((Ferry)fieldList[15]).setPrice(4000);
        ((Ferry)fieldList[15]).setColor(Color.CYAN);

        fieldList[16] = new RealEstate();
        ((RealEstate)fieldList[16]).setName(stringArrayList.get(17));
        ((RealEstate)fieldList[16]).setPrice(3600);
        ((RealEstate)fieldList[16]).setColor(Color.GRAY);

        fieldList[17] = new Chance();
        ((Chance)fieldList[17]).setName(stringArrayList.get(18));
        ((Chance)fieldList[17]).setColor(Color.BLACK);

        fieldList[18] = new RealEstate();
        ((RealEstate)fieldList[18]).setName(stringArrayList.get(19));
        ((RealEstate)fieldList[18]).setPrice(3600);
        ((RealEstate)fieldList[18]).setColor(Color.GRAY);

        fieldList[19] = new RealEstate();
        ((RealEstate)fieldList[19]).setName(stringArrayList.get(20));
        ((RealEstate)fieldList[19]).setPrice(4000);
        ((RealEstate)fieldList[19]).setColor(Color.GRAY);

        fieldList[20] = new Neutral();
        ((Neutral)fieldList[20]).setName(stringArrayList.get(21));
        ((Neutral)fieldList[20]).setColor(Color.LIGHT_GRAY);

        fieldList[21] = new RealEstate();
        ((RealEstate)fieldList[21]).setName(stringArrayList.get(22));
        ((RealEstate)fieldList[21]).setPrice(4400);
        ((RealEstate)fieldList[21]).setColor(Color.RED);

        fieldList[22] = new Chance();
        ((Chance)fieldList[22]).setName(stringArrayList.get(23));
        ((Chance)fieldList[22]).setColor(Color.BLACK);

        fieldList[23] = new RealEstate();
        ((RealEstate)fieldList[23]).setName(stringArrayList.get(24));
        ((RealEstate)fieldList[23]).setPrice(4400);
        ((RealEstate)fieldList[23]).setColor(Color.RED);


        fieldList[24] = new RealEstate();
        ((RealEstate)fieldList[24]).setName(stringArrayList.get(25));
        ((RealEstate)fieldList[24]).setPrice(4800);
        ((RealEstate)fieldList[24]).setColor(Color.RED);

        fieldList[25] = new Ferry();
        ((Ferry)fieldList[25]).setName(stringArrayList.get(26));
        ((Ferry)fieldList[25]).setPrice(4000);
        ((Ferry)fieldList[25]).setColor(Color.CYAN);

        fieldList[26] = new RealEstate();
        ((RealEstate)fieldList[26]).setName(stringArrayList.get(27));
        ((RealEstate)fieldList[26]).setPrice(5200);
        ((RealEstate)fieldList[26]).setColor(Color.WHITE);

        fieldList[27] = new RealEstate();
        ((RealEstate)fieldList[27]).setName(stringArrayList.get(28));
        ((RealEstate)fieldList[27]).setPrice(5200);
        ((RealEstate)fieldList[27]).setColor(Color.WHITE);

        fieldList[28] = new Brewery();
        ((Brewery)fieldList[28]).setName(stringArrayList.get(29));
        ((Brewery)fieldList[28]).setPrice(3000);
        ((Brewery)fieldList[28]).setColor(Color.PINK);

        fieldList[29] = new RealEstate();
        ((RealEstate)fieldList[29]).setName(stringArrayList.get(30));
        ((RealEstate)fieldList[29]).setPrice(5600);
        ((RealEstate)fieldList[29]).setColor(Color.white);

        fieldList[30] = new GoJail();
        ((GoJail)fieldList[30]).setName(stringArrayList.get(31));
        ((GoJail)fieldList[30]).setColor(Color.DARK_GRAY);

        fieldList[31] = new RealEstate();
        ((RealEstate)fieldList[31]).setName(stringArrayList.get(32));
        ((RealEstate)fieldList[31]).setPrice(6000);
        ((RealEstate)fieldList[31]).setColor(Color.YELLOW);

        fieldList[32] = new RealEstate();
        ((RealEstate)fieldList[32]).setName(stringArrayList.get(33));
        ((RealEstate)fieldList[32]).setPrice(6000);
        ((RealEstate)fieldList[32]).setColor(Color.yellow);

        fieldList[33] = new Chance();
        ((Chance)fieldList[33]).setName(stringArrayList.get(34));
        ((Chance)fieldList[33]).setColor(Color.BLACK);

        fieldList[34] = new RealEstate();
        ((RealEstate)fieldList[34]).setName(stringArrayList.get(35));
        ((RealEstate)fieldList[34]).setPrice(6400);
        ((RealEstate)fieldList[34]).setColor(Color.yellow);

        fieldList[35] = new Ferry();
        ((Ferry)fieldList[35]).setName(stringArrayList.get(36));
        ((Ferry)fieldList[35]).setPrice(4000);
        ((Ferry)fieldList[35]).setColor(Color.CYAN);

        fieldList[36] = new Chance();
        ((Chance)fieldList[36]).setName(stringArrayList.get(37));
        ((Chance)fieldList[36]).setColor(Color.BLACK);


        fieldList[37] = new RealEstate();
        ((RealEstate)fieldList[37]).setName(stringArrayList.get(38));
        ((RealEstate)fieldList[37]).setPrice(7000);
        ((RealEstate)fieldList[37]).setColor(Color.MAGENTA);


        // tax
        fieldList[38] = new Tax();
        ((Tax)fieldList[38]).setName(stringArrayList.get(39));
       // ((Tax)fieldList[38]).setColor(Color.);

        fieldList[39] = new RealEstate();
        ((RealEstate)fieldList[39]).setName(stringArrayList.get(40));
        ((RealEstate)fieldList[39]).setPrice(8000);
        ((RealEstate)fieldList[39]).setColor(Color.MAGENTA);


    }
    public Field getFieldIndex(int index){
        return fieldList[index];
    }

    public Field[] getFieldList(){
        return this.fieldList;
    }
}
