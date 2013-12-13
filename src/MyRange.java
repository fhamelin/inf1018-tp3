
public class MyRange
{
	public boolean isAbstract = false;
	public boolean isStatic = false;
	public boolean isFinal = false;
	public String range = PUBLIC;
	
	public static final String PUBLIC = "public";
	public static final String PRIVATE = "private";
	public static final String PROTECTED = "protected";
	
	public String see()
	{	return see(0);	}
	
	public String see(int nbSpace)
	{
		String st = "";
		for (int i = 0; i < nbSpace * 2; i++)
			st += " ";
		
		if (range.compareTo(PUBLIC) == 0)
			st += "+";
		else if (range.compareTo(PRIVATE) == 0)
			st += "-";
		else
			st += "H";
		
		if (isAbstract || isFinal || isStatic)
		{
			st += "[";
			if (isAbstract)
				st += "A";
			if (isFinal)
				st += "F";
			if (isStatic)
				st += "S";
			st += "]";
		}
			
		return st;
	}
}
