package Tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import ExceptionRules.*;
import core.Status;
import core.Task;
import core.customSorting;

import static ExceptionRules.CustomExceptionRules.*;

public class TaskManagerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in))
		{
			
			Map<String,Task>taskMap=new HashMap<>();
			Task z=new Task("Drink", "Daru",LocalDate.parse("2020-10-01") );
			Task a=new Task("Eat", "chakana",LocalDate.parse("2000-10-01") );
			Task b=new Task("ganja", "phokon ",LocalDate.parse("2023-10-25") );
			Task c=new Task("study", "oops",LocalDate.parse("2050-10-01") );
			Task d=new Task("chodna", "russian",LocalDate.parse("2090-10-01") );
			taskMap.put("Drink", z);
			taskMap.put("Eat", a);
			taskMap.put("ganja", b);
			taskMap.put("study", c);
			taskMap.put("chodna", d);
			
			boolean exit=false;
			while(!exit)
			{
				System.out.println("1. Add New Task \n"
						+ "2. Delete a task \n"
						+ "3. Update task status \n"
						+ "4. Display all pending tasks  \n"
						+ "5. Display all pending tasks for today  \n"
						+ "6.  Display all tasks sorted by taskDate \n"
						+" 7. Dispaly all tasks "
						+ " ");
				try {
					switch(sc.nextInt())
					{
					
						case 1:
							// int taskId, String taskName, String description, LocalDate taskDate
	
	//						        Task tasks = new Task(sc.next(), sc.next(), LocalDate.parse(sc.next()));
	//						        tasks.put(Task.getTaskId(), Task);
							System.out.println("Please Enter  taskName,  description,  taskDate\n" + "");
							Task myTask = new Task(sc.next(), sc.next(), ParseAndValidateDate(sc.next()));
	
							taskMap.put(myTask.getTaskName(), myTask);
							System.out.println(" Task added !!!!!" + myTask.getTaskName());
	
							break;
						case 2:
							// delete a task
							System.out.println("Enter the task id ");
							String taskName = sc.next();
	
							if (taskMap.get(taskName) == null) {
								throw new ExceptionHandling("Task id of related task not found ");
							}
	
							taskMap.get(taskName).setActive(false);
							System.out.println("Task id with  " + taskName + " marked as inactive ");
	
							break;
	
						case 3:// update task status
							System.out.println("Enter the task name ");
							String Name = sc.next();
							Status status = Status.valueOf(sc.next().toUpperCase());
	
							if (taskMap.get(Name) == null) {
								throw new ExceptionHandling("Task id of related task not found ");
							}
	
							taskMap.get(Name).setStatus(status);
							System.out.println("Task name with  " + Name + " marked as inactive ");
							break;
							
						case 4:
							for(Task t:taskMap.values())
							{
								if(t.getStatus().equals(Status.PENDING))
								{
									System.out.println(t);
								}
								
							}
							break;
						case 5:// Display all pending tasks for today  
							
						
							for(Task t:taskMap.values())
							{
								if(t.getStatus().equals(Status.PENDING) && t.getTaskDate().equals(LocalDate.now()))
								{
									System.out.println(t);
								}
								
							}
							break;
			
					
					case 6:
					taskMap.values().stream().sorted(Comparator.comparing(Task::getTaskDate)).forEach(p->System.out.println(p));
					//((p1,p2)->p1.getTaskDate().isBefore(p2.getTaskDate())).forEach(p->System.out.println(p));
//						List<Task>values=new ArrayList<>(taskMap.values());
//						Collections.sort(values,new customSorting());
//						for(Task t:values)
//						{
//							System.out.println(t);
//						}
					break;
					case 7:
						for(Task t:taskMap.values())
						{
							System.out.println(t);
						}
						break;
					case 8:
						exit=true;
						System.out.println("Exit Success ");
						break;
					}
					
					
					
						
					
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}
				

	}

	

}
