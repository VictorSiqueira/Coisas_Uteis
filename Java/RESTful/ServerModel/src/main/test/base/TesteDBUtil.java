package base;

import java.util.Date;

import com.application.dao.SimpleDAO;
import com.application.dao.util.DBUtil;
import com.application.model.ObjTeste;

public class TesteDBUtil {

	public static void main(String[] argv) {
		DBUtil.getDBConnection(); // teste apenas da conexao		
	}
}
