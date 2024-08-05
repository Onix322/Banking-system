package bank;

public enum Roles {

    CUSTOMER("user/customer"),
    EMPLOYEE("user/employee"),
    OPERATOR("operator");

    public String role;

    Roles(String role) {}

    public String getRole(){
        return this.role;
    }
}
