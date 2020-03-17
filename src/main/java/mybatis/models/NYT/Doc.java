package mybatis.models.NYT;

import java.util.Arrays;

public class Doc {

    private String abstractStr;
    private String web_url;
    private String snippet;
    private String lead_paragraph;
    private String source;
    private Multimedia[] multimedia;
    private Headline headline;
    private Keyword1[] keyword1s;
    private String pub_date;
    private String document_type;
    private String news_desk;
    private String section_name;
    private String subsection_name;
//    private Byline byline; NOT MAPPING
    private String type_of_material;
    private String id;
    private int word_count;
    private String uri;

    public Doc(){
    }

    public String getAbstractStr() {
        return abstractStr;
    }

    public void setAbstractStr(String abstractStr) {
        this.abstractStr = abstractStr;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLead_paragraph() {
        return lead_paragraph;
    }

    public void setLead_paragraph(String lead_paragraph) {
        this.lead_paragraph = lead_paragraph;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Multimedia[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia[] multimedia) {
        this.multimedia = multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public Keyword1[] getKeyword1s() {
        return keyword1s;
    }

    public void setKeyword1s(Keyword1[] keyword1s) {
        this.keyword1s = keyword1s;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getNews_desk() {
        return news_desk;
    }

    public void setNews_desk(String news_desk) {
        this.news_desk = news_desk;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSubsection_name() {
        return subsection_name;
    }

    public void setSubsection_name(String subsection_name) {
        this.subsection_name = subsection_name;
    }


    public String getType_of_material() {
        return type_of_material;
    }

    public void setType_of_material(String type_of_material) {
        this.type_of_material = type_of_material;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWord_count() {
        return word_count;
    }

    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "abstractStr='" + abstractStr + '\'' +
                ", web_url='" + web_url + '\'' +
                ", snippet='" + snippet + '\'' +
                ", lead_paragraph='" + lead_paragraph + '\'' +
                ", source='" + source + '\'' +
                ", multimedia=" + Arrays.toString(multimedia) +
                ", headline=" + headline +
                ", keyword1s=" + Arrays.toString(keyword1s) +
                ", pub_date='" + pub_date + '\'' +
                ", document_type='" + document_type + '\'' +
                ", news_desk='" + news_desk + '\'' +
                ", section_name='" + section_name + '\'' +
                ", subsection_name='" + subsection_name + '\'' +
                ", type_of_material='" + type_of_material + '\'' +
                ", id='" + id + '\'' +
                ", word_count=" + word_count +
                ", uri='" + uri + '\'' +
                '}';
    }
}
