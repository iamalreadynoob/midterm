package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements IFrames
{

    protected Buttons()
    {
        mainFrame();
        sendFrame();
        userFrame();
        terminalFrame();
        settingsFrame();
    }

    @Override
    public void mainFrame()
    {
        Screen.goSend.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.goUser.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.goTerminal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }

        });

        Screen.goSettings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility(Frames.MAIN_FRAME, false);
                new Visibility(Frames.SETTINGS_FRAME, true);
                new Visibility(Frames.BACK, true);


            }

        });
    }

    @Override
    public void sendFrame()
    {

    }

    @Override
    public void userFrame()
    {

    }

    @Override
    public void terminalFrame()
    {

    }

    @Override
    public void settingsFrame()
    {

    }

    @Override
    public void back()
    {

    }

}
