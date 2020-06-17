import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Socorro {

    /**Bem, nós temos que admitir: precisamos da ajuda de vocês. Este ano as coisas não aconteceram
    como previsto, e não conseguimos terminar o software do sistema de competição em tempo. Uma
    parte vital está faltando, e como vocês sabem, precisamos do sistema funcionando corretamente
    para esta tarde. A parte do sistema que está faltando é o módulo que computa a pontuação de um
    time, dada a lista de submissões desse time. Socorro, socorro, alguém nos ajude, por favor!
    Entrada
    A entrada contém vários casos de teste. A primeira linha de um caso de teste contém um inteiro N
    indicando o número de submissões do time. Cada uma das N linhas seguintes descreve uma
    submissão, no formato problema minutos resultado onde problema é uma letra de ‘A’ a ‘Z’,
    minutos é um inteiro representando os minutos passados desde o início da competição até o
    momento dessa submissão (0 · minutos · 300) e resultado é o resultado dessa submissão
    (‘correto’ ou ‘incorreto’). As submissões estão em ordem crescente de minutos, e haverá no
    máximo um resultado correto para cada problema. O final da entrada é indicado por N = 0.
    A entrada deve ser lida da entrada padrão.
    Saída
    Para cada caso de teste da entrada seu programa deve produzir uma linha na saída, contendo
    dois inteiros S e P, separados por espaço, onde S representa o número de problemas com o
    resultado correto e P é o tempo de submissão (em minutos) em que cada problema foi julgado
    correto, acrescido de 20 para cada submissão julgada incorreto de um problema que mais tarde foi
    julgado correto.
    A saída deve ser escrita na saída padrão.
    Exemplo de entrada
    3
    A 120 incorreto
    A 130 incorreto
    A 200 incorreto
    5
    A 100 correto
    B 110 incorreto
    B 111 correto
    C 200 correto
    D 300 incorreto
    0
    Saída para o exemplo de entrada
    0 0
    3 431 */



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) {
                // break;
                System.exit(0);
            }

            int totalCorrect = 0;
            int totalTime = 0;
            Map<Character, Integer> mapIncorrects = new HashMap<>();

            for (int i = 0; i < N; i++) {
                Character letter = sc.next().charAt(0);
                int time = sc.nextInt();
                String result = sc.next();

                if (result.equals("correto")) {
                    totalCorrect++;
                    totalTime += time;

                    if (mapIncorrects.containsKey(letter)) {
                        totalTime += mapIncorrects.get(letter);
                    }
                } else {
                    if (mapIncorrects.containsKey(letter)) {
                        Integer qtdMinutos = mapIncorrects.get(letter);
                        qtdMinutos += 20;
                        mapIncorrects.put(letter, qtdMinutos);
                    } else {
                        mapIncorrects.put(letter, 20);
                    }
                }
            }

            System.out.println(totalCorrect + " " + totalTime);
        }

    }
}