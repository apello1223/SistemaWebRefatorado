package sistemaveb.service;

import sistemaveb.model.Usuario;
import sistemaveb.repository.UsuarioRepository;
import sistemaveb.exception.ValidacaoException;

public class UsuarioService {
    private UsuarioRepository repository;
    
    public UsuarioService() {
        this.repository = UsuarioRepository.getInstance();
    }
    
   
    public void cadastrarUsuario(String nome, String email) throws ValidacaoException {
        validarDadosUsuario(nome, email);
        
        Usuario usuario = new Usuario(null, nome, email);
        repository.salvar(usuario);
    }
    
    private void validarDadosUsuario(String nome, String email) throws ValidacaoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoException("Nome não pode ser vazio");
        }
        
        if (email == null || !email.contains("@")) {
            throw new ValidacaoException("Email inválido");
        }
    }
    
    public java.util.List<Usuario> listarUsuarios() {
        return repository.listarTodos();
    }
    
    public Usuario buscarUsuario(String id) {
        return repository.buscarPorId(id);
    }
}