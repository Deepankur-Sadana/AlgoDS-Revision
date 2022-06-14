import java.util.*

class `Valid Parentheses` {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            if (it == '}') {
                if (stack.isEmpty()) return false
                if (stack.peek() != '{') return false
                stack.pop()
            } else if (it == ']') {
                if (stack.isEmpty()) return false
                if (stack.peek() != '[') return false
                stack.pop()
            }else if (it == ')') {
                if (stack.isEmpty()) return false
                if (stack.peek() != '(') return false
                stack.pop()
            } else {
                stack.push(it)
            }
        }

        return stack.isEmpty()
    }
}