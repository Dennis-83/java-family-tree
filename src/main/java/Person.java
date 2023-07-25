import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private String middleName;
    private final String lastName;
    private final String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    private Person partner;

    private boolean isDeceased = false;


    public Person(String name, String middleName, String lastName, String sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }


    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPartner(Person partner) {
        this.partner = partner;
    }

    public void addParents(Person mother, Person father) {
        this.mother = mother;
        this.father = father;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addSibling(Person sibling) {
        siblings.add(sibling);
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        for (Person child : children) {
//            for (Person grandChild : child.getChildren() ) {
//                grandChildren.add(grandChild);
//            }
//          Versimpeling van wat hierboven staat
            grandChildren.addAll(child.getChildren());
        }
        return grandChildren;
    }

    public List<Pet> getPetsOfAllGrandChildren() {
        List<Pet> pets = new ArrayList<>();
        List<Person> grandKids = getGrandChildren();
        for (Person grandKid : grandKids) {
            pets.addAll(grandKid.getPets());
        }
        return pets;
    }

    public List<Person> getAllCousins(String sex) {
        List<Person> cousins = new ArrayList<>();
        for (Person sibling : siblings) {
            for (Person cousin : sibling.getChildren()) {
                if (cousin.getSex() == sex) {
                    cousins.add(cousin);
                }
            }
        }
        return cousins;
    }

    public boolean isDeceased() {
        return isDeceased;
    }

    public void setDeceased(boolean deceased) {
        isDeceased = deceased;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", mother=" + mother +
                ", father=" + father +
                ", siblings=" + siblings +
                ", children=" + children +
                ", pets=" + pets +
                ", partner=" + partner +
                '}';
    }
}
