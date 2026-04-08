package day6;

public class TV {
    private boolean power;
    private int channel;

    public void togglePower() {
        power = !power;
        if(power) {
            System.out.println("전원이 켜졌습니다.");
        } else {
            System.out.println("전원이 꺼졌습니다.");
        }
    }

    public void changeChannel(int channel) {
        if (power && channel > 0) {
            this.channel = channel;
            System.out.printf("채널을 %d번으로 변경했습니다.\n", channel);
        } else if(power && channel < 0) {
            System.out.println("채널 오류");
        } else {
            System.out.println("Please turn on TV");
        }
    }

    public int getChannel() {
        return channel;
    }

    public static void main(String[] args) {
        TV tv = new TV();
        tv.togglePower();
        tv.changeChannel(1);
    }
}
