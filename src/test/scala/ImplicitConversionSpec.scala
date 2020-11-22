import model.implicit_conversion.implicitConversion._
import model.{Activity, Competition}
import model.activityNames._
import model.implicit_conversion.implicitConversion
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec


class ImplicitConversionSpec extends AnyWordSpec with Matchers {

  "Implicit Conversions" when{
    "distance conversion" in{
      implicitConversion.DistanceUnit(10.0).KM should be(10.0)
      implicitConversion.DistanceUnit(1000.0).M should be(1.0)
    }
    "duration conversion" in{
      implicitConversion.TimeUnit(1.5).H should be(1.5)
      implicitConversion.TimeUnit(120.0).MIN should be(2.0)
    }
    "implicit duration conversion" in{
      implicitConversion.fromDoubleToDuration(60.0) should be(TimeUnit(60.0))
    }
    "implicit distance conversion" in{
      implicitConversion.fromDoubleToDistance(1.5) should be(DistanceUnit(1.5))
    }

  }

}
