package LinearProbing;
import java.util.ArrayList;
public class linearProbing {
    static String[] hashTable;
    static int usedCellNum;

    public linearProbing(int size) {
        hashTable = new String[size];
        usedCellNum = 0;
    }

    public static int modASCIIHashFunction(String word, int m)// m is number of cells in the hashtable
    {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for(sum = 0, i = 0; i<word.length(); i++)
        {
            //her we are summing up the ascii values of all the letters in the string
            sum +=ch[i];
        }
        return sum % m;
    }
    public static double getLoadFactor()
    {
        double loadFactor = (double) usedCellNum *1.0/hashTable.length;
        return loadFactor;
    }
    //first we moved all the elements of the current hashtable into a temporary list
    //then we initialize the new hashtable with 2x length
    //finally we move all the array from the temporary list to the new hashtable
    public static void reHashKeys(String word)
    {
        usedCellNum = 0;
        ArrayList<String> data = new ArrayList<String>();
        for(String s : hashTable)
        {
            if (s!= null)
            {
                data.add(s);
                //first we transfer all the preexisting terms present in the original hashTable
            }
            data.add(word);
            //then we add the new term that caused the creation of the new hashtable
            hashTable = new String[hashTable.length*2];
            //initialised new hashtable to 2x
            for(String a : data)
            {
                insertHashTable(a);
                //we cannot insert the values in the new hashtable until we create an insert method
            }
        }

    }
    public static void insertHashTable(String word)
    {
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75)
        {
            reHashKeys(word);
        }
        else
        {
            //so if the loadfactor is less than .75 then we calculate the hashvalue and try to find a place in the hashtable to put this word
            int index = modASCIIHashFunction(word, hashTable.length);
            for(int i = index; i <index + hashTable.length; i++)
            {
                int newIndex = i % hashTable.length;
                //so now we check that this new index that we have already occupies an element or not, if it does then we move to the next cell
                //and if the cell is found empty then we put this value in that cell
                if(hashTable[newIndex] == null)
                {
                    hashTable[newIndex] = word;
                    System.out.println("Successfully inserted " + word + " at location " + newIndex);
                    break;
                }
                else
                {
                    System.out.println("The location " + newIndex + " is already occupied");
                }
            }
        }
        usedCellNum++;
    }

    //now we implement a method that prints out the hashtable
    public static void displayHashTable()
    {
        if(hashTable == null)
        {
            System.out.println("The HashTable does not exist");
            return;
        }
        else
        {
            System.out.println("-----------------------HashTable------------------------");
            for(int i = 0; i < hashTable.length; i++)
            {
                System.out.println("Index " + i + ", key: " + hashTable[i]);
            }
        }
    }
    public static boolean searchHashTable(String word)
    {
        int index = modASCIIHashFunction(word, hashTable.length);
        for(int i = index; i < (index+hashTable.length); i++)
        //we will look from the index location and continue looking forward in the next cells incase it is not present at index position
            //aka incase it is already occupied and our required word is pushed forward because this is linear probing
        {
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] !=null && hashTable[newIndex].equals(word))
            {
                System.out.println(word + " found at location " + newIndex);
                return true;
            }
        }
        System.out.println(word + " not found in HashTable");
        return false;
    }
    public static void deleteKeyHashTable(String word)
    {
        int index = modASCIIHashFunction(word, hashTable.length);
        for(int i = index; i < (index+hashTable.length); i++)
        {
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word))
            {
                hashTable[newIndex] = null;
                System.out.println(word + " has been deleted from the HashTable");
                return;
            }
        }
        System.out.println(word +" does not exist in the HashTable");
    }
}
