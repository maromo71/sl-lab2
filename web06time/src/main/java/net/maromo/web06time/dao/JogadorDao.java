package net.maromo.web06time.dao;


import net.maromo.web06time.model.Jogador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class JogadorDao {
    private EntityManager em;
    private EntityTransaction entityTransaction;

    public JogadorDao(){

    }

    public void adicionar(Jogador jogador){
        em = JpaUtil.getEntityManager();
        entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.persist(jogador);
        entityTransaction.commit();
        em.close();
    }

    public List<Jogador> getJogadores(){
        em = JpaUtil.getEntityManager();
        List<Jogador> list = new ArrayList<>();
        Query query = em.createQuery("select j from Jogador j");
        list = query.getResultList();
        return list;
    }

    public void remover(Jogador jogador){
        em = JpaUtil.getEntityManager();
        Jogador j = em.find(Jogador.class, jogador.getIdJogador());
        entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.remove(j);
        entityTransaction.commit();
        em.close();
    }

    public void editar(Jogador jogador){
        em = JpaUtil.getEntityManager();
        entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.merge(jogador);
        entityTransaction.commit();
        em.close();
    }

    public Jogador buscar(int idJogador){
        em = JpaUtil.getEntityManager();
        Jogador j = em.find(Jogador.class, idJogador);
        em.close();
        return j;
    }
}
