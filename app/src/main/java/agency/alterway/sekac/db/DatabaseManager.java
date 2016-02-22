package agency.alterway.sekac.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import agency.alterway.sekac.models.Cut;
import agency.alterway.sekac.models.Summary;

/**
 * Manager to handle all database actions
 *
 * Created by marekrigan on 22/02/16.
 */
public class DatabaseManager implements DBConstants
{
    private static SQLiteDatabase  database;
    private static DDLEstablisher  ddl;
    private static DatabaseManager instance;

    private DatabaseManager(Context context)
    {
        ddl = new DDLEstablisher(context);
    }

    public static void close()
    {
        if (ddl != null)
        {
            ddl.close();
        }
    }

    public static DatabaseManager getInstance(Context paramContext)
    {
        if (instance == null)
        {
            instance = new DatabaseManager(paramContext);
        }
        if ((database == null) || (!database.isOpen()))
        {
            open();
        }
        return instance;
    }

    private static void open() throws SQLException
    {
        database = ddl.getWritableDatabase();
    }

    public long addTreeCut(Cut cut) throws SQLException, ParseException
    {
        ContentValues values = new ContentValues();

        values.put("cut_width", cut.getWidth());
        values.put("cut_height", cut.getHeight());
        values.put("cut_volume", cut.getVolume());


        return database.insert(TABLE_TREE_CUTS, null, values);
    }

    public int getPineVolume(int width, int height) throws SQLException
    {
        int volume = -1;

        Cursor cursor = database.query(true, TABLE_PINE_TREE, new String[] { "WIDTH" + width }, HEIGHT+" = ?", new String[] { String.valueOf(height) }, null, null, null, null);

        if (cursor.moveToFirst())
        {
            volume = cursor.getInt(0);
            cursor.close();
        }

        return volume;
    }

    public List<Cut> getTreeCuts() throws SQLException
    {
        List<Cut> treeCuts = new ArrayList<>();

        Cursor cursor = database.query(true, TABLE_TREE_CUTS, null, null, null, null, null, null, null);

        if (cursor.moveToFirst())
        {
            do
            {
                treeCuts.add(new Cut(cursor.getLong(0), cursor.getInt(1),  cursor.getInt(2), cursor.getInt(3)));
            } while (cursor.moveToNext());

            cursor.close();
        }

        return treeCuts;
    }

    public Summary getDaySummary()
    {
        Summary daySummary = new Summary();

        Cursor cursor = database.query(true, TABLE_TREE_CUTS, null, null, null, null, null, null, null);
            daySummary.setNoOfCuts(cursor.getCount());
        cursor.close();

        cursor = database.rawQuery("SELECT SUM("+CUT_HEIGHT+") FROM "+TABLE_TREE_CUTS, null);

            daySummary.setTotalHeight(cursor.getInt(0));
        cursor.close();

        cursor = database.rawQuery("SELECT SUM("+CUT_WIDTH+") FROM "+TABLE_TREE_CUTS, null);
            daySummary.setTotalWidth(cursor.getInt(0));
        cursor.close();

        cursor = database.rawQuery("SELECT SUM("+CUT_VOLUME+") FROM "+TABLE_TREE_CUTS, null);
            daySummary.setTotalWidth(cursor.getInt(0));
        cursor.close();

        return daySummary;
    }

    public boolean removeCut(Cut cut)
    {
        return database.delete(TABLE_TREE_CUTS, CUT_ID+" = ?",new String[]{String.valueOf(cut.getId())}) == 1;
    }

    public boolean removeAllCuts() throws SQLException
    {
        return database.delete(TABLE_TREE_CUTS, null, null) == 1;
    }
}

