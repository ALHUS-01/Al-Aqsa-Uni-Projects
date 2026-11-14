// Husam Akram Hamad Braika - 1320237093
package husamakrambraika_1320237093;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private String identityNumber;
    private String name;
    private String gender;
    private String phone;
    private String address;

    public Person() {
    }

    public Person(String identityNumber, String name, String gender, String phone, String address) {
        this.identityNumber = identityNumber;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + identityNumber + " | Name: " + name + " | Gender: " + gender + " | Phone: " + phone;
    }
}
// Husam Akram Hamad Braika - 1320237093
