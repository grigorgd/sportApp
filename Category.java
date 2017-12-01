/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Category;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Grzesiek
 */
public class Category {
    
    private final SimpleStringProperty leagueName;
    private final SimpleStringProperty leagueLink;
    private final SimpleStringProperty customName;
    
    public Category(String leagueName, String leagueLink, String customName){
        this.leagueName = new SimpleStringProperty(leagueName);
        this.leagueLink = new SimpleStringProperty(leagueLink);
        this.customName = new SimpleStringProperty(customName);
    }

    //----------------------------------------------LeagueName
    public String getLeagueName(){
        return leagueName.get();
    }
    
    public StringProperty leagueNameProperty() {
        return leagueName;
    }
    
    public void setLeagueName(String leagueName){
        this.leagueName.set(leagueName);
    }

    //----------------------------------------------LeagueLink
    public String getLeagueLink(){
        return leagueLink.get();
    }
    
    public StringProperty leagueLinkProperty() {
        return leagueLink;
    }
    
    public void setLeagueLink(String leagueLink){
        this.leagueLink.set(leagueLink);
    }

    //----------------------------------------------CustomName
    public String getCustomName(){
        return customName.get();
    }
    
    public StringProperty customNameProperty() {
        return customName;
    }
    
    public void setCustomName(String customName){
        this.customName.set(customName);
    }
    
}
