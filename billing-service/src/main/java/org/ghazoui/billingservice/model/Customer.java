package org.ghazoui.billingservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Customer {

    private Long id;
    private String name;
    private String email;
}