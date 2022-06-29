class PC
{
  public int palavrasCRESCENTES(String um, String dois)
  {
    char[] letraSTR1 = new char[50];
    letraSTR1 = um.ToCharArray();
    int valorSTR1 = 0;
    char[] letraSTR2 = new char[50];
    letraSTR2 = dois.ToCharArray();
    int valorSTR2 = 0;
    int resp = 0;
    Boolean testaro2 = false;
    Boolean testaro1 = false;

    int valormenor = 1000;

    int tam1 = um.Length;
    int tam2 = dois.Length;
    int tamanhofor = 0;

    if (tam1 < tam2)
    {
      tamanhofor = tam1;
    }

    if (tam2 < tam1)
    {
      tamanhofor = tam2;
    }

    if (tam1 == tam2)
    {
      tamanhofor = tam1;
    }

    for (int i = 0; i < tamanhofor; i++)
    {

      if (letraSTR1[i] != ' ' && letraSTR2[i] != ' ')
      {
        valorSTR1 = (int)letraSTR1[i];
        valorSTR2 = (int)letraSTR2[i];
      }

      if (valorSTR1 != valorSTR2)
      {
        if (valorSTR1 > valorSTR2)
        {

          if (valormenor > valorSTR2)
          {
            valormenor = valorSTR2;
            resp = 1;
            i = letraSTR2.Length;
            testaro1 = true;
          }

        }

        if (valorSTR1 < valorSTR2)
        {
          i = tamanhofor;
          resp = 0;
          testaro2 = true;
        }
      }

    }

    if (tam1 == tam2 && testaro2 == false)
    {
      if (resp == 0)
      {
        resp = 2;
      }
    }

    if (testaro1 == false && testaro2 == false)
    {
      if (tam1 < tam2)
      {
        resp = 0;
      }
      if (tam1 > tam2)
      {
        resp = 1;
      }
    }



    return resp;
  }
}