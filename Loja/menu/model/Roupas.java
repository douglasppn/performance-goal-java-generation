package menu.model;

import menu.repository.MenuRepository;

public class Roupas extends Produto implements MenuRepository {
	private int tecido;

	public Roupas(int identificacao, float preco, float peso, int tipo, int tecido) {
		super(identificacao, preco, peso, tipo);
		this.tecido = tecido;
	}

	public int getTecido() {
		return tecido;
	}

	public void setTecido(int tecido) {
		this.tecido = tecido;
	}

	@Override
	public void visualizar() {
		
		String tipoTecido = "";
		
		switch(this.tecido) {
		case 1:
			tipoTecido = "Tecido fino";
			break;
		case 2:
			tipoTecido = "Tecido grosso";
			break;
		}
		
		super.visualizar();
		System.out.println("Peso do produto: " + tipoTecido);
	}

	@Override
	public void cadastrar(Produto conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Produto conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procurarID(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarProdutos() {
		// TODO Auto-generated method stub
		
	}


}