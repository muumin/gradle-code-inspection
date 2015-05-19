package example

import spock.lang.Specification
import spock.lang.Unroll

class HogeSpec  extends Specification {

    def "setter/getterのテスト"() {
        setup:
        def hoge = new Hoge()

        when:
        hoge.setA("b")
        println "hoge"

        then:
        hoge.getA() == "b"
    }
}
