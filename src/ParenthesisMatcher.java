public class ParenthesisMatcher {

    /**
     * Checks whether the given character is a type of parenthesis symbol.
     *
     * @param character the character to check
     * @return true if the character is an opening or closing parenthesis symbol; false otherwise
     */
    private static boolean isParenthesis(String character) {
        if (character.equals("{") || character.equals("}") ||
                character.equals("[") || character.equals("]") ||
                character.equals("(") || character.equals(")")) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the given character is a closing parenthesis symbol.
     *
     * @param character the character to check
     * @return true if the character is a closing parenthesis; false otherwise
     */
    private static boolean isClosingParenthesis(String character) {
        if (character.equals("}") || character.equals("]") ||
                character.equals(")")) {
            return true;
        }
        return false;
    }

    /**
     * Determines whether two parenthesis symbols form a matching pair.
     *
     * @param first the opening parenthesis
     * @param second the closing parenthesis
     * @return true if the two symbols match; false otherwise
     */
    private static boolean areParenthesisMatching(String first, String second) {
        if ((first.equals("{") && second.equals("}")) || (first.equals("[") && second.equals("]")) ||
                (first.equals("(") && second.equals(")"))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyStack<String> syntacticStack = new MyStack<>();
        String sourceCode = "while (data[index] < 10) { data[index] = 10; index++ }}";
        String character;
        boolean isValid = true;
        for (int i = 0; i < sourceCode.length(); i++) {
            character = sourceCode.substring(i,i + 1);
            if (isParenthesis(character)) {
                if (isClosingParenthesis(character)) {
                    if (syntacticStack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    else if (areParenthesisMatching(syntacticStack.peek(), character)) {
                        syntacticStack.pop();
                    }
                    else {
                        isValid = false;
                        break;
                    }
                }
                else {
                    syntacticStack.push(character);
                }
            }
        }
        if (isValid && syntacticStack.isEmpty()) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Incorrect!");
        }
    }
}
