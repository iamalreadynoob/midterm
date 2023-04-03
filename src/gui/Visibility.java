package gui;

public class Visibility implements IFrames
{

    private boolean isVisible;

    protected Visibility(Frames frame, boolean isVisible)
    {
        this.isVisible = isVisible;

        switch (frame)
        {
            case MAIN_FRAME: mainFrame(); break;
            case SEND_FRAME: sendFrame(); break;
            case USER_FRAME: userFrame(); break;
            case TERMINAL_FRAME: terminalFrame(); break;
            case SETTINGS_FRAME: settingsFrame(); break;
            case BACK: back(); break;
        }

    }

    public Visibility()
    {
        isVisible = false;
    }

    protected void hide()
    {
        mainFrame();
        sendFrame();
        userFrame();
        terminalFrame();
        settingsFrame();
        back();
    }

    @Override
    public void mainFrame()
    {
        Screen.appName.setVisible(isVisible);
        Screen.goSend.setVisible(isVisible);
        Screen.goUser.setVisible(isVisible);
        Screen.goTerminal.setVisible(isVisible);
        Screen.goSettings.setVisible(isVisible);
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
        Screen.settingsHeader.setVisible(isVisible);
        Screen.infoRow.setVisible(isVisible);
        Screen.langList.setVisible(isVisible);
        Screen.changeLang.setVisible(isVisible);
        Screen.changeTheme.setVisible(isVisible);
        Screen.resetData.setVisible(isVisible);
    }

    @Override
    public void back()
    {
        Screen.back.setVisible(isVisible);
    }

}
