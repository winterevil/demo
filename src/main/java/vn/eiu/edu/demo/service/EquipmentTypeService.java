package vn.eiu.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.demo.model.EquipmentType;
import vn.eiu.edu.demo.repository.EquipmentTypeRepo;

import java.util.List;

@Service
public class EquipmentTypeService {
    @Autowired
    EquipmentTypeRepo equipmentTypeRepo;

    public void saveEquipmentType(EquipmentType equipmentType){
        equipmentTypeRepo.save(equipmentType);
    }

    public List<EquipmentType> getAllEquipmentTypes(){
        return equipmentTypeRepo.findAll();
    }
}
