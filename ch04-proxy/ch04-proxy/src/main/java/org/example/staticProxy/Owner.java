package org.example.staticProxy;

public class Owner implements RentHouse{
    @Override
    public void toRentHouse() {
        System.out.println("两室一厅，月租5k");
    }
}
