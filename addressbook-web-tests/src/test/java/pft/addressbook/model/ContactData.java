package pft.addressbook.model;

public class ContactData {
  private  int id  = Integer.MAX_VALUE;
  private  String firstname;
  private  String lastname;
  private String group;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getGroup() {
    return group;
  }
  public int getId() { return id;}

  public ContactData whithId(int id) {
    this.id = id;
    return this;
  }

  public ContactData  whithFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData  whithLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData  whithGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}
