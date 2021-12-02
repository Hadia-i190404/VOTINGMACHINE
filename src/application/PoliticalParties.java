package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PoliticalParties {
	
	String name;
	int votes;
	
	public PoliticalParties()
	{
		name=" ";
		votes=0;
	}
	public PoliticalParties(String nme,int vot)
	{
		name=nme;
		votes=vot;
	}
	//FileHandling for adding new parties
	public void setvotes(int vot)
	{
		votes=vot;
	}
	public void updateparties(String n) throws IOException
	{
		name=n;
		setvotes(0);
		File info=new File("Poltics.txt");
		FileWriter wfile=new FileWriter(info,true);
		wfile.write(name+","+Integer.toString(votes)+"\n");
		wfile.close();
		
	}

}
