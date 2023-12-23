package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import messages.Message;
import model.Account;
import view.RegisterFormView;

public class RegisterFormController implements ActionListener {

    private RegisterFormView registerFormView;

    public RegisterFormController(RegisterFormView registerFormView) {
        this.registerFormView = registerFormView;
    }

    // Su dung Map de luu tru account
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // String username = registerFormView.jTextField_Username.getText();
    // String password = registerFormView.jTextField_Password.getText();
    // String confirmPassword =
    // registerFormView.jTextField_ConfirmPassword.getText();

    // if (registerFormView.accountList.containsKey(username)) {
    // Message.IS_EXISTED_USERNAME();
    // } else {
    // if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
    // Message.IS_EMPTY_FIELD();
    // } else if (!password.equals(confirmPassword)) {
    // Message.IS_NOT_MATCH_PASSWORD_AND_CONFIRM_PASSWORD();
    // } else {
    // registerFormView.accountList.put(username, password);
    // System.out.println(registerFormView.accountList);
    // }
    // }

    // }

    // Su dung ArrayList<Account> de luu tru account
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = registerFormView.jTextField_Username.getText();
        String password = registerFormView.jTextField_Password.getText();
        String confirmPassword = registerFormView.jTextField_ConfirmPassword.getText();

        if ((isEmpty(username, password, confirmPassword))) {
            Message.IS_EMPTY_FIELD();
        } else if (!isMatchPasswordAndConfirmPassword(password, confirmPassword)) {
            Message.IS_NOT_MATCH_PASSWORD_AND_CONFIRM_PASSWORD();
        } else {
            if (isDuplicateUsername(username)) {
                Message.IS_EXISTED_USERNAME();
            } else {
                registerFormView.accountList.add(new Account(username, password));
                registerFormView.initData();
                Message.IS_REGISTER_SUCCESS();
            }

        }

    }

    private boolean isMatchPasswordAndConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isEmpty(String username, String password, String confirmPassword) {
        return username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty();
    }

    private boolean isDuplicateUsername(String username) {
        for (Account item : registerFormView.accountList) {
            if (item.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
