import java.util.ArrayList;

public class MyMethod implements ThrowAble
{
	public MyRange range = new MyRange();
	public String nom;
	public String returnType;
	public ArrayList<MyAttribut> parameters = new ArrayList<MyAttribut>();
	public ArrayList<MyAttribut> attributs = new ArrayList<MyAttribut>();
	public ArrayList<String> throwsException = new ArrayList<String>();
	
	public String see()
	{	return see(0);	}
	
	public String see(int nbSpace)
	{
		String st = "";
		
		for (int i = 0; i < nbSpace*2; i++)
			st += " ";
		
		st += "M-> "+range.see()+" "+nom+"(";
		for (int i = 0; i < parameters.size()-1; i++)
			st += parameters.get(i).smallSee()+", ";
		if (parameters.size() > 0)
			st += parameters.get(parameters.size()-1).smallSee();
			
		st += "): "+returnType;
		
		if (throwsException.size() > 0)
		{
			st += " [T:";
			for (int i = 0; i < throwsException.size() - 1; i++)
				st += throwsException.get(i)+", ";
			st += throwsException.get(throwsException.size() - 1)+"]";
		}
		
		return st;
	}
	
	public void addThrowException(String str)
	{
		throwsException.add(str);
	}

}
