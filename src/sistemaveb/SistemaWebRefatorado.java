package sistemaveb;

import sistemaveb.model.Usuario;
import sistemaveb.service.UsuarioService;
import sistemaveb.exception.ValidacaoException;

public class SistemaWebRefatorado {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA WEB REFATORADO ===");
        System.out.println("Testando funcionalidades...\n");
        
        UsuarioService usuarioService = new UsuarioService();
        
        // Teste 1: Listar usuários existentes
        System.out.println("1. Listando usuários cadastrados:");
        usuarioService.listarUsuarios().forEach(System.out::println);
        
        // Teste 2: Cadastrar novo usuário
        System.out.println("\n2. Cadastrando novo usuário:");
        try {
            usuarioService.cadastrarUsuario("Carlos Oliveira", "carlos@email.com");
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (ValidacaoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        // Teste 3: Tentar cadastrar usuário inválido
        System.out.println("\n3. Tentando cadastrar usuário inválido:");
        try {
            usuarioService.cadastrarUsuario("", "email-invalido");
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (ValidacaoException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        
        // Teste 4: Listar usuários após cadastro
        System.out.println("\n4. Lista final de usuários:");
        usuarioService.listarUsuarios().forEach(System.out::println);
        
        // Teste 5: Buscar usuário específico
        System.out.println("\n5. Buscando usuário por ID:");
        Usuario usuario = usuarioService.buscarUsuario("1");
        if (usuario != null) {
            System.out.println("Usuário encontrado: " + usuario);
        } else {
            System.out.println("Usuário não encontrado");
        }
        
        System.out.println("\n=== TESTES CONCLUÍDOS ===");
    }
}