package com.example.amr.compass_17;

/**
 * Created by abdel on 9/27/2016.
 */
public class News {
    private String title;
    private int image;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String article;

    public News(String title, int image, String article) {
        this.title = title;
        this.image = image;
        this.article = article;
    }
}
