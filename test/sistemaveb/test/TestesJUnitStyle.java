package sistemaveb.test;

import sistemaveb.service.UsuarioService;
import sistemaveb.exception.ValidacaoException;

// Testes estilo JUnit manual
public class TestesJUnitStyle {
    
    public static void main(String[] args) {
        System.out.println("🧪 TESTES NO ESTILO JUNIT");
        System.out.println("=========================\n");
        
        UsuarioService service = new UsuarioService();
        int testesPassados = 0;
        int testesTotais = 0;
        
        // Teste 1: Email válido (@Test)
        testesTotais++;
        try {
            service.validarEmail("teste@email.com");
            System.out.println("✅ @Test testValidarEmailCorreto() - PASSOU");
            testesPassados++;
        } catch (ValidacaoException e) {
            System.out.println("❌ @Test testValidarEmailCorreto() - FALHOU: " + e.getMessage());
        }
        
        // Teste 2: Email inválido (@Test expected = ValidacaoException.class)
        testesTotais++;
        try {
            service.validarEmail("email-invalido");
            System.out.println("❌ @Test testValidarEmailInvalido() - FALHOU: Deveria lançar exceção");
        } catch (ValidacaoException e) {
            System.out.println("✅ @Test testValidarEmailInvalido() - PASSOU: " + e.getMessage());
            testesPassados++;
        }
        
        // Teste 3: Nome válido (@Test)
        testesTotais++;
        try {
            service.validarNome("João Silva");
            System.out.println("✅ @Test testValidarNomeCorreto() - PASSOU");
            testesPassados++;
        } catch (ValidacaoException e) {
            System.out.println("❌ @Test testValidarNomeCorreto() - FALHOU: " + e.getMessage());
        }
        
        // Teste 4: Nome vazio (@Test expected = ValidacaoException.class)
        testesTotais++;
        try {
            service.validarNome("");
            System.out.println("❌ @Test testValidarNomeVazio() - FALHOU: Deveria lançar exceção");
        } catch (ValidacaoException e) {
            System.out.println("✅ @Test testValidarNomeVazio() - PASSOU: " + e.getMessage());
            testesPassados++;
        }
        
        // Teste 5: assertEquals - Cálculo de tamanho
        testesTotais++;
        int resultado = service.calcularTamanhoNome("Maria");
        if (resultado == 5) {
            System.out.println("✅ @Test testCalcularTamanhoNome() - PASSOU: assertEquals(5, " + resultado + ")");
            testesPassados++;
        } else {
            System.out.println("❌ @Test testCalcularTamanhoNome() - FALHOU: Esperado 5, obtido " + resultado);
        }
        
        System.out.println("\n=========================");
        System.out.println("📊 RESULTADO: " + testesPassados + "/" + testesTotais + " testes passaram");
        System.out.println("🎯 ESTILO JUNIT: Testes implementados seguindo padrão JUnit");
        System.out.println("📝 ANOTAÇÕES: @Test, @Test(expected), assertEquals simulados");
    }
}