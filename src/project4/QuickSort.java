package project4;

import java.util.Random;  
  
public class QuickSort {  
    public static final Random RND = new Random();  
  
    private static void swap(int[] array, int i, int j) {  
        int tmp = array[i];  
        array[i] = array[j];  
        array[j] = tmp;  
    }  
  
    private static  int partition(int[] array, int begin, int end) {  
        int index = begin + RND.nextInt(end - begin + 1);  
        int pivot = array[index];  
        swap(array, index, end);  
        for (int i = index = begin; i < end; ++i) {  
            if (array[i] <= pivot) {  
                swap(array, index++, i);  
            }  
        }  
        swap(array, index, end);  
        return (index);  
    }  
  
    private static void qsort(int[] array, int begin, int end) {  
        if (end > begin) {  
            int index = partition(array, begin, end);  
            qsort(array, begin, index - 1);  
            qsort(array, index + 1, end);  
        }  
    }  
  
    public static  void sort(int[] array) {  
        qsort(array, 0, array.length - 1);  
    }
}