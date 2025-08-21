package vn.eiu.edu.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_EquipmentType")
public class EquipmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EquipmentTypeId")
    private Integer equipmentTypeId;

    @Column(name = "TypeName", nullable = false, unique = true, columnDefinition = "VARCHAR(100)")
    private String typeName;

    @Column(name = "Description", columnDefinition = "VARCHAR(255)")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "equipmentType")
    private List<Equipment> equipmentList = new ArrayList<>();

    public void addEquipment(Equipment equipment){
        equipmentList.add(equipment);
        equipment.setEquipmentType(this);
    }

    public void removeEquipment(Equipment equipment){
        equipmentList.remove(equipment);
        equipment.setEquipmentType(null);
    }

    public EquipmentType(String typeName, String description){
        this.typeName = typeName;
        this.description = description;
    }
}
