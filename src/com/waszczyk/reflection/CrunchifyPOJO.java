package com.waszczyk.reflection;

public class CrunchifyPOJO {
	 
    public String name;
    protected String webAddress;
    public String email;
    protected int zip;
 
    public CrunchifyPOJO() {
        name = "Crunchify.com";
        webAddress = "http://crunchify.com";
        email = "test@crunchify.com";
    }
 
    // ==========================================================
    // Create a Setters and Getters for all variables
    // ==========================================================
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    protected String getWebAddress() {
        return webAddress;
    }
 
    protected void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    protected int getZip() {
        return zip;
    }
 
    protected void setZip(int zip) {
        this.zip = zip;
    }
 
    public void thisIsCrunchifyReflection() {
        System.out.println("- Hey This is Crunchify's Refection API tutorials. More than 400 Tutorials on Crunchify.com");
    }
 
    // ==========================================================
    // Create a String description of a Crunchify credentials
    // ==========================================================
 
    public String toString() {
        String result = "Name: " + getName() + "\n";
        result += "WebAddress: " + getWebAddress() + "\n";
        result += "email: " + getEmail() + "\n";
        result += "zip: " + getZip() + "\n";
        return result;
    }
 
    public static void main(String[] args) {
 
        // Create and print a CrunchifyPOJO object ...
        CrunchifyPOJO crunchify = new CrunchifyPOJO();
        crunchify.setName("Crunchify.com");
        crunchify.setWebAddress("http://crunchify.com");
        crunchify.setEmail("test@crunchify.com");
        crunchify.setZip(95124);
        System.out.println(crunchify);
    }
}