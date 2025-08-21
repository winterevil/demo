package vn.eiu.edu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.eiu.edu.demo.model.EquipmentType;

@Repository
public interface EquipmentTypeRepo extends JpaRepository<EquipmentType, Integer> {
}
