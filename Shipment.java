package warehouse;


	import java.util.*;

	public class Shipment {
	    private String shipId;
	    private String destination;
	    private List<Item> items;
	    private String status;
	    private String carrier;

	    public Shipment(String shipId, String destination, String carrier) {
	        this.shipId = shipId;
	        this.destination = destination;
	        this.carrier = carrier;
	        this.items = new ArrayList<>();
	        this.status = "CREATED";
	    }

	    public void addItem(Item item) {
	        items.add(item);
	    }

	    public void dispatch() {
	        this.status = "IN_TRANSIT";
	    }

	    public void updateStatus(String status) {
	        this.status = status;
	    }

	    public String getStatus() { return status; }

	    public void printShipment() {
	        System.out.println("Shipment ID: " + shipId + " | Carrier: " + carrier + " | Status: " + status);
	        for (Item i : items) {
	            System.out.println(" - " + i);
	        }
	    }
	
}
