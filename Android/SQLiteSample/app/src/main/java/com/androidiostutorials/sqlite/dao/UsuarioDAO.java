package com.androidiostutorials.sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.androidiostutorials.sqlite.model.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Victor on 24/04/2016.
 */
public class UsuarioDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "AgoraVou";
    private static final Integer VERSAO = 1;
    private static final String TABELA = "Usuario";

    public UsuarioDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "nascimento TEXT, " + //na real é date
                "email TEXT, " +
                "status INTEGER, " +
                "ultimoLogin TEXT, " + //na real é date
                "dataCadastro TEXT );"; //na real é date
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA +";";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Usuario usuario) {
        ContentValues contentValues = new ContentValues(); //faz o mesmo papel que o hibernate
        contentValues.put("nome", usuario.getName());
        contentValues.put("nascimento", convertDateToStringDate(usuario.getBirth()));
        contentValues.put("email", usuario.getEmail());
        contentValues.put("status", Integer.parseInt(usuario.getStatus()));
        contentValues.put("ultimoLogin",convertDateToStringDate(usuario.getLastLogon()));
        contentValues.put("dataCadastro", convertDateToStringDate(usuario.getRegisterDate()));

        //insert(nome da tabela, valor a ser inserido se alguma linha for nula, contentValues com o que vai ser inserido);
        getWritableDatabase().insert(TABELA, null, contentValues);
    }

    public Usuario getUsuarioById(Usuario usuario) {
        String sql = "SELECT * FROM "+ TABELA + " WHERE id = "+usuario.getId() +";";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        List<Usuario> lista = new ArrayList<>();
        while (cursor.moveToNext()){
            Usuario res = new Usuario();
            res.setId(cursor.getInt(cursor.getColumnIndex("id")));
            res.setName(cursor.getString(cursor.getColumnIndex("nome")));
            res.setBirth(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("nascimento"))));
            res.setEmail(cursor.getString(cursor.getColumnIndex("nome")));
            res.setStatus(cursor.getString(cursor.getColumnIndex("nome")));
            res.setRegisterDate(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("dataCadastro"))));
            res.setLastLogon(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("ultimoLogin"))));
            lista.add(res);
            return res;
        }
        return null;
    }

    public Usuario getUsuarioByNome(Usuario usuario) {
        String sql = "SELECT * FROM "+ TABELA + " WHERE nome = '"+usuario.getName() +"';";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        List<Usuario> lista = new ArrayList<>();
        while (cursor.moveToNext()){
            Usuario res = new Usuario();
            res.setId(cursor.getInt(cursor.getColumnIndex("id")));
            res.setName(cursor.getString(cursor.getColumnIndex("nome")));
            res.setBirth(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("nascimento"))));
            res.setEmail(cursor.getString(cursor.getColumnIndex("nome")));
            res.setStatus(cursor.getString(cursor.getColumnIndex("nome")));
            res.setRegisterDate(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("dataCadastro"))));
            res.setLastLogon(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("ultimoLogin"))));
            lista.add(res);
            return res;
        }
        return null;
    }

    public List<Usuario> getAllUsuarios() {
        String sql = "SELECT * FROM "+ TABELA + ";";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        List<Usuario> lista = new ArrayList<>();
        while (cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
            usuario.setName(cursor.getString(cursor.getColumnIndex("nome")));
            usuario.setBirth(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("nascimento"))));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("nome")));
            usuario.setStatus(cursor.getString(cursor.getColumnIndex("nome")));
            usuario.setRegisterDate(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("dataCadastro"))));
            usuario.setLastLogon(convertStringDateToDate(
                    cursor.getString(cursor.getColumnIndex("ultimoLogin"))));
            lista.add(usuario);
        }
        return lista;
    }

    public void update(Usuario usuario) {
        ContentValues contentValues = new ContentValues(); //faz o mesmo papel que o hibernate
        contentValues.put("nome",usuario.getName());
        contentValues.put("nascimento", convertDateToStringDate(usuario.getBirth()));
        contentValues.put("email", usuario.getEmail());
        contentValues.put("status", Integer.parseInt(usuario.getStatus()));
        contentValues.put("ultimoLogin", convertDateToStringDate(usuario.getLastLogon()));
        contentValues.put("dataCadastro", convertDateToStringDate(usuario.getRegisterDate()));

        //insert(nome da tabela, valores para atualizar ,qual ocorrencia quer atualizar, );
        String[] args = {usuario.getId().toString()};
        getWritableDatabase().update(TABELA, contentValues, "id=?", args);
    }

    public void deletar(Usuario usuario) {
        String[] args = {usuario.getId().toString()};
        //delete(TABELA,WHERE,VALORES DO WHERE);
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public static Date convertStringDateToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateReturn = null;
        try {
            dateReturn = sdf.parse("date");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateReturn;
    }

    public static String convertDateToStringDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date != null){
            return sdf.format(date);
        }else {
            return "";
        }
    }

}
