package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Exam01 {

    static void main(String[] args) {

        UserInput userInput = new UserInput();
        MemberDAO memberDAO = new MemberDAO();
        MemberDTO memberDTO = new MemberDTO();

        Scanner sc = new Scanner(System.in);

//        userInput.insertInput(sc, memberDTO);

        try{
            userInput.updateInput(sc, memberDAO);
//            boolean result = memberDAO.insertMember(memberDTO);
//            if (result) {
//                System.out.println("Insert Successful");
//            }
//            MemberDTO memberDTO1 = memberDAO.getMember(1);
//            System.out.println(memberDTO1.getCreated_at().toString());
//            System.out.println(memberDTO1.getName());
//            System.out.println(memberDTO1.getEmail());
//            System.out.println(memberDTO1);

//            List<MemberDTO> memberDTOList = memberDAO.getAllMembers();
//            for(MemberDTO memberDTO1:memberDTOList){
//                System.out.println(memberDTO1);
//            }

//            memberDAO.deleteMember(13);

//            MemberDTO memberDTO1 = new MemberDTO();
//            memberDTO1.setName("testq11");
//            memberDTO1.setEmail("testq11@gamil.com");
//            memberDTO1.setPassword("testq11");
//            memberDTO1.setId(12);
//            memberDAO.updateMember(memberDTO1);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
