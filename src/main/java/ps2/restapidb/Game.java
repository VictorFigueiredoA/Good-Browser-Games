package ps2.restapidb;

import javax.persistence.*;

	@Entity
	@Table(name="games")
	public class Game {
	    @Id @GeneratedValue
	    private long id;
	    private String nome;
	    private String categoria;
	    private String url;
	    private String Descricao;
	    private String imagem;
	  

	    public Game(){
	        super();
	    }
	    public long getId(){
	        return id;
	    }
	    public void setId(long id){
	        this.id = id;
	    }
	    public String getNome(){
	        return nome;
	    }
	    public void setNome(String nome){
	        this.nome = nome;
	    }
	  
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		
		public String getImagem() {
			return imagem;
		}
		public void setImagem(String imagem) {
			this.imagem = imagem;
		}
		public String getDescricao() {
			return Descricao;
		}
		public void setDescricao(String descricao) {
			Descricao = descricao;
		}
	}