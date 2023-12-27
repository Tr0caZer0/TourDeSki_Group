package application;



import java.sql.Time;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.application.Platform;


public class Main extends Application implements EventHandler<ActionEvent> {

	Timer timer = new Timer();
	Contestant contestant = new Contestant();
	SkiTimerLogic logic = new SkiTimerLogic();
	
	Label welcome;
	Button start1;
	Button start2;
	Button start3;
	Button clear;
	Button nr0;
	Button nr1;
	Button nr2;
	Button nr3;
	Button nr4;
	Button nr5;
	Button nr6;
	Button nr7;
	Button nr8;
	Button nr9;
	Scene scene2;
	TextField search2;
	GridPane grid;
	
//	Second window
	Button start;
	Button takeTime;
	Button finish;
	Button stop;
	Button saveFile;
	Button clear2;
	Button nr00;
	Button nr11;
	Button nr22;
	Button nr33;
	Button nr44;
	Button nr55;
	Button nr66;
	Button nr77;
	Button nr88;
	Button nr99;
	Button blank;
	Label header;
	Scene scene1;
	TextField search;
	GridPane grid2;
	
	TableView<Contestant> resultTable;
	ObservableList<Contestant> resultList;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
//		start1.setOnAction(e -> {primaryStage.setScene(scene2); logic.skierList("1", "Mass");}); 
			primaryStage.setTitle("Ski timer");
			
			start1 = new Button();		
			start1.setText("Mass");
			start1.setOnAction(e -> {primaryStage.setScene(scene2); 
									String groupNumber = search2.getText();
									logic.skierList(groupNumber, "Mass");
									}); // Här måste logiken för start-valet in. 
																	//Så att rätt inställningar körs i nästa fönster
			start1.setMinSize(100, 54);								// Jag tänker också att var och en av startvalsknapparna ska 
			start1.setMaxSize(100, 54);								//funka som "OK" för "Search group"-fältet
			start1.setFont(Font.font("Arial", FontWeight.BOLD ,10 ));
			start1.setStyle(
					 "-fx-background-color: #CCD8A2 ; "
					+ "-fx-text-fill: #6F7178; "
					+ "-fx-border-color: #6F7178; "
					+ "-fx-border-width: 1px;"
					+"-fx-background-radius: 3px; "
					+"-fx-border-radius: 3px;");
		
			start2 = new Button();		
			start2.setText("Interval");
			start2.setOnAction(e -> primaryStage.setScene(scene2) );// Här måste logiken för start-valet in. Så att rätt inställningar körs i nästa fönster
			start2.setMinSize(100, 54);
			start2.setMaxSize(100, 54);
			start2.setFont(Font.font("Arial", FontWeight.BOLD ,10 ));
			start2.setStyle(
					 "-fx-background-color: #EFE2AF ; "
					+ "-fx-text-fill: #6F7178; "
					+ "-fx-border-color: #6F7178; "
					+ "-fx-border-width: 1px;"
					+"-fx-background-radius: 3px; "
					+"-fx-border-radius: 3px;");
			
			start3 = new Button();		
			start3.setText("Pursuit");
			start3.setOnAction(e -> primaryStage.setScene(scene2));// Här måste logiken för start-valet in. Så att rätt inställningar körs i nästa fönster
			start3.setMinSize(100, 54);
			start3.setMaxSize(100, 54);
			start3.setFont(Font.font("Arial", FontWeight.BOLD ,10 ));
			start3.setStyle(
					 "-fx-background-color: #F8AB81 ; "
					+ "-fx-text-fill: #6F7178; "
					+ "-fx-border-color: #6F7178; "
					+ "-fx-border-width: 1px;"
					+"-fx-background-radius: 3px; "
					+"-fx-border-radius: 3px;");
			
