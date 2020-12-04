package br.com.ong.domain;

public class OngItens {

	private int Id_Itens_Ong;
	private Ong Id_Ong;
	private Itens Id_Itens;
	private Long Qtd_Itens;

	public int getId_Itens_Ong() {
		return Id_Itens_Ong;
	}

	public void setId_Itens_Ong(int id_Itens_Ong) {
		Id_Itens_Ong = id_Itens_Ong;
	}

	public Ong getId_Ong() {
		return Id_Ong;
	}

	public void setId_Ong(Ong id_Ong) {
		Id_Ong = id_Ong;
	}

	public Itens getId_Itens() {
		return Id_Itens;
	}

	public void setId_Itens(Itens id_Itens) {
		Id_Itens = id_Itens;
	}

	public Long getQtd_Itens() {
		return Qtd_Itens;
	}

	public void setQtd_Itens(Long qtd_Itens) {
		Qtd_Itens = qtd_Itens;
	}

}
