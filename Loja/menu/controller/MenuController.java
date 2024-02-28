package menu.controller;

import java.util.ArrayList;

import menu.repository.MenuRepository;
import menu.model.Produto;

public class MenuController implements MenuRepository {
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int identificacao = 1000;  //Optei por iniciar a ID de um produto com 1001.

	@Override
	public void procurarID(int identificacao) { //Procura o produto pela ID
		// TODO Auto-generated method stub
		var produto = buscarNaCollection(identificacao);
		
		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\nO Produto com ID: " + identificacao + " não foi encontrado!");
		
	}

	@Override
	public void listarProdutos() { //Mostra todos os produtos da loja
		// TODO Auto-generated method stub
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto produto) { //Cria um produto novo
		// TODO Auto-generated method stub
		listaProdutos.add(produto);
		System.out.println("\nO produto com ID: " + produto.getIdentificacao() + " foi criado com sucesso!\n");
	}

	@Override
	public void atualizar(Produto produto) { //Atualizar um produto, procura a ID e pede para substituir as características do produto
		// TODO Auto-generated method stub
		var buscaProduto = buscarNaCollection(produto.getIdentificacao());
		
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO produto com ID: " + produto.getIdentificacao() + " foi atualizado com sucesso!");
		} else
			System.out.println("\nO produto com ID: " + produto.getIdentificacao() + " não foi encontrado!");
	}

	@Override
public void deletar(int identificacao) { //Deletar um produto através da inserção de uma ID
		// TODO Auto-generated method stub
	    // Busca a conta na lista
	    var produto = buscarNaCollection(identificacao);
	    
	    if (produto != null) {
	        // Remove a conta da lista
	        if (listaProdutos.remove(produto)) {
	            System.out.println("\nO produto com ID: " + identificacao + " foi deletado com sucesso!");
	        } else {
	            System.out.println("\nFalha ao deletar o produto com ID: " + identificacao);
	        }
	    } else {
	        System.out.println("\nNão foi encontrado um produto com ID: " + identificacao);
	    }
	}
	
	public int gerarNumero() { //Incrementar o ID em 1 a cada criação de produto
		return ++ identificacao;
	}
	
	public Produto buscarNaCollection(int identificacao) {	//Buscar qual produto possui a ID especificada
		for (var produto : listaProdutos) {
			if (produto.getIdentificacao() == identificacao) {
				return produto;
			}
		}
		
		return null;
	}
	
	public boolean idProdutoValido(int identificacao) { 	//Checar se o ID do produto é valido ou não
	    for (Produto produto : listaProdutos) {
	        if (produto.getIdentificacao() == identificacao) {
	            return true;
	        }
	    }
	    return false;
	}
}