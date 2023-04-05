package exceptions;

import communication.Domains;
import database.Clients;

import javax.swing.*;
import java.util.ArrayList;

public class UserExceptions
{

    private JTextField nameSection, surnameSection, emailSection, exceptionSection;
    private JComboBox<String> priorityList;
    private ArrayList<String> exceptionList;
    private Clients clients;
    private boolean isValid;

    public UserExceptions(JTextField nameSection, JTextField surnameSection, JTextField emailSection, JTextField exceptionSection, JComboBox<String> priorityList, Clients clients)
    {
        this.nameSection = nameSection;
        this.surnameSection = surnameSection;
        this.emailSection = emailSection;
        this.exceptionSection = exceptionSection;
        this.priorityList = priorityList;
        this.clients = clients;

        exceptionList = new ExceptionList().getExceptions();
        isValid = true;

        isName();
        if (isValid) isSurname();
        if (isValid) isEmail();
        if (isValid) isEmailValid();
        if (isValid) isEmailUnique();
        if (isValid) isPriority();
    }

    public boolean isValid() {return isValid;}

    private void isName()
    {
        if (nameSection.getText() == null || nameSection.getText().matches(".*[\\d\\p{Punct}].*"))
        {
            isValid = false;
            exceptionSection.setText(exceptionList.get(0));
        }
    }

    private void isSurname()
    {
        if (surnameSection.getText() == null || surnameSection.getText().matches(".*[\\d\\p{Punct}].*"))
        {
            isValid = false;
            exceptionSection.setText(exceptionList.get(1));
        }
    }

    private void isEmail()
    {
        if (emailSection.getText() == null)
        {
            isValid = false;
            exceptionSection.setText(exceptionList.get(2));
        }
    }

    private void isEmailValid()
    {
        if (!emailSection.getText().matches("edu"))
        {
            isValid = new Domains().isIncluded(emailSection.getText());

            if (!isValid) exceptionSection.setText(exceptionList.get(3));
        }
    }

    private void isEmailUnique()
    {
        for (String mail: clients.getClientEmails())
        {
            if (emailSection.getText().equals(mail))
            {
                isValid = false;
                exceptionSection.setText(exceptionList.get(4));
                break;
            }
        }
    }

    private void isPriority()
    {
        if (priorityList.getSelectedItem() == null)
        {
            isValid = false;
            exceptionSection.setText(exceptionList.get(5));
        }
    }

}
