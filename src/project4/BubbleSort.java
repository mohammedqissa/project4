package project4;

class BubbleSort {
	
	public static void sort(int[] data)  
	{  
	   for (int k = 0; k < data.length - 1; k++)  
	   {  
	      boolean isSorted = true;  
	  
	      for (int i = 1; i < data.length - k; i++)  
	      {  
	         if (data[i] < data[i - 1])  
	         {  
	            int tempVariable = data[i];  
	            data[i] = data[i - 1];  
	            data[i - 1] = tempVariable;  
	  
	            isSorted = false;  
	  
	         }  
	      }  
	  
	      if (isSorted)  
	         break;  
	   }  
	}  
}