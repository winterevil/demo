package vn.eiu.edu.demo.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.eiu.edu.demo.model.Equipment;
import vn.eiu.edu.demo.model.User;
import vn.eiu.edu.demo.service.EquipmentService;
import vn.eiu.edu.demo.service.EquipmentTypeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @Autowired
    EquipmentTypeService equipmentTypeService;

    @GetMapping("/equipments")
    public String showEquipment(@RequestParam(value = "keyword", defaultValue = "") String keyword, Model model,
                                HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        List<Equipment> equipmentList = new ArrayList<>();
        if (keyword.isBlank()) {
            equipmentList = equipmentService.getAllEquipments();
        } else {
            equipmentList = equipmentService.searchEquipmentByName(keyword);
        }

        model.addAttribute("equipmentList", equipmentList);
        return "equipment-list";
    }

    @GetMapping("/equipment/delete/{id}")
    public String deleteEquipment(@PathVariable("id") String id, HttpSession session, RedirectAttributes attributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        if (user.getRole() != 1) {
            attributes.addFlashAttribute("errRole", "You don't have permission to delete this equipment");
            return "redirect:/equipments";
        }

        equipmentService.deleteEquipmentById(id);
        return "redirect:/equipments";
    }

    @PostMapping("/equipment/form")
    public String saveEquipment(@Valid @ModelAttribute("equipment") Equipment equipment, BindingResult result,
                                Model model, @RequestParam("formMode") String formMode) {
        if (result.hasErrors()) {
            model.addAttribute("formMode", formMode);
            model.addAttribute("typeList", equipmentTypeService.getAllEquipmentTypes());
            return "equipment-form";
        }

        if (formMode.equals("add")) {
            if (equipmentService.checkExistById(equipment.getEquipmentId())){
                model.addAttribute("formMode", formMode);
                model.addAttribute("typeList", equipmentTypeService.getAllEquipmentTypes());
                model.addAttribute("duplicatedId", "Id already exists");
                return "equipment-form";
            }
        }

        equipmentService.saveEquipment(equipment);
        return "redirect:/equipments";
    }

    @GetMapping("/equipment/add")
    public String addEquipment(Model model, HttpSession session, RedirectAttributes attributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        if (user.getRole() != 1) {
            attributes.addFlashAttribute("errRole", "You don't have permission to add this equipment");
            return "redirect:/equipments";
        }

        model.addAttribute("typeList", equipmentTypeService.getAllEquipmentTypes());
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("formMode", "add");
        return "equipment-form";
    }

    @GetMapping("equipment/edit/{id}")
    public String editEquipment(@PathVariable("id") String id, Model model, HttpSession session, RedirectAttributes attributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        if (user.getRole() != 1) {
            attributes.addFlashAttribute("errRole", "You don't have permission to edit this equipment");
            return "redirect:/equipments";
        }

        Equipment equipment = equipmentService.getEquipmentById(id);
        model.addAttribute("equipment", equipment);
        model.addAttribute("formMode", "edit");
        model.addAttribute("typeList", equipmentTypeService.getAllEquipmentTypes());
        return "equipment-form";
    }

}
