package test;

import java.util.Date;

import dao.SimpleDAO;
import model.ObjTeste;
import util.DBUtil;

public class TesteDBUtil {

	public static void main(String[] argv) {
		//DBUtil.getDBConnection(); // teste apenas da conexao
		
		ObjTeste obj = new ObjTeste(null, "victor", new Date(), "A");		
		SimpleDAO dao = new SimpleDAO();
		obj = dao.addObjTeste(obj);
		System.out.println("ID: "+obj.getId());
		if(obj.getId()!=null){
			System.out.println("Resultado byID : "+dao.getObjTesteById(obj).getId());			
			System.out.println("Resultado All : "+dao.getAllObjTestes().size());
		}
	}
}
