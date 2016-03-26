package com.testejson;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Victor on 26/03/2016.
 */
public class Pessoa {
    String _id;
    Integer index;
    String nome;
    String genero;
    String idade;
    String email;
    String endereço;
    String cidade;
    Double latitude;
    Double longitude;
    Boolean ativo;

    public Pessoa() {
    }

    public Pessoa(String _id, Integer index, String nome, String genero, String idade, String email, String endereço, String cidade, Double latitude, Double longitude, Boolean ativo) {
        this._id = _id;
        this.index = index;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.email = email;
        this.endereço = endereço;
        this.cidade = cidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ativo = ativo;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
