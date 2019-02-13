package ca.strangebrew

import spock.lang.Specification
import spock.lang.Unroll

import java.math.RoundingMode

class BrewCalcsSpec extends Specification {

    @Unroll
    def 'test ABV calculations'() {
        when:
        double abv = BrewCalcs.calcAlcohol(BrewCalcs.ALC_BY_VOLUME, originalGravity, finalGravity)

        then:
        rounded(abv) == expectedABV

        where:
        originalGravity | finalGravity | expectedABV
        1.065           | 1.012        | 6.978
        1.100           | 1.000        | 13.277
        1.045           | 1.017        | 3.669
        1.000           | 1.000        | 0
        1.065           | 1.066        | -0.132
    }

    @Unroll
    def 'test ABW calculations'() {
        when:
        double abw = BrewCalcs.calcAlcohol(BrewCalcs.ALC_BY_WEIGHT, originalGravity, finalGravity)

        then:
        rounded(abw) == expectedABW

        where:
        originalGravity | finalGravity | expectedABW
        1.065           | 1.012        | 5.475
        1.100           | 1.000        | 10.542
        1.045           | 1.017        | 2.864
        1.000           | 1.000        | 0
        1.065           | 1.066        | -0.099
    }

    double rounded(double precise) {
        BigDecimal.valueOf(precise).setScale(3, RoundingMode.HALF_UP).toDouble()
    }
}
