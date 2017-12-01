package sportextractor;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class SportExtractor extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = (Parent)FXMLLoader.load(getClass().getResource("Extractor.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Sport Extractor");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
