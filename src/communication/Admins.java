package communication;

import database.Saves;

import javax.swing.*;
import java.util.ArrayList;

public class Admins
{
    public void askPassword(JTextField exceptionSection)
    {
        ArrayList<String> script = new Saves().getScript();

        exceptionSection.setText(script.get(33));
        exceptionSection.setEditable(true);
    }

    public String getPassword(JTextField exceptionSection)
    {
        String password = null;

        Integer loc = null;

        for (int i = 0; i < exceptionSection.getText().length(); i++)
        {
            if (exceptionSection.getText().charAt(i) == ':')
            {
                loc = i+1;
                while (exceptionSection.getText().charAt(loc) == ' ')
                {
                    loc++;
                }

                break;
            }
        }

        while (loc < exceptionSection.getText().length())
        {
            if (password == null) password = Character.toString(exceptionSection.getText().charAt(loc));
            else password += Character.toString(exceptionSection.getText().charAt(loc));

            loc++;
        }

        exceptionSection.setEditable(false);
        exceptionSection.setText(null);

        return password;
    }

}