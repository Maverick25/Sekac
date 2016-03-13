package agency.alterway.sekac.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DDL for the Sekac Database
 *
 * Created by marekrigan on 22/02/16.
 */
public class DDLEstablisher extends SQLiteOpenHelper implements DBConstants
{
    public DDLEstablisher(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(CREATE_TABLE_TREE_CUTS);
        database.execSQL(CREATE_TABLE_PINE_TREE);
        fillPineTreeTable(database);
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {
        database.execSQL("DROP TABLE IF EXISTS " +TABLE_TREE_CUTS);
        database.execSQL("DROP TABLE IF EXISTS " +TABLE_PINE_TREE);
        onCreate(database);
    }

    private void fillPineTreeTable(SQLiteDatabase database)
    {
        ContentValues values = new ContentValues();
        try
        {
            int i = 3;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 2);
            values.put(WIDTH11, 3);
            values.put(WIDTH12, 3);
            values.put(WIDTH13, 4);
            values.put(WIDTH14, 4);
            values.put(WIDTH15, 5);
            values.put(WIDTH16, 6);
            values.put(WIDTH17, 6);
            values.put(WIDTH18, 7);
            values.put(WIDTH19, 8);
            values.put(WIDTH20, 9);
            values.put(WIDTH21, 10);
            values.put(WIDTH22, 11);
            values.put(WIDTH23, 12);
            values.put(WIDTH24, 13);
            values.put(WIDTH25, 14);
            values.put(WIDTH26, 15);
            values.put(WIDTH27, 16);
            values.put(WIDTH28, 17);
            values.put(WIDTH29, 18);
            values.put(WIDTH30, 20);
            values.put(WIDTH31, 21);
            values.put(WIDTH32, 22);
            values.put(WIDTH33, 24);
            values.put(WIDTH34, 25);
            values.put(WIDTH35, 27);
            values.put(WIDTH36, 28);
            values.put(WIDTH37, 30);
            values.put(WIDTH38, 31);
            values.put(WIDTH39, 33);
            values.put(WIDTH40, 35);
            values.put(WIDTH41, 36);
            values.put(WIDTH42, 38);
            values.put(WIDTH43, 40);
            values.put(WIDTH44, 42);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;
            
            values.put(HEIGHT, i);
            values.put(WIDTH10, 3);
            values.put(WIDTH11, 4);
            values.put(WIDTH12, 4);
            values.put(WIDTH13, 5);
            values.put(WIDTH14, 6);
            values.put(WIDTH15, 7);
            values.put(WIDTH16, 7);
            values.put(WIDTH17, 8);
            values.put(WIDTH18, 10);
            values.put(WIDTH19, 11);
            values.put(WIDTH20, 12);
            values.put(WIDTH21, 13);
            values.put(WIDTH22, 14);
            values.put(WIDTH23, 16);
            values.put(WIDTH24, 17);
            values.put(WIDTH25, 18);
            values.put(WIDTH26, 20);
            values.put(WIDTH27, 22);
            values.put(WIDTH28, 23);
            values.put(WIDTH29, 25);
            values.put(WIDTH30, 26);
            values.put(WIDTH31, 28);
            values.put(WIDTH32, 30);
            values.put(WIDTH33, 32);
            values.put(WIDTH34, 34);
            values.put(WIDTH35, 36);
            values.put(WIDTH36, 38);
            values.put(WIDTH37, 40);
            values.put(WIDTH38, 42);
            values.put(WIDTH39, 44);
            values.put(WIDTH40, 46);
            values.put(WIDTH41, 48);
            values.put(WIDTH42, 51);
            values.put(WIDTH43, 53);
            values.put(WIDTH44, 55);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 4);
            values.put(WIDTH11, 4);
            values.put(WIDTH12, 5);
            values.put(WIDTH13, 6);
            values.put(WIDTH14, 7);
            values.put(WIDTH15, 8);
            values.put(WIDTH16, 9);
            values.put(WIDTH17, 11);
            values.put(WIDTH18, 12);
            values.put(WIDTH19, 13);
            values.put(WIDTH20, 15);
            values.put(WIDTH21, 16);
            values.put(WIDTH22, 18);
            values.put(WIDTH23, 20);
            values.put(WIDTH24, 21);
            values.put(WIDTH25, 23);
            values.put(WIDTH26, 25);
            values.put(WIDTH27, 27);
            values.put(WIDTH28, 29);
            values.put(WIDTH29, 31);
            values.put(WIDTH30, 33);
            values.put(WIDTH31, 35);
            values.put(WIDTH32, 37);
            values.put(WIDTH33, 40);
            values.put(WIDTH34, 42);
            values.put(WIDTH35, 44);
            values.put(WIDTH36, 47);
            values.put(WIDTH37, 50);
            values.put(WIDTH38, 52);
            values.put(WIDTH39, 55);
            values.put(WIDTH40, 58);
            values.put(WIDTH41, 60);
            values.put(WIDTH42, 64);
            values.put(WIDTH43, 66);
            values.put(WIDTH44, 69);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 4);
            values.put(WIDTH11, 5);
            values.put(WIDTH12, 6);
            values.put(WIDTH13, 7);
            values.put(WIDTH14, 8);
            values.put(WIDTH15, 10);
            values.put(WIDTH16, 11);
            values.put(WIDTH17, 13);
            values.put(WIDTH18, 14);
            values.put(WIDTH19, 16);
            values.put(WIDTH20, 18);
            values.put(WIDTH21, 20);
            values.put(WIDTH22, 21);
            values.put(WIDTH23, 23);
            values.put(WIDTH24, 26);
            values.put(WIDTH25, 28);
            values.put(WIDTH26, 30);
            values.put(WIDTH27, 32);
            values.put(WIDTH28, 35);
            values.put(WIDTH29, 37);
            values.put(WIDTH30, 40);
            values.put(WIDTH31, 42);
            values.put(WIDTH32, 45);
            values.put(WIDTH33, 48);
            values.put(WIDTH34, 50);
            values.put(WIDTH35, 53);
            values.put(WIDTH36, 56);
            values.put(WIDTH37, 59);
            values.put(WIDTH38, 62);
            values.put(WIDTH39, 66);
            values.put(WIDTH40, 69);
            values.put(WIDTH41, 72);
            values.put(WIDTH42, 76);
            values.put(WIDTH43, 80);
            values.put(WIDTH44, 83);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 5);
            values.put(WIDTH11, 6);
            values.put(WIDTH12, 7);
            values.put(WIDTH13, 8);
            values.put(WIDTH14, 10);
            values.put(WIDTH15, 12);
            values.put(WIDTH16, 13);
            values.put(WIDTH17, 15);
            values.put(WIDTH18, 17);
            values.put(WIDTH19, 19);
            values.put(WIDTH20, 21);
            values.put(WIDTH21, 23);
            values.put(WIDTH22, 25);
            values.put(WIDTH23, 27);
            values.put(WIDTH24, 30);
            values.put(WIDTH25, 32);
            values.put(WIDTH26, 35);
            values.put(WIDTH27, 38);
            values.put(WIDTH28, 40);
            values.put(WIDTH29, 43);
            values.put(WIDTH30, 46);
            values.put(WIDTH31, 49);
            values.put(WIDTH32, 52);
            values.put(WIDTH33, 56);
            values.put(WIDTH34, 59);
            values.put(WIDTH35, 62);
            values.put(WIDTH36, 66);
            values.put(WIDTH37, 69);
            values.put(WIDTH38, 73);
            values.put(WIDTH39, 77);
            values.put(WIDTH40, 81);
            values.put(WIDTH41, 84);
            values.put(WIDTH42, 89);
            values.put(WIDTH43, 93);
            values.put(WIDTH44, 97);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 6);
            values.put(WIDTH11, 7);
            values.put(WIDTH12, 8);
            values.put(WIDTH13, 10);
            values.put(WIDTH14, 11);
            values.put(WIDTH15, 13);
            values.put(WIDTH16, 15);
            values.put(WIDTH17, 17);
            values.put(WIDTH18, 19);
            values.put(WIDTH19, 21);
            values.put(WIDTH20, 24);
            values.put(WIDTH21, 26);
            values.put(WIDTH22, 28);
            values.put(WIDTH23, 31);
            values.put(WIDTH24, 34);
            values.put(WIDTH25, 37);
            values.put(WIDTH26, 40);
            values.put(WIDTH27, 43);
            values.put(WIDTH28, 46);
            values.put(WIDTH29, 49);
            values.put(WIDTH30, 53);
            values.put(WIDTH31, 56);
            values.put(WIDTH32, 60);
            values.put(WIDTH33, 64);
            values.put(WIDTH34, 67);
            values.put(WIDTH35, 71);
            values.put(WIDTH36, 75);
            values.put(WIDTH37, 79);
            values.put(WIDTH38, 83);
            values.put(WIDTH39, 88);
            values.put(WIDTH40, 92);
            values.put(WIDTH41, 97);
            values.put(WIDTH42, 102);
            values.put(WIDTH43, 106);
            values.put(WIDTH44, 111);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 6);
            values.put(WIDTH11, 8);
            values.put(WIDTH12, 9);
            values.put(WIDTH13, 11);
            values.put(WIDTH14, 13);
            values.put(WIDTH15, 15);
            values.put(WIDTH16, 17);
            values.put(WIDTH17, 19);
            values.put(WIDTH18, 21);
            values.put(WIDTH19, 24);
            values.put(WIDTH20, 27);
            values.put(WIDTH21, 29);
            values.put(WIDTH22, 32);
            values.put(WIDTH23, 35);
            values.put(WIDTH24, 38);
            values.put(WIDTH25, 41);
            values.put(WIDTH26, 45);
            values.put(WIDTH27, 48);
            values.put(WIDTH28, 52);
            values.put(WIDTH29, 55);
            values.put(WIDTH30, 59);
            values.put(WIDTH31, 63);
            values.put(WIDTH32, 67);
            values.put(WIDTH33, 72);
            values.put(WIDTH34, 76);
            values.put(WIDTH35, 80);
            values.put(WIDTH36, 85);
            values.put(WIDTH37, 89);
            values.put(WIDTH38, 94);
            values.put(WIDTH39, 99);
            values.put(WIDTH40, 104);
            values.put(WIDTH41, 109);
            values.put(WIDTH42, 114);
            values.put(WIDTH43, 119);
            values.put(WIDTH44, 125);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 7);
            values.put(WIDTH11, 9);
            values.put(WIDTH12, 10);
            values.put(WIDTH13, 12);
            values.put(WIDTH14, 14);
            values.put(WIDTH15, 16);
            values.put(WIDTH16, 19);
            values.put(WIDTH17, 21);
            values.put(WIDTH18, 24);
            values.put(WIDTH19, 27);
            values.put(WIDTH20, 30);
            values.put(WIDTH21, 33);
            values.put(WIDTH22, 36);
            values.put(WIDTH23, 39);
            values.put(WIDTH24, 43);
            values.put(WIDTH25, 46);
            values.put(WIDTH26, 50);
            values.put(WIDTH27, 54);
            values.put(WIDTH28, 58);
            values.put(WIDTH29, 62);
            values.put(WIDTH30, 66);
            values.put(WIDTH31, 70);
            values.put(WIDTH32, 74);
            values.put(WIDTH33, 79);
            values.put(WIDTH34, 84);
            values.put(WIDTH35, 89);
            values.put(WIDTH36, 94);
            values.put(WIDTH37, 99);
            values.put(WIDTH38, 104);
            values.put(WIDTH39, 110);
            values.put(WIDTH40, 115);
            values.put(WIDTH41, 121);
            values.put(WIDTH42, 127);
            values.put(WIDTH43, 133);
            values.put(WIDTH44, 139);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 8);
            values.put(WIDTH11, 10);
            values.put(WIDTH12, 11);
            values.put(WIDTH13, 14);
            values.put(WIDTH14, 16);
            values.put(WIDTH15, 18);
            values.put(WIDTH16, 20);
            values.put(WIDTH17, 23);
            values.put(WIDTH18, 26);
            values.put(WIDTH19, 29);
            values.put(WIDTH20, 32);
            values.put(WIDTH21, 36);
            values.put(WIDTH22, 39);
            values.put(WIDTH23, 43);
            values.put(WIDTH24, 47);
            values.put(WIDTH25, 51);
            values.put(WIDTH26, 55);
            values.put(WIDTH27, 59);
            values.put(WIDTH28, 63);
            values.put(WIDTH29, 68);
            values.put(WIDTH30, 73);
            values.put(WIDTH31, 77);
            values.put(WIDTH32, 82);
            values.put(WIDTH33, 87);
            values.put(WIDTH34, 92);
            values.put(WIDTH35, 98);
            values.put(WIDTH36, 103);
            values.put(WIDTH37, 109);
            values.put(WIDTH38, 114);
            values.put(WIDTH39, 121);
            values.put(WIDTH40, 127);
            values.put(WIDTH41, 133);
            values.put(WIDTH42, 140);
            values.put(WIDTH43, 146);
            values.put(WIDTH44, 152);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 9);
            values.put(WIDTH11, 11);
            values.put(WIDTH12, 12);
            values.put(WIDTH13, 15);
            values.put(WIDTH14, 17);
            values.put(WIDTH15, 20);
            values.put(WIDTH16, 22);
            values.put(WIDTH17, 25);
            values.put(WIDTH18, 28);
            values.put(WIDTH19, 32);
            values.put(WIDTH20, 36);
            values.put(WIDTH21, 39);
            values.put(WIDTH22, 43);
            values.put(WIDTH23, 47);
            values.put(WIDTH24, 51);
            values.put(WIDTH25, 55);
            values.put(WIDTH26, 60);
            values.put(WIDTH27, 65);
            values.put(WIDTH28, 69);
            values.put(WIDTH29, 74);
            values.put(WIDTH30, 79);
            values.put(WIDTH31, 84);
            values.put(WIDTH32, 89);
            values.put(WIDTH33, 95);
            values.put(WIDTH34, 101);
            values.put(WIDTH35, 106);
            values.put(WIDTH36, 113);
            values.put(WIDTH37, 119);
            values.put(WIDTH38, 125);
            values.put(WIDTH39, 132);
            values.put(WIDTH40, 138);
            values.put(WIDTH41, 145);
            values.put(WIDTH42, 152);
            values.put(WIDTH43, 159);
            values.put(WIDTH44, 166);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 9);
            values.put(WIDTH11, 12);
            values.put(WIDTH12, 14);
            values.put(WIDTH13, 16);
            values.put(WIDTH14, 19);
            values.put(WIDTH15, 22);
            values.put(WIDTH16, 24);
            values.put(WIDTH17, 28);
            values.put(WIDTH18, 31);
            values.put(WIDTH19, 35);
            values.put(WIDTH20, 38);
            values.put(WIDTH21, 42);
            values.put(WIDTH22, 46);
            values.put(WIDTH23, 51);
            values.put(WIDTH24, 55);
            values.put(WIDTH25, 60);
            values.put(WIDTH26, 65);
            values.put(WIDTH27, 70);
            values.put(WIDTH28, 75);
            values.put(WIDTH29, 80);
            values.put(WIDTH30, 86);
            values.put(WIDTH31, 91);
            values.put(WIDTH32, 97);
            values.put(WIDTH33, 103);
            values.put(WIDTH34, 109);
            values.put(WIDTH35, 115);
            values.put(WIDTH36, 122);
            values.put(WIDTH37, 129);
            values.put(WIDTH38, 135);
            values.put(WIDTH39, 143);
            values.put(WIDTH40, 150);
            values.put(WIDTH41, 157);
            values.put(WIDTH42, 165);
            values.put(WIDTH43, 172);
            values.put(WIDTH44, 180);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 10);
            values.put(WIDTH11, 12);
            values.put(WIDTH12, 14);
            values.put(WIDTH13, 17);
            values.put(WIDTH14, 20);
            values.put(WIDTH15, 23);
            values.put(WIDTH16, 26);
            values.put(WIDTH17, 30);
            values.put(WIDTH18, 33);
            values.put(WIDTH19, 37);
            values.put(WIDTH20, 41);
            values.put(WIDTH21, 46);
            values.put(WIDTH22, 50);
            values.put(WIDTH23, 55);
            values.put(WIDTH24, 60);
            values.put(WIDTH25, 64);
            values.put(WIDTH26, 70);
            values.put(WIDTH27, 76);
            values.put(WIDTH28, 81);
            values.put(WIDTH29, 86);
            values.put(WIDTH30, 92);
            values.put(WIDTH31, 98);
            values.put(WIDTH32, 104);
            values.put(WIDTH33, 111);
            values.put(WIDTH34, 118);
            values.put(WIDTH35, 124);
            values.put(WIDTH36, 132);
            values.put(WIDTH37, 139);
            values.put(WIDTH38, 146);
            values.put(WIDTH39, 154);
            values.put(WIDTH40, 161);
            values.put(WIDTH41, 169);
            values.put(WIDTH42, 178);
            values.put(WIDTH43, 186);
            values.put(WIDTH44, 194);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 11);
            values.put(WIDTH11, 13);
            values.put(WIDTH12, 16);
            values.put(WIDTH13, 18);
            values.put(WIDTH14, 22);
            values.put(WIDTH15, 25);
            values.put(WIDTH16, 28);
            values.put(WIDTH17, 32);
            values.put(WIDTH18, 36);
            values.put(WIDTH19, 40);
            values.put(WIDTH20, 44);
            values.put(WIDTH21, 49);
            values.put(WIDTH22, 53);
            values.put(WIDTH23, 59);
            values.put(WIDTH24, 64);
            values.put(WIDTH25, 69);
            values.put(WIDTH26, 75);
            values.put(WIDTH27, 81);
            values.put(WIDTH28, 86);
            values.put(WIDTH29, 92);
            values.put(WIDTH30, 99);
            values.put(WIDTH31, 105);
            values.put(WIDTH32, 112);
            values.put(WIDTH33, 119);
            values.put(WIDTH34, 126);
            values.put(WIDTH35, 133);
            values.put(WIDTH36, 141);
            values.put(WIDTH37, 148);
            values.put(WIDTH38, 156);
            values.put(WIDTH39, 165);
            values.put(WIDTH40, 173);
            values.put(WIDTH41, 181);
            values.put(WIDTH42, 190);
            values.put(WIDTH43, 199);
            values.put(WIDTH44, 208);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 12);
            values.put(WIDTH11, 14);
            values.put(WIDTH12, 17);
            values.put(WIDTH13, 20);
            values.put(WIDTH14, 23);
            values.put(WIDTH15, 26);
            values.put(WIDTH16, 30);
            values.put(WIDTH17, 34);
            values.put(WIDTH18, 38);
            values.put(WIDTH19, 42);
            values.put(WIDTH20, 47);
            values.put(WIDTH21, 52);
            values.put(WIDTH22, 57);
            values.put(WIDTH23, 62);
            values.put(WIDTH24, 68);
            values.put(WIDTH25, 74);
            values.put(WIDTH26, 80);
            values.put(WIDTH27, 86);
            values.put(WIDTH28, 92);
            values.put(WIDTH29, 99);
            values.put(WIDTH30, 106);
            values.put(WIDTH31, 112);
            values.put(WIDTH32, 119);
            values.put(WIDTH33, 127);
            values.put(WIDTH34, 134);
            values.put(WIDTH35, 142);
            values.put(WIDTH36, 150);
            values.put(WIDTH37, 158);
            values.put(WIDTH38, 166);
            values.put(WIDTH39, 176);
            values.put(WIDTH40, 184);
            values.put(WIDTH41, 193);
            values.put(WIDTH42, 203);
            values.put(WIDTH43, 212);
            values.put(WIDTH44, 222);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 12);
            values.put(WIDTH11, 15);
            values.put(WIDTH12, 18);
            values.put(WIDTH13, 21);
            values.put(WIDTH14, 24);
            values.put(WIDTH15, 28);
            values.put(WIDTH16, 32);
            values.put(WIDTH17, 36);
            values.put(WIDTH18, 40);
            values.put(WIDTH19, 45);
            values.put(WIDTH20, 50);
            values.put(WIDTH21, 56);
            values.put(WIDTH22, 61);
            values.put(WIDTH23, 66);
            values.put(WIDTH24, 72);
            values.put(WIDTH25, 78);
            values.put(WIDTH26, 85);
            values.put(WIDTH27, 92);
            values.put(WIDTH28, 98);
            values.put(WIDTH29, 105);
            values.put(WIDTH30, 112);
            values.put(WIDTH31, 119);
            values.put(WIDTH32, 127);
            values.put(WIDTH33, 135);
            values.put(WIDTH34, 143);
            values.put(WIDTH35, 151);
            values.put(WIDTH36, 160);
            values.put(WIDTH37, 168);
            values.put(WIDTH38, 177);
            values.put(WIDTH39, 187);
            values.put(WIDTH40, 196);
            values.put(WIDTH41, 205);
            values.put(WIDTH42, 216);
            values.put(WIDTH43, 226);
            values.put(WIDTH44, 236);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 13);
            values.put(WIDTH11, 16);
            values.put(WIDTH12, 19);
            values.put(WIDTH13, 22);
            values.put(WIDTH14, 26);
            values.put(WIDTH15, 30);
            values.put(WIDTH16, 34);
            values.put(WIDTH17, 38);
            values.put(WIDTH18, 43);
            values.put(WIDTH19, 48);
            values.put(WIDTH20, 53);
            values.put(WIDTH21, 59);
            values.put(WIDTH22, 64);
            values.put(WIDTH23, 70);
            values.put(WIDTH24, 77);
            values.put(WIDTH25, 83);
            values.put(WIDTH26, 90);
            values.put(WIDTH27, 97);
            values.put(WIDTH28, 104);
            values.put(WIDTH29, 111);
            values.put(WIDTH30, 119);
            values.put(WIDTH31, 126);
            values.put(WIDTH32, 134);
            values.put(WIDTH33, 143);
            values.put(WIDTH34, 151);
            values.put(WIDTH35, 160);
            values.put(WIDTH36, 169);
            values.put(WIDTH37, 178);
            values.put(WIDTH38, 187);
            values.put(WIDTH39, 198);
            values.put(WIDTH40, 207);
            values.put(WIDTH41, 217);
            values.put(WIDTH42, 228);
            values.put(WIDTH43, 239);
            values.put(WIDTH44, 249);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 14);
            values.put(WIDTH11, 17);
            values.put(WIDTH12, 20);
            values.put(WIDTH13, 23);
            values.put(WIDTH14, 27);
            values.put(WIDTH15, 31);
            values.put(WIDTH16, 35);
            values.put(WIDTH17, 40);
            values.put(WIDTH18, 45);
            values.put(WIDTH19, 50);
            values.put(WIDTH20, 56);
            values.put(WIDTH21, 62);
            values.put(WIDTH22, 68);
            values.put(WIDTH23, 74);
            values.put(WIDTH24, 81);
            values.put(WIDTH25, 87);
            values.put(WIDTH26, 95);
            values.put(WIDTH27, 102);
            values.put(WIDTH28, 110);
            values.put(WIDTH29, 117);
            values.put(WIDTH30, 125);
            values.put(WIDTH31, 133);
            values.put(WIDTH32, 142);
            values.put(WIDTH33, 151);
            values.put(WIDTH34, 160);
            values.put(WIDTH35, 168);
            values.put(WIDTH36, 179);
            values.put(WIDTH37, 188);
            values.put(WIDTH38, 198);
            values.put(WIDTH39, 209);
            values.put(WIDTH40, 219);
            values.put(WIDTH41, 229);
            values.put(WIDTH42, 241);
            values.put(WIDTH43, 252);
            values.put(WIDTH44, 263);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 14);
            values.put(WIDTH11, 18);
            values.put(WIDTH12, 21);
            values.put(WIDTH13, 24);
            values.put(WIDTH14, 29);
            values.put(WIDTH15, 33);
            values.put(WIDTH16, 37);
            values.put(WIDTH17, 42);
            values.put(WIDTH18, 48);
            values.put(WIDTH19, 53);
            values.put(WIDTH20, 59);
            values.put(WIDTH21, 65);
            values.put(WIDTH22, 71);
            values.put(WIDTH23, 78);
            values.put(WIDTH24, 85);
            values.put(WIDTH25, 92);
            values.put(WIDTH26, 100);
            values.put(WIDTH27, 108);
            values.put(WIDTH28, 115);
            values.put(WIDTH29, 123);
            values.put(WIDTH30, 132);
            values.put(WIDTH31, 140);
            values.put(WIDTH32, 149);
            values.put(WIDTH33, 159);
            values.put(WIDTH34, 168);
            values.put(WIDTH35, 177);
            values.put(WIDTH36, 188);
            values.put(WIDTH37, 198);
            values.put(WIDTH38, 208);
            values.put(WIDTH39, 220);
            values.put(WIDTH40, 230);
            values.put(WIDTH41, 241);
            values.put(WIDTH42, 254);
            values.put(WIDTH43, 265);
            values.put(WIDTH44, 277);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 15);
            values.put(WIDTH11, 18);
            values.put(WIDTH12, 22);
            values.put(WIDTH13, 26);
            values.put(WIDTH14, 30);
            values.put(WIDTH15, 35);
            values.put(WIDTH16, 39);
            values.put(WIDTH17, 44);
            values.put(WIDTH18, 50);
            values.put(WIDTH19, 56);
            values.put(WIDTH20, 62);
            values.put(WIDTH21, 69);
            values.put(WIDTH22, 75);
            values.put(WIDTH23, 82);
            values.put(WIDTH24, 90);
            values.put(WIDTH25, 97);
            values.put(WIDTH26, 105);
            values.put(WIDTH27, 113);
            values.put(WIDTH28, 121);
            values.put(WIDTH29, 129);
            values.put(WIDTH30, 139);
            values.put(WIDTH31, 147);
            values.put(WIDTH32, 156);
            values.put(WIDTH33, 167);
            values.put(WIDTH34, 176);
            values.put(WIDTH35, 186);
            values.put(WIDTH36, 197);
            values.put(WIDTH37, 208);
            values.put(WIDTH38, 219);
            values.put(WIDTH39, 231);
            values.put(WIDTH40, 242);
            values.put(WIDTH41, 253);
            values.put(WIDTH42, 267);
            values.put(WIDTH43, 279);
            values.put(WIDTH44, 291);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 16);
            values.put(WIDTH11, 19);
            values.put(WIDTH12, 23);
            values.put(WIDTH13, 27);
            values.put(WIDTH14, 32);
            values.put(WIDTH15, 36);
            values.put(WIDTH16, 41);
            values.put(WIDTH17, 46);
            values.put(WIDTH18, 52);
            values.put(WIDTH19, 58);
            values.put(WIDTH20, 65);
            values.put(WIDTH21, 72);
            values.put(WIDTH22, 78);
            values.put(WIDTH23, 86);
            values.put(WIDTH24, 94);
            values.put(WIDTH25, 101);
            values.put(WIDTH26, 110);
            values.put(WIDTH27, 119);
            values.put(WIDTH28, 127);
            values.put(WIDTH29, 135);
            values.put(WIDTH30, 145);
            values.put(WIDTH31, 154);
            values.put(WIDTH32, 164);
            values.put(WIDTH33, 175);
            values.put(WIDTH34, 185);
            values.put(WIDTH35, 195);
            values.put(WIDTH36, 207);
            values.put(WIDTH37, 218);
            values.put(WIDTH38, 229);
            values.put(WIDTH39, 242);
            values.put(WIDTH40, 253);
            values.put(WIDTH41, 266);
            values.put(WIDTH42, 279);
            values.put(WIDTH43, 292);
            values.put(WIDTH44, 305);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 17);
            values.put(WIDTH11, 20);
            values.put(WIDTH12, 24);
            values.put(WIDTH13, 28);
            values.put(WIDTH14, 33);
            values.put(WIDTH15, 38);
            values.put(WIDTH16, 43);
            values.put(WIDTH17, 49);
            values.put(WIDTH18, 55);
            values.put(WIDTH19, 61);
            values.put(WIDTH20, 68);
            values.put(WIDTH21, 75);
            values.put(WIDTH22, 82);
            values.put(WIDTH23, 90);
            values.put(WIDTH24, 98);
            values.put(WIDTH25, 106);
            values.put(WIDTH26, 115);
            values.put(WIDTH27, 124);
            values.put(WIDTH28, 133);
            values.put(WIDTH29, 142);
            values.put(WIDTH30, 152);
            values.put(WIDTH31, 161);
            values.put(WIDTH32, 171);
            values.put(WIDTH33, 183);
            values.put(WIDTH34, 193);
            values.put(WIDTH35, 204);
            values.put(WIDTH36, 216);
            values.put(WIDTH37, 228);
            values.put(WIDTH38, 239);
            values.put(WIDTH39, 253);
            values.put(WIDTH40, 265);
            values.put(WIDTH41, 278);
            values.put(WIDTH42, 292);
            values.put(WIDTH43, 305);
            values.put(WIDTH44, 319);

            database.insert(TABLE_PINE_TREE, null, values);
            i++;

            values.put(HEIGHT, i);
            values.put(WIDTH10, 17);
            values.put(WIDTH11, 21);
            values.put(WIDTH12, 25);
            values.put(WIDTH13, 30);
            values.put(WIDTH14, 34);
            values.put(WIDTH15, 40);
            values.put(WIDTH16, 45);
            values.put(WIDTH17, 51);
            values.put(WIDTH18, 57);
            values.put(WIDTH19, 64);
            values.put(WIDTH20, 71);
            values.put(WIDTH21, 78);
            values.put(WIDTH22, 86);
            values.put(WIDTH23, 94);
            values.put(WIDTH24, 102);
            values.put(WIDTH25, 110);
            values.put(WIDTH26, 120);
            values.put(WIDTH27, 129);
            values.put(WIDTH28, 138);
            values.put(WIDTH29, 148);
            values.put(WIDTH30, 159);
            values.put(WIDTH31, 169);
            values.put(WIDTH32, 179);
            values.put(WIDTH33, 191);
            values.put(WIDTH34, 202);
            values.put(WIDTH35, 213);
            values.put(WIDTH36, 226);
            values.put(WIDTH37, 238);
            values.put(WIDTH38, 250);
            values.put(WIDTH39, 264);
            values.put(WIDTH40, 277);
            values.put(WIDTH41, 290);
            values.put(WIDTH42, 305);
            values.put(WIDTH43, 318);
            values.put(WIDTH44, 333);

            database.insert(TABLE_PINE_TREE, null, values);

            values.put(HEIGHT, i + 1);
            values.put(WIDTH10, 18);
            values.put(WIDTH11, 22);
            values.put(WIDTH12, 26);
            values.put(WIDTH13, 31);
            values.put(WIDTH14, 36);
            values.put(WIDTH15, 41);
            values.put(WIDTH16, 47);
            values.put(WIDTH17, 53);
            values.put(WIDTH18, 59);
            values.put(WIDTH19, 66);
            values.put(WIDTH20, 74);
            values.put(WIDTH21, 82);
            values.put(WIDTH22, 89);
            values.put(WIDTH23, 98);
            values.put(WIDTH24, 107);
            values.put(WIDTH25, 115);
            values.put(WIDTH26, 125);
            values.put(WIDTH27, 135);
            values.put(WIDTH28, 144);
            values.put(WIDTH29, 154);
            values.put(WIDTH30, 165);
            values.put(WIDTH31, 176);
            values.put(WIDTH32, 186);
            values.put(WIDTH33, 199);
            values.put(WIDTH34, 210);
            values.put(WIDTH35, 222);
            values.put(WIDTH36, 235);
            values.put(WIDTH37, 247);
            values.put(WIDTH38, 260);
            values.put(WIDTH39, 275);
            values.put(WIDTH40, 288);
            values.put(WIDTH41, 302);
            values.put(WIDTH42, 317);
            values.put(WIDTH43, 332);
            values.put(WIDTH44, 346);

            database.insert(TABLE_PINE_TREE, null, values);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

