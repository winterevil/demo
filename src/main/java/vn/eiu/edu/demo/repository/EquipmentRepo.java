package vn.eiu.edu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.eiu.edu.demo.model.Equipment;

import java.util.List;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, String> {
    List<Equipment> searchAllByEquipmentNameContainingIgnoreCase(String keyword);
}
