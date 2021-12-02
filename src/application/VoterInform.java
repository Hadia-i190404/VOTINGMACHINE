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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class VoterInform implements Initializable{

	
	@FXML
	private AnchorPane vpane;
	@FXML
	private ListView<String> lw;
	
	Vector<Voter> vots=new Vector<Voter>();
	Vector<String> voter=new Vector<String>();
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try
		{
			reading();
		}
		catch(IOException ioe)
		{
			System.out.println("error");
		}
		
		for(Voter i : vots)
		{
			String l=i.voter+"   "+ Integer.toString(i.vc);
			voter.add(l);
		}
		lw.getItems().addAll(voter);
	}
	public void reading() throws IOException
	{
		String s;
		BufferedReader br = new BufferedReader(new FileReader("Voter.txt"));
		while((s=br.readLine())!=null)
		{
			StringTokenizer tok=new StringTokenizer(s,",");
			String t1=tok.nextToken(); String t2=tok.nextToken(); 
			Voter ves=new Voter(t1,Integer.parseInt(t2));
			System.out.println("namre: "+ t1 + t2);
			vots.add(ves);
		}
	}
	public void back(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Display.fxml"));
		vpane.getChildren().setAll(p);
	}
}
