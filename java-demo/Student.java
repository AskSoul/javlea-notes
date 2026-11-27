public class Student {
    private String id;
    private String name;
    private int age;
    private double score;

    public Student(){}

    public Student(String id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("INVALIDATE AGE!");
            return;
        }
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return id + "\t名称：" + name + "\t年龄：" + age + "\t分数：" + score;
    }

    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setId("001");
        stu1.setName("伊易");
        stu1.setAge(19);
        stu1.setScore(99.9);
        System.out.println(stu1);

        Student stu2 = new Student(
                "002",
                "尔鸸",
                21,
                81.5
        );
        System.out.println(stu2);
    }
}
