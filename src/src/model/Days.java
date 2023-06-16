package model;

import java.io.Serializable;

public class Days implements Serializable {

    private int login;
    private int number;
    private String loginday;

    public Days(int login, int number, String loginday) {
        this.login = login;
        this.number = number;
        this.loginday = loginday;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLoginday() {
        return loginday;
    }

    public void setLoginday(int YYYY, int MM, int DD) {
        String date = (YYYY + "-" + MM + "-" + DD);
        this.loginday = date;
    }

}
