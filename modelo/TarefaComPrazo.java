package modelo;

// "extends" = HERANÇA: TarefaComPrazo tem tudo de Tarefa e mais o prazo
public class TarefaComPrazo extends Tarefa {
    private String prazo;

    public TarefaComPrazo(int id, String titulo, String descricao, String prazo) {
        super(id, titulo, descricao);
        this.prazo = prazo;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    // reescreve o método exibir() da classe Tarefa
    @Override
    public void exibir() {
        super.exibir(); // mostra o que a Tarefa já mostrava
        System.out.println("    Prazo: " + prazo);
    }
}
