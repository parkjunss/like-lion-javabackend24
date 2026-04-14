package day8;

public class FileHandler implements ReadWritable {
    public String readContent(){
        return "파일에서 내용을 읽습니다.";
    }

    public void writeContent(String content){
        System.out.println("파일에 내용을 썼습니다.");
    }

}
