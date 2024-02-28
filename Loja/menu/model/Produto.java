package menu.model;

public abstract class Produto {
	
	protected int identificacao;
	private float preco;
	private float peso;
	private int tipo;

	public Produto(int identificacao, float preco, float peso, int tipo) {
		
		this.identificacao = identificacao;
		this.preco = preco;
		this.peso = peso;
		this.tipo = tipo;
		
	}

	public int getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {
		
		String tipoProduto = "";
		
		switch(this.tipo) {
		case 1:
			tipoProduto = "Roupa";
			break;
		case 2:
			tipoProduto = "Produtos Eletronicos";
			break;
		}
		
		System.out.println("**************************");
		System.out.println("Dados do Produto");
		System.out.println("**************************");
		System.out.println("ID do produto: " + this.identificacao);
		System.out.println("Preço do produto: " + this.preco);
		System.out.println("Tipo do produto: " + tipoProduto);
		System.out.println("Peso do produto: " + this.peso);
	}

	
	

}