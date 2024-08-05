package bank;

public enum Roles {

    CUSTOMER("User/customer"),
    EMPLOYEE("User/employee"),
    OPERATOR("operator");

    public String role;

    Roles(String role) {}

    public String getRole(){
        return this.role;
    }
}
