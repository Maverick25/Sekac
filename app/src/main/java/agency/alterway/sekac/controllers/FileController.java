package agency.alterway.sekac.controllers;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import agency.alterway.sekac.injections.Injection;
import agency.alterway.sekac.models.Cut;
import agency.alterway.sekac.models.Summary;
import agency.alterway.sekac.utils.DateHandler;
import au.com.bytecode.opencsv.CSVWriter;

/**
 *
 *
 * Created by marekrigan on 13/03/16.
 */
public class FileController
{
    private static FileController instance;
    private static Injection injection;

    private FileController(Injection injection)
    {
        FileController.injection = injection;
    }

    public static FileController getInstance(Injection injection)
    {
        if (instance == null)
        {
            instance = new FileController(injection);
        }
        else
        {
            FileController.injection = injection;
        }

        return instance;
    }


    public String exportToCSV(Date selectedDate, List<Cut> treeCuts, Summary summary)
    {
        File exportDir = new File(Environment.getExternalStorageDirectory(), "sekac_poznamky");

        boolean folderCreated = true;
        if (!exportDir.exists() && !exportDir.mkdirs())
        {
            return "Súbor nie je dostupný";
        }

        try
        {
            File file = new File(exportDir.getAbsolutePath()+"/sekac_" + DateHandler.fileFormatter.format(selectedDate) + ".csv");

            if (file.exists())
            {
                file.delete();
            }

                CSVWriter writer = new CSVWriter(new FileWriter(file));

                List<String[]> data = new ArrayList<>();
                data.add(new String[]{DateHandler.formatter.format(selectedDate)});

//                data.add(new String[]{"Číslo","Dĺžka","Šírka","Kubíky"});
                data.add(new String[]{"Cislo","Dlzka","Sirka","Kubiky"});


                for (int i=1; i<= treeCuts.size(); i++)
                {
                    int j = i-1;
                    data.add(new String[]
                            {
                                    String.valueOf(i),
                                    treeCuts.get(j).getFormattedHeight(),
                                    treeCuts.get(j).getFormattedWidth(),
                                    treeCuts.get(j).getFormattedVolume()
                            });
                }

                data.add(new String[]{});

                data.add(new String[]
                        {
//                                "", "Počet", "Spolu Kubíky","Spolu Hmota"
                                "", "Pocet", "Spolu Kubiky","Spolu Hmota"
                        });

                data.add(new String[]
                        {
                                "", summary.getFormattedNoOfCuts(), summary.getFormattedVolume(), summary.getFormattedMatter()
                        });

                writer.writeAll(data);

                writer.close();

            return "Súbor bol úspešne vytvorený";
        }
        catch (Exception sqlEx)
        {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
            return "Niekde sa stala chyba";
        }
    }


}
