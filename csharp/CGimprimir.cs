class CGimprimir<T>
{
  public void imprimirNum(T[] vetor)
  {

    for (int i = 0; i < vetor.Length; i++)
    {
      System.Console.WriteLine(vetor[i]);
    }

  }
}