package application;




import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
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
	
	
	Button start;
//	Lägger till stop
//	Button stop;
//	Används inte
//	Button addParticipant;
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
	Button blank;
	Button enter;

	Button finish;
	Button clear;
	Button takeTime;
	Button stop;
	Scene scene1;
	Scene scene2;
	TextField search;
	TextField listView;
	Label header;
	TableView<Contestant> resultTable;
	ObservableList<Contestant> resultList;
	
	
	@Override
	public void start(Stage primaryStage) {
		logic.skierList();
		try {
		
			primaryStage.setTitle("Ski timer");

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
			
			//Slutresultatsknapp
			stop = new Button();
			stop.setText("Stop");
//			goalTime.setOnAction(e -> );
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
			
			stop.setOnAction(event -> 
			logic.quitApp("Application closed"));

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
			 
			
			//Siffer-knappar
			nr0= new Button();
			nr0.setText("0");
			nr0.setOnAction(e ->appendToSearch ("0"));
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
			nr1.setOnAction(e -> appendToSearch ("1"));
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
			nr2.setOnAction(e ->appendToSearch ("2"));
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
			nr3.setOnAction(e ->appendToSearch ("3"));
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
			nr4.setOnAction(e ->appendToSearch ("4"));
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
			nr5.setOnAction(e ->appendToSearch ("5"));
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
			nr6.setOnAction(e ->appendToSearch ("6"));
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
			nr7.setOnAction(e ->appendToSearch ("7"));
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
			nr8.setOnAction(e ->appendToSearch ("8"));
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
			nr9.setOnAction(e ->appendToSearch ("9"));
			nr9.setMinSize(60, 40);
			nr9.setMaxSize(60, 40);
			nr9.setFont(Font.font("Arial", FontWeight.BOLD,14 ));
			nr9.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			clear = new Button();
			clear.setText("CL");
			clear.setOnAction(e-> clearSearch());
			clear.setMinSize(60, 40);
			clear.setMaxSize(60, 40);
			clear.setFont(Font.font("Arial", FontWeight.BOLD, 14));
			clear.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
			 		+ "-fx-text-fill:#6F7178;"
			 		+ "-fx-border-width: 1px;"
			 		+ "-fx-background-radius: 3px; "
			 		+ "-fx-border-radius: 3px;");
			
			blank = new Button();
			blank.setText(" ");
			blank.setMinSize(60, 40);
			blank.setMaxSize(60, 40);
			blank.setStyle("-fx-background-color: #fffcf2; "
			 		+ "-fx-border-color: #6F7178;"
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
			
// JUst as I can write over the time i must be able to write over the startnumber and name. 
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
			timeColumn1.setCellValueFactory(new PropertyValueFactory <> ("intervall"));
			
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
	
			
			//Grid till sifferknapparna
			GridPane grid = new GridPane();
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
			grid.setConstraints(clear, 2,3);
			grid.getChildren().addAll(nr1, nr2, nr3, nr4, nr5, nr6, nr7, nr8, nr9, nr0, clear, blank);
			
			
			//VBox till de stora knapparna
			VBox bigButtons = new VBox();
			bigButtons.setPadding(new Insets(0));
			bigButtons.setSpacing(2);
			bigButtons.alignmentProperty().setValue(Pos.CENTER);
			bigButtons.getChildren().addAll(start,takeTime, finish, stop);
			
			
			//HBox till bottendelen av BorderPane
			HBox bottom = new HBox();
			bottom.setPadding(new Insets(0));
			bottom.setSpacing(0);
			bottom.setPadding(new Insets (15));
			bottom.setAlignment(Pos.TOP_CENTER);
			bottom.getChildren().addAll(grid, bigButtons);
			
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
			 
		
			 scene1 = new Scene(borderPane1, 400, 600);
		     primaryStage.setScene(scene1);
		     primaryStage.show();
			
			
			
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
		
		private void clearSearch() {
		    search.clear();
}
}


/* 
CCD8A2 grön
EFE2AF gul
F8AB81 orange
F4A261
*/