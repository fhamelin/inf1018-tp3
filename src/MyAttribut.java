
public class MyAttribut
{
	public MyRange range = new MyRange();
	public String nom;
	public String type;
	
	
	public String see()
	{	return see(0);	}
	
	public String see(int nbSpace)
	{
		String st = "";
		
		for (int i = 0; i < nbSpace * 2; i++)
			st += " ";
		
		st += "A-> "+range.see()+" "+nom+": "+type;
		
		return st;
	}
	
	public String smallSee()
	{
		String st = "";
		
		if (range.isFinal)
			st += "[F] ";
		
		st += nom+":"+type;
		
		return st;
	}
}
