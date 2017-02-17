package com.example.amr.compass_17;

/**
 * Created by abdel on 9/27/2016.
 */
public class News {
    private String Title;
    private String image;
    private String article;

    public News(String title, String image, String article) {
        Title = title;
        this.image = image;
        this.article = article;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
