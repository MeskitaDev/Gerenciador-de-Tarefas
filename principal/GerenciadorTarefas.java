package servico;

import modelo.Tarefa;
import java.util.ArrayList;

// faz as operações do CRUD
public class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    // id novo para cada tarefa
    public int gerarId() {
        int id = proximoId;
        proximoId++;
        return id;
    }

    // CREATE: adiciona uma tarefa na lista
    public void adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    // READ: mostra todas as tarefas
    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        for (Tarefa t : tarefas) {
            t.exibir();
        }
    }

    // Procura uma tarefa pelo id
    public Tarefa buscarPorId(int id) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    // DELETE: remove a tarefa
    public boolean remover(int id) {
        Tarefa t = buscarPorId(id);
        if (t == null) {
            return false;
        }
        tarefas.remove(t);
        return true;
    }

    public boolean estaVazio() {
        return tarefas.isEmpty();
    }
}
