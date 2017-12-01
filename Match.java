/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Grzesiek
 */
public class Match {
    
    private final SimpleStringProperty downloadDate;
    private final SimpleStringProperty homeName;
    private final SimpleStringProperty awayName;
    private final SimpleDoubleProperty homeRate;
    private final SimpleDoubleProperty drawRate;
    private final SimpleDoubleProperty awayRate;
    private final SimpleStringProperty matchDate;
    private final SimpleStringProperty matchTime;
    private final SimpleStringProperty matchResult;
    
    public Match(String downloadDate, String homeName, String awayName, Double homeRate, Double drawRate, Double awayRate, String matchDate, String matchTime, String matchResult){
        this.downloadDate = new SimpleStringProperty(downloadDate);
        this.homeName = new SimpleStringProperty(homeName);
        this.awayName = new SimpleStringProperty(awayName);
        this.homeRate = new SimpleDoubleProperty(homeRate);
        this.drawRate = new SimpleDoubleProperty(drawRate);
        this.awayRate = new SimpleDoubleProperty(awayRate);
        this.matchDate = new SimpleStringProperty(matchDate);
        this.matchTime = new SimpleStringProperty(matchTime);
        this.matchResult = new SimpleStringProperty(matchResult);
    }

    //----------------------------------------------DownloadDate
    public String getDownloadDate(){
        return downloadDate.get();
    }
    
    public SimpleStringProperty downloadDateProperty() {
        return downloadDate;
    }
    
    public void setDownloadDate(String downloadDate){
        this.downloadDate.set(downloadDate);
    }

    //----------------------------------------------HomeName
    public String getHomeName(){
        return homeName.get();
    }
    
    public SimpleStringProperty homeNameProperty() {
        return homeName;
    }
    
    public void setHomeName(String homeName){
        this.homeName.set(homeName);
    }

    //----------------------------------------------AwayName
    public String getAwayName(){
        return awayName.get();
    }
    
    public SimpleStringProperty awayNameProperty() {
        return awayName;
    }
    
    public void setAwayName(String awayName){
        this.awayName.set(awayName);
    }

    //----------------------------------------------HomeRate
    public Double getHomeRate(){
        return homeRate.get();
    }
    
    public SimpleDoubleProperty homeRateProperty() {
        return homeRate;
    }
    
    public void setHomeRate(Double homeRate){
        this.homeRate.set(homeRate);
    }

    //----------------------------------------------DrawRate
    public Double getDrawRate(){
        return drawRate.get();
    }
    
    public SimpleDoubleProperty drawRateProperty() {
        return drawRate;
    }
    
    public void setDrawRate(Double drawRate){
        this.drawRate.set(drawRate);
    }

    //----------------------------------------------AwayRate
    public Double getAwayRate(){
        return awayRate.get();
    }
    
    public SimpleDoubleProperty awayRateProperty() {
        return awayRate;
    }
    
    public void setAwayRate(Double awayRate){
        this.awayRate.set(awayRate);
    }

    //----------------------------------------------DownloadDate
    public String getMatchDate(){
        return matchDate.get();
    }
    
    public SimpleStringProperty matchDateProperty() {
        return matchDate;
    }
    
    public void setMatchDate(String matchDate){
        this.matchDate.set(matchDate);
    }
    
    //----------------------------------------------MatchTime
    public String getMatchTime(){
        return matchTime.get();
    }
    
    public SimpleStringProperty matchTimeProperty() {
        return matchTime;
    }
    
    public void setMatchTime(String matchTime){
        this.matchTime.set(matchTime);
    }

    //----------------------------------------------MatchResult
    public String getMatchResult(){
        return matchResult.get();
    }
    
    public SimpleStringProperty matchResultProperty() {
        return matchResult;
    }
    
    public void setMatchResult(String matchResult){
        this.matchResult.set(matchResult);
    }
    
}
