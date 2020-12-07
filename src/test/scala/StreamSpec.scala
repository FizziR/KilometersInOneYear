import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, Keep, Sink}
import akka.stream.scaladsl.Source
import akka.stream.testkit.scaladsl.TestSink
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

class StreamSpec extends AnyWordSpec with Matchers{

  implicit val system = ActorSystem("Test-System")

  "Testing the akka stream with the testkit" when{
    "the source is under testing" in{
      val sourceUnderTest = Source(1 to 4).filter(_ % 2 == 0).map(_ * 2)

      sourceUnderTest.runWith(TestSink.probe[Int]).request(2).expectNext(4, 8).expectComplete()
    }
  }

}
