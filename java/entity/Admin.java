package entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mobileno;
    private String name;
    private String address;

    // Getters and Setters
    public Long getmobileno() {
        return mobileno;
    }

    public void setmobileno(Long no) {
        this.mobileno = no;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

  
}

