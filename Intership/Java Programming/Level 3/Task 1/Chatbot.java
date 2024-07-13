import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chatbot {
    private Map<String, String> responses;

    public Chatbot() {
        responses = new HashMap<>();
        initializeResponses();
    }

    private void initializeResponses() {
        responses.put("hi", "Hello! How can I help you today?");
        responses.put("hello", "Hi there! What can I do for you?");
        responses.put("how are you", "I'm just a program, so I'm always running smoothly! How about you?");
        responses.put("what is your name", "I'm your friendly chatbot, here to assist you.");
        responses.put("bye", "Goodbye! Have a great day!");
        // Add more predefined responses here
    }

    public String getResponse(String input) {
        input = input.toLowerCase().trim();
        if (responses.containsKey(input)) {
            return responses.get(input);
        } else {
            return "I'm sorry, I don't understand that. Can you rephrase?";
        }
    }

    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        
        System.out.println("Chatbot: Hi! I'm your friendly chatbot. Ask me anything.");
        
        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Chatbot: " + chatbot.getResponse(userInput));
                break;
            }
            
            String response = chatbot.getResponse(userInput);
            System.out.println("Chatbot: " + response);
        }
        
        scanner.close();
    }
}
