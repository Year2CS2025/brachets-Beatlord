import java.util.Stack;

public class Balanced {
    public static void main(String[] args) {
        // Test cases from your slides
        String[] compositions = {"({[]})", "({[})", "((()))", "({)}"};
        
        for (String musicalPhrase : compositions) {
            System.out.println("Phrase: " + musicalPhrase + " -> Balanced: " + checkHarmony(musicalPhrase));
        }
    }

    
     //Use a Stack (LIFO) to ensure every opening bracket 
     //is closed by its matching counterpart in the correct order.
    
    public static boolean checkHarmony(String musicalPhrase) {
        Stack<Character> memory = new Stack<>();

        for (int i = 0; i < musicalPhrase.length(); i++) {
            char currentSymbol = musicalPhrase.charAt(i);

            // 1. If we see an 'opening' symbol, we push it to memory
            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                memory.push(currentSymbol);
            } 
            // 2. If it's a 'closing' symbol, we check if it matches the most recent opener
            else if (currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']') {
                
                // Edge case: If we see a closer but the memory is empty, it's not balanced
                if (memory.isEmpty()) {
                    return false;
                }

                char lastOpener = memory.pop();

                // Check for harmony mismatch
                if (currentSymbol == ')' && lastOpener != '(') return false;
                if (currentSymbol == '}' && lastOpener != '{') return false;
                if (currentSymbol == ']' && lastOpener != '[') return false;
            }
        }

        // 3. At the end, the memory must be empty for the phrase to be balanced
        return memory.isEmpty();
    }
}
