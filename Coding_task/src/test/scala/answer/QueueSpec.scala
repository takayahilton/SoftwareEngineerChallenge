package answer

import org.scalatest.{FunSuite, Matchers}

class QueueSpec extends FunSuite with Matchers {
  test("Queue.empty") {
    Queue.empty.isEmpty shouldBe true
    Queue.empty.head shouldBe None
  }

  test("enQueue and deQueue") {
    val queue = Queue.empty.enQueue(1).enQueue(2).enQueue(3)
    queue.head shouldBe Some(1)
    queue.deQueue().head shouldBe Some(2)
    queue.deQueue().deQueue().head shouldBe Some(3)
    queue.deQueue().deQueue().deQueue().head shouldBe None
    queue.deQueue().deQueue().deQueue().deQueue().head shouldBe None
  }
}
