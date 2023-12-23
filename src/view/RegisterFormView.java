package view;

import constants.ColorsHandling;
import constants.Path;
import controller.LoginFormController;
import controller.RegisterFormController;
import model.Account;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RegisterFormView extends JFrame {
    private RegisterFormView registerFormView;

    // public static Map<String, String> accountList = new HashMap<>();
    public static ArrayList<Account> accountList = new ArrayList<>();

    // Components for Login Form
    private JLabel jLabel_Logo = new JLabel("Register", JLabel.CENTER);
    private JLabel jLabel_Username = new JLabel("Username: ");
    private JLabel jLabel_Password = new JLabel("Password: ");
    private JLabel jLabel_ConfirmPassword = new JLabel("Confirm Password: ");
    // Text fields and button
    public static JTextField jTextField_Username = new JTextField(10);
    public static JTextField jTextField_Password = new JTextField(10);
    public static JTextField jTextField_ConfirmPassword = new JTextField(10);
    private JButton jButton_RegisterButton = new JButton("Register");

    // Additional label for other options
    private JButton jButton_OtherOption = new JButton("Already have an account? Sign in here");

    // Fonts and dimensions
    // ! Font nay dat ten chua dung
    Font font_logo = new Font("Dialog", Font.BOLD, 50);
    Font font_text = new Font("Dialog", Font.PLAIN, 18);
    Font font_text_field = new Font("Dialog", Font.PLAIN, 25);
    Font font_button = new Font("Dialog", Font.BOLD, 20);
    // Dimension sizeText = new Dimension(100, 30);
    Dimension sizeInputField = new Dimension(50, 10);
    Dimension sizeButton = new Dimension(300, 50);

    // Borders and styling
    EmptyBorder containerBorder = new EmptyBorder(0, 30, 0, 30);
    EmptyBorder logoBorder = new EmptyBorder(50, 0, 0, 0);
    EmptyBorder jLabelBorder = new EmptyBorder(0, 0, 10, 0);
    EmptyBorder userNameBorder = new EmptyBorder(50, 0, 50, 0);
    EmptyBorder userNameFieldBorder = new EmptyBorder(0, 10, 0, 10);
    EmptyBorder passwordBorder = new EmptyBorder(50, 0, 50, 0);
    EmptyBorder passwordFieldBorder = new EmptyBorder(0, 10, 0, 10);
    EmptyBorder confirmPasswordBorder = new EmptyBorder(50, 0, 50, 0);
    EmptyBorder confirmPasswordFieldBorder = new EmptyBorder(0, 10, 0, 10);
    // EmptyBorder dataZoneBorder = new EmptyBorder(150, 20, 150, 20);
    EmptyBorder buttonBorder = new EmptyBorder(30, 0, 20, 0);
    EmptyBorder otherOptionsBorder = new EmptyBorder(0, 0, 15, 0);
    Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
    URL iconUrl = RegisterFormView.class.getResource("/resources/key.png");
    Image img = Toolkit.getDefaultToolkit().createImage(iconUrl);

    // Panels for organizing components
    private JPanel jPanel_container = new JPanel();
    private JPanel jPanel_TopZone = new JPanel();
    private JPanel jPanel_Username = new JPanel(); // Panel for username components
    private JPanel jPanel_Password = new JPanel(); // Panel for password components
    private JPanel jPanel_ConfirmPassword = new JPanel(); // Panel for confirm password components
    private JPanel jPanel_MiddleZone = new JPanel(); // Middle zone combining username and password
    private JPanel jPanel_Button = new JPanel(); // Panel for login button
    private JPanel jPanel_OtherOptions = new JPanel(); // Panel for other options
    private JPanel jPanel_BottomZone = new JPanel(); // Panel for login button and other options

    public RegisterFormView() {
        setTitle("Register");
        setSize(520, 680);
        setIconImage(img);
        // pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        System.out.println("set up xog ");
        initForm();
    }

    public void initData() {
        writeFile(Path.url);
    }

    private void writeFile(String url) {
        try {
            File file = new File(url);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account item : accountList) {
                bufferedWriter.write(item.getUsername() + " " + item.getPassword());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

            // BufferedWriter BufferedWriter = new BufferedWriter(new FileWriter(url));
            // for (Account item : accountList) {
            // BufferedWriter.write(item.getUsername() + " " + item.getPassword());
            // BufferedWriter.newLine();
            // }
            // BufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Loi write file" + e);
        }
    }

    private void initForm() {

        // Setting up title label
        jLabel_Logo.setFont(font_logo);
        // jLabel_Logo.setPreferredSize(sizeText);
        jLabel_Logo.setForeground(ColorsHandling.TEXT_COLOR);
        jLabel_Logo.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_TopZone.setLayout(new BorderLayout());
        jPanel_TopZone.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_TopZone.setBorder(logoBorder);
        jPanel_TopZone.add(jLabel_Logo, BorderLayout.CENTER);

        // Setting up username components
        jLabel_Username.setFont(font_text);
        jLabel_Username.setBorder(jLabelBorder);
        // jLabel_Username.setPreferredSize(sizeText);
        jLabel_Username.setForeground(ColorsHandling.TEXT_COLOR);
        jLabel_Username.setBackground(ColorsHandling.PRIMARY_COLOR);
        // jTextField_Username.setBorder(border);
        jTextField_Username.setFont(font_text_field);
        jTextField_Username.setBackground(ColorsHandling.SECONDARY_COLOR);
        jTextField_Username.setForeground(ColorsHandling.TEXT_COLOR);
        jPanel_Username.setBorder(userNameBorder);
        jPanel_Username.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_Username.setLayout(new BoxLayout(jPanel_Username, BoxLayout.Y_AXIS));
        jPanel_Username.add(jLabel_Username);
        jPanel_Username.add(jTextField_Username);

        // Setting up password components
        jLabel_Password.setFont(font_text);
        jLabel_Password.setBorder(jLabelBorder);
        // jLabel_Password.setPreferredSize(sizeText);
        jLabel_Password.setForeground(ColorsHandling.TEXT_COLOR);
        jLabel_Password.setBackground(ColorsHandling.PRIMARY_COLOR);
        // jTextField_Password.setBorder(border);
        jTextField_Password.setFont(font_text_field);
        jTextField_Password.setBorder(border);
        jTextField_Password.setBackground(ColorsHandling.SECONDARY_COLOR);
        jTextField_Password.setForeground(ColorsHandling.TEXT_COLOR);
        jPanel_Password.setBorder(passwordBorder);
        jPanel_Password.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_Password.setLayout(new BoxLayout(jPanel_Password, BoxLayout.Y_AXIS));
        jPanel_Password.add(jLabel_Password);
        jPanel_Password.add(jTextField_Password);

        // Setting up confirm password components
        jLabel_ConfirmPassword.setFont(font_text);
        jLabel_ConfirmPassword.setBorder(jLabelBorder);
        // jLabel_ConfirmPassword.setPreferredSize(sizeText);
        jLabel_ConfirmPassword.setForeground(ColorsHandling.TEXT_COLOR);
        jLabel_ConfirmPassword.setBackground(ColorsHandling.PRIMARY_COLOR);
        // jTextField_ConfirmPassword.setBorder(border);
        jTextField_ConfirmPassword.setFont(font_text_field);
        jTextField_ConfirmPassword.setBorder(border);
        jTextField_ConfirmPassword.setBackground(ColorsHandling.SECONDARY_COLOR);
        jTextField_ConfirmPassword.setForeground(ColorsHandling.TEXT_COLOR);
        jPanel_ConfirmPassword.setBorder(confirmPasswordBorder);
        jPanel_ConfirmPassword.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_ConfirmPassword.setLayout(new BoxLayout(jPanel_ConfirmPassword, BoxLayout.Y_AXIS));
        jPanel_ConfirmPassword.add(jLabel_ConfirmPassword);
        jPanel_ConfirmPassword.add(jTextField_ConfirmPassword);
        // Middle zone setup
        jPanel_MiddleZone.setLayout(new BorderLayout());
        // jPanel_MiddleZone.setBorder(dataZoneBorder);
        jPanel_MiddleZone.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_MiddleZone.setLayout(new GridLayout(3, 1));
        jPanel_MiddleZone.add(jPanel_Username);
        jPanel_MiddleZone.add(jPanel_Password);
        jPanel_MiddleZone.add(jPanel_ConfirmPassword);

        // Button zone setup
        jButton_RegisterButton.setPreferredSize(sizeButton);
        jButton_RegisterButton.setFont(font_button);
        jButton_RegisterButton.setForeground(ColorsHandling.PRIMARY_COLOR);
        jButton_RegisterButton.setBackground(ColorsHandling.TEXT_COLOR);
        // jButton_LoginButton.setBorder(border);
        jButton_OtherOption.setBorder(null);
        // jButton_OtherOption.setFocusPainted(false); //tat di trang thai hover
        jButton_OtherOption.setRolloverEnabled(false);
        jButton_OtherOption.setForeground(ColorsHandling.TEXT_COLOR);
        jButton_OtherOption.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_BottomZone.setBackground(ColorsHandling.PRIMARY_COLOR);
        // jPanel_BottomZone.setLayout(new BoxLayout(jPanel_BottomZone,
        // BoxLayout.Y_AXIS));
        jPanel_BottomZone.setLayout(new BorderLayout());
        jPanel_Button.add(jButton_RegisterButton);
        jPanel_Button.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_Button.setBorder(buttonBorder);
        jPanel_OtherOptions.add(jButton_OtherOption);
        jPanel_OtherOptions.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_OtherOptions.setBorder(otherOptionsBorder);
        jPanel_BottomZone.add(jPanel_Button, BorderLayout.NORTH);
        jPanel_BottomZone.add(jPanel_OtherOptions, BorderLayout.SOUTH);

        // Container setup
        jPanel_container.setLayout(new BorderLayout());
        jPanel_container.setBackground(ColorsHandling.PRIMARY_COLOR);
        jPanel_container.setBorder(containerBorder);
        jPanel_container.add(jPanel_TopZone, BorderLayout.NORTH);
        jPanel_container.add(jPanel_MiddleZone, BorderLayout.CENTER);
        jPanel_container.add(jPanel_BottomZone, BorderLayout.SOUTH);

        this.add(jPanel_container);

        // Action
        ActionListener ac = new RegisterFormController(this);

        jButton_RegisterButton.addActionListener(ac);
        jButton_OtherOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFormView();
            }
        });
    }
}
