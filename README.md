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

Por fim, só precisa rodá-los na IDE e terá o projeto funcioanndo. Futuramente, irei fazer o app.java ser o arquivo principal;