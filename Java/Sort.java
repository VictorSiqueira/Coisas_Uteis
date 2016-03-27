package reports;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Sort {
    private String nome;
    private Date data;
    
    public Sort() {
		super();
	}
    
	public Sort(String nome, Date data) {
		super();
		this.nome = nome;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Sort> reorderWith2Attributes (List<Sort> sortList){
        Collections.sort(sortList, new Comparator<Sort>() {
					public int compare(Sort o1, Sort o2) { 
			            Date date1 =  o1.getData();
			            Date date2 =  o2.getData();
			            int sComp = date1.compareTo(date2);
			            if (sComp != 0) {
			               return sComp;
			            } else {
			               String esp1 = o1.getNome();
			               String esp2 = o2.getNome();
			               return esp1.compareTo(esp2);
			            }
			      } });
        return sortList;
    }
    
}