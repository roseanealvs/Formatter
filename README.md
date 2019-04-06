# Formatter
App que utiliza expressões regulares para manipulação de Strings

O objetivo desse App é mostrar quantas coisas são possíveis fazer com REGEX!!! 

Com as expressões regulares, foi possível criar um StringFormatter que quebra o texto em N max caracteres, no caso utilizei 40, e pode justificá-lo ou não.

Na primeira parte, foi utilizado um pattern que traria todos os trechos com no máximo 40 caracteres, mas que não quebra as palavras no meio. A seguinte expressão foi utilizada: 
.{1,40}\n|.{1,40}$|.{1,40}\s

A expressão acima procura primeiro por qualquer caracter entre 1 e 40 vezes até uma quebra de linha ou, em segundo, procura por qualquer caracter entre 1 e 40 vezes até o final do input ou, em terceiro lugar, procura por qualquer caracter entre 1 e 40 vezes até um espaço.

Em seguida, a expressão regular é compilada em modo “DOTALL” onde o “.” (ponto) representa também o fim de linhas (por padrão o “.” não reconhece fim de linha).

Após o matcher ser processado com o pattern, e foram reconhecidos padrões, os mesmos são separados em grupos, então, para cada grupo é verificada a necessidade de justificar ou não o texto;

Caso seja necessário justificar, o grupo é passado para o método responsável pela justificação da linha, onde os seguintes passos são realizados:

1 - Pegar o número de espaços total existente entre as palavras (regex usado: \u0020(?!$) ) - pega todos os espaços que não estejam no final da string;

2- Subtrai do limite máximo de caracteres o tamanho total da string, obtendo o número total de espaços que devem ser inseridos na string;

3 - Pega o quociente da divisão entre espaço necessário e espaços existentes (div) - resulta em quantos espaços devem ser adicionado a mais em cada um já existente.

4 - Pega o resto da divisão entre espaço necessário e espaços existentes (mod) - resulta nos remanescentes

5 - Divide a string em palavras (split(“ ”))

6 - Itera sobre o array de palavras utilizando String.format (%-totalLenght+s) onde totalLength = tamanho total da palavra + div + mod + 1
	mod vai sendo subtraído de 1 a cada iteração;
	1 é o espaço que existia antes e foi omitido no “split”;

Os passos acima se repetem para todos os grupos do matcher.
