package com.password.generate.models.forms;

public class PasswordForm {
    private Integer passLenght;
    private Boolean letters;
    private Boolean digits; 
    private Boolean symbols;
    
    public PasswordForm() {
    }

    public PasswordForm(Integer passLenght, Boolean letters, Boolean digits, Boolean symbols) {
        this.passLenght = passLenght;
        this.letters = letters;
        this.digits = digits;
        this.symbols = symbols;
    }

    public Integer getPassLenght() {
        return passLenght;
    }

    public void setPassLenght(Integer passLenght) {
        this.passLenght = passLenght;
    }

    public Boolean getLetters() {
        return letters;
    }

    public void setLetters(Boolean letters) {
        this.letters = letters;
    }

    public Boolean getDigits() {
        return digits;
    }

    public void setDigits(Boolean digits) {
        this.digits = digits;
    }

    public Boolean getSymbols() {
        return symbols;
    }

    public void setSymbols(Boolean symbols) {
        this.symbols = symbols;
    }

    
}
