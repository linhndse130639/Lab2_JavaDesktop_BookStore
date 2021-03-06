/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Duc Linh
 */
public class BookDTO implements Serializable{
    private String bookId,titleBook,author,desBook,imagerName,price,quantity,category,date,quantityBook;
    private int quantityUserBuy;

    public BookDTO() {
    }

    public BookDTO(String bookId, String titleBook, String author, String desBook, String imagerName, String price,String category) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.author = author;
        this.desBook = desBook;
        this.imagerName = imagerName;
        this.price = price;
        this.category = category;
    }

    public BookDTO(String bookId, String titleBook, String author, String desBook, String imagerName, String price,String category, String quantityBook) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.author = author;
        this.desBook = desBook;
        this.imagerName = imagerName;
        this.price = price;
        this.category = category;
        this.quantityBook = quantityBook;
    }
    

    public BookDTO(String titleBook, String author, String desBook, String imagerName, String price) {
        this.titleBook = titleBook;
        this.author = author;
        this.desBook = desBook;
        this.imagerName = imagerName;
        this.price = price;
    }

    public BookDTO(String bookId, String titleBook, String author, String price, int quantityUserBuy) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.author = author;
        this.price = price;
        this.quantityUserBuy = quantityUserBuy;
    }

    public BookDTO(String bookId, String titleBook, String quantity) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.quantity = quantity;
    }

    public BookDTO(String bookId, String titleBook, String author, String desBook, String imagerName, String price, String quantity, String category, String date, String quantityBook) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.author = author;
        this.desBook = desBook;
        this.imagerName = imagerName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.date = date;
        this.quantityBook = quantityBook;
    }
    

    public String getQuantityBook() {
        return quantityBook;
    }

    public void setQuantityBook(String quantityBook) {
        this.quantityBook = quantityBook;
    }
    
    public BookDTO(String titleBook, String date) {
        this.titleBook = titleBook;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public int getQuantityUserBuy() {
        return quantityUserBuy;
    }

    public void setQuantityUserBuy(int quantityUserBuy) {
        this.quantityUserBuy = quantityUserBuy;
    }

    public Vector toVectorBookView() {
        Vector v = new Vector();
        v.add(bookId);
        v.add(titleBook);
        v.add(imagerName);
        v.add(desBook);
        v.add(price);
        v.add(author);
        v.add(category);
        return v;
    }
    public Vector toVectorUserCart(){
        Vector v = new Vector();
        v.add(bookId);
        v.add(titleBook);
        v.add(author);
        v.add(price);
        v.add(quantityUserBuy);
        return v;
    }
    public Vector toVectorNotification(){
        Vector v = new Vector();
        v.add(bookId);
        v.add(titleBook);
        v.add(quantity);
        return v;
    }
    public Vector toVectorHistory(){
        Vector v = new Vector();
        v.add(titleBook);
        v.add(date);
        return v;
    }
    public Vector toVectorAdmin(){
        Vector v = new Vector();
        v.add(bookId);
        v.add(titleBook);
        v.add(imagerName);
        v.add(desBook);
        v.add(price);
        v.add(author);
        v.add(category);
        v.add(quantityBook);
        return v;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesBook() {
        return desBook;
    }

    public String getImagerName() {
        return imagerName;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDesBook(String desBook) {
        this.desBook = desBook;
    }

    public void setImagerName(String imagerName) {
        this.imagerName = imagerName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
