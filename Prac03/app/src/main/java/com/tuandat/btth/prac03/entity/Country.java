package com.tuandat.btth.prac03.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    private String name;
    private String capital;
    private int population;
    private double area;
    private int density;
    private double worldShare;
    private int flagResource;
}
