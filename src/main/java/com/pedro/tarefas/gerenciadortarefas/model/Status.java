package com.pedro.tarefas.gerenciadortarefas.model;

public enum Status {
    PENDENTE(0), CONCLUIDA(1);

    private int valor;
    Status(int valor) {
        this.valor = valor;
    }
}