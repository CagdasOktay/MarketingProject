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
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    Long productid;
    int quantity;
    String productname;
    String barcode;

    @Builder.Default
    Long created = System.currentTimeMillis();
    Long updated;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    Status status=Status.PENDING;

}
