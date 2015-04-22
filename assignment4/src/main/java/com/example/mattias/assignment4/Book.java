package com.example.mattias.assignment4;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Mattias on 15-04-22.
 */
public class Book implements Serializable {
    String title;
    String isbn;
    Drawable image;

    public Book(String title, String isbn, Drawable image) {
        this.title = title;
        this.isbn = isbn;
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getSummary() {
        return "Det är ett välkänt faktum att läsare distraheras av läsbar text på en sida när man skall studera layouten. Poängen med Lorem Ipsum är att det ger ett normalt ordflöde, till skillnad från \"Text här, Text här\", och ger intryck av att vara läsbar text. Många publiseringprogram och webbutvecklare använder Lorem Ipsum som test-text, och en sökning efter \"Lorem Ipsum\" avslöjar många webbsidor under uteckling. Olika versioner har dykt upp under åren, ibland av olyckshändelse, ibland med flit (mer eller mindre humoristiska).";
    }
}
