import java.util.ArrayList;

public class MyJavaFilesManager
{
	private ArrayList<MyClass> classes;
	public MyClass actClass = null;
	
	public MyJavaFilesManager()
	{
		classes = new ArrayList<MyClass>();
	}
	
	public void addClass(MyClass c)
	{
		classes.add(c);
		actClass = c;
	}
	
	public ArrayList<MyClass> getClasses()
	{	return classes;	}
	
	public String see()
	{
		String st = "";
		
		for (int i = 0; i < classes.size(); i++)
			st += classes.get(i).see()+"\n";
		
		return st;
	}
	
	public void merged(MyJavaFilesManager mjfm)
	{
		for (int i = 0; i < mjfm.getClasses().size(); i++)
			classes.add(mjfm.getClasses().get(i));
	}
}
