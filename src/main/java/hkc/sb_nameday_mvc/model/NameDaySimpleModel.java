package hkc.sb_nameday_mvc.model;

public class NameDaySimpleModel {
    private String name;
    private String date;

    public NameDaySimpleModel(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
