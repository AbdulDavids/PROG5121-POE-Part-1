import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JOptionPane;
import org.junit.Test;

public class loginTest {

    @Test
    public void usernameCorrectFormat() {
        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "6T4fce$92";
        String usernameMessage = "";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        if (aLogin.checkUserName()) {

            usernameMessage = "Welcome " + firstName + ", " + lastName + " it is great to see you.";

            JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

        }

        assertEquals(usernameMessage, "Welcome Kyle, Williams it is great to see you.");

    }

    @Test
    public void usernameInCorrectFormat() {
        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyle!!!!!!!";
        String password = "6T4fce$92";
        String usernameMessage = "";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        if (!aLogin.checkUserName()) {

            usernameMessage = aLogin.registerUser();

            JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

        }

        assertEquals(usernameMessage,
                "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");

    }

    @Test
    public void PasswordComplexity() {

        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String usernameMessage = "";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        if (aLogin.checkPasswordComplexity()) {

            usernameMessage = "Password successfully captured";

            JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

        }

        assertEquals(usernameMessage,
                "Password successfully captured");

    }

    @Test
    public void InsufficientPasswordComplexity() {

        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "password";
        String usernameMessage = "";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        if (!aLogin.checkPasswordComplexity()) {

            usernameMessage = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";

            JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

        }

        assertEquals(usernameMessage,
                "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");

    }

    @Test
    public void LoginSuccessful() {

        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "Ch&&sec@ke99!";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        Boolean loginStatus = aLogin.loginUser("kyl_1", "Ch&&sec@ke99!");

        assertTrue(loginStatus);

    }

    @Test
    public void LoginFailed() {

        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "Ch&&sec@ke99!";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        Boolean loginStatus = aLogin.loginUser("incorrectUsername", "password");

        assertFalse(loginStatus);

    }

    @Test
    public void checkUserName() {
        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "6T4fce$92";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        assertTrue(aLogin.checkUserName());

    }

    @Test
    public void FalseCheckUserName() {
        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyle!!!!!!!";
        String password = "6T4fce$92";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        assertFalse(aLogin.checkUserName());

    }

    @Test
    public void checkPasswordComplexity() {
        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "6T4fce$92";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        assertTrue(aLogin.checkPasswordComplexity());

    }

    @Test
    public void falseCheckPasswordComplexity() {
        // testparams
        String firstName = "Kyle";
        String lastName = "Williams";
        String userName = "kyl_1";
        String password = "password";

        Login aLogin = new Login();
        aLogin.setFirstName(firstName);
        aLogin.setLastName(lastName);
        aLogin.setUserName(userName);
        aLogin.setPassword(password);

        assertFalse(aLogin.checkPasswordComplexity());

    }
}
