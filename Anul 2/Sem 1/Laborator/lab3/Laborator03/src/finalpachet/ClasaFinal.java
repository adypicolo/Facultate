package finalpachet;

public class ClasaFinal {

    //  public final int MY_YD=1;
//}

    //  public final int MY_YD;
//}

    //  public final int MY_YD;
    // public ClasaFinal(){
    //     MY_YD = 1;
    // }

    //  public final int MY_YD;
    // public ClasaFinal(){
    //     MY_YD = 1;
    // }
    //    public ClasaFinal (String nume){
    //        MY_YD = 1;
    //   }

    //  public final int MY_YD=1;
    // public ClasaFinal(){
    //     MY_YD = 1;
    // }

    //  public final int MY_YD;
    //  MY_YD = 1;
//}

    //  public final int MY_YD;
    //{MY_YD=1;}//bloc de initializare de instanta
//}

    //  public final int MY_YD =1;
    //{MY_YD=1;}//bloc de initializare de instanta
//}

    // public  static final int MY_YD;
    // static {MY_YD =1;} //bloc static
    // }

    // public final int MY_YD;
    // static {MY_YD =1;} //bloc static
    // }

    // public  static final int MY_YD =1;
    // static {MY_YD =1;} //bloc static
    // }

    //   public final int MY_YD =1;
    //  }

    public int id;

    public ClasaFinal(int id) {
        this.id = id;
    }

    public final String metodaFinal() {
        return "Metoda final parinte" + id;
    }

    public String metodaNefinal() {
        return "Metoda nefinal parinte" + id;
    }

    public ClasaFinal(){

    }

}