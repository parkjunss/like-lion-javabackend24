package lion.jdbc;

import java.util.Scanner;

public class UserInput {
    public void insertInput(Scanner sc, MemberDTO memberDTO) {
        System.out.print("Enter username: ");
        memberDTO.setName(sc.nextLine());
        System.out.print("Enter email: ");
        memberDTO.setEmail(sc.nextLine());
        System.out.print("Enter password: ");
        memberDTO.setPassword(sc.nextLine());
    }

    public void updateInput(Scanner sc, MemberDAO memberDAO) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        int foundId = memberDAO.findByName(username);
        if (foundId == -1) {
            System.out.println("Username not found");
        } else {
            MemberDTO memberDTOupdate = memberDAO.getMember(foundId);
            if (memberDTOupdate != null) {
                // 여기서 수정 로직 진행
                System.out.println("Found username: " + username + " id: " + foundId);
                System.out.println("Enter new name: ");
                memberDTOupdate.setName(sc.nextLine());
                System.out.println("Enter new email: ");
                memberDTOupdate.setEmail(sc.nextLine());
                System.out.println("Enter new password: ");
                memberDTOupdate.setPassword(sc.nextLine());
            } else {
                System.out.println("데이터를 불러오는데 실패했습니다.");
            }

            try {
                memberDAO.updateMember(memberDTOupdate);
                System.out.println("Done");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
