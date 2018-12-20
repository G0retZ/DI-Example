package com.example.sergejmitrofanov.librarycatalogue.entity;

public class Book {

  public final String author;
  public final String bookTitle;
  public final int rating;

  public Book(String author, String bookTitle, int rating) {
    this.author = author;
    this.bookTitle = bookTitle;
    this.rating = rating;
  }
}
