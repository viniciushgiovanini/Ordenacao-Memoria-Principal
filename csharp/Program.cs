class Program
{

  public static void mergesortPalavra(String[] vetor)
  {
    PC pala = new PC();
    CGimprimir<String> imprimirString = new CGimprimir<String>();
    mergePala mgP = new mergePala();

    mgP.mergesort(0, vetor.Length - 1, vetor, pala);
    imprimirString.imprimirNum(vetor);

  }

  public static void mergesortNum(int[] vetor)
  {

    mergeNum msN = new mergeNum();
    CGimprimir<int> imprimirInt = new CGimprimir<int>();

    msN.mergesort(0, vetor.Length - 1, vetor);
    imprimirInt.imprimirNum(vetor);
  }

  //----------Métodos de Ordenação do HEAPSORT----------//
  public static void heapsortPalavra(String[] vetor)
  {
    PC pala = new PC();
    CGimprimir<String> imprimirString = new CGimprimir<String>();
    heapsortPala Hpala = new heapsortPala();
    vetor = Hpala.heapsort(vetor, pala);
    imprimirString.imprimirNum(vetor);
  }
  public static void heapsortNumerico(int[] vetor)
  {
    CGimprimir<int> imprimirInt = new CGimprimir<int>();
    heapsortNum heap = new heapsortNum();
    vetor = heap.heapsort(vetor);
    imprimirInt.imprimirNum(vetor);


  }

  //----------Métodos de Ordenação do QUICKSORT----------//
  public static void quicksortPalavra(String[] vetor)
  {
    PC pala = new PC();
    quicksortPala quickPala = new quicksortPala();
    CGimprimir<String> imprimirString = new CGimprimir<String>();
    quickPala.quicksort(0, vetor.Length - 1, vetor, pala);
    imprimirString.imprimirNum(vetor);
  }

  public static void quicksortNum(int[] vetor)
  {
    CGimprimir<int> imprimirInt = new CGimprimir<int>();
    quicksortNum quick = new quicksortNum();
    quick.quicksort(0, vetor.Length - 1, vetor);
    imprimirInt.imprimirNum(vetor);
  }


  public static void Main()
  {
    PC pala = new PC();

    String[] vetor = new String[] { "cruzeiro", "atletico", "america", "athletico", "avai", "botafogo",
        "bragantino", "ceara", "corinthians", "coritiba", "saopaulo", "santos", "juventude", "palmeiras", "goais",
        "internacional", "fluminense", "fortaleza", "cuiaba", "flamengo", "sport", "tombense", "vila nova", "vasco",
        "novorizontino", "operario", "ponte preta", "sampaio", "londrina", "nautico", "cruzeiro", "gremio", "guarani",
        "ituano", "criciuma", "chapecoense", "csa", "crb", "brusque", "bahia", "atleticogo" };

    String a = "Cruzeiro";
    String b = "Internacional";

    System.Console.WriteLine(pala.palavrasCRESCENTES(a, b));

    int[] vetorNum = { 100, 200, 300, 40, 30, 25, 1, 45, 0, 8, 5, 2, 6, 1, 0 };

    //Chamando quicksortNumerico
    //quicksortNum(vetorNum);

    //Chamando quicksortPalavra
    //quicksortPalavra(vetor);

    //Chamando heapsortNumerico
    //heapsortNumerico(vetorNum);

    //Chamando heapsortPalavra
    // heapsortPalavra(vetor);

    //Chamando mergesorteNumerico
    //mergesortNum(vetorNum);

    //Chamando mergesortePalavra
    mergesortPalavra(vetor);

    System.Console.WriteLine("Meu primeiro programa em C#");
  }
}
