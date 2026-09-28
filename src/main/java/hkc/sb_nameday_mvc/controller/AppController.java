package hkc.sb_nameday_mvc.controller;

import hkc.sb_nameday_mvc.dto.NameDaySimpleDTO;
import hkc.sb_nameday_mvc.service.NameDayService;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class AppController {

    private NameDayService nameDayService;

    @Autowired
    public AppController(NameDayService nameDayService) {
        this.nameDayService = nameDayService;
    }

    @GetMapping("/allNameDays")
    public String getAllNameDays(Model model) throws IOException, JDOMException {

        List<NameDaySimpleDTO> nameDaySimpleDTO = nameDayService.getAllNameDay();
        model.addAttribute("nameDaySimpleDTO",nameDaySimpleDTO);
        return "allNameDays.html";
    }
}
