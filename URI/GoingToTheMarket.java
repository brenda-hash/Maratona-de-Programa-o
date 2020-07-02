import java.util.Scanner;

/*URI Online Judge | 1281
Going to the Market
By Neilor Tonin, URI  Brazil

Timelimit: 1
Ms. Parcinova usually go to the public market to buy fruits and vegetables.
She asked her daughter, Mangojata, to help her doing a program that calculates 
the amount she needs bring to be able to buy everything of her shopping list,

 considering the amount of each fruit or vegetable and prices of these items.

Input
The first line of input contains an integer N that indicates the amount of trips of Dona Parcinova 
to the market (which is nothing more than the number of test cases). 
Each test case starts with an integer M which is the quantity of products 
with prices that are available for sale at the market. 
Follow M products with their respective prices per unit or Kg. 
The next input line contains an integer P (1 ≤ P ≤ M) that indicates the list of products that
 Ms. Parcinova want to buy. Follow P lines containing a string (with up to 50 chars) and an integer,
  representing each item with the desired quantity of this item.

Output
Each test case produce one output line, containing the money spent by Ms.
Parcinova in the following format: R$ followed by a space and followed by the spent money, 
with 2 places after the decimal point according to the following example.


Sample Input	

2
4
mamao 2,19
cebola 3,10
tomate 2,80
uva 2,73
3
mamao 2
tomate 1
uva 3
5
morango 6,70
repolho 1,12
brocolis 1,71
tomate 2,80
cebola 2,81
4
brocolis 2
tomate 1
cebola 1
morango 1
*/
public class GoingToTheMarket {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      double S = 0;

      int M = sc.nextInt();

      String[] productNames = new String[M];
      double[] productPricing = new double[M];

      for (int j = 0; j < M; j++) {
        productNames[j] = sc.next();
        productPricing[j] = sc.nextDouble();
      }

      int P = sc.nextInt();
      String[] productNamesX = new String[P];
      int[] counts = new int[P];

      for (int w = 0; w < P; w++) {
        productNamesX[w] = sc.next();
        counts[w] = sc.nextInt();
      }

      for (int l = 0; l < P; l++) {
        for (int m = 0; m < M; m++) {
          if (productNames[m].equalsIgnoreCase(productNamesX[l])) {
            S = (S + (productPricing[m]) * counts[l]);
          }
        }
      }

      System.out.println(String.format("R$ %.2f", S));
    }
  }
}
