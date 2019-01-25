import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Task implements Comparable<Task>{

	private Date startDate;
	private Date endDate;
	private String name;
	private Set<Task> dependencies;
	
	public Task()
	{
		dependencies=new TreeSet<Task>();
	}
//	
//	public Task(Date startDate,Date endDate,String name)
//	{
//		this.startDate=startDate;
//		this.endDate=endDate;
//		this.name=name;
//		dependencies=new TreeSet<Task>();
//	}
	
	public void addDependent(Task t)
	{
		dependencies.add(t);
	}
	
	public void addDependents(List<Task> list)
	{
		dependencies.addAll(list);
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Task o) {
		
		if(this.getStartDate().before(o.getStartDate()))
			return -1;
		else if(this.getStartDate().after(o.getStartDate()))
			return 1;
		else
			return 0;
	}

	public Set<Task> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<Task> dependencies) {
		this.dependencies = dependencies;
	}

	@Override
	public String toString() {
		return "Task [startDate=" + startDate + ", endDate=" + endDate + ", name=" + name + ", dependencies="
				+ dependencies + "]";
	}
	
	
	
	
	
}
