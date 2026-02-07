import java.util.Scanner;


class StudentMarks{
    private
    int mathsMarks;
    int javaMarks;
    // String name;
    int averageMarks;
    String grade;
    int mathAverage=0;
    int jvAverage=0;

    public StudentMarks() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Maths marks:");
        this.mathsMarks = sc.nextInt();
        System.out.println("Enter Java Marks");
        this.javaMarks = sc.nextInt();
        sc.nextLine();
        // System.out.println("Enter Name");
        // this.name = sc.nextLine();

        this.averageMarks = (mathsMarks+javaMarks)/2;
        if(averageMarks>=90) grade = "A";
        else if(averageMarks>=70 && averageMarks<=89) grade = "B";
        else if(averageMarks<70) grade = "C";

        mathAverage = (mathAverage+mathsMarks)/2;
        jvAverage = (jvAverage+javaMarks)/2;
    }

    void display(){
        System.out.println("Maths marks: "+mathsMarks);
        System.out.println("Java Marks: "+javaMarks);
        // System.out.println("Name: "+name);
        System.out.println("Average Marks: "+averageMarks);
        System.out.println("Grade: "+grade);
        System.out.println("Average Math Marks: "+mathAverage);
        System.out.println("Average Java Marks: "+jvAverage);

    }
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of students: ");
            int nosStud = sc.nextInt();

            StudentMarks[] s = new StudentMarks[nosStud];
            for (int i = 0; i < nosStud; i++) {
                s[i] = new StudentMarks();
                s[i].display();
            }
            sc.close();
        }
}
