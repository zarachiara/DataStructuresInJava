public static void selectionSort (FileEntry[] list) 
{
	// decrement until you hit 0. 
	for (int j = list.length - 1; j>0; j--) 
	{
		int latestPos = 0;
		for (int k=1;k<=j; k++) 
		{
			// if list[latestPos] date is earlier than list[k]
			if (earlier (list[latestPos], list[k])) 
			{

				latestPos = k;
			}
		}
		// ensures never swap two elements that are equal
		if (j != latestPos && earlier(list[j], list[latestPos]))
		{
			Date temp = list[j];
			list[j] = list[latestPos];
			list[latestPos] = temp;
		}
	}
}