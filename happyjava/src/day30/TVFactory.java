package day30;

public class TVFactory {
    public static TV createTV(String type)
    {
        if("STV".equals(type))
        {
            return new STV();
        } else if("MyTV".equals(type))
        {
            return new MyTV();
        }
        return new MyTV();
    }
}
