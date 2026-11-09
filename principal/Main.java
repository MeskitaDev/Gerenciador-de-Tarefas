package app;

import modelo.Tarefa;
import modelo.TarefaComPrazo;
import servico.GerenciadorTarefas;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static GerenciadorTarefas gerenciador = new GerenciadorTarefas();

    public static void main(String[] args) {
        int opcao = -1;

        // O programa repete até digitar 0
        while (opcao != 0) {
            mostrarMenu();
            opcao = lerNumero("Escolha uma opção: ");
            System.out.println();

            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    gerenciador.listar();
                    break;
                case 3:
                    atualizarTarefa();
                    break;
                case 4:
                    removerTarefa();
                    break;
                case 5:
                    concluirTarefa();
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("===== GERENCIADOR DE TAREFAS =====");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Atualizar tarefa");
        System.out.println("4 - Remover tarefa");
        System.out.println("5 - Marcar/desmarcar como concluída");
        System.out.println("0 - Sair");
    }

    // ---------- CRUD ----------

    static void adicionarTarefa() {
        String titulo = lerTextoObrigatorio("Título: ");
        String descricao = lerTextoObrigatorio("Descrição: ");

        System.out.print("Tem prazo? (s/n): ");
        String resposta = scanner.nextLine().trim();

        int id = gerenciador.gerarId();

        if (resposta.equalsIgnoreCase("s")) {
            String prazo = lerTextoObrigatorio("Prazo (ex: 25/12/2026): ");
            gerenciador.adicionar(new TarefaComPrazo(id, titulo, descricao, prazo));
        } else {
            gerenciador.adicionar(new Tarefa(id, titulo, descricao));
        }
        System.out.println("Tarefa adicionada com sucesso!");
    }

    static void atualizarTarefa() {
        Tarefa tarefa = escolherTarefa();
        if (tarefa == null) {
            return;
        }

        System.out.println("Deixe em branco (Enter) para manter o valor atual.");

        System.out.print("Novo título (" + tarefa.getTitulo() + "): ");
        String titulo = scanner.nextLine().trim();
        if (!titulo.isEmpty()) {
            tarefa.setTitulo(titulo);
        }

        System.out.print("Nova descrição (" + tarefa.getDescricao() + "): ");
        String descricao = scanner.nextLine().trim();
        if (!descricao.isEmpty()) {
            tarefa.setDescricao(descricao);
        }

        // Se a tarefa for com prazo
        if (tarefa instanceof TarefaComPrazo) {
            TarefaComPrazo comPrazo = (TarefaComPrazo) tarefa;
            System.out.print("Novo prazo (" + comPrazo.getPrazo() + "): ");
            String prazo = scanner.nextLine().trim();
            if (!prazo.isEmpty()) {
                comPrazo.setPrazo(prazo);
            }
        }

        System.out.println("Tarefa atualizada com sucesso!");
    }

    static void removerTarefa() {
        Tarefa tarefa = escolherTarefa();
        if (tarefa == null) {
            return;
        }
        gerenciador.remover(tarefa.getId());
        System.out.println("Tarefa removida.");
    }

    static void concluirTarefa() {
        Tarefa tarefa = escolherTarefa();
        if (tarefa == null) {
            return;
        }
        // ! = not
        tarefa.setConcluida(!tarefa.isConcluida());
        System.out.println("Status da tarefa alterado!");
    }

    // Mostra as tarefas, pede o id e devolve a tarefa escolhida 
    static Tarefa escolherTarefa() {
        if (gerenciador.estaVazio()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return null;
        }
        gerenciador.listar();
        int id = lerNumero("Digite o id da tarefa: ");
        Tarefa tarefa = gerenciador.buscarPorId(id);
        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.");
        }
        return tarefa;
    }

    // Lê um texto e só aceita se não estiver vazio (validação)
    static String lerTextoObrigatorio(String mensagem) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(mensagem);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Este campo não pode ficar vazio.");
            }
        }
        return texto;
    }

    // Lê um número inteiro e repete se digitar algo que não é número
    static int lerNumero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números.");
            }
        }
    }
}
