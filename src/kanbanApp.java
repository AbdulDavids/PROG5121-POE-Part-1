import javax.swing.*;

public class kanbanApp {
    public static void main(String[] args) {

        Boolean finished = false;
        Login account = new Login();

        while (!finished) {

            // show a dialog with the options and a message
            String[] options = { "Register", "Login" };
            Integer loginOrRegister = JOptionPane.showOptionDialog(null, "Please choose an option",
                    "User Input",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                    options[0]);

            // registration code
            if (loginOrRegister == 0) {
                String firstName = JOptionPane.showInputDialog(
                        "Please enter your first name");

                String lastName = JOptionPane.showInputDialog(
                        "Please enter your last name");

                String userName = JOptionPane.showInputDialog(
                        "Enter a username that contains an underscore, no spaces and is less than 5 characters long");

                String password = JOptionPane.showInputDialog(
                        "Enter a password that contains:" + System.lineSeparator()
                                + "At least 8 characters."
                                + System.lineSeparator() + "A capital letter"
                                + System.lineSeparator()
                                + "Contains a number." + System.lineSeparator()
                                + "Contains a special character");

                account.setFirstName(firstName);
                account.setLastName(lastName);
                account.setUserName(userName);
                account.setPassword(password);

                JOptionPane.showMessageDialog(null, account.registerUser());

            }

            // login code
            if (loginOrRegister == 1) {
                String loginUserName = JOptionPane.showInputDialog("Please enter your username");

                String loginPassword = JOptionPane.showInputDialog("Please enter your password");

                Boolean loginStatus = account.loginUser(loginUserName, loginPassword);

                JOptionPane.showMessageDialog(null, account.returnLoginStatus(loginStatus), null, 1);

                if (loginStatus) {

                    finished = true;
                }
            }

        }

    }

}
