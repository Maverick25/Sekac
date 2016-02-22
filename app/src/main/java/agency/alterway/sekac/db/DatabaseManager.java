package agency.alterway.sekac.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import agency.alterway.sekac.models.Cut;
import agency.alterway.sekac.models.DayData;

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

//    private void createDayData(Date selectedDate, Cut cut) throws
//                                                               SQLException
//    {
//        ContentValues values = new ContentValues();
//
//        values.put(DAY_DATE, formatter.format(selectedDate));
//
//        if (cut != null)
//        {
//            values.put(DAY_VOLUME, cut.getVolume());
//            values.put(DAY_CUTS, 1);
//        }
//        else
//        {
//            values.put(DAY_VOLUME, 0);
//            values.put(DAY_CUTS, 0);
//        }
//
//        database.insert(TABLE_DAYS_DATA, null, values);
//    }

    private boolean deleteAllTreeCuts() throws SQLException
    {
        return database.delete(TABLE_TREE_CUTS, null, null) == 1;
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

    private void updateDayData(Date date, Cut cut, DayData dayData) throws SQLException
    {
        ContentValues values = new ContentValues();

        values.put("day_cuts", dayData.getNoOfCuts() + 1);
        values.put("day_volume", dayData.getVolume() + cut.getVolume());

        database.update("table_days_data", values, "day_date = ?", new String[] { formatter.format(date) });
    }

    public long addTreeCut(Cut cut) throws SQLException, ParseException
    {
//        DayData localDayData = getDayData(selectedDate);

//        if (localDayData == null)
//        {
//            deleteAllTreeCuts();
//            createDayData(selectedDate, cut);
//        }

        ContentValues values = new ContentValues();

        values.put("cut_width", cut.getWidth());
        values.put("cut_height", cut.getHeight());
        values.put("cut_volume", cut.getVolume());

//        updateDayData(selectedDate, cut, localDayData);

        return database.insert(TABLE_TREE_CUTS, null, values);
    }

    public DayData getDayData(Date date) throws SQLException,ParseException
    {
        DayData dayData = null;

        Cursor cursor = database.query(true, "table_days_data", null, "day_date = ?", new String[] { formatter.format(date) }, null, null, null, null);

        if (cursor.moveToFirst())
        {
            dayData = new DayData(formatter.parse(cursor.getString(0)), cursor.getInt(1), cursor.getInt(2));

            cursor.close();
        }
        return dayData;
    }

//    public List<DayData> getDayDatasForMonth(MonthData monthData) throws SQLException,ParseException
//    {
//        List<DayData> days = new ArrayList<>();
//
//        Cursor cursor = database.rawQuery("SELECT * FROM "+ TABLE_DAYS_DATA +" WHERE STRFTIME('%m',"+ DAY_DATE +") = ? AND STRFTIME('%Y',"+ DAY_DATE +") = ?", new String[] { String.valueOf(monthData.getMonthCode() + 1), String.valueOf(monthData.getYearCode()) });
//
//        if(cursor.moveToFirst())
//        {
//            do
//            {
//                days.add(new DayData(formatter.parse(cursor.getString(0)),cursor.getInt(1),cursor.getInt(2)));
//            } while(cursor.moveToNext());
//
//            cursor.close();
//        }
//
//        return days;
//    }

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

    public boolean removeCut(Cut cut)
    {
        return database.delete(TABLE_TREE_CUTS, CUT_ID+" = ?",new String[]{String.valueOf(cut.getId())}) == 1;
    }

//    public List<MonthData> getWorkingMonths() throws SQLException,ParseException
//    {
//        List<MonthData> months = new ArrayList<>();
//
//        Cursor cursor = database.query(true, TABLE_DAYS_DATA, new String[] { DAY_DATE }, null, null, null, null, null, null);
//
//        if (cursor.moveToFirst())
//        {
//            String monthName = "";
//
//            do
//            {
//                Date monthDate = formatter.parse(cursor.getString(0));
//
//                Calendar monthCalendar = Calendar.getInstance();
//                monthCalendar.setTime(monthDate);
//
//                if (!monthName.equals(monthFormatter.format(monthDate)))
//                {
//                    int monthCode = monthCalendar.get(Calendar.MONTH);
//                    int yearCode = monthCalendar.get(Calendar.YEAR);
//
//                    monthName = monthFormatter.format(monthDate);
//
//                    months.add(new MonthData(monthCode, yearCode, monthName));
//                }
//
//            } while (cursor.moveToNext());
//
//            cursor.close();
//        }
//
//        return months;
//    }
}

