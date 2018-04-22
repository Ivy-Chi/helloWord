package arg.test;

public class Animal implements Talking{
    private String name;
    private int age;

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
        this.age = age;
    }

    public Animal(String name, int age){
        this.name=name;
        this.age=age;
    }
    public void say(){
        System.out.println("This is Animal");
    }
}
