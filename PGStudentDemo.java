import java.util.Scanner;

interface Showable{
    void show();
}

class Person implements Showable{
    private String name, gender;
    int phoneno;

    public Person(String name, String gender, int phoneno) {
        this.name = name;
        this.gender = gender;
        this.phoneno = phoneno;
    }

    @Override
    public void show(){
        System.out.println("Name = " + name + "\nGender = " + gender + "\nPhone No = " + phoneno);
    }
}

class Student extends Person{
    String course;
    int score;

    public Student(String name, String gender, int phoneno, String course, int score){
        super(name, gender, phoneno);
        this.course = course;
        this.score = score;
    }

    @Override
    public void show(){
        super.show();
        System.out.println("Course = " + course + "\nScore = " + score);
    }
}

class PGStudent extends Student{
    String researchArea, guide;

    public PGStudent(String name, String gender, int phoneno, String course, int score, String researchArea, String guide){
        super(name, gender, phoneno, course, score);
        this.researchArea = researchArea;
        this.guide = guide;
    }

    @Override
    public void show(){
        super.show();
        System.out.println("ResearchArea = " + researchArea + "\nGuide = " + guide);

    }
}

class PGStudentDemo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PGStudent pg[] = new PGStudent[10];
        
        System.out.print("Enter number of PGStudents : ");
        int n = sc.nextInt();

        System.out.print("Enter Student Details : ");
        for(int i=0; i<n; i++){
            System.out.println("");
        pg.show();
    }
}