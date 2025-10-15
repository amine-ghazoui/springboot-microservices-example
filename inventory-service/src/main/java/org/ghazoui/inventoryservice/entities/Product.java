package org.ghazoui.inventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Product {

    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}