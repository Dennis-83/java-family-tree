import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class PersonTest {


    @Test
    void addParents() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        Person father = new Person("Thomas", "Wayne", 42, "male");
        Person mother = new Person("Martha", "Wayne", 42, "female");
        //When
        batman.addParents(mother, father);
        //Then
        assertThat(batman.getFather().getName()).isEqualTo("Thomas");
        assertThat(batman.getMother().getName()).isEqualTo("Martha");
    }

    @Test
    void addChild() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        //When
        Person son = new Person("Damian", "Wayne", 5, "male");
        batman.addChild(son);
        //Then
        assertThat(batman.getChildren()).contains(son);
    }

    @Test
    void addPet() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        Pet cat = new Pet("Selina", "cat", 9);
        //When
        batman.addPet(cat);
        //Then
        assertThat(batman.getPets()).contains(cat);
        assertThat(batman.getPets().get(0).getName()).isEqualTo("Selina");
    }

    @Test
    void addAPetWithAnOwner() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        Pet cat = new Pet("Selina", "cat", 9);
        //When
        batman.addPetWithOwner(cat, batman);
        //Then
        assertThat(batman.getPets().get(0).getOwner().getName()).isEqualTo("Bruce");
    }


    @Test
    void addSibling() {
        //Given
        Person damian = new Person("Damian", "Wayne", 5, "male");
        Person robin = new Person("Dick", "Grayson", 32, "male");
        //When
        damian.addSibling(robin);
        //Then
        assertThat(damian.getSiblings()).contains(robin);
        assertThat(damian.getSiblings().get(0).getName()).isEqualTo("Dick");
    }

    @Test
    void getGrandChildren() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        Person son = new Person("Damian", "Wayne", 5, "male");
        Person grandkid = new Person("Penelope", "Wayne", 5, "female");
        //When
        batman.addChild(son);
        son.addChild(grandkid);
        //Then
        assertThat(batman.getGrandChildren()).contains(grandkid);
    }

    @Test
    void getPetsOfAllGrandChildren() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        Person son = new Person("Damian", "Wayne", 5, "male");
        Person grandDaughter = new Person("Penelope", "Wayne", 5, "female");
        Person grandSon = new Person("Trevor", "Wayne", 3, "male");
        Pet dog = new Pet("Pongo", "dog", 8);
        Pet lizard = new Pet("Freddy", "lizard", 42);
        //When
        batman.addChild(son);
        son.addChild(grandSon);
        son.addChild(grandDaughter);
        grandSon.addPet(lizard);
        grandDaughter.addPet(dog);
        //Then
        assertThat(batman.getPetsOfAllGrandChildren()).contains(dog);
        assertThat(batman.getPetsOfAllGrandChildren().get(0).getName()).isEqualTo("Freddy");
    }

    @Test
    void getAllCousins() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        Person batbro = new Person("John", "Wayne", 40, "male");
        Person batsis = new Person("Jenny", "Wayne", 35, "female");
        Person cousin1 = new Person("Lisa", "Simpson", 12, "female");
        Person cousin2 = new Person("Bart", "Simpson", 8, "male");
        Person cousin3 = new Person("Maggie", "Simpson", 3, "female");
        //When
        batman.addSibling(batbro);
        batman.addSibling(batsis);
        batbro.addChild(cousin1);
        batsis.addChild(cousin2);
        batsis.addChild(cousin3);
        batman.getAllCousins("female");
        //Then
        assertThat(batman.getAllCousins("female")).doesNotContain(cousin2);
    }

    @Test
    void addPartner() {
        //Given
        Person batman = new Person("Bruce", "Wayne", 22, "male");
        Person wife = new Person("Talia", "al Ghul", 25, "female");
        //When
        batman.addPartner(wife);
        //Then
        assertThat(batman.getPartner().getName()).isEqualTo("Talia");
    }
}
