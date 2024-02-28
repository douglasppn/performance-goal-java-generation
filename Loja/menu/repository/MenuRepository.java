package menu.repository;

import menu.model.Produto;

public interface MenuRepository {
	
	//CRUD do Produto
	public void procurarID(int numero);
	public void listarProdutos();
	public void cadastrar(Produto conta);
	public void atualizar(Produto conta);
	public void deletar(int numero);
	
}