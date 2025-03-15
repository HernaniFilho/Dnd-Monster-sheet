## Projeto de Monster sheet Simplificada

Neste projeto aplico meus conhecimentos em Java e orientação a objetos, como também conhecimentos de padrões arquiteturais (MVC),
padrões de projeto e afins

## O que apliquei

O padrão arquitetural MVC junto com o padrão DAO para acesso ao banco de dados MySQL.

## Como usar?

Você vai precisar ter o MySQL instalado na sua máquina e alterar (ou não) esses valores em ConnectionFactory presente em br.monstersheet.factory

    //Username do Banco de dados
    private static final String USERNAME = "root";

    //Password do Banco de dados
    private static final String PASSWORD = "0123456";

    //Database URL, Port, Database name
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/monsterssheet";

E claro ter o JDK mais recente instalado para executar arquivos do ambiente Java. No atual momento de desenvolvimento voc~e precisará de uma IDE 
que rode Java (ex.: Eclipse) para executar os arquivos presentes em br.monstersheet.view

É importante verificar a pasta lib, ali tem um script SQL que você pode copiar para criar todas as tabelas do projeto no MySQL

Por fim, só precisa rodá-los na IDE e terá o projeto funcioanndo. Ao executar o arquivo MonsterListWindow em br.monstersheet.view você terá o projeto todo rodando.

## Lições para o futuro com este projeto

Aprendi como construir uma aplicação com interface gráfica com uma ferramenta completamente nova, o que me ensinou a importante da arquitetura de projeto.
Neste projeto por exemplo eu usei o MVC, que a primeiro momento parecia desafiador mas me mostrou como foi importante para separar as funcionalidades e responsabilidades dos meus cógidos.

Percebi ao desenvolver da aplicação que o acesso a um bando de dados é muito custoso e então aprender novas maneiras de se conectar a uma base de dados, de forma a diminuir os acessos é importantíssimo mesmo num projeto pessoal pequeno.

Também aprendi que um bom planejamento é importantíssimo, o diagrama UML que eu fiz me ajudou muito a "enxergar" o escopo da aplicação e assim me focar no desenvolvimento. Num projeto real por exemplo é importantíssimo um planejamento para aplicações de metodologia ágeis e frameworks de desenvolvimento.

Percebi também que preciso evoluir na aréa UI/UX para dar feedbacks ao usuário de forma mais eficiente.