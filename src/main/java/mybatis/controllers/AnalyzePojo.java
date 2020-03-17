package mybatis.controllers;

public class AnalyzePojo {
    private String searchTerm;
    private String keyword;
    private int numOccurences;
    private int numArticlesScanned;

    public AnalyzePojo(){
    }

    public AnalyzePojo(String searchTerm, String keyword, int numOccurences, int numArticlesScanned) {
        this.searchTerm = searchTerm;
        this.keyword = keyword;
        this.numOccurences = numOccurences;
        this.numArticlesScanned = numArticlesScanned;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getNumOccurences() {
        return numOccurences;
    }

    public void setNumOccurences(int numOccurences) {
        this.numOccurences = numOccurences;
    }

    public int getNumArticlesScanned() {
        return numArticlesScanned;
    }

    public void setNumArticlesScanned(int numArticlesScanned) {
        this.numArticlesScanned = numArticlesScanned;
    }
}
