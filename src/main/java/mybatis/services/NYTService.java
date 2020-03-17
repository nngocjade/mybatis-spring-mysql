package mybatis.services;

import mybatis.controllers.AnalyzePojo;
import mybatis.models.NYT.Doc;
import mybatis.models.NYT.NYTBasePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NYTService {

    @Autowired
    RestTemplate restTemplate;

    final String nytBaseUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json";
    final String nytApiKey = "oQK13ZiKb3bLyUCgwL0qDZVBNRPnu1ml";

    public NYTBasePojo searchNYT(String searchTerm) {

        String request = nytBaseUrl + "?s=" + searchTerm + "&api-key=" + nytApiKey;
        //as long as the data matches the object, it will automatically map it
        NYTBasePojo obj = restTemplate.getForObject(request, NYTBasePojo.class);

        return obj;
    }

    public AnalyzePojo AnalyzeNYT(String searchTerm, String keyword) {

        String request = nytBaseUrl + "?s=" + searchTerm + "&api-key=" + nytApiKey;
        //as long as the data matches the object, it will automatically map it
        NYTBasePojo obj = restTemplate.getForObject(request, NYTBasePojo.class);

        int count = numArticleContains(searchTerm, obj.getResponse().getDocs());

        AnalyzePojo obj1 = new AnalyzePojo();
        obj1.setKeyword(keyword);

        return ;
    }



    public int numArticleContains(String keyword, Doc[] docs) {

        int count = 0;

        for (Doc d : docs){
            if(d.getSnippet().contains(keyword) || d.getLead_paragraph().contains(keyword)){
                count++;
            }
        }
        return count;
    }


}
