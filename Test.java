import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame{

    public static void main(String[] args){

        new Test();
    }

    private JButton saveButton, undoButton, redoButton;
    private JTextArea theArticle = new JTextArea(40,60);
    // contain the array list with all the mementos that all the different articles
    Caretaker caretaker = new Caretaker();

    Originator originator = new Originator();
    int saveFiles =0;
    int currentArticle =0;

    public Test(){
        this.setSize(750, 780);
        this.setTitle("Memento");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel( "Article"));
        panel1.add(theArticle);

       ButtonListener saveListen = new ButtonListener();
       ButtonListener undoListen = new ButtonListener();
       ButtonListener redoListen = new ButtonListener();

       saveButton = new JButton("Save");
       saveButton.addActionListener(saveListen);

       undoButton = new JButton("Undo");
       undoButton.addActionListener(undoListen);

       redoButton = new JButton("Redo");
       redoButton.addActionListener(redoListen);

       panel1.add(saveButton);
       panel1.add(undoButton);
       panel1.add(redoButton);

       this.add(panel1);
       this.setVisible(true);

    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == saveButton){

                String textInArea = theArticle.getText();
                originator.set(textInArea);
                caretaker.addMemento(originator.sotoreInMemento());
                saveFiles++;
                currentArticle++;
                System.out.println("Save Files " + saveFiles);
                undoButton.setEnabled(true);
            } else
                if (e.getSource() == undoButton){
                        if(currentArticle >=1){
                            currentArticle--;
                            String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
                            theArticle.setText(textBoxString);
                            redoButton.setEnabled(true);
                        } else{
                            undoButton.setEnabled(false);
                        }
                } else {
                    if (e.getSource() == redoButton){
                        if((saveFiles -1) > currentArticle){
                            currentArticle++;
                            String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
                            theArticle.setText(textBoxString);
                            undoButton.setEnabled(true);

                        } else {
                            redoButton.setEnabled(false);//cant be clicked anymore
                        }
                    }
                }
        }
    }


}
