import java.util.Arrays;

public class BinarySeparation {
    public static void main(String[] args) {
        int[] list = {1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(separate(list)));
    }
    public static int[] separate(int[] list) {
        int[] newList = new int[list.length];
        int k = 0;
        for (int i = 0; i < list.length; i++)
        {
            if(list[i] == 0)
            {
                newList[k] = 0;
                k++;
            }
        }
        for(int i = k; i < list.length; i++)
        {
            newList[k] = 1;
            k++;
        }
        return newList;
    }
}
