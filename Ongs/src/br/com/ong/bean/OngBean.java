package br.com.ong.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import com.sun.tools.classfile.Opcode.Set;

import br.com.ong.dao.OngDAO;
import br.com.ong.domain.Ong;

@ManagedBean(name = "MBOng")
@ViewScoped
public class OngBean {

	private ListDataModel<Ong> itens;
	private Ong ong;

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public ListDataModel<Ong> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Ong> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			OngDAO dao = new OngDAO();
			ArrayList<Ong> lista = dao.listar();
			itens = new ListDataModel<Ong>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void prepararNovo() {
		ong = new Ong();
	}

	public void novo() {
		try {
			OngDAO dao = new OngDAO();
			dao.salvar(ong);
			
			ArrayList<Ong> lista = dao.listar();
			itens = new ListDataModel<Ong>(lista);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
