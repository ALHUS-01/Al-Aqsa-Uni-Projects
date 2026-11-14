// Husam Akram Hamad Braika - 1320237093
package husamakrambraika_1320237093;

import java.io.Serializable;

public class Author extends Person implements Serializable {

    private int noOfBooks;
    private String email;
    private String workplace;

    public Author() {
    }

    public Author(String identityNumber, String name, String gender, String phone, String address, int noOfBooks, String email, String workplace) {
        super(identityNumber, name, gender, phone, address);
        this.noOfBooks = noOfBooks;
        this.email = email;
        this.workplace = workplace;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return super.toString() + " | Email: " + email + " | Workplace: " + workplace + " | Books: " + noOfBooks;
    }
}
// Husam Akram Hamad Braika - 1320237093
