package ExceptionRules;

import java.time.LocalDate;
import java.util.Map;

import core.Task;

public class CustomExceptionRules 
{
	//int taskId, String taskName, String description, LocalDate taskDate
	public  static Task validateAllInputs(String taskName, String description, LocalDate taskDate,Map<Integer, Task> tasklist)
	{
		
		return new Task(description, description, taskDate);
	}
	public static  LocalDate ParseAndValidateDate(String date)throws ExceptionHandling
	{
		return LocalDate.parse(date);
	}
	
	public static boolean deleteTask(int taskId,Map<Integer,Task>taskMap)throws ExceptionHandling
	{
	
		Task t=taskMap.get(taskId);
		if(t==null)
		{
			throw new ExceptionHandling("ID is not found "+taskId );
		}
		
		taskMap.get(taskId).setActive(false);
		
		return true;
	}
	
}
