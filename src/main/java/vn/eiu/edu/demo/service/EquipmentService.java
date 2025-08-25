package vn.eiu.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.demo.model.Equipment;
import vn.eiu.edu.demo.repository.EquipmentRepo;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepo equipmentRepo;

    public void saveEquipment(Equipment equipment){
        equipmentRepo.save(equipment);
    }

    public List<Equipment> getAllEquipments(){
        return equipmentRepo.findAll();
    }

    public Equipment getEquipmentById(String equipmentId){
        return equipmentRepo.findById(equipmentId).orElseThrow();
    }

    public void deleteEquipmentById(String equipmentId){
        equipmentRepo.deleteById(equipmentId);
    }

    public List<Equipment> searchEquipmentByName(String keyword){
        if (keyword == null || keyword.isEmpty()){
            return equipmentRepo.findAll();
        }

        return equipmentRepo.searchAllByEquipmentNameContainingIgnoreCase(keyword);
    }

    public boolean checkExistById(String equipmentId){
        return equipmentRepo.existsById(equipmentId);
    }

}
