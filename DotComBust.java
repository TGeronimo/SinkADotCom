import java.util.*;
public class DotComBust {
  private GameHelper helper = new GameHelper();
  private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>(); //cria um ArrayList de objetos DotCom
  private int numOfGuesses = 0;

  private void setUpGame() { //Prepara o jogo, ou seja, cria as DotComs, dá instruções ao jogador e posiciona as DotComs.
    //primeiro cria alguns objetos DotCom e fornece nomes para eles
    DotCom one = new DotCom();
    one.setName("Pets.com");
    DotCom two = new DotCom();
    two.setName("eToys.com");
    DotCom three = new DotCom();
    three.setName("Go2.com");
    dotComsList.add(one);
    dotComsList.add(two);
    dotComsList.add(three);
    //exibe instruções para o usuário
    System.out.println("Seu objetivo e eliminar tres dot coms.");
    System.out.println("Pets.com, eToys.com, Go2.com");
    System.out.println("Tente eliminar todas com o menor número de palpites");

    for (DotCom dotComToSet : dotComsList) { //repete para cada DotCom da lista
      ArrayList<String> newLocation = helper.placeDotCom(3); //Solicita ao objeto auxiliar o local de um objeto DotCom.
      dotComToSet.setLocationCells(newLocation); //Chama o método de configuração nesse objeto DotCopm para lhe passar o local que você acabou de obter.
    }
  }


  private void startPlaying() {
    while (!dotComsList.isEmpty()) { //! equivale a NÃO. o mesmo que dotComsList.isEmpty() == false.
      String userGuess = helper.getUserInput("Insira um palpite:");
      checkUserGuess(userGuess);
    }
    finishGame();
  }


  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "Errado!";

    for (DotCom dotComToSet : dotComsList) {
      result = dotComToSet.checkYourself(userGuess);
      if (result.equals("Correto!")) {
        break;
      }
      if (result.equals("Eliminar!")) {
        dotComsList.remove(dotComToSet);
        break;
      }
    }
    System.out.println(result);
  }


  private void finishGame() {
    System.out.println("Todas as Dot Coms foram eliminadas! Agora seu conjunto está vazio.");
    if (numOfGuesses <= 18) {
      System.out.println("Você so usou " + numOfGuesses + " palpites.");
      System.out.println("Você saiu antes de eliminar suas opções.");
    } else {
      System.out.println("Demorou demais. " + numOfGuesses + " palpites.");
      System.out.println("Não haverá pesca com essas opções.");
    }
  }


  public static void main(String[] args) {
    DotComBust game = new DotComBust();

    game.setUpGame();

    game.startPlaying();
  }
}
