package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import messages.Message;
import model.Account;
import view.LoginFormView;
import view.RegisterFormView;

public class LoginFormController implements ActionListener {

  private RegisterFormView registerFormView;

  public LoginFormController(RegisterFormView registerFormView) {
    this.registerFormView = registerFormView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String username = LoginFormView.jTextField_Username.getText();
    String password = LoginFormView.jTextField_Password.getText();

    if (isEmpty(username, password)) {
      Message.IS_EMPTY_USERNAME_OR_PASSWORD();
    } else {
      if (!isMatching(username, password)) {
        Message.IS_WRONG_USERNAME_OR_PASSWORD();
      } else {
        Message.IS_LOGIN_SUCCESS();
        Message.IS_WELLCOME(username);
        System.out.println("Login success: " + registerFormView.accountList.toString());
      }
    }
  }

  private boolean isEmpty(String username, String password) {
    return username.isEmpty() || password.isEmpty();
  }

  private boolean isMatching(String username, String password) {
    for (Account item : registerFormView.accountList) {
      if (item.getUsername().equals(username) && item.getPassword().equals(password)) {
        return true;
      }
    }
    return false;
  }
}
