package Module3;
public class contact {
    private String name;
    private String phoneNumber;

    public contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + '|' + phoneNumber;
    }
}
