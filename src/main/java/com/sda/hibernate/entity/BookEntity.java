package com.sda.hibernate.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name = "books")  // zmiana nazwy na books z BookEntity
public class BookEntity {

    @Column(name="title",nullable = false,length = 128)     // ctrl space pokazuje jakiego mamy wlasciwosci pola do wyboru
    private String title;
    @Column(name="author",nullable = false,length = 128)
    private String author;
    @Column(name="published",nullable = true)
    private Date published;
    @Column(name="isbn",nullable = false,length = 20)
    private String isbn;
    @Column(name="category",nullable = true)
    private String category;
    @Column(name="pageCount",nullable = true)
    private Integer pageCount;
    @Column(name="publisher",nullable = true)
    private String publisher;
    @Column(precision = 2)
    private BigDecimal price;
    @Column(name="onStock")
    private Integer onStock;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                    //sluzy do auto increamentacji
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOnStock() {
        return onStock;
    }

    public void setOnStock(Integer onStock) {
        this.onStock = onStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
