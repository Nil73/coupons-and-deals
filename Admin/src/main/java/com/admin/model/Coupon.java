package com.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Coupons")
public class Coupon {

    @Id
    private String id;
    private String provider;
    private String code;
    private String description;

    public Coupon() {
    }

    public Coupon(String id, String provider, String code, String description) {
        super();
        this.id = id;
        this.provider = provider;
        this.code = code;
        this.description = description;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
