package org.itstep.mvc.io;

import lombok.Data;

@Data
public class Car {
    private Engine engine;
    private String model;
    private double price;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car() {
    }

    void go(){
         System.out.println("Using "+engine.getType());
     }
}
