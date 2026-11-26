import java.util.*;
import java.io.*;
import java.time.LocalDate;

// Parent abstract class
abstract class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    abstract void showDetails();
}

// Child class: inheritance
class Student extends Person {
    private int rollNo;
    private String course;
    private LocalDate date;

    Student(String name, int rollNo, String course) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        date = LocalDate.now();
    }

    // Getters and setters
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    // Method overriding and polymorphism
    void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course: " + course);
        System.out.println("Date: " + date);
    }
}

// Circle class: constructor, encapsulation, getter and setter
class Circle {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        LinkedList<String> tasks = new LinkedList<>();
        HashSet<String> subjects = new HashSet<>();

        int choice = 0;

        do {
            System.out.println("\n===== STUDENT BUDDY =====");
            System.out.println("1. Add student");
            System.out.println("2. View students");
            System.out.println("3. Digit sum");
            System.out.println("4. Palindrome check");
            System.out.println("5. Anagram check");
            System.out.println("6. Circle area");
            System.out.println("7. Add task");
            System.out.println("8. Add subject");
            System.out.println("9. Save students and exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter roll number: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter course: ");
                        String course = sc.nextLine();

                        students.add(new Student(name, roll, course));
                        System.out.println("Student added!");
                        break;

                    case 2:
                        for (Student s : students) {
                            Person p = s; // polymorphism
                            p.showDetails();
                            System.out.println("----------------");
                        }
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        int num = sc.nextInt();
                        int sum = 0;

                        while (num > 0) {
                            sum = sum + num % 10;
                            num = num / 10;
                        }
                        System.out.println("Digit sum = " + sum);
                        break;

                    case 4:
                        System.out.print("Enter a word: ");
                        String word = sc.nextLine();
                        String reverse = new StringBuilder(word).reverse().toString();

                        if (word.equalsIgnoreCase(reverse))
                            System.out.println("Palindrome");
                        else
                            System.out.println("Not palindrome");
                        break;

                    case 5:
                        System.out.print("Enter first word: ");
                        String a = sc.nextLine().toLowerCase();
                        System.out.print("Enter second word: ");
                        String b = sc.nextLine().toLowerCase();

                        char[] x = a.toCharArray();
                        char[] y = b.toCharArray();
                        Arrays.sort(x);
                        Arrays.sort(y);

                        if (Arrays.equals(x, y))
                            System.out.println("Anagram");
                        else
                            System.out.println("Not anagram");
                        break;

                    case 6:
                        System.out.print("Enter radius: ");
                        double r = sc.nextDouble();
                        Circle c = new Circle(r);
                        System.out.println("Area = " + c.area());
                        break;

                    case 7:
                        System.out.print("Enter task: ");
                        tasks.add(sc.nextLine());
                        System.out.println("Task added!");
                        System.out.println("Tasks: " + tasks);
                        break;

                    case 8:
                        System.out.print("Enter subject: ");
                        subjects.add(sc.nextLine());
                        System.out.println("Subjects: " + subjects);
                        break;

                    case 9:
                        FileWriter fw = new FileWriter("students.txt");
                        for (Student s : students) {
                            fw.write(s.getRollNo() + " - " + s.name + "\n");
                        }
                        fw.close();
                        System.out.println("Student records saved. Bye!");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter the correct input type.");
                sc.nextLine();
            } catch (IOException e) {
                System.out.println("File error.");
            }

        } while (choice != 9);

        sc.close();
    }
}
