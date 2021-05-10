public class SimpleDotCom {

 int [] locationCells;
 int numOfHits = 0;

 public void setLocationCells (int[] locs) {
  locationCells = locs;
 }

 public String checkYourself(String stringGuess) {
  int guess = Integer.parseInt(stringGuess);
  String result = "miss";

  // temos um bug neste código (bem aqui no for): se o jogador repetir um palpite correto pode vencer sem adivinhar as demais posições.
  //pois não elimina uma célula que já foi verificada, fazendo que possa ser verificada novamente.
  for (int cell : locationCells) {
   if (guess == cell) {
	result = "hit";
	numOfHits++;
	break;
   }
  } //fora do loop

  if (numOfHits == locationCells.length) {
    result = "kill";
  }
  System.out.println(result);
  return result;
 } //fecha o método
} //fecha a classe
