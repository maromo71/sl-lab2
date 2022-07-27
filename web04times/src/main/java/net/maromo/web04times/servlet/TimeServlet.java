package net.maromo.web04times.servlet;

import net.maromo.web04times.dao.JogadorDao;
import net.maromo.web04times.model.Jogador;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TimeServlet", value = "/time")
public class TimeServlet extends HttpServlet {

    private final List<Jogador> lista = new ArrayList<>();

    public void adicionarNoTime(Jogador jogador) throws ClassNotFoundException {
        lista.add(jogador);
        JogadorDao jogadorDao = new JogadorDao();
        jogadorDao.adicionarJogador(jogador);
    }

    public List<Jogador> listaDeJogadores() throws ClassNotFoundException {
        JogadorDao jogadorDao = new JogadorDao();
        try {
            return jogadorDao.listarJogadores();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Primeira Servlet</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Servelt para times - VAZIO</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Jogador jogador = new Jogador();
        jogador.setNome(request.getParameter("nomeJogador"));
        jogador.setApelido(request.getParameter("apelidoJogador"));
        jogador.setPosicao(request.getParameter("posicaoJogador"));
        jogador.setIdade(Integer.parseInt(request.getParameter("idadeJogador")));
        try {
            this.adicionarNoTime(jogador);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Dados Cadastrados</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Jogador Cadastrado com Sucesso</h2>");
        try {
            for (Jogador j : this.listaDeJogadores()) {
                response.getWriter().println("<p>Nome do Jogador: " + j.getNome() + "</p>");
                response.getWriter().println("<p>Apelido do Jogador: " + j.getApelido() + "</p>");
                response.getWriter().println("<p>Posição do Jogador: " + j.getPosicao() + "</p>");
                response.getWriter().println("<p>Idade do Jogador: " + j.getIdade() + "</p>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().println("</body>");
        response.getWriter().println("</html");

    }
}
