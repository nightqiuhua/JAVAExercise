package atguigu.basic.day04

object MatchTest {
  def main(args: Array[String]): Unit = {
    val number = 99;
    number match {
      case 99 => println("number is 99")
      case _  => println("yes ")
    }


  }

}
