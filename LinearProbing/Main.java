package LinearProbing;

public class Main {
    public static void main(String[] args) {
        linearProbing linearprobing = new linearProbing(15);
        linearProbing.insertHashTable("The");
        linearProbing.insertHashTable("World");
        linearProbing.insertHashTable("Is");
        linearProbing.insertHashTable("Ending");
        linearProbing.insertHashTable("Run");
        linearProbing.insertHashTable("Now");
        linearProbing.insertHashTable("Hurry");
        linearProbing.insertHashTable("Quick");
        linearProbing.searchHashTable("Hurry");
        linearProbing.searchHashTable("LMAO");
        linearProbing.deleteKeyHashTable("Hurry");
        linearProbing.deleteKeyHashTable("Buffoon");
        linearProbing.displayHashTable();


    }
}