			//Siffer-knappar
			nr0= new Button();
			nr0.setText("0");
			nr0.setOnAction(e ->appendToSearch2 ("0"));
			nr0.setMinSize(60, 40);
			nr0.setMaxSize(60, 40);
			nr0.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr0.setStyle("-fx-background-color: #fffcf2; "
				 		+ "-fx-border-color: #6F7178;"
				 		+ "-fx-text-fill:#6F7178;"
				 		+ "-fx-border-width: 1px;"
				 		+ "-fx-background-radius: 3px; "
				 		+ "-fx-border-radius: 3px;");
			
			
			nr1= new Button();
			nr1.setText("1");
			nr1.setOnAction(e -> appendToSearch2 ("1"));
			nr1.setMinSize(60, 40);
			nr1.setMaxSize(60, 40);
			nr1.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr1.setStyle("-fx-background-color: #fffcf2; "
				 		+ "-fx-border-color: #6F7178;"
				 		+ "-fx-text-fill:#6F7178;"
				 		+ "-fx-border-width: 1px;"
				 		+ "-fx-background-radius: 3px; "
				 		+ "-fx-border-radius: 3px;");
			
			nr2= new Button();
			nr2.setText("2");
			nr2.setOnAction(e ->appendToSearch2 ("2"));
			nr2.setMinSize(60, 40);
			nr2.setMaxSize(60, 40);
			nr2.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr2.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr3= new Button();
			nr3.setText("3");
			nr3.setOnAction(e ->appendToSearch2 ("3"));
			nr3.setMinSize(60, 40);
			nr3.setMaxSize(60, 40);
			nr3.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr3.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr4= new Button();
			nr4.setText("4");
			nr4.setOnAction(e ->appendToSearch2 ("4"));
			nr4.setMinSize(60, 40);
			nr4.setMaxSize(60, 40);
			nr4.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr4.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr5= new Button();
			nr5.setText("5");
			nr5.setOnAction(e ->appendToSearch2 ("5"));
			nr5.setMinSize(60, 40);
			nr5.setMaxSize(60, 40);
			nr5.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr5.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr6= new Button();
			nr6.setText("6");
			nr6.setOnAction(e ->appendToSearch2 ("6"));
			nr6.setMinSize(60, 40);
			nr6.setMaxSize(60, 40);
			nr6.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr6.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr7= new Button();
			nr7.setText("7");
			nr7.setOnAction(e ->appendToSearch2 ("7"));
			nr7.setMinSize(60, 40);
			nr7.setMaxSize(60, 40);
			nr7.setFont(Font.font("Arial", FontWeight.BOLD,14));
			nr7.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr8= new Button();
			nr8.setText("8");
			nr8.setOnAction(e ->appendToSearch2 ("8"));
			nr8.setMinSize(60, 40);
			nr8.setMaxSize(60, 40);
			nr8.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr8.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr9= new Button();
			nr9.setText("9");
			nr9.setOnAction(e ->appendToSearch2 ("9"));
			nr9.setMinSize(60, 40);
			nr9.setMaxSize(60, 40);
			nr9.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr9.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			clear2 = new Button();
			clear2.setText("CL");
			clear2.setOnAction(e-> clearSearch2());
			clear2.setMinSize(60, 40);
			clear2.setMaxSize(60, 40);
			clear2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
			clear2.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			blank = new Button();
			blank.setText("");
			blank.setMinSize(60, 40);
			blank.setMaxSize(60, 40);
			blank.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			//Sökfältet
			search2 = new TextField();
			search2.setPromptText("Search group");
			search2.setMinSize(292, 40);
			search2.setMaxSize(292, 40);
			search2.setStyle("-fx-border-color: #6F7178; -fx-border-width: 1px; "
					+ "					-fx-border-color: #6F7178;"
					+ "			 		-fx-border-width: 1px;"
					+ "			 		-fx-background-radius: 3px; "
					+ "			 		-fx-border-radius: 3px;"
					+"					-fx-border-color: #6F7178;"
					+ "			 		-fx-border-width: 1px;");
					
			
			
			//Welcome-label
			welcome = new Label();
			welcome.setMinSize(292, 20);
			welcome.setMaxSize(292, 20);
			welcome.setText("Chose group and start type");
			welcome.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			welcome.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			welcome.setAlignment(Pos.CENTER);
			
