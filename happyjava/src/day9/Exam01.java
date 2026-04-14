package day9;

public class Exam01 {
    int id;

    Exam01(int id){
        this.id = id;
    }

    public class InnerClass{
        String name;
        InnerClass(String name){
            this.name = name;
        }
        public void print(){
            System.out.println(id);
            System.out.println(name);
        }
    }


    public static void main(String[] args) {

        Exam01 exam01 = new Exam01(1);
        System.out.println(exam01.id);

        InnerClass inner = exam01.new InnerClass("Tom");
        inner.print();

    }
}


