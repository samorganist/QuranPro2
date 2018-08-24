package samorganist.com.quranpro2.Model;

/**
 * Created by Samorganist on 22/08/2018.
 */

public class Suraat {

    private int position;
    private String name;
    private String arname;
    private String frarname;
    private boolean makkah;
    private int number_versets;
    private int startpage;

    public Suraat(int position, String name, String arname, String frarname, boolean makkah, int number_versets, int startpage) {
        this.position = position;
        this.name = name;
        this.arname = arname;
        this.frarname = frarname;
        this.makkah = makkah;
        this.number_versets = number_versets;
        this.startpage = startpage;
    }

    @Override
    public String toString() {
        return "Suraat{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", arname='" + arname + '\'' +
                ", frarname='" + frarname + '\'' +
                ", makkah=" + makkah +
                ", number_versets=" + number_versets +
                ", startpage=" + startpage +
                '}';
    }

    public String getArname() {
        return arname;
    }

    public void setArname(String arname) {
        this.arname = arname;
    }

    public String getFrarname() {
        return frarname;
    }

    public void setFrarname(String frarname) {
        this.frarname = frarname;
    }

    public int getStartpage() {
        return startpage;
    }

    public void setStartpage(int startpage) {
        this.startpage = startpage;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMakkah() {
        return makkah;
    }

    public void setMakkah(boolean makkah) {
        this.makkah = makkah;
    }

    public int getNumber_versets() {
        return number_versets;
    }

    public void setNumber_versets(int number_versets) {
        this.number_versets = number_versets;
    }

}