			//Grid till sifferknapparna
			grid = new GridPane();
			grid.setPadding(new Insets(6));
			grid.setVgap(2);
			grid.setHgap(2);
			grid.setConstraints(nr1,0, 0);
			grid.setConstraints(nr2, 1, 0);
			grid.setConstraints(nr3, 2, 0);
			grid.setConstraints(nr4, 0, 1);
			grid.setConstraints(nr5, 1, 1);
			grid.setConstraints(nr6, 2, 1);
			grid.setConstraints(nr7, 0, 2);
			grid.setConstraints(nr8, 1, 2);
			grid.setConstraints(nr9, 2, 2);
			grid.setConstraints(nr0, 1, 3);
			grid.setConstraints(blank,0,3);
			grid.setConstraints(clear2, 2,3);
			grid.getChildren().addAll(nr1, nr2, nr3, nr4, nr5, nr6, nr7, nr8, nr9, nr0,  blank, clear2);
		
			
			//VBox till startknapparna
			VBox startVbox = new VBox();
			startVbox.setPadding(new Insets(0));
			startVbox.setSpacing(2);
			startVbox.alignmentProperty().setValue(Pos.CENTER);
			startVbox.getChildren().addAll( start1, start2, start3);
			
			
			//HBox till bottendelen av BorderPane
			HBox bottom2 = new HBox();
			bottom2.setPadding(new Insets(0));
			bottom2.setSpacing(0);
			bottom2.setPadding(new Insets (15));
			bottom2.setAlignment(Pos.TOP_CENTER);
			bottom2.getChildren().addAll(grid, startVbox);
			
			//VBox till search
			VBox vBoxSearchList2 = new VBox();
			vBoxSearchList2.setPadding(new Insets (0));
			vBoxSearchList2.setSpacing(20);
			vBoxSearchList2.getChildren().addAll(welcome,search2);
			
			
			//Hela layouten in i BorderPane
			BorderPane borderPane2 = new BorderPane();
			borderPane2.setBottom(bottom2);
			borderPane2.setCenter( vBoxSearchList2);
			vBoxSearchList2.setAlignment(Pos.BOTTOM_CENTER);
			
			
			//Svart ram runt hela alltet
			 borderPane2.setStyle("-fx-border-color: #6F7178; -fx-border-width: 3px;");		
			/*
			//VBox till startknapparna
			VBox startVbox = new VBox();
			startVbox.setPadding(new Insets(0));
			startVbox.setSpacing(2);
			startVbox.alignmentProperty().setValue(Pos.CENTER);
			startVbox.getChildren().addAll(welcome, start1, start2, start3);
		
			//VBox till bottendelen av BorderPane
			VBox bottom2 = new VBox();
			bottom2.setPadding(new Insets(0));
			bottom2.setSpacing(0);
			bottom2.setPadding(new Insets (15));
			bottom2.setAlignment(Pos.TOP_CENTER);
			bottom2.getChildren().addAll(search, grid);
			
			
			//Hela layouten in i BorderPane
			BorderPane borderPane2 = new BorderPane();
			borderPane2.setBottom(bottom2);
			borderPane2.setCenter(startVbox);
			startVbox.setAlignment(Pos.CENTER);
			
			*/
			
			
			//SIDA TVÅ
			
		
			//Många många knappar!
			
			//Start-knapp
			start = new Button();
			start.setText("Start");
			start.setMinSize(100, 40);
			start.setMaxSize(100, 40);
			start.setOnAction(e -> {System.out.println("Klockan startas"); 
										logic.addTimeToContestant("Start", null);
										Platform.runLater(() -> {
										    resultList.setAll(logic.contestants);
										});
									});
			start.setFont(Font.font("Arial", FontWeight.BOLD, 10));
			start.setStyle( "-fx-background-color: #CCD8A2 ; "
					+ "-fx-text-fill: #6F7178; "
					+ "-fx-border-color: #6F7178; "
					+ "-fx-border-width: 1px;"
					+"-fx-background-radius: 3px; "
					+"-fx-border-radius: 3px;");
			
