/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package epocaespecial2022;

public class App {

  public static void main(String[] args) throws InterruptedException {

    var controlo = new ControloEntradaImpl();
    for (int j = 0; j < 2; ++j) {
      new Thread(() -> {
        try {
          System.out.println("Abrindo entrada");
          System.out.println("Porta aberta");
          controlo.podeAbrirEntrada();
          System.out.println("Entrando passageiros");
          for (int i = 0; i < 5; ++i) {
            controlo.entrouPassageiro("Passageiro " + (i + 1));
          }
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }).start();
    }

    System.out.println("Fechando porta");
    controlo.podeFecharEntrada();
    System.out.println("Porta fechada");
    new Thread(() -> {
      try {
        controlo.podeAbrirEntrada();
        System.out.println("Porta aberta");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

    for (int i = 0; i < 10; ++i) {
      controlo.saiuPassageiro();
    }
  }
}
