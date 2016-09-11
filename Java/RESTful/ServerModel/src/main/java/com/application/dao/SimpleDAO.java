package com.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.application.dao.util.DBUtil;
import com.application.model.ObjTeste;

public class SimpleDAO {
	private Connection conn;
	private String TABLE_NAME = "teste";
	private String COLUMN_ID = "id";
	private String COLUMN_NAME = "nome";
	private String COLUMN_DATE = "data";
	private String COLUMN_STATUS = "status";
	 
    public SimpleDAO() {
        conn = DBUtil.getDBConnection();
        //conn.setAutoCommit(false);
    }
    
    /**
     * metodo para inser��o do objeto ao database
     * @param obj
     * @return
     */
    public ObjTeste addObjTeste( ObjTeste obj ) {
        try {
        	//deixando a coluna de id vazia o proprio banco fica responsavel por gerar, desde que esteja configrado assim
        	//senao da exceptio acusando "Field 'id' doesn't have a default value"
            String query = "INSERT INTO "+TABLE_NAME+" ("+COLUMN_NAME+","+COLUMN_DATE+", "+COLUMN_STATUS+") VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS );
            preparedStatement.setString( 1, obj.getNome());
            preparedStatement.setDate( 2, new java.sql.Date(obj.getData().getTime()));//convers�o para inser��o na base
            preparedStatement.setString( 3, obj.getStatus());
            preparedStatement.executeUpdate();
            
            //obtendo id gerado pela base
            ResultSet tableKeys = preparedStatement.getGeneratedKeys();
            tableKeys.next();
            int autoGeneratedID = tableKeys.getInt(1);
            obj.setId(autoGeneratedID);          
            
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return obj;
    }
    
    /**
     * metodo para exlusa� do objeto ao databse
     * @param obj
     * @return
     */
    public boolean deleteObjTeste( ObjTeste obj) {
        try {
            String query = "DELETE FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+"=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, obj.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * metodo para atualizacao do objto no database
     * @param obj
     * @return
     */
    public ObjTeste updateObjTeste( ObjTeste obj ) {
        try {
            String query = "UPDATE "+TABLE_NAME+" SET "+COLUMN_NAME+"=?, "+COLUMN_DATE+"=?, "+COLUMN_STATUS+"=? WHERE "+COLUMN_ID+"=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, obj.getNome());
            preparedStatement.setDate( 2, new java.sql.Date(obj.getData().getTime()));//convers�o para inser��o na base
            preparedStatement.setString( 3, obj.getStatus());
            preparedStatement.setInt( 4, obj.getId());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getObjTesteById(obj);
    }
    
    /**
     * metodo para recupera��o de todos objtos na base
     * @return
     */
    public List<ObjTeste> getAllObjTestes() {
        List<ObjTeste> objList = new ArrayList<ObjTeste>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM "+TABLE_NAME );
            while( resultSet.next() ) {
                ObjTeste objReturn = new ObjTeste();
                objReturn.setId(resultSet.getInt(COLUMN_ID ));
                objReturn.setNome(resultSet.getString( COLUMN_NAME));
                objReturn.setData(new Date(resultSet.getDate(COLUMN_DATE ).getTime()));
                objReturn.setStatus(resultSet.getString( COLUMN_STATUS ));
                objList.add(objReturn);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objList;
    }
    
    /**
     * metodo para a recupera��o de um objeto pelo id no database
     * @param obj
     * @return
     */
    public ObjTeste getObjTesteById(ObjTeste obj) {
        ObjTeste objReturn = new ObjTeste();
        try {
            String query = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+"=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, obj.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next() ) {
            	objReturn.setId(resultSet.getInt(COLUMN_ID ));
                objReturn.setNome(resultSet.getString( COLUMN_NAME));
                objReturn.setData(new Date(resultSet.getDate(COLUMN_DATE ).getTime()));
                objReturn.setStatus(resultSet.getString( COLUMN_STATUS ));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objReturn;
    }
}
