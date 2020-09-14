package com.example.first;

import org.springframework.web.multipart.MultipartFile;

public class userData {

    private String name;
    private String brand;
    private Double perhour;
    private MultipartFile file;


    public userData(String name, String brand, Double perhour, MultipartFile file) {
        this.name = name;
        this.brand=brand;
        this.perhour=perhour;
        this.file=file;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    } public Double getPerhour(){
        return this.perhour;
    }
    public void setPerhour(Double perhour){
        this.perhour=perhour;
    } public MultipartFile getFile(){
        return this.file;
    }
    public void setFile(MultipartFile file){
        this.file=file;
    }
    @Override
    public String toString(){
        return "{"
                + "name:"+name+","
                +"brand:"+brand+","
                +"perhour:"+perhour+","
                +"file:"+file.getOriginalFilename()
                +"}";
    }
}
