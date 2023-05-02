# Como rodar o projeto
- Na pasta TrabalhoFinal crie uma pasta "ClassDump" e rode a seguinte série de comandos:
```bash
javacc -output_directory=./ClassDump Lugosi.jj
```
```bash
javac -d ./ClassDump ./ClassDump/*.java 
```
```bash
java -cp ./ClassDump Lugosi {Arquivo de entrada .lug}
```