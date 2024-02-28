package menu.model;

import menu.repository.MenuRepository;

public class Eletronicos extends Produto implements MenuRepository {
	
	private int garantiaMeses;
	
	public Eletronicos(int identificacao, float preco, float peso, int tipo, int garantiaMeses) {
		super(identificacao, preco, peso, tipo);
		this.garantiaMeses = garantiaMeses;
	}

	public int getGarantiaMeses() {
		return garantiaMeses;
	}

	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Garantia em meses: " + this.garantiaMeses);
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