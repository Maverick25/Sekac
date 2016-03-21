package agency.alterway.sekac.controllers;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
    private static final String ACCESS_TOKEN = "Hbm6EwWgYu4AAAAAAAAL8rfitsCPW1mvQzJ1FbovWRN_RE0HWfrCgN-Hnp7H1mZ5";
    private static FileController instance;
    private static Injection injection;
    private DbxClientV2 client;

    private FileController(Injection injection)
    {
        FileController.injection = injection;

        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
         client = new DbxClientV2(config, ACCESS_TOKEN);
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

    public void exportToCSV(Date selectedDate, List<Cut> treeCuts, Summary summary)
    {
        File exportDir = new File(Environment.getExternalStorageDirectory(), "sekac_poznamky");

        if (!exportDir.exists() && !exportDir.mkdirs())
        {
            injection.onUploadedSheet("Súbor nie je dostupný");
        }

        try
        {
            String filename = "sekac_" + DateHandler.fileFormatter.format(selectedDate) + ".csv";
            File file = new File(exportDir.getAbsolutePath()+"/"+filename);

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
                            "", "Pocet", "Kubiky","Hmota"
                    });

            data.add(new String[]
                    {
                            "", summary.getFormattedNoOfCuts(), summary.getFormattedVolume(), summary.getFormattedMatter()
                    });

            writer.writeAll(data);

            writer.close();

            DropboxUploader uploader = new DropboxUploader();
            uploader.execute(filename, file.getAbsolutePath());
        }
        catch (Exception sqlEx)
        {
            sqlEx.printStackTrace();
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
            injection.onUploadedSheet("Niekde sa stala chyba");
        }
    }


    private class DropboxUploader extends AsyncTask<String, Void, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params)
        {
            // Upload "test.txt" to Dropbox
            try
            {
                String filename = params[0];
                String path = params[1];

                client.files().delete("/"+filename);

                InputStream in = new FileInputStream(path);
                client.files().uploadBuilder("/"+filename).uploadAndFinish(in);

                return true;
            }
            catch (DbxException | IOException e)
            {
                e.printStackTrace();

                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success)
        {
            if(success)
            {
                injection.onUploadedSheet("Súbor bol úspešne vytvorený");
            }
            else
            {
                injection.onUploadedSheet("Chyba nastala pri uložení do Dropboxu");
            }
        }
    }

}
