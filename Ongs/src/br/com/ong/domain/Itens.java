package br.com.ong.domain;

public class Itens {
	private int Id_Itens;
	private String Item_Nome;
	private String Descricao_Item;
	private String Tipo_Item;

	public int getId_Itens() {
		return Id_Itens;
	}

	public void setId_Itens(int id_Itens) {
		Id_Itens = id_Itens;
	}

	public String getItem_Nome() {
		return Item_Nome;
	}

	public void setItem_Nome(String item_Nome) {
		Item_Nome = item_Nome;
	}

	public String getDescricao_Item() {
		return Descricao_Item;
	}

	public void setDescricao_Item(String descricao_Item) {
		Descricao_Item = descricao_Item;
	}

	public String getTipo_Item() {
		return Tipo_Item;
	}

	public void setTipo_Item(String tipo_Item) {
		Tipo_Item = tipo_Item;
	}

}
