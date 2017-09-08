
public class Originator {
    private  String article;

    public void set(String newArticle){

        System.out.println("From originator: current version of article\n" + newArticle +"\n");
        article = newArticle;
    }

    //create new memento with new article

    public Memento sotoreInMemento(){
        System.out.println("From originator : Saving to memento");
        return  new Memento(article);
    }

    public String restoreFromMemento(Memento newMenmento){
        article = newMenmento.getArticle();
        System.out.println("From Originator: Previous article saved in memento\n"+ article +"\n");
        return article;

    }

}
