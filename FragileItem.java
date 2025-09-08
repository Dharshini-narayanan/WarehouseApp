package warehouse;

	public class FragileItem extends Item {
	    public FragileItem(String sku, String name, double unitPrice, int qtyOnHand) {
	        super(sku, name, unitPrice, qtyOnHand);
	    }

	    @Override
	    public boolean pickPack(int qty) {
	        System.out.println("Handle fragile item with extra padding!");
	        return super.pickPack(qty);
	    }

	    @Override
	    public double shippingCost(double weight) {
	        return super.shippingCost(weight) + 20;
	    }
	
}
