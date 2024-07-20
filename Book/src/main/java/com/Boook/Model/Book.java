package com.Boook.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookDetails")
public class Book {
@Id
private int bookId;
@Column(length = 15)
private String bookName;
private String author;
private float bookPrice;

public int getBookId() {
	return this.bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public float getBookPrice() {
	return bookPrice;
}
public void setBookPrice(float bookPrice) {
	this.bookPrice = bookPrice;
}

}
