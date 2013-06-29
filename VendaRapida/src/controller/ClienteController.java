package controller;

import java.util.List;
import model.Cliente;
import net.sf.jasperreports.engine.JRException;

public interface ClienteController {

    Cliente buscar(int id) throws Exception;

    void editar(Cliente cliente) throws Exception;

    void excluir(int id) throws Exception;

    List<Cliente> listar() throws Exception;

    List<Cliente> listar(Cliente cliente) throws Exception;

    void salvar(Cliente cliente) throws Exception;

    int incrementar() throws Exception;
    
    void gerarRelatorio(List listaGerada, String path) throws JRException;
}