			//Reset-knapp
			stop = new Button();
			stop.setText("Stop");
			stop.setOnAction(event -> {
			logic.quitApp("Application closed");});
			stop.setMinSize(100, 40);
			stop.setMaxSize(100, 40);
			stop.setFont(Font.font("Arial", FontWeight.BOLD ,10 ));
			stop.setStyle(
					 "-fx-background-color: #d16c45 ; "
					+ "-fx-text-fill: #6F7178; "
					+ "-fx-border-color: #6F7178; "
					+ "-fx-border-width: 1px;"
					+"-fx-background-radius: 3px; "
					+"-fx-border-radius: 3px;");
			//Calls to stop the application
			
			
			
			//Mellantidsknapp
			takeTime = new Button();
			takeTime.setText("Take time");
			takeTime.setOnAction(e ->{ System.out.println("Taking Intrevall time");
				String startNumber = search.getText();
				logic.addTimeToContestant("Lap", startNumber);
				search.setText("");
				Platform.runLater(() -> {
				    resultList.setAll(logic.contestants);
				});
			});		
			takeTime.setMinSize(100, 40);
			takeTime.setMaxSize(100, 40);
			takeTime.setFont(Font.font("Arial", FontWeight.BOLD ,10 ));
			takeTime.setStyle(
					 "-fx-background-color: #F8AB81 ; "
					+ "-fx-text-fill: #6F7178; "
					+ "-fx-border-color: #6F7178; "
					+ "-fx-border-width: 1px;"
					+"-fx-background-radius: 3px; "
					+"-fx-border-radius: 3px;");
	

			//Slutresultatsknapp
			finish = new Button();
			finish.setText("Finish");
//			Stoppa tid, töm fönster med lista.
			finish.setOnAction(e -> {
			System.out.println("Sluttid");
			String startNumber = search.getText();
			logic.addTimeToContestant("Goal", startNumber);	
			search.setText("");
			Platform.runLater(() -> {
			    resultList.setAll(logic.contestants);
			});
			});
			finish.setMinSize(100, 40);
			finish.setMaxSize(100, 40);
			finish.setFont(Font.font("Arial", FontWeight.BOLD,10 ));
			finish.setStyle( "-fx-background-color: #EFE2AF; "
					+ "-fx-text-fill: #6F7178; "
					+ "-fx-border-color: #6F7178; "
					+ "-fx-border-width: 1px;"
					+"-fx-background-radius: 3px; "
					+"-fx-border-radius: 3px;");
			 
			
			saveFile = new Button();		
			saveFile.setText("Save file");
			saveFile.setOnAction(e-> {System.out.println("Saving to file"); logic.saveCompetitionScore();});
			saveFile.setMinSize(60, 40);
			saveFile.setMaxSize(60, 40);
			saveFile.setFont(Font.font("Arial", FontWeight.BOLD, 9));
			saveFile.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			clear2 = new Button();
			clear2.setText("CL");
			clear2.setOnAction(e-> clearSearch());
			clear2.setMinSize(60, 40);
			clear2.setMaxSize(60, 40);
			clear2.setFont(Font.font("Arial", FontWeight.BOLD, 9));
			clear2.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			
			//Sökfältet
			search = new TextField();
			search.setPromptText("Search bib");
			search.setMinSize(292, 40);
			search.setMaxSize(292, 40);
			search.setStyle("-fx-border-color: #6F7178; -fx-border-width: 1px; "
					+ "					-fx-border-color: #6F7178;"
					+ "			 		-fx-border-width: 1px;"
					+ "			 		-fx-background-radius: 3px; "
					+ "			 		-fx-border-radius: 3px;"
					+"					-fx-border-color: #6F7178;"
					+ "			 		-fx-border-width: 1px;");
			
//			// Rubrik till resultattabellen
			header = new Label();
			header.setMinSize(292, 20);
			header.setMaxSize(292, 20);
			header.setText("RESULT LIST");
			header.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			header.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			header.setAlignment(Pos.CENTER);
			
			
			
