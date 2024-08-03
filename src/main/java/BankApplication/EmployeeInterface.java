package BankApplication;

public interface EmployeeInterface extends UserInterface{

    String[] permissionList = new String[]{
            UserInterface.permisionsList[0],
            UserInterface.permisionsList[1],
            UserInterface.permisionsList[9],
    };

    static void implementUI(){

        for (int i = 0; i < permissionList.length; i++) {
            System.out.println(i + ". " + permissionList[i]);
        }
    }

    @Override
    default void pushIn() {
        UserInterface.super.pushIn();
    }

    @Override
    default void pushOut() {
        UserInterface.super.pushOut();
    }

    @Override
    default void exit() {
        UserInterface.super.exit();
    }
}
