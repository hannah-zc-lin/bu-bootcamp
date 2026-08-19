import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest {
    private contact contact; 
 
    @BeforeEach
    void setUp() {
        contact = new contact("Ada Lovelace", "+1 617 555 0101");
    } 

    @Test
    void getName_returnsCorrectName() {
        assertEquals("Ada Lovelace", contact.getName());
    } 
    
    @Test
    void getPhone_returnsCorrectPhone() {
        assertEquals("+1 617 555 0101", contact.getPhoneNumber());
    } 
    
    @Test
    void toString_containsBothFields() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
        void toString_containsSeparator() {
            assertTrue(contact.toString().contains("|"));
        }
    @Test
        void toString_containsSameName_differentPhone() {
            contact contact1 = new contact("Ada Lovelace", "+1 617 555 0101");
            contact contact2 = new contact("Ada Lovelace", "+1 212 555 0202");

            assertEquals("+1 617 555 0101", contact1.getPhoneNumber());
            assertEquals("+1 212 555 0202", contact2.getPhoneNumber());
        }
    @Test
        void toString_containsSamePhone_differentName() {
            contact contact1 = new contact("Ada Lovelace", "+1 617 555 0101");
            contact contact2 = new contact("Grace Hopper", "+1 617 555 0101");

            assertEquals("Ada Lovelace", contact1.getName());
            assertEquals("Grace Hopper", contact2.getName());
        }
    @Test
        void toString_containsNoPhone() {
            contact contact = new contact("Ada Lovelace", "");

            assertEquals("Ada Lovelace", contact.getName());
            assertEquals("", contact.getPhoneNumber());
        }
        
} 