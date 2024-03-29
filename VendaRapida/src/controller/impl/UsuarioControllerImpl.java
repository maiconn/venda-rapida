package controller.impl;

import controller.UsuarioController;
import controller.VendaController;
import controller.dao.Dao;
import controller.dao.DaoFactory;
import controller.dao.TipoDao;
import controller.dao.impl.DaoFactoryImpl;
import java.util.List;
import model.Usuario;
import model.Venda;

public class UsuarioControllerImpl implements UsuarioController {

    private Dao usuarioDao;
    
    public UsuarioControllerImpl() {
        DaoFactory daoFactory = new DaoFactoryImpl();
        usuarioDao = daoFactory.CriarDao(TipoDao.USUARIO);
    }
    
    private boolean confirmarSenha(String senha, String senha2) {
        return senha.equals(senha2);
    }
    
    private void verificarCampos(Usuario usuario, String confirmarSenha) throws RegraNegocioException {
        if (usuario.getLogin().trim().equals(""))
            throw new RegraNegocioException("Login não informado");
        if (usuario.getSenha().trim().equals(""))
            throw new RegraNegocioException("Senha não informada");
        if (!confirmarSenha(usuario.getSenha(), confirmarSenha))
            throw new RegraNegocioException("Senhas não conferem.");
        if (usuario.getNome().trim().equals(""))
            throw new RegraNegocioException("Nome não informado");
    }
    
    @Override
    public Usuario efetuarLogin(String login, String senha) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario = (Usuario)usuarioDao.buscar(usuario);
        if (usuario == null)
            throw new RegraNegocioException("Usuário não cadastrado");
        if (!confirmarSenha(usuario.getSenha(), senha))
            throw new RegraNegocioException("Senha incorreta");
        return usuario;
    }
    
    @Override
    public void salvar(Usuario usuario, String confirmarSenha) throws Exception {
        if (usuarioDao.buscar(usuario) != null)
            throw new RegraNegocioException("Usuário já existe. Digite outro login");
        verificarCampos(usuario, confirmarSenha);
        usuarioDao.salvar(usuario);
    }
    
    @Override
    public void editar(Usuario usuario, String confirmarSenha) throws Exception {
        if (usuarioDao.buscar(usuario) == null)
            throw new RegraNegocioException("Usuário não cadastrado");
        verificarCampos(usuario, confirmarSenha);
        usuarioDao.editar(usuario);
    }
    
    @Override
    public void excluir(String login) throws Exception{
        VendaController vendaController = new VendaControllerImpl();
        Venda venda = new Venda();
        venda.setLoginUsuario(login);
        List<Venda> listaVenda = vendaController.listar(venda, null, null, null);

        if (!listaVenda.isEmpty()) 
            throw new RegraNegocioException("Usuário já efetuou vendas e não pode ser excluído");

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario = (Usuario)usuarioDao.buscar(usuario);
        if (usuario == null)
            throw new RegraNegocioException("Usuário não cadastrado");
        usuarioDao.excluir(usuario);
    }

    @Override
    public Usuario buscar(String login) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        return (Usuario)usuarioDao.buscar(usuario);
    }

    @Override
    public List<Usuario> listar() throws Exception {
        return usuarioDao.listar();
    }

    @Override
    public List<Usuario> listar(Usuario usuario) throws Exception {
        return usuarioDao.listar(usuario, null);
    }
}
