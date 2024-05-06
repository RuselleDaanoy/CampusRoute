/*
 * Still working kasi ang dumi pa asdkfhjaksjhdfjkas
*/

public class ChatbotAlgorithm {

    public static String getResponse(String query) {
        query = query.toLowerCase(); // Convert query to lower case for case-insensitive comparison

        // Check if the query contains certain keywords and return the appropriate response
        if (query.contains("use") && query.contains("kiosk") || query.contains("this")) {
            return "To use the kiosk, please follow the instructions on the screen or ask for assistance.\n\n" +
            "1. Navigate to the Home page.\r\n" + //
            "2. On the right side of your screen, select \"Navigate\".\r\n" + //
            "3. In the navigation screen, choose the desired floor, then click \"Explore\".\r\n" + //
            "4. The screen will display the map of the selected floor.\r\n" + //
            "5. From the map, select the location you wish to go to.\r\n" + //
            "6. The screen will show you the most efficient path from your current location to your destination.\r\n" + //
            "7. After clicking the path button, the screen will generate a QR code. You can take a picture of the QR code and scan it using your mobile phone.";
        } 
        
        else if (query.contains("tuition") || query.contains("pay")) {
            return "The tuition fee can be paid at the Finance Office, located on the second floor";
        }

        else if (query.equals("cog") || query.equals("com") || query.equals("requirements")) {
        return "To obtain the Certificate of Grades, COM, and SOA requirements, please visit the finance department on the second floor.";
        }

        else if (query.contains("scholarship") || query.equals("soa")) {
            return "For the Certificate of Grades, COM, and SOA required for scholarships, kindly proceed to the Scholarship office on the second floor.";
        } 
        
        else if (query.contains("room") || query.contains("find")) {
            // Add more conditions for other scenarios
            return "To find a room, please refer to the map for assistance.";
        } 
        
        else {
            return "I'm sorry, I don't have information on that.";
        }
    }
}
