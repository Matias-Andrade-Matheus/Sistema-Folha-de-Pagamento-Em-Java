# Sistema-Folha-de-Pagamento-Em-Java
## Sistema de Folha de Pagamento por Vulnerabilidade Socio-familiar
Este é um programa em Java desenvolvido por um trio com o intuito de obtenção de nota na matéria de Algoritmos e Programação do curso de Ciência da Computação da Unifacs.
O programa auxilia na triagem e classificação de famílias para programas de assistência social.
O sistema calcula uma pontuação de prioridade com base em critérios como: renda per capita, número de dependentes de pessoas com algum tipo de deficiência, nível de desemprego e nível de riscos habitacionais.

## Principais Funcionalidades

- Cadastro de Famílias: Por meio de uma breve entrevista, há a coleta de dados sobre as famílias envolvidas no benefício.

- Cálculo de Pontuação: Algoritmo gera pontos com condições de bônus para priorização de certos grupos desfavorecidos conforme critérios pré-estabelecidos.

- Classificação de Vulnerabilidade: 
Identificação visual (colorida no terminal), o programa apresenta os seguintes níveis:

- (🔴) CRÍTICA: Acima de 50 pontos.

- (🟡) MODERADA: Entre 31 e 50 pontos.

- (🟢) BAIXA: Até 30 pontos.

- Ranking de Prioridade: O sistema cria uma ordenação das famílias cadastradas da mais necessitada para a menos necessitada.

- Persistência de Dados: Salvamento automático em arquivo texto (familias.txt) para não perder os dados ao fechar o programa.

## Critérios de Pontuação
O sistema utiliza a seguinte lógica para calcular a prioridade:

- Renda Per Capita familiar

- Dependentes na família

- Integrantes da família com deficiência

- Risco no bairro de moradia

- Desempregados por tempo de desemprego em meses


#### Renda Per Capita familiar
A renda familiar medida pelo sistema se baseia em Renda Per Capita, isso é, soma total da renda bruta familiar e divide por integrante.

Por tanto, as variações desse cálculo se incluem no sistema da seguinte forma de pontuação: 

- Renda Per Capita até R$ 200 -> +25 pontos

- Renda Per Capita entre R$ 201 e R$ 400 -> +15 pontos

- Renda Per Capita entre R$ 401 e R$ 600 -> +10 pontos

- Renda Per Capita entre R$ 601 e R$ 700 -> +5 pontos


#### Dependentes na família
Para cada integrante da família que é dependente, quem não possui renda, o sistema soma 10 pontos:

- Se possui dependentes: +10 pontos por dependente

#### Integrantes com deficiência
Nessa parte do sistema existe uma verificação de resposta para a presença ou não de uma pessoa que possui está limitação (Sim/Não) na família que está sendo cadastrada. Tal método é aplicado para certificação de que esse usuário pretende utilizar-se deste benefício.

Para cada integrante da família que possui algum tipo de deficiência o sistema soma 10 pontos:

- Se possui deficiência: +10 pontos por integrante

#### Risco no bairro (Violência/Natural/Ambos) 
Nessa parte do sistema existe uma verificação de resposta para a aplicação do grupo familiar no benefício (Sim/Não) e do tipo de aplicação (Violência/Natural/Ambos) da família que está sendo cadastrada. Tal método é aplicado para certificação de que esse usuário pretende utilizar-se deste benefício e como utilizará.

Para esta questão social na família, se presente, o sistema soma 7 pontos ou 10 pontos:

- Se a família aplica-se em um Risco do tipo Violência ou Natural: +7 pontos

- Se a família aplica-se em Ambos os Riscos: +10 pontos

#### Desemprego (Entre 6 e 12 meses e acima de 12 meses)
Nessa parte do sistema existe uma verificação de resposta para a presença ou não de uma pessoa que possui esta questão (Sim/Não) na família que está sendo cadastrada.

Para esta questão social na família, se presente, o sistema soma 7 pontos ou 10 pontos:

- Entre 6 e 12 meses: +7 Pontos

- Acima de 12 meses: +10 pontos

## Tecnologias Utilizadas
- Linguagem: Java (JDK 17+)

- IDE recomendada: IntelliJ IDEA

- Manipulação de Dados: ArrayList e Collections

## Como Executar
1. Certifique-se de ter o JDK instalado em sua máquina.
2. Clone este repositório ou baixe o arquivo Main.java.
3. Abra o projeto no IntelliJ IDEA.
4. Certifique-se de que o arquivo Main.java está marcado como Source Root.
5. Execute a classe Main.

## Exemplo de Uso
Ao iniciar o programa, você verá um menu interativo:

1 - Cadastrar nova família
2 - Listar famílias
3 - Ver prioridade na fila
4 - Sair

## Estrutura do Projeto

├── Main.java         # Código fonte principal e classe interna Familia

├── familias.txt      # Arquivo gerado automaticamente com os dados salvos

└── README.md         # Documentação do projeto

# Autores

Helena (nome completo) - Github []

Rafael (nome completo) - Github []

Matheus Henrique Matias Andrade - GitHub []
