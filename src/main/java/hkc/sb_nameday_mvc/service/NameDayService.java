package hkc.sb_nameday_mvc.service;

import hkc.sb_nameday_mvc.XmlReader;
import hkc.sb_nameday_mvc.dto.NameDaySimpleDTO;
import hkc.sb_nameday_mvc.model.NameDayInXML;
import hkc.sb_nameday_mvc.model.NameDaySimpleModel;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NameDayService {

    private final RestClient restClient;

    @Autowired
    public NameDayService() {
        restClient = RestClient.create();
    }

    public List<NameDaySimpleDTO> getAllNameDay() throws IOException, JDOMException {
        List<NameDaySimpleDTO>  responseDTO = new ArrayList<>();

        NameDayInXML tempRestDayNameModel = restClient.get()
                .uri("http://localhost:8081/getAll")
                .retrieve()
                .body(NameDayInXML.class);

        if (tempRestDayNameModel != null) {
            String xmlData = tempRestDayNameModel.getXmlData();

            List<NameDaySimpleModel> nameDayModelsList = new XmlReader().getNameDaysFromString(xmlData);

            for (NameDaySimpleModel tempModelVariable : nameDayModelsList) {
                   NameDaySimpleDTO tempDTO = new NameDaySimpleDTO(
                           tempModelVariable.getName(),
                           tempModelVariable.getDate()
                   );
                   responseDTO.add(tempDTO);
            }
        }
        return responseDTO;
    }

    public NameDaySimpleDTO changeDate(NameDaySimpleDTO requestDTO) {
        NameDaySimpleDTO responseDTO = null;

        NameDaySimpleModel responseModel = restClient.post()
                .uri("http://localhost:8081/changeDate")
                .body(requestDTO)
                .retrieve()
                .body(NameDaySimpleModel.class);
        if (responseModel != null) {
            responseDTO = new NameDaySimpleDTO(
                    responseModel.getName(),
                    responseModel.getDate()
            );
        }
        return responseDTO;
    }
}
