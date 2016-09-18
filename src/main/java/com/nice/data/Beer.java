package com.nice.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Evegeny on 18/09/2016.
 */
@Data
@Entity
@NoArgsConstructor
public class Beer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;

    public Beer(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
