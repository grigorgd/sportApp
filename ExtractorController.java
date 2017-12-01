package sportextractor;

import Category.Category;
import Match.DownloadMatch;
import Match.Match;
import dbutil.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExtractorController implements Initializable {
    
    public ExtractorModel extractor = new ExtractorModel();
    
    //--------------------------------------------------------------
    //WIDOK GŁÓWNY
    //--------------------------------------------------------------
    
    @FXML
    private Label db;
    
    @FXML
    private Label lastAction;
    
    //--------------------------------------------------------------
    //WIDOK ZAKŁADU
    //--------------------------------------------------------------
    
    @FXML
    private ComboBox comboCategory;
    
    @FXML
    private ObservableList<String> comboCategoryList;
    
    private final String sqlCategorySelect = "SELECT * FROM League";
    
    @FXML
    private void loadCategory(){
        try{
            Connection con = DBConnection.getConnection();
            this.comboCategoryList = FXCollections.observableArrayList();
        
            ResultSet rs = con.createStatement().executeQuery(sqlCategorySelect);
            
            while(rs.next()){
                this.comboCategoryList.add(rs.getString(4));
            }
        }
        catch(SQLException ex){
            System.err.print("Error " + ex);
        }
//        comboCategory.setItems(null);
        comboCategory.getItems().addAll(comboCategoryList);
    }
    
    
    @FXML
    private Button loadMatchButton;
    
    @FXML
    private TableView<Match> matchTable;
    
    @FXML
    private TableColumn<Match, String> downloadDateColumn;
    
    @FXML
    private TableColumn<Match, String> homeNameColumn;
    
    @FXML
    private TableColumn<Match, String> awayNameColumn;
    
    @FXML
    private TableColumn<Match, Double> homeRateColumn;
    
    @FXML
    private TableColumn<Match, Double> drawRateColumn;
    
    @FXML
    private TableColumn<Match, Double> awayRateColumn;
    
    @FXML
    private TableColumn<Match, String> matchDateColumn;
    
    @FXML
    private TableColumn<Match, String> matchTimeColumn;
    
    @FXML
    private TableColumn<Match, String> matchResultColumn;
    
    private ObservableList<Match> dataMatch;
    
    @FXML
    private String statementMatchData(){
        if(comboCategory.getValue() == null) return null;
        String sql = "SELECT download_date, home_name, away_name, home_rate, draw_rate, away_rate, match_date, "
                + "match_time, match_result FROM Match INNER JOIN League ON Match.id_league = League.id_league "
                + "WHERE League.custom_name = \"" + comboCategory.getValue().toString() + "\"";
        return sql;
    }
    
    @FXML
    private void loadMatchData(ActionEvent event) throws SQLException{
       
        try(Connection con = DBConnection.getConnection()){
            this.dataMatch = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery(statementMatchData());
            
            while(rs.next()){
                this.dataMatch.add(new Match(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), 
                        rs.getDouble(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            this.downloadDateColumn.setCellValueFactory(new PropertyValueFactory<>("downloadDate"));
            this.homeNameColumn.setCellValueFactory(new PropertyValueFactory<>("homeName"));
            this.awayNameColumn.setCellValueFactory(new PropertyValueFactory<>("awayName"));
            this.homeRateColumn.setCellValueFactory(new PropertyValueFactory<>("homeRate"));
            this.drawRateColumn.setCellValueFactory(new PropertyValueFactory<>("drawRate"));
            this.awayRateColumn.setCellValueFactory(new PropertyValueFactory<>("awayRate"));
            this.matchDateColumn.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
            this.matchTimeColumn.setCellValueFactory(new PropertyValueFactory<>("matchTime"));
            this.matchResultColumn.setCellValueFactory(new PropertyValueFactory<>("matchResult"));

            this.matchTable.setItems(null);
            this.matchTable.setItems(this.dataMatch);
            
            con.close();
        }
        catch(SQLException ex){
            System.err.print("Error " + ex);
        }    
    }
    
    
    
    @FXML
    private void loadAllMatchData(ActionEvent event) throws SQLException{ 
       String statementAllMatchData = "SELECT download_date, home_name, away_name, home_rate, draw_rate, "
            + "away_rate, match_date, match_time, match_result FROM Match";
        
        try(Connection con = DBConnection.getConnection()){
            this.dataMatch = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery(statementAllMatchData);
            
            while(rs.next()){
                this.dataMatch.add(new Match(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), 
                        rs.getDouble(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            this.downloadDateColumn.setCellValueFactory(new PropertyValueFactory<>("downloadDate"));
            this.homeNameColumn.setCellValueFactory(new PropertyValueFactory<>("homeName"));
            this.awayNameColumn.setCellValueFactory(new PropertyValueFactory<>("awayName"));
            this.homeRateColumn.setCellValueFactory(new PropertyValueFactory<>("homeRate"));
            this.drawRateColumn.setCellValueFactory(new PropertyValueFactory<>("drawRate"));
            this.awayRateColumn.setCellValueFactory(new PropertyValueFactory<>("awayRate"));
            this.matchDateColumn.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
            this.matchTimeColumn.setCellValueFactory(new PropertyValueFactory<>("matchTime"));
            this.matchResultColumn.setCellValueFactory(new PropertyValueFactory<>("matchResult"));

            this.matchTable.setItems(null);
            this.matchTable.setItems(this.dataMatch);
            
            con.close();
        }
        catch(SQLException ex){
            System.err.print("Error " + ex);
        }
    }
    
    @FXML
    private Button updateButton;
    
    @FXML
    private Button updateAllButton;
    
//    private void updateData(ActionEvent event) throws IOException{
//        String sqlUpdate = "UPDATE Match SET download_date = ?, home_rate = ?, draw_rate = ?, away_rate = ? "
//            + "WHERE home_name = ?, away_name = ?, match_date = ?";
//        String sqlInsert = "INSERT INTO Match(download_date, home_name, away_name, home_rate, draw_rate, "
//            + "away_rate, match_date, match_time) VALUES (?,?,?,?,?,?,?,?)";
//        ArrayList<Match> lista = DownloadMatch.download(sqlCategory);
//        for(Match m : lista){
//            
//            try(Connection con = DBConnection.getConnection()){
//            
//            PreparedStatement statement = con.prepareStatement(sqlUpdate);
//            
//            statement.setString(1, this.leagueName.getText());
//            statement.setString(2, this.leagueLink.getText());
//            statement.setString(3, this.customName.getText());
//            
//            statement.execute();
//            con.close();
//            this.lastAction.setText("dodano kategorie do bazy");
//        }
//        catch(SQLException ex){
//            ex.printStackTrace();
//        }
//            
//        }
//    }
//    
//    private void updateAllData(ActionEvent event)throws IOException{
//        
//    }
    
    
    //--------------------------------------------------------------
    //WIDOK KATEGORII
    //--------------------------------------------------------------
    
    @FXML
    private TextField leagueName;
    
    @FXML
    private TextField leagueLink;
    
    @FXML
    private TextField customName;
    
    @FXML
    private Button addLeagueButton;
    
    @FXML
    private Button clearLeagueButton;
    
    @FXML
    private Button loadLeagueButton;
    
    @FXML
    private TableView<Category> categoryTable;
    
    @FXML
    private TableColumn<Category, String> leagueNameColumn;
    
    @FXML
    private TableColumn<Category, String> leagueLinkColumn;
    
    @FXML
    private TableColumn<Category, String> leagueCustomNameColumn;
    
    private final String sqlCategory = "SELECT * FROM League";
    
    private ObservableList<Category> dataCategory;
  
    @FXML
    private void loadCategoryData(ActionEvent event)throws SQLException{
        
        try(Connection con = DBConnection.getConnection()){
            this.dataCategory = FXCollections.observableArrayList();
        
            ResultSet rs = con.createStatement().executeQuery(sqlCategory);
            
            while(rs.next()){
                this.dataCategory.add(new Category(rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            
            this.leagueNameColumn.setCellValueFactory(new PropertyValueFactory<>("leagueName"));
            this.leagueLinkColumn.setCellValueFactory(new PropertyValueFactory<>("leagueLink"));
            this.leagueCustomNameColumn.setCellValueFactory(new PropertyValueFactory<>("customName"));

            this.categoryTable.setItems(null);
            this.categoryTable.setItems(this.dataCategory);
            
            con.close();
        }
        catch(SQLException ex){
            System.err.print("Error " + ex);
        } 
    }
    
    @FXML
    private void addCategory(ActionEvent event){
        String sqlInsert = "INSERT INTO League(league_name,league_link,custom_name) VALUES (?,?,?)";
        
        try(Connection con = DBConnection.getConnection()){
            
            PreparedStatement statement = con.prepareStatement(sqlInsert);
            
            statement.setString(1, this.leagueName.getText());
            statement.setString(2, this.leagueLink.getText());
            statement.setString(3, this.customName.getText());
            
            statement.execute();
            con.close();
            this.lastAction.setText("dodano kategorie do bazy");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void clearFields(ActionEvent event){
        this.leagueName.setText("");
        this.leagueLink.setText("");
        this.customName.setText("");
    }
    
    
    
    
    
    
    
    
    //--------------------------------------------------------------
    //INICJALIZACJA
    //--------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(this.extractor.isConnected()){
            this.db.setText("połączono...");
        }
        else{
            this.db.setText("nie połączono");
        }
        loadCategory();
    }
  
   
}
