package willywank.mainobjects;

public class InventoryEmptyException extends Exception{
    void showErrors(){
        System.out.println("Inventory is empty\n");
    }
}
