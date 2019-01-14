
// поместить во фрейм(в центр часть) кнопку со следующими свойствами: если нажать на неё нее первый раз , то фон окрасится в красный цвет ,
//при 2 нажатии - синий, при 3 в -зеленый и при следующем нажатие вернетсся к исходному цвету ю
//при этом изменяе надпись на кнопке оответствующую цвету . в правой части поместить кнопку ,
//которая либо блокирует действия 1 кнопки, либо снова запускает её
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new DrawFrame();
    }
}
class DrawFrame extends JFrame {
    public DrawFrame() {

        JPanel Panel = new JPanel();

        this.setLayout(null);
        Panel.setLayout(null);

        add(Panel);
        Panel.setBounds(10,10,1200,630);


        final boolean[] blocked = {false};

        Color ishod = Panel.getBackground();
        JButton colorButton = new JButton("default");
        colorButton.setBounds(200,200,100,100);
        Panel.add(colorButton);

        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (blocked[0] == false) {
                    String color = colorButton.getText();
                    switch (color) {
                        case "default":
                            Panel.setBackground(Color.red);
                            colorButton.setText("red");
                            break;
                        case "red":
                            Panel.setBackground(Color.blue);
                            colorButton.setText("blue");
                            break;
                        case "blue":
                            Panel.setBackground(Color.green);
                            colorButton.setText("green");
                            break;
                        case "green":
                            Panel.setBackground(ishod);
                            colorButton.setText("default");
                            break;

                    }
                }
            }
        });



        JButton styleButton = new JButton("Блок/Разблок");

        styleButton.setBounds(320,200,100,100);
        Panel.add(styleButton);

        styleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (blocked[0] == false)
                    blocked[0] = true;
                else
                    blocked[0] = false;

            }
        });

        setSize(900,650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
