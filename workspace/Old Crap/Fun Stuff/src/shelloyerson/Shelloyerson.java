package shelloyerson;

public class Shelloyerson {
    // characteristics
    private boolean isMale;
    private int strength, speed, looks, dance, sing, smarts;
    private String name, gender;
    
    public static int shelloyersonCount;
    //constructors:
    public Shelloyerson(){
        if (Math.random() < 0.5){
            isMale = true;
            gender = "male";
        }
        else {
            isMale = false;
        }
        strength = (int) (Math.random() * 10) + 1;
        speed = (int) (Math.random() * 10) + 1;
        looks = (int) (Math.random() * 10) + 1;
        dance = (int) (Math.random() * 10) + 1;
        sing = (int) (Math.random() * 10) + 1;
        smarts = (int) (Math.random() * 10) + 1;
        shelloyersonCount++;
    }
    public Shelloyerson(String newName){
        name = newName;
    }
    
    //accessors
    public boolean isMale() {
        return isMale;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLooks() {
        return looks;
    }

    public int getDance() {
        return dance;
    }

    public int getSing() {
        return sing;
    }

    public int getSmarts() {
        return smarts;
    }
    
    public String getName(){
        return name;
    }
    
    public String getGender(){
        return gender;
    }

    //mutators
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLooks(int looks) {
        this.looks = looks;
    }

    public void setDance(int dance) {
        this.dance = dance;
    }

    public void setSing(int sing) {
        this.sing = sing;
    }

    public void setSmarts(int smarts) {
        this.smarts = smarts;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    //special methods
    public String toString(){
        if (this.isMale())
            return " ____  \n|>._.|>\n ^  ^  \n" + name;
        else return "  ____ \n<|._.<|\n  ^  ^ \n" + name;
    }
    
}

