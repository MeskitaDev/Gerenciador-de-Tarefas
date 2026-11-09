# Gerenciador de Tarefas (CLI)

## Nome da aplicação
**Gerenciador de Tarefas** — mini sistema CRUD em Java, executado pelo terminal.

## Descrição das funcionalidades
O programa mostra um menu e roda até o usuário digitar `0`.

| Opção | Funcionalidade |
|-------|----------------|
| 1 | **Adicionar** tarefa (título e descrição obrigatórios; prazo opcional) |
| 2 | **Listar** todas as tarefas |
| 3 | **Atualizar** uma tarefa existente (Enter mantém o valor atual) |
| 4 | **Remover** uma tarefa |
| 5 | **Marcar/desmarcar** uma tarefa como concluída |
| 0 | **Sair** |

**Validações:** campos obrigatórios não aceitam texto vazio, entradas que não são números são recusadas e ids inexistentes mostram mensagem de erro. Os dados ficam só na memória (sem persistência).

**Conceitos aplicados:** condicionais (`if`, `switch`), laços (`while`, `for`), funções/métodos, e POO (classes, encapsulamento, herança com `Tarefa` → `TarefaComPrazo`).

## Estrutura do projeto
```
GerenciadorTarefas/
└── src/
    ├── app/      Main.java                  (menu e funções do programa)
    ├── modelo/   Tarefa.java                (classe base)
    │             TarefaComPrazo.java        (herda de Tarefa)
    └── servico/  GerenciadorTarefas.java    (guarda a lista e faz o CRUD)
```

## Como executar
Requisito: **JDK** instalado (`javac -version` para conferir).

1. Abra o terminal dentro da pasta `GerenciadorTarefas`.
2. Compile:
   ```
   javac -d out src/app/*.java src/modelo/*.java src/servico/*.java
   ```
3. Execute:
   ```
   java -cp out app.Main
   ```
4. Use o menu digitando o número da opção. Digite `0` para encerrar.
