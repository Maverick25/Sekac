package agency.alterway.sekac.injections;

/**
 * Created by marekrigan on 13/03/16.
 */
public interface Injection {
    void onUploadedSheet(boolean success, String message, boolean isFinishingDay);
}
