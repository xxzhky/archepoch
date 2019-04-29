package com.gp.vip.interview.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.ref.WeakReference;

public class TestWeakReference {
    public static void main(String[] args) {

        Car car = new Car(22000, "silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);
        int i = 0;
        while (true) {
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }

        //----------------------------------------------------
        /*Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);

        int i=0;

        while(true){
            System.out.println("here is the strong reference 'car' "+car);
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }*/
    }


    }

@Data
@AllArgsConstructor
class Car {
    private double price;
    private String colour;

    public String toString() {
        return colour + "car costs $" + price;
    }
}