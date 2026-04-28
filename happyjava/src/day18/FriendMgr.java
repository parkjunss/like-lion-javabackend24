package day18;

import netscape.javascript.JSObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FriendMgr {
    public class Friend {
        private String name;
        private String phoneNumber;
        private String email;
        public Friend(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Friend{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
    public void AddFriend(Friend friend, PrintWriter writer) {
        StringBuilder sb = new StringBuilder();
        sb.append(friend.name);
        sb.append("\t");
        sb.append(friend.phoneNumber);
        sb.append("\t");
        sb.append(friend.email);
        writer.println(sb);
    }

    public static void main(String[] args) {
        final String outputFile = "output.txt";
        FriendMgr fm = new FriendMgr();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile)))
        {
            for (int i=0; i<2; i++){
                System.out.println("Enter friend name:");
                String name = reader.readLine();
                System.out.println("Enter friend phone number:");
                String phoneNumber = reader.readLine();
                System.out.println("Enter friend email:");
                String email = reader.readLine();

                Friend friend = fm.new Friend(name, phoneNumber, email);
                fm.AddFriend(friend, writer);
            }

        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


}
