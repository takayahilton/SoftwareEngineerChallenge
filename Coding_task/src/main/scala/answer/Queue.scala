package answer

//Coding task's Queue is invariant, but immutable queue should usually be covariant.
class Queue[+A] private (private val in: List[A], private val out: List[A]) {
  def isEmpty: Boolean = in.isEmpty && out.isEmpty
  def enQueue[B >: A](t: B): Queue[B] = new Queue(t :: in, out)
  def deQueue(): Queue[A] = out match {
    case Nil if in.nonEmpty     => new Queue(Nil, in.reverse.tail)
    case Nil                    => Queue.empty
    case _ :: xs                => new Queue(in, xs)
  }
  def head: Option[A] = out match {
    case Nil if in.nonEmpty => in.lastOption
    case out                => out.headOption
  }
}

object Queue {
  def empty[A]: Queue[A] = new Queue(Nil, Nil)
}
