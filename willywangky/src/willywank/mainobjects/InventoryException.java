package willywank.mainobjects;

public class InventoryException extends Exception{
    void showErrors(){
        System.out.println("Inventory is empty\n");
    }
}
