package application;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
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

public class VoteCount implements Initializable {

	@FXML
	private AnchorPane cpane;
	@FXML
	private ListView<String> lw;
	@FXML 
	private TextArea ta;
	
	 Vector<PoliticalParties> p=new Vector<PoliticalParties>();
	 Vector<String> parties=new Vector<String>();
//	private String[] parties = {"PMLN","PTI","PPP"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
			getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		for(PoliticalParties i : p) {
			
			String l=i.name+ "    " + Integer.toString(i.votes);
			System.out.println("lllll   "+ l + "\n");
			parties.add(l);
		}		
		
		lw.getItems().addAll(parties);	
		//lw.setOnAction(this::incVote);
	}
	
	
	public void getData() throws IOException {
		String line;
		BufferedReader br=new BufferedReader(new FileReader("Poltics.txt"));
		while( (line = br.readLine() )!= null) {
			StringTokenizer t=new StringTokenizer(line,",");
			PoliticalParties pp=new PoliticalParties(t.nextToken(), Integer.parseInt(t.nextToken()));
			System.out.println("votecount  "+ pp.votes + "\n");
			p.add(pp);
		}		
	}
	public void back(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Display.fxml"));
		cpane.getChildren().setAll(p);
	}
}	