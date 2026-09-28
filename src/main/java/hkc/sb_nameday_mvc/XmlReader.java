package hkc.sb_nameday_mvc;

import hkc.sb_nameday_mvc.model.NameDaySimpleModel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {

    public List<NameDaySimpleModel> getNameDaysFromString(String xmlData) throws IOException, JDOMException {
        List<NameDaySimpleModel> nameDaySimpleModels = new ArrayList<>();

        SAXBuilder  saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(xmlData));
        Element rootElement = document.getRootElement();

       List<Element> nameDays = rootElement.getChildren("nameDay");

       for (Element tempNameDayVariable : nameDays) {

           String name = tempNameDayVariable.getChildText("name");
           String date = tempNameDayVariable.getChildText("date");

           NameDaySimpleModel nameDaySimpleModel = new NameDaySimpleModel(name, date);
           nameDaySimpleModels.add(nameDaySimpleModel);
       }

       return nameDaySimpleModels;
    }
}
