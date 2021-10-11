package src.data;

import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScraper {
    private String[] unFilteredDataArray;
    private String totalCoronaCases;
    private String totalDeaths;
    private String totalRecovered;
    private String lastUpdated;

    public WebScraper() {

    }

    public void getData() throws IOException {

        Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/country/philippines/").timeout(60000)
                .get();

        Elements data = doc.select("div[class=content-inner]");
        String unFilteredData = data.text();

        unFilteredDataArray = unFilteredData.split(" ");

        totalCoronaCases = unFilteredDataArray[15];
        totalDeaths = unFilteredDataArray[17];
        totalRecovered = unFilteredDataArray[19];
        lastUpdated = unFilteredDataArray[7] + " " + unFilteredDataArray[8] + " "
                + unFilteredDataArray[9].substring(0, unFilteredDataArray[9].length() - 1);

    }

    public String getTotalCoronaCases() {
        return totalCoronaCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public String getTotalRecoveries() {
        return totalRecovered;
    }

    public String getLastUpdate() {
        return lastUpdated;
    }
}