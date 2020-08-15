import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/*Problema A
MeuSom
Arquivo fonte: meusom.c, meusom.cpp ou meusom.java
A codificação MeuSom agrupa palavras que possuem o som parecido, com base em sua
pronúncia e fonemas. Por exemplo, "concerto" e "conserto", "viagem" e "viajem" possuem a
codificação equivalente no MeuSom.
Para isto, a codificação MeuSom traduz cada palavra em uma série de dígitos, em que cada dígito
representa uma letra:
1 representa B, F, P, ou V
2 representa C, G, J, K, Q, S, X, ou Z
3 representa D ou T
4 representa L
5 representa M ou N
6 representa R
As letras A, E, I, O, U, H, W, e Y não são representadas na codificação MeuSom, e letras
repetidas com o mesmo dígito codificado são representados por uma instância simples do dígito.
Palavras com o mesmo código MeuSom são consideradas equivalentes.
Entrada
A entrada contém vários casos de teste, e cada linha possui uma palavra simples, toda em letras
maiúsculas e menor que 20 letras.
A entrada deve ser lida da entrada padrão.
Saída
Para cada caso de teste da entrada produzir uma linha na saída, com a codificação MeuSom.
A saída deve ser escrita na saída padrão.
Exemplo de entrada
CONCERTO
CONSERTO
PFISTER
VIAGEM
BABBI
Saída para o exemplo de entrada
25263
25263
1236
125
11*/


public class MeuSom {
	public static void main(String[] args){

		Map<Character, Integer> map = new HashMap<>();
		map.put('B', 1);
		map.put('F', 1);
		map.put('P', 1);
		map.put('V', 1);
		map.put('C', 2);
		map.put('G', 2);
		map.put('J', 2);
		map.put('Q', 2);
		map.put('S', 2);
		map.put('X', 2);
		map.put('Z', 2);
		map.put('D', 3);
		map.put('T', 3);
		map.put('L', 4);
		map.put('M', 5);
		map.put('N', 5);
		map.put('R', 6);

		Scanner sc = new Scanner(System.in);



		while(sc.hasNext()){
			String input = sc.nextLine();
			String output = "";
			Integer previousValue = 0;

			for(Character character: input.toCharArray()){
				if(map.containsKey(character)){
					Integer value = map.get(character);

					if(previousValue != value){
						output += value;
						previousValue = value;
					}
					
				}else{
					previousValue = 0;
				}
			}

			System.out.println(output); 
		}
	}
}