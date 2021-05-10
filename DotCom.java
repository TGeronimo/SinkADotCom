import java.util.*;

public class DotCom {
  private ArrayList<String> locationCells;
  private String name;


  public void setLocationCells(ArrayList<String> loc) {
    locationCells = loc;
  }


  public void setName(String n) {
    name = n;
  }


  public String checkYourself(String userInput) {
    String result = "Errado!";
    int index = locationCells.indexOf(userInput);
    //.indexOf() verifica se o elemento está na lista e retorna sua posição. Caso não esteja, retorna -1.

    if (index >= 0) { //se não retornar -1, então o palpite está na lista
      locationCells.remove(index); //remove o elemento da lista

      if (locationCells.isEmpty()) { // verifica se o último palpite afundou a DotCom, isEmpty verifica se o ArrayList está vazio
        result = "Eliminar!";
        System.out.println("Ora! Você afundou " + name + " :(");
      } else {
        result = "Correto!";
      } //encerra if

    } //encerra if externo
    return result; //caso tenha errado, retorna "miss"
  }
}
