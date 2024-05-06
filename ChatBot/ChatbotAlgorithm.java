/*
 * Medyo okay na but still working with the faqs and responses
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class ChatbotAlgorithm {

    // Map to associate sets of keywords with response suppliers
    private static final Map<Set<String>, Supplier<String>> responseMap = new HashMap<>();

    static {
        // Populate the response map with sets of keywords and corresponding response suppliers

        responseMap.put(new HashSet<>(Arrays.asList("hi", "hello")), 
            () -> "Hello! How can I assist you today?");

        responseMap.put(new HashSet<>(Arrays.asList("kiosk", "use", "this")), 
            ChatbotAlgorithm::getKioskUsageInstructions);

        responseMap.put(new HashSet<>(Arrays.asList("tuition", "pay")), 
            () -> "The tuition fee can be paid at the Finance Office, located on the second floor.");

        responseMap.put(new HashSet<>(Arrays.asList("cog", "com", "soa", "requirements")), 
            () -> "To obtain the Certificate of Grades, COM, and SOA requirements, please visit the finance department on the second floor.");

        responseMap.put(new HashSet<>(Arrays.asList("room", "find", "place")), 
            () -> "To find the place, please refer to the map for assistance.");
            
        responseMap.put(new HashSet<>(Arrays.asList("programmer", "code", "program", "own")), 
            ChatbotAlgorithm::getProgrammers);
    }

    // Method to process the query and return a response
    public static String getResponse(String query) {
        query = query.toLowerCase(); // Convert query to lower case for case-insensitive comparison

        for (Map.Entry<Set<String>, Supplier<String>> entry : responseMap.entrySet()) {
            if (entry.getKey().stream().anyMatch(query::contains)) {
                return entry.getValue().get(); // Get the response using the supplier
            }
        }

        // Default response for unrecognized queries
        return "I'm sorry, I don't have information on that. Could you please provide more details or ask about something else?";
    }

    // Method to get kiosk usage instructions
    private static String getKioskUsageInstructions() {
        return "To use the kiosk, please follow the instructions on the screen or ask for assistance:\n\n" +
                "1. Navigate to the Home page.\n" +
                "2. On the right side of your screen, select \"Navigate\".\n" +
                "3. In the navigation screen, choose the desired floor, then click \"Explore\".\n" +
                "4. The screen will display the map of the selected floor.\n" +
                "5. From the map, select the location you wish to go to.\n" +
                "6. The screen will show you the most efficient path from your current location to your destination.\n" +
                "7. After clicking the path button, the screen will generate a QR code. You can take a picture of the QR code and scan it using your mobile phone.";
    }

    private static String getProgrammers() {
        return "This program was developed with the dedication and expertise of our team:\n\n" +
                "Faye Buri, Ruselle Daanoy, Pia Macalanda, and Thoby Ralleta.\n\n" +
                "Together, we strive to deliver excellence in every line of code. <3";
    }
}
