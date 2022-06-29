class Program
{
  public static void Main()
  {
    //Classes de Ordenação
    quicksortNum quick = new quicksortNum();
    quicksortPala quickPala = new quicksortPala();


    //Classe Generica de Impressao
    CGimprimir<int> imprimirInt = new CGimprimir<int>();
    CGimprimir<String> imprimirString = new CGimprimir<String>();


    //Classe da Função palavrasCRESCENTES
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


    // quick.quicksort(0, vetorNum.Length - 1, vetorNum);

    // imprimirInt.imprimirNum(vetorNum);

    quickPala.quicksort(0, vetor.Length - 1, vetor, pala);

    imprimirString.imprimirNum(vetor);

    System.Console.WriteLine("Meu primeiro programa em C#");
  }
}
