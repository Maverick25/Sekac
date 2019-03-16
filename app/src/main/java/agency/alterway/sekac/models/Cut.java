package agency.alterway.sekac.models;

/**
 * Model object representing single cut of the tree
 * <p>
 * Created by marekrigan on 22/02/16.
 */
public class Cut {
    private int height;
    private long id;
    private int volume;
    private int width;

    public Cut() {}

    public Cut(int width, int height, int volume) {
        this.width = width;
        this.height = height;
        this.volume = volume;
    }

    public Cut(long id, int width, int height, int volume) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.volume = volume;
    }

    public String getFormattedVolume() {
        return String.valueOf(volume);
    }

    public String getFormattedHeight() {
        return String.valueOf(height);
    }

    public String getFormattedWidth() {
        return String.valueOf(width);
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.id;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int paramInt) {
        this.height = paramInt;
    }

    public void setId(long paramLong) {
        this.id = paramLong;
    }

    public void setVolume(int paramInt) {
        this.volume = paramInt;
    }

    public void setWidth(int paramInt) {
        this.width = paramInt;
    }
}

