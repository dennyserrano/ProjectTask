import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ProjectService {
	
	//edit?
	private Set<Project> projects=new TreeSet<Project>();
	
	public ProjectBuilder createProject()
	{
		return new ProjectBuilder();
	}
	
	public CreateTaskBuilder createTask()
	{
		return new CreateTaskBuilder();
	}
	
	public void addProject(Project p)
	{
		projects.add(p);
	}
	
	public List<OutputProject> getSchedules()
	{
		ArrayList<OutputProject> list=new ArrayList<OutputProject>();
		
		for(Project p:projects)
		{
			OutputProject clone=new OutputProject();
			clone.setName(p.getName());
			clone.setTasks(new ArrayList<Task>(p.getTasks()));
			list.add(clone);
		}
		
		
		return list;
	}
	
	private ArrayList<Task> collect(Set<Task> tasks)
	{
		ArrayList<Task> al=new ArrayList<Task>();
		for(Task t:tasks)
		{
			if(t.getDependencies().size()==0)
				al.add(t);
			else
				{
					al.addAll(collect(t.getDependencies()));
					al.add(t);
				}
		}
		return al;
	}
	
	class ProjectBuilder
	{
		private Project proj;
		
		ProjectBuilder()
		{
			proj=new Project();
		}
		
		public ProjectBuilder setName(String name)
		{
			proj.setName(name);
			return this;
		}
		
		public ProjectBuilder addTask(Task t)
		{
			proj.addTask(t);
			return this;
		}
		
		public Project build()
		{
			return proj;
		}
		
		
	}
	
	class CreateTaskBuilder
	{
		private Task task;
		
		CreateTaskBuilder()
		{
			task=new Task();
		}
		
		public CreateTaskBuilder setName(String name)
		{
			task.setName(name);
			return this;
		}
		
		public CreateTaskBuilder addDependent(Task t)
		{
			task.addDependent(t);
			return this;
		}
		
		public CreateTaskBuilder addDependents(List<Task> t)
		{
			task.addDependents(t);
			return this;
		}

		public EndDate startDate(Date d)
		{
			task.setStartDate(d);
			return new EndDate(task);
		}
		
		
	}
	
	
	
	class EndDate
	{
		private Task task;
		EndDate(Task t)
		{
			task=t;
		}
		
		public BuildClass endDate(Date e)
		{
			task.setEndDate(e);
			return new BuildClass(task);
		}
	}
	
	class BuildClass
	{
		private Task task;
		BuildClass(Task t)
		{
			task=t;
		}
		
		public Task build()
		{
			return task;
		}
	}

}
