package day30;

public class MyTV implements TV {
    private boolean power;
    private int volume;
    private int channel;

    public MyTV() {
        this.channel = 15;
        this.power = false;
        this.volume = 30;
    }
    @Override
    public void powerOnOff(){
        power = !power;
        System.out.println("Power is " + power);
    }
    @Override
    public void volumeUp(){
        volume = volume++;
        System.out.println("Volume is " + volume);
    }
    @Override
    public void volumeDown(){
        volume = volume--;
        System.out.println("Volume is " + volume);
    }
    @Override
    public void channelUp(){
        channel = channel++;
        System.out.println("Channel is " + channel);
    }
    @Override
    public void channelDown(){
        channel = channel--;
        System.out.println("Channel is " + channel);
    }
    @Override
    public void channelChange(int target){
        channel = target;
        System.out.println("Channel is " + channel);
    }
}
