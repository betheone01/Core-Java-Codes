package core;

import java.util.Comparator;

public class customSorting  implements Comparator<Task>{
	
	public int compare(Task o1,Task o2)
	{
		//return o1.getTaskDate().compareTo(o2.getTaskDate());
		
		if(o1.getTaskDate().isBefore(o2.getTaskDate()))
		{
			return -1;
		}
		else if(o1.getTaskDate().isAfter(o2.getTaskDate()))
		{
			return 1;
		}
		return 0;
	}

}
