package net.maromo.web06time.bean;


import net.maromo.web06time.dao.JogadorDao;
import net.maromo.web06time.model.Jogador;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;


@ManagedBean
@SessionScoped
public class JogadorBean {
    private Jogador jogador;
    private JogadorDao dao = new JogadorDao();

    @PostConstruct
    public void init() {
        jogador = new Jogador();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public List<Jogador> getJogadores() {
        return dao.getJogadores();
    }

    public String adicionar(){
        dao.adicionar(jogador);
        jogador = new Jogador();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage("Jogador Adicionado com Sucesso"));
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "home";
    }

    public String editar(){
        dao.editar(jogador);
        jogador = new Jogador();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage("Jogador Editado com Sucesso"));
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "home";
    }

    public String remover(){
        dao.remover(jogador);
        jogador = new Jogador();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage("Jogador Removido com Sucesso"));
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "home";
    }

    public void jogadorPorId(){
        jogador = dao.buscar(Integer.parseInt(jogador.getIdJogador().toString()));
        if(jogador==null || jogador.getIdJogador()==0){
            jogador = new Jogador();
            FacesMessage message = new FacesMessage("Jogador não Encontrado");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
