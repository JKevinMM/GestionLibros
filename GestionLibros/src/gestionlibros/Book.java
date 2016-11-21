package gestionlibros;

public class Book {
    String id, title, author, editorial, subject, state;

    public Book() {
        this.id = "";
        this.title = "";
        this.author = "";
        this.editorial = "";
        this.subject = "";
        this.state = "";
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getSubject() {
        return subject;
    }

    public String getState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setState(String state) {
        this.state = state;
    }
}