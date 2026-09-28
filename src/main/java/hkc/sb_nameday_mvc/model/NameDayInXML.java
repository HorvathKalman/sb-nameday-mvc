package hkc.sb_nameday_mvc.model;

public class NameDayInXML {
    private Integer id;
    private String xmlData;

    public NameDayInXML(Integer id, String xmlData) {
        this.id = id;
        this.xmlData = xmlData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }
}
