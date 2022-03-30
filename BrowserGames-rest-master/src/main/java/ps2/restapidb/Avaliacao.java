package ps2.restapidb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avaliacoes")
public class Avaliacao {
    @Id @GeneratedValue
    private long id;
    private String nomeGame;
    private long estrela;
    private String comentario;

    public Avaliacao(){
        super();
    }
    
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

	public String getNomeGame() {
		return nomeGame;
	}

	public void setNomeGame(String nomeGame) {
		this.nomeGame = nomeGame;
	}

	public long getEstrela() {
		return estrela;
	}

	public void setEstrela(long estrela) {
		this.estrela = estrela;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


}