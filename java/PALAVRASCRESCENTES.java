public class PALAVRASCRESCENTES {
  public static int palavrasCRESCENTES(String um, String dois) {// Se as 2 Strings for igual retorna 2;
    // Se a primeira String for mais proxima de A do que a segunda retorna 0;
    // Se a primeira String estiver mais longe de A do que a segunda retorna 1;

    // BUG DA FUNCAO <------------------ // ESSA FUNCAO COMPARA CADA CARACTER
    // ATRAVES DA TABELA ASCII, NA TABELA AS LETRA MAISUCULAS OCUPAM UM VALOR MENOR
    // QUE AS MINUSCULAS, DESSA MANEIRA A FUNCAO SEMPRE VAI JOGAR PALAVRAS
    // MAIUSCULAS NA FRENTE DE MINUSCULAS. // PARA CORRIGIR EU TERIA QUE CRIAR MEU
    // PROPRIO ARRAY DE CARACTERES.

    char[] letraSTR1 = new char[50];
    letraSTR1 = um.toCharArray();
    int valorSTR1 = 0;
    char[] letraSTR2 = new char[50];
    letraSTR2 = dois.toCharArray();
    int valorSTR2 = 0;
    int resp = 0;
    boolean testaro2 = false;
    boolean testaro1 = false;

    int valormenor = 1000;

    int tam1 = um.length();
    int tam2 = dois.length();
    int tamanhofor = 0;

    if (tam1 < tam2) {

      tamanhofor = tam1;

    }

    if (tam2 < tam1) {

      tamanhofor = tam2;

    }

    if (tam1 == tam2) {

      tamanhofor = tam1;

    }

    for (int i = 0; i < tamanhofor; i++) {

      if (letraSTR1[i] != ' ' && letraSTR2[i] != ' ') {

        valorSTR1 = (int) letraSTR1[i];
        valorSTR2 = (int) letraSTR2[i];
      }

      if (valorSTR1 != valorSTR2) {

        if (valorSTR1 > valorSTR2) {

          if (valormenor > valorSTR2) {

            valormenor = valorSTR2;
            resp = 1;
            i = letraSTR2.length;
            testaro1 = true;
          }
        }

        if (valorSTR1 < valorSTR2) {

          i = tamanhofor;
          resp = 0;
          testaro2 = true;
        }
      }
    }

    if (tam1 == tam2 && testaro2 == false) {

      if (resp == 0) {

        resp = 2;

      }

    }

    if (testaro1 == false && testaro2 == false) {

      if (tam1 < tam2) {

        resp = 0;

      }

      if (tam1 > tam2) {

        resp = 1;

      }

    }

    return resp;

    // Essa função analisa sempre as 2 palavras posicao por posicao.
    // Ela faz isso pegando o tamanho da string menor e analisando todas as letras
    // das 2 string até esse numero, para o for nao comparar a letra que tem a mais
    // na string maior com vazio.
    // Depois ele tem que sempre ignorar letras de espaços que não são comparados.
    // Ai ele pega sempre a letra na posicao 0 da string 1 com a letra da posicao 0
    // da string 2, se a primeira letra que aparecer diferente da string 2 com a
    // string 1 for menor que a letra diferente da string 1, ele transforma em true
    // a resposta, deixando a palavra presente na casa dois da função habilidade
    // para ser trocado com a string presente na casa um, isso quer dizer que ordem
    // alfabetica, a string dois vem antes da string um.
    // Se for achando as letras diferentes e string1 < string2 ele termina a funcao
    // pois não precisa ser feita a troca

  }

  public static void main(String[] args) {

    String um = "atleticogo";
    String dois = "atletico";

    String a = "Cruzeiro";
    String b = "Internacional";

    // String ze = "zebra";
    // String zz = "ZZZZZZZZZZ";

    int resp = palavrasCRESCENTES(um, dois);
    int resp2 = palavrasCRESCENTES(b, a);
    // int resp3 = palavrasCRESCENTES(ze, zz); --> BUG ENCONTRADO NA FUNCAO
    // palavrasCRESCENTES.

    /*
     * 1. Quando A o primeiro parametro foi mais perto do top da tabela da ordem
     * alfabetica e o segundo parametro não for igual ou acima RETORNA 0;
     * 2. Quando o primeiro parametro foi igual ao segundo RETORNA 2
     * 3. Quando o Segundo parametro for mais proxima do top da tabela de ordem
     * alfabetica que o primeiro retorna 1
     */

    System.out.println(resp);
    System.out.println(resp2);
    // System.out.println(resp3);

  }
}
