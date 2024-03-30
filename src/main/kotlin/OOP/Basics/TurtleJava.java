package OOP.Basics;

public class TurtleJava {



    private int feetCount = 4;
    private String feetColor = "Brown";
    private int headCount = 1;
    private String headColor = "Brown";
    private String shelterColor = "Brown";
    private int tailCount = 1;
    private String tailColor = "Brown";
    private int age = 1;
    private String name = "Tosbik";
    private String sex = "Female";
    private Boolean isMarried = true;



    //java da constructor ları ayrı ayrı yazıyoruz
    public TurtleJava(){
        // hiç constructer vermezsek bile default olarak bulunuyor.
    }
    public TurtleJava(int mFeetCount){
        feetCount = mFeetCount;
    }

    public TurtleJava(int mFeetCount, String name){
        feetCount = mFeetCount;
        this.name = name; //this.name sınıfın içinde ki değeri, diğer name ise parametre de ki name i belirtir.
    }

    public TurtleJava(String mName){
        name = mName;
    }




    public String makeASound(){
        return "hththht";
    }



    void eatMeal(){

    }

    void walk(){

    }

    void swim(){

    }


    public int getFeetCount() {
        return feetCount;
    }

    public void setFeetCount(int feetCount) {
        this.feetCount = feetCount;
    }

    public String getFeetColor() {
        return feetColor;
    }

    public void setFeetColor(String feetColor) {
        this.feetColor = feetColor;
    }

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public String getHeadColor() {
        return headColor;
    }

    public void setHeadColor(String headColor) {
        this.headColor = headColor;
    }

    public String getShelterColor() {
        return shelterColor;
    }

    public void setShelterColor(String shelterColor) {
        this.shelterColor = shelterColor;
    }

    public int getTailCount() {
        return tailCount;
    }

    public void setTailCount(int tailCount) {
        this.tailCount = tailCount;
    }

    public String getTailColor() {
        return tailColor;
    }

    public void setTailColor(String tailColor) {
        this.tailColor = tailColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }

    public static void main(String[] args) {
        TurtleJava turtleJavaZero = new TurtleJava();
        TurtleJava turtleJavaOne = new TurtleJava(4);
        TurtleJava turtleJavaTwo = new TurtleJava(4, "Murtle");
    }
}
