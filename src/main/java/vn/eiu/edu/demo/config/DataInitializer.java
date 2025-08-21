package vn.eiu.edu.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.eiu.edu.demo.model.Equipment;
import vn.eiu.edu.demo.model.EquipmentType;
import vn.eiu.edu.demo.model.User;
import vn.eiu.edu.demo.service.EquipmentService;
import vn.eiu.edu.demo.service.EquipmentTypeService;
import vn.eiu.edu.demo.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    EquipmentTypeService equipmentTypeService;
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        EquipmentType type1 = new EquipmentType("Laptop", "Portable computers used for teaching/research");
        EquipmentType type2 = new EquipmentType("Projector", "Devices used for classroom presentations");
        EquipmentType type3 = new EquipmentType("Printer", "Printers for administrative/student use");
        EquipmentType type4 = new EquipmentType("Microscope", "Lab equipment for biology/medical courses");
        Equipment e1 = new Equipment("EQ00000001","Dell Latitude 5420",1500,20);
        Equipment e2 = new Equipment("EQ00000002","HP ProBook 450 G8",1350,15);
        Equipment e3 = new Equipment("EQ00000003","Epson EB-X06 Projector",2200,5);
        Equipment e4 = new Equipment("EQ00000004","BenQ MW550 Projector",2500,3);
        Equipment e5 = new Equipment("EQ00000005","Canon LBP2900 Printer",1200,10);
        Equipment e6 = new Equipment("EQ00000006","Olympus CX23 Microscope",5000,7);

        type1.addEquipment(e1);
        type1.addEquipment(e2);
        type2.addEquipment(e3);
        type2.addEquipment(e4);
        type3.addEquipment(e5);
        type4.addEquipment(e6);

        equipmentTypeService.saveEquipmentType(type1);
        equipmentTypeService.saveEquipmentType(type2);
        equipmentTypeService.saveEquipmentType(type3);
        equipmentTypeService.saveEquipmentType(type4);

        User u1 = new User("admin", "admin", 1);
        User u2 = new User("staff01", "staff", 2);
        User u3 = new User("customer", "customer", 3);

        userService.saveUser(u1);
        userService.saveUser(u2);
        userService.saveUser(u3);
    }

}
