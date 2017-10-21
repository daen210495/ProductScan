package model;

/**
 * Created by User on 10/22/2017.
 */

public class ScanData {

    private int id;
    private String sdata;
    private String date;

    public ScanData() {
    }
    public ScanData(int id, String sdata, String date) {
        this.id = id;
        this.sdata = sdata;
        this.date = date;
    }

    public String getsData() {
        return sdata;
    }

    public void setsData(String sdata) {
        this.sdata = sdata;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
