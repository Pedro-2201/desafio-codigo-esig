package com.pedro.tarefas.gerenciadortarefas.controller;

import com.pedro.tarefas.gerenciadortarefas.model.Status;
import com.pedro.tarefas.gerenciadortarefas.model.Tarefa;
import com.pedro.tarefas.gerenciadortarefas.util.EntityManagerProducer;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@SessionScoped
public class TarefaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    private Tarefa tarefa = new Tarefa();

    public String salvarTarefa() {
        em.getTransaction().begin();
        if (tarefa.getId() == null) {
            em.persist(tarefa); 
        } else {
            em.merge(tarefa); 
        }
        em.getTransaction().commit();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa salva com sucesso!"));
        tarefa = new Tarefa(); // Limpar a tarefa para um novo input
        return "index?faces-redirect=true";
    }

    public void excluirTarefa(Long id) {
        em.getTransaction().begin();
        Tarefa tarefaParaExcluir = em.find(Tarefa.class, id);
        if (tarefaParaExcluir != null) {
            em.remove(tarefaParaExcluir);
        }
        em.getTransaction().commit();
    }

    public void concluirTarefa(Long id) {
        em.getTransaction().begin();
        Tarefa tarefaParaConcluir = em.find(Tarefa.class, id);
        if (tarefaParaConcluir != null) {
            tarefaParaConcluir.setStatus(Status.CONCLUIDA);
        }
        em.getTransaction().commit();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa concluida!"));
    }

    public List<Tarefa> listarTarefas() {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t from Tarefa t", Tarefa.class);
        return query.getResultList();
    }

    public List<Tarefa> listarTarefasPendentes() {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t from Tarefa t", Tarefa.class);
        return query.getResultList().stream().filter(t -> t.getStatus()
                .equals(Status.PENDENTE)).collect(Collectors.toList());
    }

    public String editarTarefa(Long id) {
        tarefa = em.find(Tarefa.class, id);
        return "cadastrarTarefa.xhtml?faces-redirect=true"; 
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
