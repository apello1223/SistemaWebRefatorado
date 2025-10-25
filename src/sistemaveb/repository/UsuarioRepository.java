package sistemaveb.repository;

import sistemaveb.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> usuarios;
    private static UsuarioRepository instance;
    
    private UsuarioRepository() {
        this.usuarios = new ArrayList<>();
        // Dados iniciais para teste
        usuarios.add(new Usuario("1", "João Silva", "joao@email.com"));
        usuarios.add(new Usuario("2", "Maria Santos", "maria@email.com"));
    }
    
    // Singleton pattern - garante apenas uma instância
    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }
    
    public void salvar(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId().isEmpty()) {
            usuario.setId(String.valueOf(usuarios.size() + 1));
        }
        usuarios.add(usuario);
    }
    
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios); // Retorna cópia para evitar modificações externas
    }
    
    public Usuario buscarPorId(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public boolean remover(String id) {
        return usuarios.removeIf(u -> u.getId().equals(id));
    }
}