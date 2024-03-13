package projeto;

import java.util.ArrayList;
import java.util.List;

public class PizzaBot {

  private String[] alfabetoEntrada = {"1", "2", "3", "4", "5", "6", "p", "m", "g", "f", "s", "n"};
  private String[] alfabetoPilha = {"A", "$"};
  private List<String> stack = new ArrayList<>();

  public void iniciar(String cadeia) {
    q0(cadeia);
  }

  public void q0(String cadeia) {
    this.stack.add("$");
    q1(cadeia);
  }

  public void q1(String cadeia) {
    if (cadeia.charAt(0) != '1' && cadeia.charAt(0) != '2' && cadeia.charAt(0) != '3'
        && cadeia.charAt(0) != '4' && cadeia.charAt(0) != '5' && cadeia.charAt(0) != '6') {
      rejeitar();
      return;
    }

    while (!cadeia.isEmpty()) {

      if (cadeia.charAt(0) == '1' || cadeia.charAt(0) == '2' || cadeia.charAt(0) == '3'
          || cadeia.charAt(0) == '4' || cadeia.charAt(0) == '5' || cadeia.charAt(0) == '6') {
        this.stack.add("A");
      } else if (cadeia.charAt(0) == 'p' || cadeia.charAt(0) == 'm' || cadeia.charAt(0) == 'g') {
        if (stack.get(stack.size() - 1).equals("A") && stack.get(stack.size() - 2).equals("A")
            && stack.get(stack.size() - 3).equals("A")) {
          this.stack.remove(stack.size() - 1);
        }
        q2(removeByIndex(cadeia, 0));
        return;
      } else {
        rejeitar();
        return;
      }

      cadeia = removeByIndex(cadeia, 0);
    }

    rejeitar();

  }

  private void q2(String cadeia) {
    if (cadeia.charAt(0) == 'f' || cadeia.charAt(0) == 'g') {
      if (stack.get(stack.size() - 1).equals("A") && stack.get(stack.size() - 2).equals("A")) {
        this.stack.remove(stack.size() - 1);
      }
      q3(removeByIndex(cadeia, 0));
      return;
    }
    rejeitar();
  }

  private void q3(String cadeia) {
    if (cadeia.charAt(0) == 's' || cadeia.charAt(0) == 'n') {
      if (stack.get(stack.size() - 1).equals("A")) {
        this.stack.remove(stack.size() - 1);
        q4(removeByIndex(cadeia, 0));
        return;
      }
    }
    rejeitar();
  }

  private void q4(String cadeia) {
    if (stack.get(stack.size() - 1).equals("$") && cadeia.isEmpty()) {
      q5();
      return;
    }
    rejeitar();
  }

  private void q5() {
    aceitar();
  }

  private static String removeByIndex(String str, int index) {
    return new StringBuilder(str).deleteCharAt(index).toString();
  }


  public void rejeitar() {
    System.out.println("Cadeia rejeitada");
  }

  public void aceitar() {
    System.out.println("Cadeia aceita");
  }
  
}
