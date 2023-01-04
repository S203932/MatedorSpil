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
        this.fieldList = new Field[24];
    }

    public void setupField(String filename){
        ReadFile readFile = new ReadFile();
        ArrayList<String> stringArrayList = readFile.ReadFile(filename);
        fieldList[0] = new StartField();
        ((StartField)fieldList[0]).setName(stringArrayList.get(1));
        ((StartField)fieldList[0]).setColor(Color.WHITE);

        fieldList[1] = new Property();
        ((Property)fieldList[1]).setName(stringArrayList.get(2));
        ((Property)fieldList[1]).setValue(1);
        ((Property)fieldList[1]).setColor(Color.ORANGE);

        fieldList[2] = new Property();
        ((Property)fieldList[2]).setName(stringArrayList.get(3));
        ((Property)fieldList[2]).setValue(1);
        ((Property)fieldList[2]).setColor(Color.ORANGE);

        fieldList[3] = new Chance();
        ((Chance)fieldList[3]).setName(stringArrayList.get(4));
        ((Chance)fieldList[3]).setColor(Color.LIGHT_GRAY);

        fieldList[4] = new Property();
        ((Property)fieldList[4]).setName(stringArrayList.get(5));
        ((Property)fieldList[4]).setValue(1);
        ((Property)fieldList[4]).setColor(Color.CYAN);

        fieldList[5] = new Property();
        ((Property)fieldList[5]).setName(stringArrayList.get(6));
        ((Property)fieldList[5]).setValue(1);
        ((Property)fieldList[5]).setColor(Color.CYAN);

        fieldList[6] = new NeutralFields();
        ((NeutralFields)fieldList[6]).setName(stringArrayList.get(7));
        ((NeutralFields)fieldList[6]).setColor(Color.GRAY);

        fieldList[7] = new Property();
        ((Property)fieldList[7]).setName(stringArrayList.get(8));
        ((Property)fieldList[7]).setValue(2);
        ((Property)fieldList[7]).setColor(Color.MAGENTA);

        fieldList[8] = new Property();
        ((Property)fieldList[8]).setName(stringArrayList.get(9));
        ((Property)fieldList[8]).setValue(2);
        ((Property)fieldList[8]).setColor(Color.MAGENTA);

        fieldList[9] = new Chance();
        ((Chance)fieldList[9]).setName(stringArrayList.get(10));
        ((Chance)fieldList[9]).setColor(Color.LIGHT_GRAY);

        fieldList[10] = new Property();
        ((Property)fieldList[10]).setName(stringArrayList.get(11));
        ((Property)fieldList[10]).setValue(2);
        ((Property)fieldList[10]).setColor(Color.PINK);

        fieldList[11] = new Property();
        ((Property)fieldList[11]).setName(stringArrayList.get(12));
        ((Property)fieldList[11]).setValue(2);
        ((Property)fieldList[11]).setColor(Color.PINK);

        fieldList[12] = new NeutralFields();
        ((NeutralFields)fieldList[12]).setName(stringArrayList.get(13));
        ((NeutralFields)fieldList[12]).setColor(Color.BLACK);

        fieldList[13] = new Property();
        ((Property)fieldList[13]).setName(stringArrayList.get(14));
        ((Property)fieldList[13]).setValue(3);
        ((Property)fieldList[13]).setColor(Color.RED);

        fieldList[14] = new Property();
        ((Property)fieldList[14]).setName(stringArrayList.get(15));
        ((Property)fieldList[14]).setValue(3);
        ((Property)fieldList[14]).setColor(Color.RED);

        fieldList[15] = new Chance();
        ((Chance)fieldList[15]).setName(stringArrayList.get(16));
        ((Chance)fieldList[15]).setColor(Color.LIGHT_GRAY);

        fieldList[16] = new Property();
        ((Property)fieldList[16]).setName(stringArrayList.get(17));
        ((Property)fieldList[16]).setValue(3);
        ((Property)fieldList[16]).setColor(Color.YELLOW);

        fieldList[17] = new Property();
        ((Property)fieldList[17]).setName(stringArrayList.get(18));
        ((Property)fieldList[17]).setValue(3);
        ((Property)fieldList[17]).setColor(Color.YELLOW);

        fieldList[18] = new GoJail();
        ((GoJail)fieldList[18]).setName(stringArrayList.get(19));
        ((GoJail)fieldList[18]).setColor(Color.DARK_GRAY);

        fieldList[19] = new Property();
        ((Property)fieldList[19]).setName(stringArrayList.get(20));
        ((Property)fieldList[19]).setValue(4);
        ((Property)fieldList[19]).setColor(Color.GREEN);

        fieldList[20] = new Property();
        ((Property)fieldList[20]).setName(stringArrayList.get(21));
        ((Property)fieldList[20]).setValue(4);
        ((Property)fieldList[20]).setColor(Color.GREEN);

        fieldList[21] = new Chance();
        ((Chance)fieldList[21]).setName(stringArrayList.get(22));
        ((Chance)fieldList[21]).setColor(Color.LIGHT_GRAY);

        fieldList[22] = new Property();
        ((Property)fieldList[22]).setName(stringArrayList.get(23));
        ((Property)fieldList[22]).setValue(5);
        ((Property)fieldList[22]).setColor(Color.BLUE);

        fieldList[23] = new Property();
        ((Property)fieldList[23]).setName(stringArrayList.get(25));
        ((Property)fieldList[23]).setValue(5);
        ((Property)fieldList[23]).setColor(Color.BLUE);
    }
    public Field getFieldIndex(int index){
        return fieldList[index];
    }

    public Field[] getFieldList(){
        return this.fieldList;
    }
}
