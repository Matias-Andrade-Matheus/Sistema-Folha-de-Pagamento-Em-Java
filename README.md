# Sistema-Folha-de-Pagamento-Em-Java
## Sistema de Folha de Pagamento por Vulnerabilidade Socio-familiar
Este é um programa em Java desenvolvido por um trio com o intuito de obtenção de nota na matéria de Algoritmos e Programação do curso de Ciência da Computação da Unifacs.
O programa auxilia na triagem e classificação de famílias para programas de assistência social.
O sistema calcula uma pontuação de prioridade com base em critérios como: renda per capita, número de dependentes de pessoas com algum tipo de deficiência, nível de desemprego e nível de riscos habitacionais.

## Principais Funcionalidades

Cadastro de Famílias: Por meio de uma breve entrevista, há a coleta de dados sobre as famílias envolvidas no benefício.

Cálculo de Pontuação: Algoritmo gera pontos com condições de bônus para priorização de certos grupos desfavorecidos conforme critérios pré-estabelecidos.

Classificação de Vulnerabilidade: Com identificação visual (colorida no terminal), o programa apresenta os seguintes níveis:

🔴 CRÍTICA: Acima de 50 pontos.

🟡 MODERADA: Entre 31 e 50 pontos.

🟢 BAIXA: Até 30 pontos.

Ranking de Prioridade: O sistema cria uma ordenação das famílias cadastradas da mais necessitada para a menos necessitada.

Persistência de Dados: Salvamento automático em arquivo texto (familias.txt) para não perder os dados ao fechar o programa.
## Critérios de Pontuação
O sistema utiliza a seguinte lógica para calcular a prioridade:
### Renda Per Capita 
Renda Per Capita até R$200 -> +25 pontos
Renda Per Capita entre R$201 e R$400 -> +15 pontos
Renda Per Capita entre R$401 e R$600 -> +10 pontos
### Dependentes
Possui dependentes +10 pontos por dependente
Integrantes com deficiência	+10 pontos por integrante
Risco no bairro (Violência/Natural)	+7 a +10 pontos
Desemprego (Acima de 12 meses)	+10 pontos
🛠️ Tecnologias Utilizadas
Linguagem: Java (JDK 17+)
IDE recomendada: IntelliJ IDEA
Manipulação de Dados: ArrayList e Collections
Persistência: File I/O (PrintWriter e Scanner)
📦 Como Executar
Certifique-se de ter o JDK instalado em sua máquina.
Clone este repositório ou baixe o arquivo Main.java.
Abra o projeto no IntelliJ IDEA.
Certifique-se de que o arquivo Main.java está marcado como Source Root.
Execute a classe Main.
🖥️ Exemplo de Uso
Ao iniciar o programa, você verá um menu interativo:
code
Text
1 - Cadastrar nova família
2 - Listar famílias
3 - Ver prioridade na fila
4 - Sair
📂 Estrutura do Projeto
code
Text
├── Main.java         # Código fonte principal e classe interna Familia
├── familias.txt      # Arquivo gerado automaticamente com os dados salvos
└── README.md         # Documentação do projeto
✒️ Autor
Seu Nome - Seu GitHub
