package APLab3;

public class Data implements java.io.Serializable
{
    public String userName;
    public String note;
    public int choice;
    
    public Data(String username,String userNote, int ch)
    {
        userName = username ;
        note = userNote;
        choice = ch;
    }
    
    public String getUser()
    {
        return userName;
    }
    
    public String getNotes()
    {
        return note;
    }
    
}

