package io.hedwig.scala.notes.oo

/**
  * 1. author: patrick
  * todo: to understand the innerclass usage
  */
class Graph{
  class Node{
    var connectedNodes:List[Graph#Node] =Nil
    def connectTo(node:Graph#Node): Unit ={
      if(!connectedNodes.exists(node.equals)){
        connectedNodes=node::connectedNodes
      }
    }
  }

  var nodes:List[Node]=Nil
  def newNode:Node={
    val res= new Node
    nodes=res:: nodes
    res
  }
}

object GraphHandler extends App{
  val graph1:Graph = new Graph
  val node1: graph1.Node = graph1.newNode
  val node2: graph1.Node = graph1.newNode
  val node3: graph1.Node = graph1.newNode
  node1.connectTo(node2)
  node3.connectTo(node2)
  val graph2: Graph = new Graph
  val node4: graph2.Node = graph2.newNode
  node4.connectTo(node1)
}
