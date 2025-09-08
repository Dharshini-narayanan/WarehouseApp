package warehouse;

public class Item {
	    private String sku;
	    private String name;
	    private double unitPrice;
	    private int qtyOnHand;

	    public Item(String sku, String name, double unitPrice, int qtyOnHand) {
	        this.sku = sku;
	        this.name = name;
	        this.unitPrice = unitPrice;
	        this.qtyOnHand = qtyOnHand;
	    }

	    public String getSku() { return sku; }
	    public String getName() { return name; }
	    public double getUnitPrice() { return unitPrice; }
	    public int getQtyOnHand() { return qtyOnHand; }

	    public void setQtyOnHand(int qty) { this.qtyOnHand = qty; }

	    public void receive(int qty) {
	        this.qtyOnHand += qty;
	    }

	    public boolean pickPack(int qty) {
	        if (qtyOnHand >= qty) {
	            qtyOnHand -= qty;
	            return true;
	        }
	        return false;
	    }

	    
	    public double shippingCost(double weight) {
	        return weight * 10;
	    }

	    public double shippingCost(double weight, double distance, boolean priority) {
	        double cost = weight * 10 + distance * 0.5;
	        if (priority) cost *= 1.5;
	        return cost;
	    }

	    @Override
	    public String toString() {
	        return name + " (SKU: " + sku + ", Price: " + unitPrice + ", Stock: " + qtyOnHand + ")";
	    }
	

}
