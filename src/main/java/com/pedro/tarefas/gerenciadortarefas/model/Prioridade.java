package com.pedro.tarefas.gerenciadortarefas.model;

public enum Prioridade {
    ALTA(1), MEDIA(2), BAIXA(3);

    public int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }
}