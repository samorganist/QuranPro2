package samorganist.com.quranpro2.Model;

import java.util.List;

/**
 * Created by Samorganist on 22/08/2018.
 */

public class Reciter {
    private String Name;
    private String Country;
    private int Thumbnail;
    private List<SuratVocal> souratList;

    public Reciter(String name, String country, int thumbnail, List<SuratVocal> souratList) {
        Name = name;
        Country = country;
        Thumbnail = thumbnail;
        this.souratList = souratList;
    }

    public List<SuratVocal> getSouratList() {
        return souratList;
    }

    public void setSouratList(List<SuratVocal> souratList) {
        this.souratList = souratList;
    }


    public Reciter(String name, String country, int thumbnail) {
        Name = name;
        Country = country;
        Thumbnail = thumbnail;
    }
    public Reciter(String name, int thumbnail) {
        Name = name;
        Thumbnail = thumbnail;
    }
    public Reciter(String name) {
        Name = name;
    }
    public Reciter(String name, String country) {
        Name = name;
        Country = country;

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
