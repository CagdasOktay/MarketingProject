package com.cagdas.repository.entities;


import com.cagdas.repository.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String productname;
    private String barcode;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status=Status.PENDING;

}
