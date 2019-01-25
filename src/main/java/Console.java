
import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Console {

	public static void main(String[] args) {
	
		//new Date() should not be placed as string but for the sake of quick implem
		// task that is added in the project and added in another task? so duplicate task
		
		ProjectService ps=new ProjectService();
		
		
		Task t1=ps.createTask()
		.startDate(new Date("1/20/2019"))
		.endDate(new Date("1/21/2019"))
		.build();
		
		Task t2=ps.createTask()
		.startDate(new Date("1/22/2019"))
		.endDate(new Date("1/23/2019"))
		.build();
		
		Task t3=ps.createTask()
		.addDependent(t2)
		.startDate(new Date("1/24/2019"))
		.endDate(new Date("1/25/2019"))
		.build();
		
		Task t4=ps.createTask()
		.addDependent(t1)
		.startDate(new Date("1/26/2019"))
		.endDate(new Date("1/27/2019"))
		.build();
		
		Task t5=ps.createTask()
				.startDate(new Date("2/26/2019"))
				.endDate(new Date("2/27/2019"))
				.build();
		
		
		Project p1=ps.createProject()
				.setName("project1")
				.addTask(t4)
				.addTask(t3)
				.build();
		
		Project p2=ps.createProject()
				.setName("project2")
				.addTask(t5)
				.build();
		
		ps.addProject(p1);
		ps.addProject(p2);
		
		for(OutputProject p:ps.getSchedules())
		{
			System.out.println("Project Name:"+p.getName());
			
			System.out.println("Tasks:");
			for(Task t:p.getTasks())
				System.out.println(t);
			System.out.println();
			System.out.println();
		}
		
	}
	
}
