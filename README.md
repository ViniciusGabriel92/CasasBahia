# AppCasasBahia
Aplicação/loja online para exibição/aquisição de TV's de diversas m

###### Procedimento de clonagem do projeto
  - Na aba VCS do AS, faça o seguinte caminho: "Checkout from version code" -> Git e insira a seguinte URL para clonar este projeto "https://github.com/ViniciusGabriel92/CasasBahia.git"

## Requisito mínimo:
- IDE: Android Studio 3.6 - Link para download ("https://developer.android.com/studio?hl=pt")
- Execução com no mínimo: Android Version 4.4 (Kitkat)



## Library's

```python
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    kapt 'com.github.bumptech.glide:compiler:4.11.0'
    implementation 'com.squareup.retrofit2:retrofit:2.7.2'
    implementation 'com.squareup.retrofit2:converter-gson:2.7.2'
    implementation 'com.squareup.retrofit2:converter-gson:2.7.2'
```

## Principais Desafios

- De início, um dos principais desafios desta task foi definir a arquitetura para melhor atender ao cenário, em seguida, foi a definição das tecnologias que seriam utilizadas, após análise e comparações, optei pelas tecnologias sugeridas.

- Implementei uma arquitetura clean, com a separação de responsabilidades por camadas, onde temos a camada "app", onde realizamos os principais processamentos referenteas a camada do usuário; a camada "core", onde temos todas as nossas entidades e contratos da aplicação, e por último (e não menos importante), a camada "infra", onde temos as tecnologias de utilização externa, ex.: Retrofit.
A criação da última camada citada se deu por conta do fato em que a qualquer momento podemos migrar a tecnologia de requisição as API's e não haverá nenhum impacto no restante da aplicação, pois a mesma só a consulta e recebe os dados prontos para serem utilizados, sem saber como são gerados.

- Mais um dos principais desafios foi a permissão de acesso ao domínio "mocky.io", pois a partir do Android 9.0 (API nível 28), o suporte a textos não criptografados é desativado por padrão, o que me levou a baixar o certificado do site, importar no projeto, configurar o arquivo de segurança no manifest e mandá-lo permitir o acesso ao domínio, o mesmo ocorreu para acesso ao domínio no link das imagens da aplicação no JSON.

- Um outro desafio desta task também foi o entendimento da linguagem de programação Kotlin e suas diferenças com o Java.

- Um outro ponto foi a utilização de folders architecture para separação das funcionalidades e exibições. 
P.S: De início, pensei em reaproveitar algumas views que se repetem entre algumas telas, mas percebi que o custo de processamento para manipular as mesmas para atender ao case seria maior do que criar as views separadas.

## Design Patterns Utilizados
-Nesta task, foram utilizados alguns padrões de projetos, tais como: Strategy, SOLID, Factory e Builder

## Tempo Investido
- Basicamente, ao longo de duas semanas se deu a média de 72 horas de tempo de desenvolvimento da aplicação.
