/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Grzesiek
 */
public class DownloadResult {
     
    private final String homeName;
    private final String awayName;
    private final String result;
    
    public DownloadResult(String homeName, String awayName, String result){
        this.homeName = homeName;
        this.awayName = awayName;
        this.result = result;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public String getResult() {
        return result;
    }
    
    public static ArrayList<DownloadResult> download(String leagueName, LocalDate resultDate)throws IOException{
        String url = "https://www.efortuna.pl/pl/strona_glowna/wyniki/" + resultDate.toString();
        
        Document doc = Jsoup.connect(url).get();
        //=====================================sprawdzam czy sa wyniki meczow danej ligi adnego dnia
        //=====================================jeśli nie ma zwaracam null
        if(doc.select("div.body:contains(" + leagueName + ")").first() == null){
            return null;
        }
        Element body = doc.select("div.body:contains(" + leagueName + ")").first();
        Elements tr = body.select("tbody > tr");
        
        Element teamName2;
        String teamName;
        String[] teamsNames;
        String res;
        ArrayList<DownloadResult> wyniki = new ArrayList<>();
        
        for(Element b : tr){
            teamName2 = b.select("span.bet_item_main_text").first();
            teamName = teamName2.select("a.bet_item_detail_href, span:not([class^=bet])").first().text();
            teamsNames = teamName.split("-");
            res = b.select("td.col_betResult").text().trim();
            wyniki.add(new DownloadResult(teamsNames[0], teamsNames[1], res));
        }
        return wyniki;
    }
}


