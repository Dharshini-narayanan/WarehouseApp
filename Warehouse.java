package warehouse;


import java.util.*;

public class Warehouse {
    private String whId;
    private String location;
    private int capacity;
    private List<Item> inventory;

    public Warehouse(String whId, String location, int capacity) {
        this.whId = whId;
        this.location = location;
        this.capacity = capacity;
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void receiveItem(String sku, int qty) {
        for (Item i : inventory) {
            if (i.getSku().equals(sku)) {
                i.receive(qty);
                return;
            }
        }
        System.out.println("Item not found!");
    }

    public Item findItem(String sku) {
        for (Item i : inventory) {
            if (i.getSku().equals(sku)) return i;
        }
        return null;
    }

    public void printInventory() {
        System.out.println("-Inventory in Warehouse " + whId + " -");
        for (Item i : inventory) {
            System.out.println(i);
        }
    }
}
