import java.util.ArrayList;

public class Caretaker {

    ArrayList<Memento> savedArticle = new ArrayList<Memento>();

    public void addMemento(Memento m){ savedArticle.add(m); }

    // getting the object from memento
    public Memento getMemento(int index){
        return savedArticle.get(index);
    }



}
