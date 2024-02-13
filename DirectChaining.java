
import java.util.LinkedList;
import java.util.ArrayList;
public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 10;

    DirectChaining(int size)
    {
     hashTable = new LinkedList[size];
    }

    public int  modASCII(String word, int cellNumber)
    {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for(sum = 0, i = 0 ; i< word.length(); i++)
        {
            sum += ch[i];
        }
        return sum % cellNumber;
    }
    //here we insert into hash table
    public void insertHashTable(String word)
    {
        int newIndex = modASCII(word, hashTable.length);
        if(hashTable[newIndex] == null)
        //aka if the specific hash value occupier is empty i.e. does not already have a value
            //we create a new linked list with the location of the node entered as the hash value
        {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        }
        else
        {
            //here linked list already exists
            hashTable[newIndex].add(word);
        }
    }
    //method responsible for displaying hash table
    public void displayHashTable()
    {
        if(hashTable == null)
        {
            System.out.println("Hashtable does not exist");
            return;
        }
        else
        {
            System.out.println("---------HashTable----------");
            for(int i = 0; i <hashTable.length; i++)
            {
                System.out.println("Index: " + i + ", Key: " + hashTable[i]);
            }
        }
    }

    public boolean searchHashTable(String word)
    {
        //first thing we need to do is find out the index of this string
        int newIndex = modASCII(word, hashTable.length);
        if(hashTable[newIndex] != null && hashTable[newIndex].contains(word))
        //so firstly we check whether it's null, if it isnt then we check whether the value present in it
            //is the word we're looking for
        {
            System.out.println("'"+  word + "' found in HashTable at location " + newIndex);
            return true;
        }
        else
        {
            System.out.println(word + " not found in HashTable");
            return false;
        }
    }
    public void deleteKeyHashTable(String word)
    {
        int newIndex = modASCII(word, hashTable.length);
        boolean result = searchHashTable(word);
        if(result)
        {
            hashTable[newIndex].remove(word);
            System.out.println("'" + word + "' has been deleted from the HashTable");
        }
        else
        {
            System.out.println(word + " not found in HashTable");
        }
    }
}
