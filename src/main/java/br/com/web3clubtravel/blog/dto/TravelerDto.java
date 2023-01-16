package br.com.web3clubtravel.blog.dto;

import br.com.web3clubtravel.blog.model.Traveler;

public class TravelerDto {
    private String name;
    private String phone;
    private String email;

    public TravelerDto() {}

    public TravelerDto(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public static TravelerDto of(Traveler traveler) {
        return new TravelerDto(traveler.getName(), traveler.getPhone(), traveler.getEmail());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
