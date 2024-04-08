public class RolePerson implements Comparable<RolePerson> {
    String role;
    String name;
    public RolePerson(String role, String name) {
        this.role = role;
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public String getName() {
        return name;
    }
    public int compareTo(RolePerson other) {
        return this.role.compareTo(other.role) + this.name.compareTo(other.name);
    }
}
