package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class PartiesController implements Initializable{
	@FXML
	private AnchorPane PartyPane;
	@FXML
	private TextArea t;
	@FXML
	private ListView<String> lists;
	
	Vector<PoliticalParties> pp=new Vector<PoliticalParties>();
	Vector<String>Partyname =new Vector<String>(); 
	
	
	
	public void back(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Display.fxml"));
		PartyPane.getChildren().setAll(p);
	}
	
	public void reading() throws IOException
	{
		String s;
		BufferedReader br = new BufferedReader(new FileReader("Poltics.txt"));
		while((s=br.readLine())!=null)
		{
			StringTokenizer tok=new StringTokenizer(s,",");
			PoliticalParties party=new PoliticalParties(tok.nextToken(),Integer.parseInt(tok.nextToken()));
			System.out.println("Party name "+ party.name );
			pp.add(party);
		}
	}
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
			String l=i.name;
			System.out.println("lllll   "+ l + "\n");
			Partyname.add(l);
		}
		
		lists.getItems().addAll(Partyname);
	}

}
