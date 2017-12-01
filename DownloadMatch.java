/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Grzesiek
 */
public class DownloadMatch {
    // ####################### pobieranie zakladów #######################
    
    public static ArrayList<Match> download(String url)throws IOException{
        ArrayList<Match> resultPack = new ArrayList<>();
        
        Document doc = Jsoup.connect(url).get();
        String title = doc.select("h1.bet_table_title").text().trim(); //pobiera tytul
        Elements betsAll = doc.select("tr.toggable_row"); // pobiera wszystkie zaklady
        
        Elements teamName;
        String[] teamsNames;
        Elements bet;
        ArrayList<Double> bets = new ArrayList<>();
        String[] dateTemp;
        
        for(Element b : betsAll){
            
            //------------------------------------------
            //NAMES
            //------------------------------------------
            teamName = b.select("a[class^=bet_item]");
            teamsNames = teamName.text().split("-");
            
            //------------------------------------------
            //BETS
            //------------------------------------------
            bet = b.select("a[class^=add_bet_link]");
            for(Element el : bet){
                bets.add(Double.parseDouble(el.attr("data-rate")));
            }
            
            //------------------------------------------
            //MATCH DATE
            //------------------------------------------
            dateTemp = b.select("span[id^=datetime]").first().text().split(" "); 
            String[] dt = dateTemp[0].split("\\.");//podzielenie daty [dzien, miesiac]
            String[] tt = dateTemp[1].split(":");//podzielenie godziny [godzina, minuta]
            LocalDate aLocalDate = LocalDate.of(2017, Integer.parseInt(dt[1]), Integer.parseInt(dt[0]));
            LocalTime aLocalTime = LocalTime.of(Integer.parseInt(tt[0]), Integer.parseInt(tt[1]));
            
            resultPack.add(new Match(LocalDateTime.now().toString(), teamsNames[0], teamsNames[1], bets.get(0), bets.get(1), bets.get(2), aLocalDate.toString(), aLocalTime.toString(), null));
            
        }
        return resultPack;
    }
    
}
