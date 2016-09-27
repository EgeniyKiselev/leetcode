package my.ek

import spock.lang.Specification

/**
 * Created by ekiselev on 26.09.2016.
 */
class ValidParenthesesTest extends Specification {
    def "IsValid"() {
        given:
        ValidParentheses sol = new ValidParentheses()
        expect:
        sol.isValid("()")
        sol.isValid("()[]{}")
        !sol.isValid("(]")
        !sol.isValid("([)]")
        !sol.isValid("((")
        !sol.isValid("(()))")
        !sol.isValid("((]]")
    }
}
