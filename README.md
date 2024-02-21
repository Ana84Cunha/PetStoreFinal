# ProjetoFinal Selenium PetStore

## Introdução
Este projeto foi desenvolvido como parte de uma formação para consolidar os conhecimentos adquiridos no uso do Selenium para automação de testes de software.

## Descrição
O projeto consiste em um conjunto de testes automatizados para a aplicação PetStore, utilizando o Selenium WebDriver. Ele inclui cenários de teste para o processo de registro de usuário, login, navegação e interação com elementos da página.

## Requisitos
- Java Development Kit (JDK) instalado
- Maven instalado
- WebDriverConfig configurado para iniciar o navegador desejado
- Dependências do Selenium WebDriver no arquivo pom.xml
- Jenkins configurado para integração contínua
- Relatório Allure para visualização de resultados de teste

## Como usar
1. Clone o repositório para sua máquina local.
2. Configure o WebDriverConfig para selecionar o navegador desejado.
3. Execute os testes usando o comando `mvn test`.
4. Visualize os resultados dos testes no console ou em relatórios gerados.
5. Para visualizar os resultados detalhados no Allure, execute `allure serve target/allure-results`.

## Estrutura do projeto
- **src/main/java**: Contém os arquivos de código-fonte do projeto.
- **src/test/java**: Contém os arquivos de teste.
- **src/test/resources**: Contém recursos como arquivos de configuração e dados de teste.

## Integração contínua com Jenkins
O projeto está integrado ao Jenkins para automação de builds e execução de testes em um ambiente de integração contínua.

## Relatório de testes com Allure
Os resultados dos testes são apresentados em relatórios Allure para uma visualização detalhada do progresso dos testes e das falhas encontradas.

## Contribuição
Contribuições são bem-vindas! Se encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Autor
Ana Cunha




