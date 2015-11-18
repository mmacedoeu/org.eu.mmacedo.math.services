No momento contempla a seguintes funcionalidades:

- dado uma lista de números e uma soma alvo, retorne todas as combinações de um ou mais itens da lista que a soma seja igual a soma alvo;

formato de entrada: total;parcela1,parcela2,parcela3,... vide arquivo suminputmasstest1.csv
saida pelo logger: [ (parcela1, parcela2) (parcela3) ... ]

O programa processa o arquivo csv de massa de entrada na pasta suminput ou o que estiver especificado no arquivo application.properties podendo ser ainda sobreescrito por passagem de parametro ao programa principal através do parametro --checksum.input.folder=./suminput


- encontra um caminho a partir de uma origem até o destino navegando entre os nós. Cada nó é representado por um número inteiro. Cada possibilidade de caminho é representado por um dicionário no formato (Inteiro -> Lista( Inteiros)), onde a chave é o número do nó, e a lista são as ligações unidirecional daquele nó. O resultado é uma lista de inteiros representando o caminho pelos nós;

formato de entrada: inicio;fim;no1>path1,path2;no2>path3,path4;... vide arquivo graphinputmasstest1.csv
saida pelo logger: ( path1, path3, path4 )

O programa processa o arquivo csv de massa de entrada na pasta graphinput ou o que estiver especificado no arquivo application.properties
podendo ser ainda sobreescrito por passagem de parametro ao programa principal através do parametro --graph.input.folder=./graphinput

Procedimento de empacotamento:

Via linha de comando (shell)

- Verificar se tem instalado o maven em sua máquina:

http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

- Abrir o shell, como cmd.exe, e na pasta raiz do projeto executar o comando

mvn package

- Executar o applicativo com o comando

 java -jar target\org.eummacedo.math.services-0.0.1-SNAPSHOT.jar --checksum.input.folder=./suminput --graph.input.folder=./graphinput


Via Eclipse:

Importar o projeto indo no menu

File - Import - Maven - Existing Maven Projects 

Selecionar pasta raiz do projeto e apertar o Botão Finish

Rodar a Classe Application como Java Application

Via IntelliJ:

Usar os recursos de importação de projeto maven ou gerar os arquivos de projeto na linha de comando com mvn 

https://www.jetbrains.com/idea/help/importing-project-from-maven-model.html

O aplicativo ainda pode ser testado executando os casos de testes unitários através do comando mvn test ou individual através do Junit na IDE

Para verificar os resultados observar os valores do payload no log de saída.

