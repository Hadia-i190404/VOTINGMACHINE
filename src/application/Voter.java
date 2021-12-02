package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Voter {
	String voter;
	int vc;
	
	public Voter()
	{
		voter=" ";
		vc=0;
	}
	public Voter(String n,int vcc)
	{
		voter=n;
		vc=vcc;
	}
	public void newVoter(String n,int vc) throws IOException
	{
		voter=n;
		vc=vc;
		
		File info=new File("Poltics.txt");
		FileWriter wfile=new FileWriter(info,true);
		wfile.write(voter+","+Integer.toString(vc)+"\n");
		wfile.close();
	}
}

