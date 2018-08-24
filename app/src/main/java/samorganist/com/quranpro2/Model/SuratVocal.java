package samorganist.com.quranpro2.Model;

/**
 * Created by Samorganist on 22/08/2018.
 */

public class SuratVocal {
    private String name;
    private String path;
    private int position;

    public SuratVocal(String name, String path, int position) {
        this.name = name;
        this.path = path;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
