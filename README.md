 Sistema Web Refatorado

 Descrição do Projeto
Refatoração do sistema desktop para web aplicando princípios SOLID e boas práticas de programação.

️ Princípios SOLID Aplicados

 1 Single Responsibility Principle (SRP)
**Classes afetadas:** `Usuario`, `UsuarioService`, `UsuarioRepository`
**O que fiz:** Separei as responsabilidades em classes específicas
**Por que fiz:** Antes tudo estava misturado, agora cada classe tem uma única responsabilidade

 2 Open/Closed Principle (OCP)
**Classes afetadas:** Todas as classes de serviço e repositório
**O que fiz:** Criei classes que podem ser estendidas sem modificar o código existente
**Por que fiz:** Para facilitar a adição de novas funcionalidades

 3 Liskov Substitution Principle (LSP)
**Classes afetadas:** `ValidacaoException`
**O que fiz:** Usei herança correta que mantém o comportamento esperado
**Por que fiz:** Para garantir que minhas exceções funcionem onde exceções genéricas são esperadas

 Refatorações Aplicadas

1 Extração de Métodos
**Métodos afetados:** `validarDadosUsuario()` em `UsuarioService`
**Problema anterior:** Código de validação misturado com lógica principal
**Solução:** Extraí para método separado
**Resultado:** Código mais organizado e fácil de manter

2 Padrão Repository
**Classes afetadas:** `UsuarioRepository`
**Problema anterior:** Acesso a dados diretamente no serviço
**Solução:** Separei a persistência em classe dedicada
**Resultado:** Posso mudar a forma de armazenar dados sem afetar regras de negócio

3 Padrão Singleton
**Classes afetadas:** `UsuarioRepository`
**Problema anterior:** Risco de múltiplas instâncias inconsistentes
**Solução:** Implementei padrão Singleton com `getInstance()`
**Resultado:** Garantia de única fonte de verdade para os dados

 Testes Implementados
No método `main()` testei:
 Cadastro de usuário válido
 Validação de dados inválidos (nome vazio, email inválido)
 Listagem de usuários
 Busca por ID
 Impedimento de duplicações

