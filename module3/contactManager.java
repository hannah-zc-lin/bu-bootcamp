

import java.util.*;

public class contactManager {

    public static void main(String[] args) { 
    
            HashMap<String, contact> contacts = new HashMap<>(); 
    
            // Step 4: add contacts here 
            contacts.put("Ada Lovelace", new contact("Ada Lovelace", "+1 617 555 0101"));
            contacts.put("Grace Hopper", new contact("Grace Hopper", "+1 617 555 0102"));
            contacts.put("Alan Joseph", new contact("Alan Joseph", "+1 617 555 0103"));
            contacts.put("Hannah Lin", new contact("Hannah Lin", "+1 617 555 0104"));
            contacts.put("Tim Bunyea", new contact("Tim Bunyea", "+1 617 555 0105"));
    
            // Step 5: look up a contact 
            contact foundContact = contacts.get("Ada Lovelace");
            contact notFoundContact = contacts.get("John Doe");

            if (foundContact != null) {
                System.out.println("Found contact: " + foundContact);
            } else {
                System.out.println("Contact not found.");
            }

            if (notFoundContact != null) {
                System.out.println("Found contact: " + notFoundContact);
            } else {
                System.out.println("Contact not found.");
            }
    
            // Step 6: print sorted list 
            ArrayList<contact> sorted = new ArrayList<>(contacts.values());
            sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
            System.out.println("\n\n==== All Contacts ====\n\n");
            for (contact c : sorted) {
                System.out.println(c);
            }
        } 
    
}
