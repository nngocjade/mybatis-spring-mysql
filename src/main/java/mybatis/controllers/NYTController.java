package mybatis.controllers;

import mybatis.models.NYT.NYTBasePojo;
import mybatis.models.ResponseObject;
import mybatis.services.NYTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nyt")
public class NYTController {

    @Autowired
    NYTService nytService;

    @GetMapping("/search")
    public ResponseObject<NYTBasePojo> searchNYT(
            @RequestParam("s") String searchTerm
    ){
        ResponseObject<NYTBasePojo> returnVal = new ResponseObject<>();
        NYTBasePojo data = nytService.searchNYT("news");

        returnVal.setData(data);

        return returnVal;
    }

    @GetMapping("/analyze")
    public ResponseObject<NYTBasePojo> analyzeNYT(
            @RequestParam("search") String searchTerm,
            @RequestParam("for") String keyword
    ){
        ResponseObject<AnalyzePojo> returnVal = new ResponseObject<>();
        AnalyzePojo data = nytService.numArticleContains();

        returnVal.setData(data);

        return returnVal;
    }
}
