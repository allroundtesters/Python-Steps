/**
  * @@author: patrick
  */

object Tax{
  def taxFor(amount:Double) ={
    if(amount<0){
      throw new IllegalArgumentException("Amount must be more than zero")
    }

    if(amount<0.01){
      throw new RuntimeException("Amount is too small to be taxed");
    }

    if(amount>10000000){
      throw new Exception("Are you kidding me? It is impossible in our sociality")
    }

    amount*0.08
  }
}