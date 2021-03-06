package ls20200831_personListHandler;

public class PersonAddress {
    private String address;
    private String type;

    public PersonAddress(String address, String type) {
        this.address = address;
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Address:" + address + '(' + type + ')';
    }
}
