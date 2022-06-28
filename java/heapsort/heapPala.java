package heapsort;

public class heapPala {
  public static int palavrasCRESCENTES(String um, String dois) {// Se as 2 Strings for igual retorna 2;
    // Se a primeira String for mais proxima de A do que a segunda retorna 0;
    // Se a primeira String estiver mais longe de A do que a segunda retorna 1;

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

  public static void swap(String[] vetor, int posi1, int posi2) {

    String tmp;

    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;

  }

  public static String[] heapsort(String[] array) {
    int n = array.length;
    // Alterar o vetor ignorando a posicao zero
    String[] tmp = new String[n + 1];
    for (int i = 0; i < n; i++) {
      tmp[i + 1] = array[i];
    }
    array = tmp;

    // Contrucao do heap
    for (int tamHeap = 2; tamHeap <= n; tamHeap++) {
      construir(tamHeap, array);
    }

    // Ordenacao propriamente dita
    int tamHeap = n;
    while (tamHeap > 1) {
      swap(array, 1, tamHeap--);
      reconstruir(tamHeap, array);
    }

    // Alterar o vetor para voltar a posicao zero
    tmp = array;
    array = new String[n];
    for (int i = 0; i < n; i++) {
      array[i] = tmp[i + 1];
    }

    return array;
  }

  public static void construir(int tamHeap, String[] array) {
    for (int i = tamHeap; i > 1 && (palavrasCRESCENTES(array[i], array[i / 2]) == 1); i /= 2) {
      swap(array, i, i / 2);
    }
  }

  public static void reconstruir(int tamHeap, String[] array) {
    int i = 1;
    while (i <= (tamHeap / 2)) {
      int filho = getMaiorFilho(i, tamHeap, array);
      if ((palavrasCRESCENTES(array[i], array[filho]) == 0)) {
        swap(array, i, filho);
        i = filho;
      } else {
        i = tamHeap;
      }
    }
  }

  public static int getMaiorFilho(int i, int tamHeap, String[] array) {
    int filho;
    if (2 * i == tamHeap || (palavrasCRESCENTES(array[2 * i], array[2 * i + 1]) == 1)) {
      filho = 2 * i;
    } else {
      filho = 2 * i + 1;
    }
    return filho;
  }

  public static void main(String[] args) {
    String[] arrayzinho = new String[] { "cruzeiro", "atletico", "america", "athletico", "avai", "botafogo",
        "bragantino", "ceara", "corinthians", "coritiba", "saopaulo", "santos", "juventude", "palmeiras", "goais",
        "internacional", "fluminense", "fortaleza", "cuiaba", "flamengo", "sport", "tombense", "vila nova", "vasco",
        "novorizontino", "operario", "ponte preta", "sampaio", "londrina", "nautico", "cruzeiro", "gremio", "guarani",
        "ituano", "criciuma", "chapecoense", "csa", "crb", "brusque", "bahia", "atleticogo" };

    arrayzinho = heapsort(arrayzinho);

    for (int i = 0; i < arrayzinho.length; i++) {
      System.out.println(arrayzinho[i]);
    }
  }
}
