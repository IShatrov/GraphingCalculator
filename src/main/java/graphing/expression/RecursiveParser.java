package graphing.expression;

public class RecursiveParser {
    public static ExpressionTree parse(String str) throws Exception {
        StringBuilder strNoWhitespaces = new StringBuilder(str.replaceAll(" ", ""));

        ExpressionTree ans = new ExpressionTree(getExpr(strNoWhitespaces));

        if (!strNoWhitespaces.isEmpty()) {
            throw new Exception("Ending string not empty");
        }

        return ans;
    }

    private static ExpressionNode getImmed(StringBuilder str) throws NumberFormatException {
        int i = 0;

        if (str.charAt(i) == '-') {
            i++;
        }

        if (!Character.isDigit(str.charAt(i))) {
            throw new NumberFormatException("Double missing integral part");
        }

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
        }

        if (i < str.length() && str.charAt(i) == '.') {
            i++;

            if (i >= str.length() || !Character.isDigit(str.charAt(i))) {
                throw new NumberFormatException("Double missing fravtional part");
            }

            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                i++;
            }
        }

        ImmedNode ans = new ImmedNode(Double.parseDouble(str.substring(0, i)));

        str.delete(0, i);

        return ans;
    }

    private static ExpressionNode getExpr(StringBuilder str) {
        return null;
    }
}
