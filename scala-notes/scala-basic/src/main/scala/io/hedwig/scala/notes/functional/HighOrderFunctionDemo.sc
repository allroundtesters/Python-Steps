val salaries = Seq(2000, 7000, 4000)
println(salaries)

val doubleSalary = (x: Int) => x * 2
var promotedSalary = salaries.map(doubleSalary)
println(promotedSalary)
promotedSalary = salaries.map(_ * 2)
promotedSalary = salaries.map(item => item * 2)

object SalaryRaise {
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): Unit = {
    salaries.map(promotionFunction)
  }
}

//functions that return functions

def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if (ssl) "https://" else "http://"
  (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
}

val domainName = "www.example.com"
def getURL = urlBuilder(ssl = true, domainName)
val endpoint = "users"
val query = "id=1"
val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String