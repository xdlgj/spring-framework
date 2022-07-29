package org.example.staticProxy;

public class AgentProxy implements RentHouse{
    private final Owner owner;

    public AgentProxy(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void toRentHouse() {
        before();
        owner.toRentHouse();
        after();
    }

    private void after() {
        System.out.println("after.....");
    }

    private void before() {
        System.out.println("before.......");
    }
}
