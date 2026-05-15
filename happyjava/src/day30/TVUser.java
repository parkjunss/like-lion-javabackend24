package day30;

public class TVUser{
    public static void main(String[] args) {
//        STV tv = new STV();
        TV tv = TVFactory.createTV("MyTV");
        tv.powerOnOff();
        tv.volumeUp();
        tv.volumeDown();
        tv.channelDown();
        tv.channelUp();
        tv.channelChange(13);
        tv.powerOnOff();
    }
}
