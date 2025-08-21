package vn.eiu.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.eiu.edu.demo.service.EquipmentService;

@Controller
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/equipments")
    public String showEquipment(){
        return "equipments";
    }
}
