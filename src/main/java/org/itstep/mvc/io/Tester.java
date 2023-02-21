package org.itstep.mvc.io;

public class Tester {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car();

        Engine e = new VEngine();
        e.setType("V");
        e.setVol(2);

        Engine e1 = new ElectroEng();
        e1.setType("W");
        e1.setVol(3);

        c1.setEngine(e);


    }
}
