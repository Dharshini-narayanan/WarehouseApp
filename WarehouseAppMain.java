package warehouse;
import java.util.*;

public class WarehouseAppMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Warehouse wh = new Warehouse("WH1", "Coimbatore", 100);
        Services service = new Services();

        while (true) {
            System.out.println("\n==== Warehouse Management System ====");
            System.out.println("1. Add Item");
            System.out.println("2. Receive Item (Inbound)");
            System.out.println("3. Create Shipment (Outbound)");
            System.out.println("4. Track Shipment");
            System.out.println("5. View Inventory");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter SKU: ");
                    String sku = sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Item item = new Item(sku, name, price, qty);
                    wh.addItem(item);
                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    System.out.print("Enter SKU to receive: ");
                    String skuIn = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qtyIn = sc.nextInt();
                    service.processInbound(wh, new Item(skuIn, "", 0, 0), qtyIn);
                    break;

                case 3:
                    System.out.print("Enter Shipment ID: ");
                    String shipId = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String dest = sc.nextLine();
                    System.out.print("Enter Carrier: ");
                    String carrier = sc.nextLine();
                    System.out.print("Enter Item SKU: ");
                    String skuOut = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qtyOut = sc.nextInt();

                    Shipment sh = service.processOutbound(wh, shipId, dest, carrier, skuOut, qtyOut);
                    if (sh != null) {
                        System.out.println("Shipment created successfully!");
                        sh.printShipment();
                    } else {
                        System.out.println("Shipment failed (Item not found or insufficient stock).");
                    }
                    break;

                case 4:
                    System.out.print("Enter Shipment ID to track: ");
                    String trackId = sc.nextLine();
                    service.trackShipment(trackId);
                    break;

                case 5:
                    wh.printInventory();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}

