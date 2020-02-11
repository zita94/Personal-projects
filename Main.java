/*
 * Zita Koczka
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] list = new int[1000];
        for (int i = 0; i < list.length; i++ ) {
            list[i] = i;
        }

        Scanner reader = new Scanner(System.in);
        System.out.print("What value are you looking for? ");
        int value = Integer.parseInt(reader.nextLine());
        System.out.println("The value you're looking for is at position " + FindNum(list, value));
    }

    public static int FindNum(int[] list, int value) {
        int left = 0;
        int middle = list.length / 2;
        int right = list.length;
        int counter = 0;

        while (left <= middle && right >= middle) {
            counter++;
            if (list[middle] == value) {
                System.out.println("It took " + counter + " number of searches to find the location.");
                return middle;
            } else if (list[middle] < value) {
                left = middle + 1;
                middle = (left + right) / 2;
            } else {
                right = middle - 1;
                middle = (left + right) / 2;
            }
        } System.out.println("It took " + counter +  " number of searches to find the location.");
        return -1;
    }

}
