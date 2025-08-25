package vn.eiu.edu.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_Equipment")
public class Equipment {
    @Id
    @Column(name = "EquipmentId", nullable = false, columnDefinition = "CHAR(10)")
    private String equipmentId;

    @Column(name = "EquipmentName", nullable = false, columnDefinition = "VARCHAR(150)")
    @Size(min = 5, max = 100, message = "Length of name must be between 5 and 100 characters")
    private String equipmentName;

    @Column(name = "PurchasePrice", columnDefinition = "DECIMAL(10,2)", nullable = false)
    @Min(value = 1000, message = "Price must be equal or greater than 1000")
    private double purchasePrice;

    @Column(name = "QuantityAvailable", nullable = false)
    @Min(value = 0, message = "Quantity must be from 0")
    @Max(value = 500, message = "Quantity must be to 500")
    private int quantityAvailable;

    @ManyToOne
    @JoinColumn(name = "EquipmentTypeId")
    private EquipmentType equipmentType;

    @CreatedDate
    private LocalDateTime purchaseDate;

    public Equipment(String equipmentId, String equipmentName, double purchasePrice, int quantityAvailable){
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.purchasePrice = purchasePrice;
        this.quantityAvailable = quantityAvailable;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName( String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
}
