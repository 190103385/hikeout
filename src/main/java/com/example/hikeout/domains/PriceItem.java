package com.example.hikeout.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "price_items")
public class PriceItem {

    @Id
    @SequenceGenerator(
            name = "price_item_sequence",
            sequenceName = "price_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "price_item_sequence"
    )
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "name")
    @Getter
    private String name;

    @Column(name = "price")
    @Getter
    private int price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @Getter
    Location location;
}
