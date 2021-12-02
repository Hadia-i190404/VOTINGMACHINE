package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class FirstController {
	@FXML
	private AnchorPane Pane;
	@FXML
	private TextArea text;
	@FXML
	private ListView<String> listing;
	
	public void back(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Display.fxml"));
		Pane.getChildren().setAll(p);
	}
	public void Instructions(ActionEvent event) throws IOException 
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Instruction.fxml"));
		Pane.getChildren().setAll(p);
	}
	public void partyupdate(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Parties.fxml"));
		Pane.getChildren().setAll(p);
		
	}
	public void addition(ActionEvent event) throws IOException
	{
		String nme=text.getText();
		PoliticalParties party=new PoliticalParties( );
		party.updateparties(nme);
		//party.setvotes(0);
	}
	public void ShowParties(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("PartyView.fxml"));
		Pane.getChildren().setAll(p);
	}
	public void Voting(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("Voting.fxml"));
		Pane.getChildren().setAll(p);
	}
	public void Voter(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("viewvoters.fxml"));
		Pane.getChildren().setAll(p);
	}
	public void showcount(ActionEvent event) throws IOException
	{
		AnchorPane p=FXMLLoader.load(getClass().getResource("count.fxml"));
		Pane.getChildren().setAll(p);
	}
}
