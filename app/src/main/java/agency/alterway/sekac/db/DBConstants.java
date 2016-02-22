package agency.alterway.sekac.db;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Interface for helping DDL
 *
 * Created by marekrigan on 22/02/16.
 */
public interface DBConstants
{
    String CUT_HEIGHT = "cut_height";
    String CUT_ID = "cut_id";
    String CUT_VOLUME = "cut_volume";
    String CUT_WIDTH = "cut_width";

    String DATABASE_NAME = "sekac.db";
    int DATABASE_VERSION = 1;

//    String TABLE_DAYS_DATA = "table_days_data";
    String TABLE_PINE_TREE = "table_pine_tree";
    String TABLE_TREE_CUTS = "table_tree_cuts";

    String HEIGHT = "HEIGHT";
    String WIDTH10 = "WIDTH10";
    String WIDTH11 = "WIDTH11";
    String WIDTH12 = "WIDTH12";
    String WIDTH13 = "WIDTH13";
    String WIDTH14 = "WIDTH14";
    String WIDTH15 = "WIDTH15";
    String WIDTH16 = "WIDTH16";
    String WIDTH17 = "WIDTH17";
    String WIDTH18 = "WIDTH18";
    String WIDTH19 = "WIDTH19";
    String WIDTH20 = "WIDTH20";
    String WIDTH21 = "WIDTH21";
    String WIDTH22 = "WIDTH22";
    String WIDTH23 = "WIDTH23";
    String WIDTH24 = "WIDTH24";
    String WIDTH25 = "WIDTH25";
    String WIDTH26 = "WIDTH26";
    String WIDTH27 = "WIDTH27";
    String WIDTH28 = "WIDTH28";
    String WIDTH29 = "WIDTH29";
    String WIDTH30 = "WIDTH30";
    String WIDTH31 = "WIDTH31";
    String WIDTH32 = "WIDTH32";
    String WIDTH33 = "WIDTH33";
    String WIDTH34 = "WIDTH34";
    String WIDTH35 = "WIDTH35";
    String WIDTH36 = "WIDTH36";
    String WIDTH37 = "WIDTH37";
    String WIDTH38 = "WIDTH38";
    String WIDTH39 = "WIDTH39";
    String WIDTH40 = "WIDTH40";
    String WIDTH41 = "WIDTH41";
    String WIDTH42 = "WIDTH42";
    String WIDTH43 = "WIDTH43";
    String WIDTH44 = "WIDTH44";

    SimpleDateFormat formatter      = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat monthFormatter = new SimpleDateFormat("MMM yyyy", Locale.getDefault());

    String CREATE_TABLE_PINE_TREE = "CREATE TABLE "+ TABLE_PINE_TREE +"("+
            HEIGHT +" INTEGER NOT NULL," +
            WIDTH10 + " INTEGER NOT NULL," +
            WIDTH11 + " INTEGER NOT NULL," +
            WIDTH12 + " INTEGER NOT NULL," +
            WIDTH13 + " INTEGER NOT NULL," +
            WIDTH14 + " INTEGER NOT NULL," +
            WIDTH15 + " INTEGER NOT NULL," +
            WIDTH16 + " INTEGER NOT NULL," +
            WIDTH17 + " INTEGER NOT NULL," +
            WIDTH18 + " INTEGER NOT NULL," +
            WIDTH19 + " INTEGER NOT NULL," +
            WIDTH20 + " INTEGER NOT NULL," +
            WIDTH21 + " INTEGER NOT NULL," +
            WIDTH22 + " INTEGER NOT NULL," +
            WIDTH23 + " INTEGER NOT NULL," +
            WIDTH24 + " INTEGER NOT NULL," +
            WIDTH25 + " INTEGER NOT NULL," +
            WIDTH26 + " INTEGER NOT NULL," +
            WIDTH27 + " INTEGER NOT NULL," +
            WIDTH28 + " INTEGER NOT NULL," +
            WIDTH29 + " INTEGER NOT NULL," +
            WIDTH30 + " INTEGER NOT NULL," +
            WIDTH31 + " INTEGER NOT NULL," +
            WIDTH32 + " INTEGER NOT NULL," +
            WIDTH33 + " INTEGER NOT NULL," +
            WIDTH34 + " INTEGER NOT NULL," +
            WIDTH35 + " INTEGER NOT NULL," +
            WIDTH36 + " INTEGER NOT NULL," +
            WIDTH37 + " INTEGER NOT NULL," +
            WIDTH38 + " INTEGER NOT NULL," +
            WIDTH39 + " INTEGER NOT NULL," +
            WIDTH40 + " INTEGER NOT NULL," +
            WIDTH41 + " INTEGER NOT NULL," +
            WIDTH42 + " INTEGER NOT NULL," +
            WIDTH43 + " INTEGER NOT NULL," +
            WIDTH44 + " INTEGER NOT NULL)";

//    String CREATE_TABLE_DAYS_DATA = "CREATE TABLE "+ TABLE_DAYS_DATA +"(" +
//            DAY_DATE + " DATETIME DEFAULT CURRENT_DATE PRIMARY KEY," +
//            DAY_VOLUME + " INTEGER NOT NULL," +
//            DAY_CUTS + " INTEGER NOT NULL)";

    String CREATE_TABLE_TREE_CUTS = "CREATE TABLE "+ TABLE_TREE_CUTS +"(" +
            CUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CUT_WIDTH + " INTEGER NOT NULL," +
            CUT_HEIGHT + " INTEGER NOT NULL," +
            CUT_VOLUME + " INTEGER NOT NULL)";
}
