package Laptrinhjavapackage;
public abstract class StaffMember {

    protected String name;
    protected String address;
    protected String phone;

    public StaffMember(String name, String address, String phone) {
        this.name    = name;
        this.address = address;
        this.phone   = phone;
    }

    @Override
    public String toString() {
        return "Ten: "       + name
             + "\nDia chi: " + address
             + "\nSDT: "     + phone;
    }

    public abstract double pay();

} 