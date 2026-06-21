import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private String nomeOuApelido;
    private List<Serie> favoritas;
    private List<Serie> assistidas;
    private List<Serie> desejoAssistir;

    public Usuario() {
        this.favoritas = new ArrayList<>();
        this.assistidas = new ArrayList<>();
        this.desejoAssistir = new ArrayList<>();
    }

    public Usuario(String nomeOuApelido) {
        this();
        this.nomeOuApelido = nomeOuApelido;
    }

    public String getNomeOuApelido() {
        return nomeOuApelido;
    }

    public void setNomeOuApelido(String nomeOuApelido) {
        this.nomeOuApelido = nomeOuApelido;
    }

    public List<Serie> getFavoritas() {
        return favoritas;
    }

    public List<Serie> getAssistidas() {
        return assistidas;
    }

    public List<Serie> getDesejoAssistir() {
        return desejoAssistir;
    }

}