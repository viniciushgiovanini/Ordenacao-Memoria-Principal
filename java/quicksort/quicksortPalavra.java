package quicksort;

public class quicksortPalavra {// ESSE QUICKSORT FUNCIONOU ALELUIA SENHOR

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

  public static void quicksort(int esq, int dir, String[] array) {
    int i = esq, j = dir;
    String pivo = array[(dir + esq) / 2];

    while (i <= j) {
      int teste = palavrasCRESCENTES(array[i], pivo);
      int teste2 = palavrasCRESCENTES(array[j], pivo);
      while (teste == 0) {
        i++;
        teste = palavrasCRESCENTES(array[i], pivo);
      }
      while (teste2 == 1) {
        j--;
        teste2 = palavrasCRESCENTES(array[j], pivo);
      }

      if (i <= j) {
        swap(array, i, j);
        i++;
        j--;
      }
    }
    if (esq < j)
      quicksort(esq, j, array);
    if (i < dir)
      quicksort(i, dir, array);
  }

  public static void main(String[] args) {

    // String[] arrayzinho = new String[] { "ata", "baba", "dado", "coxinha",
    // "haburguer", "jose", "espada", "felipe", "cpm", "coxinha", "vinicius",
    // "dado", "saturno", "wilson", "xips", "zebra" };

    String[] arrayzinho = new String[] { "cruzeiro", "atletico", "america", "athletico", "avai", "botafogo",
        "bragantino", "ceara", "corinthians", "coritiba", "saopaulo", "santos", "juventude", "palmeiras", "goais",
        "internacional", "fluminense", "fortaleza", "cuiaba", "flamengo", "sport", "tombense", "vila nova", "vasco",
        "novorizontino", "operario", "ponte preta", "sampaio", "londrina", "nautico", "cruzeiro", "gremio", "guarani",
        "ituano", "criciuma", "chapecoense", "csa", "crb", "brusque", "bahia", "atleticogo" };

    quicksort(0, arrayzinho.length - 1, arrayzinho);

    for (int i = 0; i < arrayzinho.length; i++) {
      System.out.println(arrayzinho[i]);
    }

  }
}
