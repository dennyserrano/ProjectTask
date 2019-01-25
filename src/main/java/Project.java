import java.util.Set;
import java.util.TreeSet;

public class Project implements Comparable<Project>{

	private Set<Task> tasks;
	private String name;
	
	public Project() {
		tasks=new TreeSet<Task>();
	}
	
	public void addTask(Task t)
	{
		tasks.add(t);
	}
	

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Project o) {
		Task[] leftTasks=(Task[]) this.getTasks().toArray(new Task[this.getTasks().size()]);
		Task[] rightTasks=(Task[]) o.getTasks().toArray(new Task[o.getTasks().size()]);
		
		int i= leftTasks[0].compareTo(rightTasks[0]);
		
		return i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
