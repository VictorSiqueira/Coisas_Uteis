package com.application.bo;

import java.util.Calendar;
import java.util.List;

import com.application.dao.SimpleDAO;
import com.application.model.ObjTeste;

public class SimpleBO {
	private SimpleDAO dao = new SimpleDAO();	
	
	/**
	 * metodo de tratamento para insercação np database
	 * @param obj
	 * @return
	 */
    public ObjTeste addObjTeste( ObjTeste obj ) {
    	if(obj.getData() ==null){
    		obj.setData(Calendar.getInstance().getTime());
    	}
    	return dao.addObjTeste(obj);
    }
    
    /**
     * metodo de tratamento para remoção np database
     * @param obj
     * @return
     */
    public boolean deleteObjTeste( ObjTeste obj ) {
    	return dao.deleteObjTeste(obj);
    }
    
    /**
     * metodo de tratamento para atualização np database
     * @param obj
     * @return
     */
    public ObjTeste updateObjTeste( ObjTeste obj ) {
    	if(obj.getData() ==null){
    		obj.setData(Calendar.getInstance().getTime());
    	}
    	return dao.updateObjTeste(obj);
    }
    
    /**
     * metodo de tratamento para obtão de todos registros np database
     * @return
     */
    public List<ObjTeste> getAllObjTestes() {
    	return dao.getAllObjTestes();
    }
    
    /**
     *  metodo de tratamento para obtão de registros especificos np database
     * @param obj
     * @return
     */
    public ObjTeste getObjTesteById( ObjTeste obj ) {
    	return dao.getObjTesteById(obj);
    }
	
}
