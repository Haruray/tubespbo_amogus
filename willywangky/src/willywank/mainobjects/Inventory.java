package willywank.mainobjects;

import java.util.*;

abstract class BaseInventory{
    static int maxCap = 30;
    static int currentCap= 0;
    public int getMaxCap(){
        return maxCap;
    }
    public int getCurrentCap(){
        return currentCap;
    }
}

public class Inventory<T extends Comparable<T>> extends BaseInventory{
    List<T> items = new ArrayList<>();
    public Inventory(){
    }

    Comparator<T> customComparator = new Comparator<T>() {
        @Override
        public int compare(T i1, T i2) {
            return i1.compareTo(i2);
        }
    };

    public void addItem(T item) throws InventoryFullExc {
        if (!this.isFull()){
            this.items.add(item);
            if (this.items.get(0) instanceof Engimon) {
                Collections.sort(this.items, customComparator.reversed());
            } else if (this.items.get(0) instanceof Skill) {
                Collections.sort(this.items, customComparator.reversed());
            }
            currentCap++;
        }
        else{
            throw new InventoryFullExc();
        }
    }
    public boolean isFull(){
        return currentCap>= maxCap;
    }

    public boolean doesItemExist(T item){
        return this.items.stream().anyMatch(i->i.equals(item));
    }

    public void deleteItem(int idx) throws InventoryEmptyException{
        if (this.items.size()>0){
            this.items.remove(idx);
            currentCap--;
        }
        else{
            throw new InventoryEmptyException();
        }
    }

    public void deleteItem(String name) throws InventoryEmptyException{
        //khusus skill
        if (this.items.size()>0){
            if (this.items.get(0) instanceof Skill){
                int idx=0;
                for (T item : items){
                    Skill s = (Skill) item;
                    if (s.getSkillName().equals(name)){
                        deleteItem(idx);
                        break;
                    }
                    idx++;
                }
            }
        }
        else{
            throw new InventoryEmptyException();
        }
    }

    public void deleteItemEngimon(int id) throws InventoryEmptyException{
        //khusus engimon, berdasarkan id engimon
        if (this.items.size()>0){
            if (this.items.get(0) instanceof Engimon){
                int idx=0;
                for (T item : items){
                    Engimon e = (Engimon) item;
                    if (e.getId()==id){
                        deleteItem(idx);
                        break;
                    }
                    idx++;
                }
            }
        }
        else{
            throw new InventoryEmptyException();
        }
    }

    public int countItem(T i){
        int count = 0 ;
        for ( T item : this.items ){
            if (item.equals(i)){
                count++;
            }
        }
        return count;
    }

    public T getDifferentItemAtX(int idx){
        //mencari item berdasarkan idx tapi harus beda --> khusus skill item
        if (idx==0){
            return this.items.get(0);
        }
        else{
            T currentItem = this.items.get(0);
            int currentIdx = 0;
            for (int i = 1 ; i < this.items.size() ; i++){
                if (!this.items.get(i).equals(currentItem)){
                    currentIdx++;
                    currentItem = this.items.get(i);
                    if (currentIdx == idx){
                        return currentItem;
                    }
                }
            }
            return currentItem;
        }
    }

    public void deleteItem(T item) throws ItemException, InventoryEmptyException{
        if (this.items.size()>0 ){
            if (this.doesItemExist(item)){
                this.items.remove(item);
                currentCap--;
            }
            else{
                throw new ItemException();
            }
        }
        else{
            throw new InventoryEmptyException();
        }
    }

    public void printItems(){
        if (this.items.size()>0){
            if (this.items.get(0) instanceof Engimon){
                int count=1;
                for (T item : this.items){
                    System.out.print(count + ". ");
                    System.out.println(item);
                    count++;
                }
            }
            else{
                T currentItem = this.items.get(0);
                boolean first = true;
                int currentQty = 1;
                int count=1;
                for (int i = 0 ; i < this.items.size() ; i++){
                    if (items.get(i).equals(currentItem)){
                        if (first)
                            first=false;
                        else
                            currentQty++;
                        if (i==this.items.size()-1){
                            System.out.print(count + ". ");
                            System.out.print(items.get(i));
                            System.out.print(" | Qty : ");
                            System.out.println(currentQty);
                        }
                    }
                    else{
                        System.out.print(count + ". ");
                        System.out.print(items.get(i-1));
                        System.out.print(" | Qty : ");
                        System.out.println(currentQty);
                        count++;
                        currentItem = items.get(i);
                        currentQty = 1;
                        first=true;
                    }
                }
                System.out.print(count + ". ");
                System.out.print(items.get(items.size()-1));
                System.out.print(" | Qty : ");
                System.out.println(currentQty);
            }
        }
    }
    public int getSize(){
        return this.items.size();
    }

    public List<T> getItems(){
        return this.items;
    }
}
