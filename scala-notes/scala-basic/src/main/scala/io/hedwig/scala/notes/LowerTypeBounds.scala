/**
  * 1. author: patrick
  */

trait Node[+B] {
  def prepend[U >: B](elem: U): Node[U]
}
case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  def prepend[U >: B](elem: U) = ListNode[U](elem, this)
  def head: B = h
  def tail = t
}

case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](elem: U) = ListNode[U](elem, this)
}

//trait Bird
//case class AfricanSwallow() extends Bird
//case class EuropeanSwallow() extends Bird
//
////todo: understand upper bound and lower bound
//val africanSwallowList= ListNode[AfricanSwallow](AfricanSwallow(), Nil())
//val birdList: Node[Bird] = africanSwallowList
//birdList.prepend(new EuropeanSwallow)