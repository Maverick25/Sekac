package agency.alterway.sekac.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Date Formatters
 *
 * Created by marekrigan on 13/03/16.
 */
public interface DateHandler
{
    SimpleDateFormat formatter = new SimpleDateFormat("dd. MMMM yyyy", Locale.getDefault());
    SimpleDateFormat fileFormatter = new SimpleDateFormat("dd_MM_yyyy", Locale.getDefault());
}
