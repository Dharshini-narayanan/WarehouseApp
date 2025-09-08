package warehouse;

	public class PerishableItem extends Item {
	    public PerishableItem(String sku, String name, double unitPrice, int qtyOnHand) {
	        super(sku, name, unitPrice, qtyOnHand);
	    }

	    @Override
	    public boolean pickPack(int qty) {
	        System.out.println("Pack perishable with cold storage!");
	        return super.pickPack(qty);
	    }

	    @Override
	    public double shippingCost(double weight) {
	        return super.shippingCost(weight) + 15;
	    }
	
}
