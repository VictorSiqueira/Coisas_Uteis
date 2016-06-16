package com.androidiostutorials.sqlite.model;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Patterns;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Victor on 22/02/2016.
 */
public class Usuario implements Serializable {
    private Integer id;
    private String nome;
    private Date nascimento;
    private String email;
    private String status;
    private Date ultimoLogin;
    private Date dataCadastro;

    public Usuario(Integer id, Date registerDate, String email, Date birth, String name, String status, Date lastLogon) {
        this.id = id;
        this.dataCadastro = registerDate;
        this.email = email;
        this.nascimento = birth;
        this.nome = name;
        this.status = status;
        this.ultimoLogin = lastLogon;
    }

    /*public Usuario() {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.email = email;
        this.nascimento = nascimento;
        this.nome = nome;
        this.status = status;
        this.ultimoLogin = ultimoLogin;
    }*/

    public Usuario() {
    }

    public Usuario(Context context) {
        Calendar calendar = Calendar.getInstance();
        this.email = getEmailFromDevice(context);
        this.ultimoLogin = calendar.getTime();
        this.dataCadastro = calendar.getTime();
        this.status = "A";
    }

    private String getEmailFromDevice(Context context){
        Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        Account[] accounts = AccountManager.get(context).getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                String possibleEmail = account.name;
            }
            return account.name;
        }
        return "";
    }

    public Integer getId() {  return id;  }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public Date getBirth() {
        return nascimento;
    }

    public void setBirth(Date birth) {
        this.nascimento = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastLogon() {
        return ultimoLogin;
    }

    public void setLastLogon(Date lastLogon) {
        this.ultimoLogin = lastLogon;
    }

    public Date getRegisterDate() {
        return dataCadastro;
    }

    public void setRegisterDate(Date registerDate) {
        this.dataCadastro = registerDate;
    }
}
