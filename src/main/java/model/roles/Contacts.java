package model.roles;

/**
 * Contacts
 */
public class Contacts {
    private String email;
    private String name;
    private String phone;
    private String adress;

    public Contacts() {
    }

    public Contacts(String email) {
        this.email = email;
    }

    public Contacts(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Contacts(String email, String name, String phone, String adress) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts = (Contacts) o;

        if (email != null ? !email.equals(contacts.email) : contacts.email != null) return false;
        if (name != null ? !name.equals(contacts.name) : contacts.name != null) return false;
        if (phone != null ? !phone.equals(contacts.phone) : contacts.phone != null) return false;
        return adress != null ? adress.equals(contacts.adress) : contacts.adress == null;

    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
