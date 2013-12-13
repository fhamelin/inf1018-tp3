import java.util.ArrayList;

public class MyClass implements ThrowAble
{
	public ArrayList<String>  throwsException = new ArrayList<String>();
	public MyRange range = new MyRange();
	public ArrayList<MyAttribut> attributs = new ArrayList<MyAttribut>();
	public ArrayList<String> interfaces = new ArrayList<String>(); //implemented's interfaces
	public ArrayList<MyMethod> methods = new ArrayList<MyMethod>();
	public ArrayList<String> imports = new ArrayList<String>(); //Import states
	public String superClass = null;
	public String nom = null;
	public String packageName = "defalut package";
	
	public String see()
	{	return see(0);	}
	
	public String see(int nbSpace)
	{
		String st = "";
		
		for (int i = 0; i < nbSpace * 2; i++)
			st += " ";
		
		st += "Class: "+range.see()+" "+nom;

		if (interfaces.size() > 0)
		{
			st += " [I:";
			for (int i = 0; i < interfaces.size() - 1; i++)
				st += interfaces.get(i)+", ";
			st += interfaces.get(interfaces.size() - 1)+"]";
		}

		if (throwsException.size() > 0)
		{
			st += " [T:";
			for (int i = 0; i < throwsException.size() - 1; i++)
				st += throwsException.get(i)+", ";
			st += throwsException.get(throwsException.size() - 1)+"]";
		}

		for (int i = 0; i < attributs.size(); i++)
			st += "\n"+attributs.get(i).see(nbSpace+1);
		for (int i = 0; i < methods.size(); i++)
			st += "\n"+methods.get(i).see(nbSpace+1);
		
		
		return st;
	}

	public void addThrowException(String str)
	{
		throwsException.add(str);
	}
}
