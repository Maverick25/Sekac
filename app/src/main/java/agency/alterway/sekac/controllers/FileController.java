package agency.alterway.sekac.controllers;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DeleteErrorException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

/**
 * Created by marekrigan on 13/03/16.
 */
public class FileController {
    private static final String ACCESS_TOKEN = "FjfD2Q141IAAAAAAAAAAC8T1RnH7tMQhcu1nIX2uXKU7uov8oDKKt-9FdE_J6lq5";
    private static FileController instance;
    private static Injection injection;
    private DbxClientV2 client;

    private FileController(Injection injection) {
        FileController.injection = injection;

        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    public static FileController getInstance(Injection injection) {
        if (instance == null) {
            instance = new FileController(injection);
        } else {
            FileController.injection = injection;
        }

        return instance;
    }

    private File convertToXLS(String filename, String path, File exportDir) throws IOException {
        Workbook wb = new HSSFWorkbook();
        CreationHelper helper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Sekáč Tabuľka");

        CSVReader reader = new CSVReader(new FileReader(path));

        String[] line;
        int r = 0;
        while ((line = reader.readNext()) != null) {
            Row row = sheet.createRow((short) r++);

            for (int i = 0; i < line.length; i++)
                row.createCell(i)
                        .setCellValue(helper.createRichTextString(line[i]));
        }

        // Write the output to a file
        File excelFile = new File(exportDir, filename + ".xls");
        FileOutputStream fileOut = new FileOutputStream(excelFile);
        wb.write(fileOut);
        fileOut.close();

        return excelFile;
    }

    public void exportToDisk(boolean isFinishingDay, Date selectedDate, List<Cut> treeCuts, Summary summary) {
        File exportDir = new File(Environment.getExternalStorageDirectory(), "sekac_poznamky");

        if (!exportDir.exists() && !exportDir.mkdirs()) {
            injection.onUploadedSheet(false, "Súbor nie je dostupný", isFinishingDay);
        }

        try {
            String filename = "sekac_" + DateHandler.fileFormatter.format(selectedDate);
            File file = new File(exportDir.getAbsolutePath() + "/" + filename + ".csv");

            CSVWriter writer = new CSVWriter(new FileWriter(file));

            List<String[]> data = new ArrayList<>();
            data.add(new String[]{DateHandler.formatter.format(selectedDate)});

//                data.add(new String[]{"Číslo","Dĺžka","Šírka","Kubíky"});
            data.add(new String[]{"Cislo", "Dlzka", "Sirka", "Kubiky"});


            for (int i = 1; i <= treeCuts.size(); i++) {
                int j = i - 1;
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
                            "", "Pocet", "Kubiky", "Hmota"
                    });

            data.add(new String[]
                    {
                            "", summary.getFormattedNoOfCuts(), summary.getFormattedVolume(), summary.getFormattedMatter()
                    });

            writer.writeAll(data);

            writer.close();

            File excelFile = convertToXLS(filename, file.getAbsolutePath(), exportDir);

            DropboxUploader uploader = new DropboxUploader(isFinishingDay);
            uploader.execute(excelFile);
        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
            injection.onUploadedSheet(false, "Niekde sa stala chyba", isFinishingDay);
        }
    }


    @SuppressLint("StaticFieldLeak")
    private class DropboxUploader extends AsyncTask<File, Void, Boolean> {
        private boolean isFinishingDay;

        DropboxUploader(boolean isFinishingDay) {
            this.isFinishingDay = isFinishingDay;
        }

        @Override
        protected Boolean doInBackground(File... params) {
            try {
                File excelFile = params[0];

                try {
                    client.files().delete("/" + excelFile.getName());
                } catch (DeleteErrorException | NoSuchMethodError e) {
                    e.printStackTrace();
                }

                InputStream in = new FileInputStream(excelFile.getAbsolutePath());
                client.files().uploadBuilder("/" + excelFile.getName()).uploadAndFinish(in);

                return true;
            } catch (DbxException | IOException e) {
                e.printStackTrace();

                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                injection.onUploadedSheet(true, "Súbor bol úspešne vytvorený", isFinishingDay);
            } else {
                injection.onUploadedSheet(false, "Súbor bol úspešne vytvorený na telefóne ale chyba nastala pri uložení do Dropboxu", isFinishingDay);
            }
        }
    }

}
