package modelo;

// Classe base: representa uma tarefa comum
public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private boolean concluida;

    public Tarefa(int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false; // toda tarefa nova começa pendente
    }

    // Getters e setters: ler e alterar os atributos
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    // Mostra a tarefa na tela
    public void exibir() {
        String status;
        if (concluida) {
            status = "Concluída";
        } else {
            status = "Pendente";
        }
        System.out.println("[" + id + "] " + titulo + " - " + status);
        System.out.println("    Descrição: " + descricao);
    }
}
