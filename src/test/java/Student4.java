
class Student4 {
    int id;
    String name;
    int age;
    //creating a parameterized constructor

    Student4(int i, String n) {
        id = i;
        name = n;

    }

    //creating a parameterized constructor
    Student4(int i, String n, int t) {
        id = i;
        name = n;
        age = t;

    }

    //method to display the values
    void display() {
        System.out.println(id + " " + name + " " + age);
    }

    public static void main(String args[]) {
        //creating objects and passing values
        Student4 s1 = new Student4(111, "Karan");
        //Log.info("Test");
        Student4 s2 = new Student4(222, "Aryan", 23);
        //calling method to display the values of object
        s1.display();
        s2.display();
    }
}