			//Listan med åkare
			resultList = FXCollections.observableArrayList(logic.contestants);
			
			TableColumn <Contestant, String> nrColumn = new TableColumn <> ("NR");
			nrColumn.setMinWidth(22);
			nrColumn.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 8;");
			nrColumn.setCellValueFactory(new PropertyValueFactory<> ("startNumber"));
			
			TableColumn <Contestant, String> nameColumn = new TableColumn <>("Name");
			nameColumn.setMinWidth(150);
			nameColumn.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 8;");
			nameColumn.setCellValueFactory(new PropertyValueFactory<>( "name"));
			
//			Add startTime
					
			TableColumn <Contestant, String> timeColumn1 = new TableColumn <> ("SPLIT"); //HÄR MÅSTE TIDSOBJEKTET FIPPLAS IHOP 
			timeColumn1.setMinWidth(60);
			timeColumn1.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 8;");
			timeColumn1.setCellValueFactory(new PropertyValueFactory <> ("interval"));
			
			TableColumn <Contestant, String> timeColumn2 = new TableColumn <>("GOAL"); // Kopplat till samma som timeColumn1 för nu.
			timeColumn2.setMinWidth(60);
			timeColumn2.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 8;");
			timeColumn2.setCellValueFactory(new PropertyValueFactory <> ("goal"));
			
			
			resultTable = new TableView<>();
			resultTable.setItems(resultList);
			resultTable.getColumns().addAll(nrColumn, nameColumn, timeColumn1, timeColumn2);
			resultTable.setMinSize(292, 250);
			resultTable.setMaxSize(292, 250);
			resultTable.setStyle("-fx-border-color: #6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
		
			// Sifferknappar. Igen
			
			nr00= new Button();
			nr00.setText("0");
			nr00.setOnAction(e ->appendToSearch ("0"));
			nr00.setMinSize(60, 40);
			nr00.setMaxSize(60, 40);
			nr00.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr00.setStyle("-fx-background-color: #fffcf2; "
				 		+ "-fx-border-color: #6F7178;"
				 		+ "-fx-text-fill:#6F7178;"
				 		+ "-fx-border-width: 1px;"
				 		+ "-fx-background-radius: 3px; "
				 		+ "-fx-border-radius: 3px;");
			
			
			nr11= new Button();
			nr11.setText("1");
			nr11.setOnAction(e -> appendToSearch ("1"));
			nr11.setMinSize(60, 40);
			nr11.setMaxSize(60, 40);
			nr11.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr11.setStyle("-fx-background-color: #fffcf2; "
				 		+ "-fx-border-color: #6F7178;"
				 		+ "-fx-text-fill:#6F7178;"
				 		+ "-fx-border-width: 1px;"
				 		+ "-fx-background-radius: 3px; "
				 		+ "-fx-border-radius: 3px;");
			
			nr22= new Button();
			nr22.setText("2");
			nr22.setOnAction(e ->appendToSearch ("2"));
			nr22.setMinSize(60, 40);
			nr22.setMaxSize(60, 40);
			nr22.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr22.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr33= new Button();
			nr33.setText("3");
			nr33.setOnAction(e ->appendToSearch ("3"));
			nr33.setMinSize(60, 40);
			nr33.setMaxSize(60, 40);
			nr33.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr33.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr44= new Button();
			nr44.setText("4");
			nr44.setOnAction(e ->appendToSearch ("4"));
			nr44.setMinSize(60, 40);
			nr44.setMaxSize(60, 40);
			nr44.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr44.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr55= new Button();
			nr55.setText("5");
			nr55.setOnAction(e ->appendToSearch ("5"));
			nr55.setMinSize(60, 40);
			nr55.setMaxSize(60, 40);
			nr55.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr55.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr66= new Button();
			nr66.setText("6");
			nr66.setOnAction(e ->appendToSearch ("6"));
			nr66.setMinSize(60, 40);
			nr66.setMaxSize(60, 40);
			nr66.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr66.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr77= new Button();
			nr77.setText("7");
			nr77.setOnAction(e ->appendToSearch ("7"));
			nr77.setMinSize(60, 40);
			nr77.setMaxSize(60, 40);
			nr77.setFont(Font.font("Arial", FontWeight.BOLD,14));
			nr77.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr88= new Button();
			nr88.setText("8");
			nr88.setOnAction(e ->appendToSearch ("8"));
			nr88.setMinSize(60, 40);
			nr88.setMaxSize(60, 40);
			nr88.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr88.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			nr99= new Button();
			nr99.setText("9");
			nr99.setOnAction(e ->appendToSearch ("9"));
			nr99.setMinSize(60, 40);
			nr99.setMaxSize(60, 40);
			nr99.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr99.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			
			//Grid till sifferknapparna
		
			grid2 = new GridPane();
			grid2.setPadding(new Insets(6));
			grid2.setVgap(2);
			grid2.setHgap(2);
			grid2.setConstraints(nr11,0, 0);
			grid2.setConstraints(nr22, 1, 0);
			grid2.setConstraints(nr33, 2, 0);
			grid2.setConstraints(nr44, 0, 1);
			grid2.setConstraints(nr55, 1, 1);
			grid2.setConstraints(nr66, 2, 1);
			grid2.setConstraints(nr77, 0, 2);
			grid2.setConstraints(nr88, 1, 2);
			grid2.setConstraints(nr99, 2, 2);
			grid2.setConstraints(nr00, 1, 3);
			grid2.setConstraints(saveFile,0,3);
			grid2.setConstraints(clear2, 2,3);
			grid2.getChildren().addAll(nr11, nr22, nr33, nr44, nr55, nr66, nr77, nr88, nr99, nr00, clear2, saveFile);
			
			
			//VBox till de stora knapparna
			VBox bigButtons = new VBox();
			bigButtons.setPadding(new Insets(0));
			bigButtons.setSpacing(2);
			bigButtons.alignmentProperty().setValue(Pos.CENTER);
			bigButtons.getChildren().addAll(start, takeTime, finish, stop);
			
			
			//HBox till bottendelen av BorderPane
			HBox bottom = new HBox();
			bottom.setPadding(new Insets(0));
			bottom.setSpacing(0);
			bottom.setPadding(new Insets (15));
			bottom.setAlignment(Pos.TOP_CENTER);
			bottom.getChildren().addAll(grid2, bigButtons);
			
			//VBox till searchField, header och listView
			VBox vBoxSearchList = new VBox();
			vBoxSearchList.setPadding(new Insets (0));
			vBoxSearchList.setSpacing(20);
			vBoxSearchList.getChildren().addAll(header, resultTable,search);
			
			
			//Hela layouten in i BorderPane
			BorderPane borderPane1 = new BorderPane();
			borderPane1.setBottom(bottom);
			borderPane1.setCenter( vBoxSearchList);
			vBoxSearchList.setAlignment(Pos.BOTTOM_CENTER);
			
			
			//Svart ram runt hela alltet
			 borderPane1.setStyle("-fx-border-color: #6F7178; -fx-border-width: 3px;");			
		     
		     scene1 = new Scene(borderPane2, 400, 600);
		     primaryStage.setScene(scene1);
		     primaryStage.show();

		     scene2 = new Scene(borderPane1, 400, 600); 
			
		} catch(Exception e) {
			e.printStackTrace();
	}
}
	
		public static void main(String[] args) {
		launch(args);

}

		@Override
		public void handle(ActionEvent arg0) {
		}
	
		private void appendToSearch(String text) {
		    search.appendText(text);
		}
		private void appendToSearch2(String text2) {
		    search2.appendText(text2);
		}
		
		private void clearSearch() {
		    search.clear();
}
		private void clearSearch2() {
		    search2.clear();
}
}


/* 
CCD8A2 grön
EFE2AF gul
F8AB81 orange
F4A261
*/