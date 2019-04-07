/**
  * @@author: patrick
  */
class User(val name:String,val age:Int)
trait Repository {
  def save(user: User)
}

trait DatabaseRepository extends Repository { /* ... */ }

trait UserService { self: Repository => // requires Repository
def create(user: User) {
  // ...
  save(user)
}
}

new UserService with DatabaseRepository {
  override def save(user: User): Unit = {
    super.save(user)
  }
}