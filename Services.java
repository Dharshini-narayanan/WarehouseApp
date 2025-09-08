package warehouse;


	import java.util.*;

	public class Services {
	    private List<Shipment> shipments = new ArrayList<>();

	    public void processInbound(Warehouse wh, Item item, int qty) {
	        wh.receiveItem(item.getSku(), qty);
	    }

	    public Shipment processOutbound(Warehouse wh, String shipId, String dest, String carrier, String sku, int qty) {
	        Item item = wh.findItem(sku);
	        if (item != null && item.pickPack(qty)) {
	            Shipment sh = new Shipment(shipId, dest, carrier);
	            sh.addItem(item);
	            shipments.add(sh);
	            return sh;
	        }
	        return null;
	    }

	    public void trackShipment(String shipId) {
	        for (Shipment s : shipments) {
	            if (s != null && s.toString().contains(shipId)) {
	                s.printShipment();
	            }
	        }
	    }

	    public double billing(Item item, double weight, double distance, boolean priority) {
	        return item.shippingCost(weight, distance, priority);
	    }
	}

 

