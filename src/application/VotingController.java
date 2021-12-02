package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class VotingController implements Initializable{
	
	
	@FXML
	private AnchorPane pane;
	@FXML
	private ChoiceBox<String> cb;
	
	Vector<PoliticalParties> pp=new Vector<PoliticalParties>();
	Vector<String>Partyname =new Vector<String>(); 
	Vector<Voter>voter =new Vector<Voter>(); 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try
		{
			reading();
		}
		catch(IOException e)
		{
			
		}
		
		for(PoliticalParties i : pp)
		{
			String line=i.name;
			Partyname.add(line);
		}
		cb.getItems().addAll(Partyname);
		cb.setOnAction(arg01->{
			try
			{
				Voteaddition(arg01);
			}
			catch(IOException ioe)
			{
				System.out.println("ERROR");
			}
		});
		
		
	}
	public void reading() throws IOException
	{
		String s;
		BufferedReader br = new BufferedReader(new FileReader("Poltics.txt"));
		while((s=br.readLine())!=null)
		{
			StringTokenizer tok=new StringTokenizer(s,",");
			PoliticalParties party=new PoliticalParties(tok.nextToken(),Integer.parseInt(tok.nextToken()));
			System.out.println("Vote count "+ party.votes+ "\n" );
			pp.add(party);
		}
	}
	public void Voteaddition(ActionEvent event) throws IOException
	{
		boolean check=false;
		String votes=cb.getValue();
		
		//System.out.println("asdfsdfs  ");
		for(PoliticalParties i : pp)
		{
			if(votes.equals(i.name))
			{
				i.votes++;
			//	System.out.println("wassup "+ i.name);check=true;
				break;
			}
		}
		if(check)
		{
			String value="";
			String upvalue="";
			boolean chck=false;
			
			BufferedReader buffer =new BufferedReader(new FileReader("Poltics.txt"));
			while((value=buffer.readLine())!=null)
			{
				StringTokenizer tok=new StringTokenizer(value,",");
				String t=tok.nextToken();
			//	System.out.println("niomimi "+  t);
				if(votes.equals(t))
				{
		//			System.out.println("nothhing ");
					System.out.println(value);
					upvalue+=t+",";
					int inc;
					inc=Integer.parseInt(tok.nextToken());
					inc++;
					upvalue+=inc;
					chck=true;
					break;
				}
				value="";
				}
			buffer.close();
			
			System.out.println("Update line: "+ upvalue);
			
			if(chck==false)
			{
				System.out.println("oho");
			}
			else
			{

				File filetobemodified=new File("Poltics.txt");
				String oldsets="";
				BufferedReader br=null;
				FileWriter fr=null;
			try
			{
				br = new BufferedReader(new FileReader(filetobemodified));
				String line=br.readLine();
				
				while(line!=null)
				{
					oldsets=oldsets+line+System.lineSeparator();
					line=br.readLine();
				}
				br.close();
				String newsets=oldsets.replaceAll(value, upvalue);
				
				fr=new FileWriter(filetobemodified);
				fr.write(newsets);
				fr.close();
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not Found");
			}
			}
		}
	}
	public void back(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Display.fxml"));
		pane.getChildren().setAll(p);
	}

}
