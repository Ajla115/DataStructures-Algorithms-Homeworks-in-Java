package task2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import task1.Stack;

public class Algorithm {

    public static double calculate(String s1) {
        s1 = s1.replaceAll("\\s+",""); // removes all whitespaces from the expression
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < s1.length(); i++) { //for loop will iterate over the whole expression
            char element = s1.charAt(i);        //function charAt(i) will return character at every position and store it into variable element

            if (element == '(') {
                continue;                    //it will just ignore right brace and skip over it
            } else if (element == '+' || element == '-' || element == '*' || element == '/' || element == '%' || element == '^' || element == '√') {
                operatorStack.push(element); //if it comes across an operator, it will push it to an appropriate stack
            } else if (element == ')') {     //if it comes across a left brace, an operation between the last pushed operator and the two last pushed operands will be performed
                char operator = operatorStack.pop();
                double val2 = operandStack.pop();
                double val1;
                if (operator == '√') {       //If the operator is square root, then just ONE latest operand will be popped from the top of the stack.
                    val1 = 0;
                } else {                    //Otherwise, two operands would be popped and used.
                    val1 = operandStack.pop();
                }
                double result = performOperation(operator, val1, val2);   //a method performOperation is called
                operandStack.push(result);                                //its result is pushed on top of the operand stack
            } else {                                                      //this else part is performed, when for loop stumbles across a number

                int j = i;
                //now, i is the index of the first digit of the number that loop comes across, and to check if the number is double-digit or has a decimal point, it will start iterating from that index on
                //however, a new variable will be initialized since we need to save the original value of i as a first number loop came across
                while (j < s1.length() && (Character.isDigit(s1.charAt(j)) || s1.charAt(j) == '.')) {
                    j++;
                }

                /*The while loop will check if j is less than the length of the expression AND if the character at index j is either a digit or a decimal point.
                If both conditions are true, then it increments j by 1 and continues to the next iteration of the loop.
                Loop will stop when it comes across  a character that is not a digit nor a decimal point.*/

                double value = Double.parseDouble(s1.substring(i, j));
                //method substring will return all digits and '.' if it has a decimal point, between  indexes i and j and i is included
                //then, it will typecast that value to a double
                operandStack.push(value);
                i = j - 1;
                //i is the beginning index of a number, while j is the ending index, so the number is placed between those two indexes
                // because outer for loop increments i by 1 at the end of each iteration, we need to set i to j - 1
                // because this way it will skip over the entire just parsed number in the next iteration
            }
        }

        return operandStack.pop();
    }


    private static double performOperation(char operator, double val1, double val2) {    //this method will perform a certain mathematics operation, based on the given operator
        if (operator == '+') {
            return val1 + val2;
        } else if (operator == '-') {
            return val1 - val2;
        } else if (operator == '*') {
            return val1 * val2;
        } else if (operator == '/') {
            return val1 / val2;
        } else if (operator == '%') {
            return val1 % val2;
        } else if (operator == '^') {
            return Math.pow(val1, val2);
        } else if (operator == '√') {
            return Math.sqrt(val2);
        } else {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static ArrayList<Double> calculateFromFile(String filePath) throws FileNotFoundException {
        ArrayList<Double> results = new ArrayList<>();

        ArrayList<String> lines = FileUtils.readFile(filePath);
        for (String line : lines) {
            double result = calculate(line.trim());
            //line.trim() is used to remove any leading and trailing white spaces from the input string line before passing it to the calculate method
            results.add(result);
        }

        return results;
    }
}


