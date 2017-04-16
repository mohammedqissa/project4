package project4;

public class ShellSort {



	public static void sort(int[] test)
	{

		int array_size = test.length;
		int i, j, increment;
		int temp;

		increment = array_size / 2;
		while (increment > 0)
		{
			for (i=0; i < array_size; i++)
			{
				j = i;
				temp = test[i];
				while ((j >= increment) && (test[j-increment] > temp))
				{
					test[j] = test[j - increment];
					j = j - increment;
				}
				test[j] = temp;
			}
			if (increment == 2)
				increment = 1;
			else 
				increment = increment * 5 / 11;
		}
	}

}
