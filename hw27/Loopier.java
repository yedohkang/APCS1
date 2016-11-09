// Yedoh Kang
// APCS1 -- pd5
// HW#27 -- Recurse, Recurse, on Elements Not the First!
// 2016-11-04

public class Loopier {
    public static int linSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int linSearchR(int[] a, int target) {
        if (a.length == 0) {
            return -1;
        }
        if (a[0] == target) {
            return 0;
        }
        //create new array of a excluding first index
        int[] newA = new int[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            newA[i - 1] = a[i];
        }

        //index keeps track of index, while search keeps track if
        //the target is not there
        int search = linSearchR(newA, target);
        int index = 1 + search;
        if (search != -1) {
            return index;
        }
        return -1;
    }

    public static int freq(int[] a, int target) {
        int count = 0;
        for (int i : a) {
            if (i == target) {
                count++;
            }
        }
        return count;
    }

    public static int freqRec(int[] a, int target) {
        if (a.length == 0) {
            return 0;
        }

        //create new array of a excluding first index
        int[] newA = new int[a.length - 1];
        for (int i = 1; i < a.length; i ++) {
            newA[i - 1] = a[i];
        }
        
        if (a[0] == target) {
            return 1 + freqRec(newA, target);
        }
        return freqRec(newA, target);
    }
    
    public static void main(String[] args) {
        int[] ints1 = {1, 5, 3, 2, 4, 8, 0};
        
        System.out.println(linSearch(ints1, 2));  //3
        System.out.println(linSearchR(ints1, 2));  //3
        
        System.out.println(linSearch(ints1, 8));  //5
        System.out.println(linSearchR(ints1, 8));  //5

        System.out.println(linSearch(ints1, 9));  //-1
        System.out.println(linSearchR(ints1, 9));  //-1

        System.out.println(linSearch(ints1, 0));  //6
        System.out.println(linSearchR(ints1, 0));  //6

        int[] ints2 = {1, 4, 5, 5, 2, 6, 1, 3, 1};

        System.out.println(freq(ints2, 1));  //3
        System.out.println(freqRec(ints2, 1));  //3
        
        System.out.println(freq(ints2, 4));  //1
        System.out.println(freqRec(ints2, 4));  //1
        
        System.out.println(freq(ints2, 5));  //2
        System.out.println(freqRec(ints2, 5));  //2
        
        System.out.println(freq(ints2, 9));  //0
        System.out.println(freqRec(ints2, 9));  //0
    }
}