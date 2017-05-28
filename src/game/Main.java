package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import petricup.lib.GameLoader;
import utils.LocalizationUtil;

/**
 * Main Class
 * @author anhcx
 */
public class Main  extends JFrame implements ActionListener,Runnable{
    
    JComboBox langList;
    /**
     * Constructor
     */
    public Main(){
        super("Agar.io Launcher");
        Box mainBox = Box.createVerticalBox();
        
        JLabel label = new JLabel("Задания");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("Лабараторная №1");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Реализовать ограничения по размеру поля. Размер поля - произвольный");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("Лабараторная №2");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Реализовать препятствия и их случайную расстановку по полю");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Реализовать объект агара и его случайное появление на поле");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("Лабараторная №3");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- У агара должен быть лимит по колличеству объектов на поле.");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("Агар должен появляться спустя определенный промежуток");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("и появляться на части поля, но не под игроком");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Реализовать поглощение агара игроком");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);        
        label = new JLabel("- Реализовать изменения размера игрока и врагов");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);        
        label = new JLabel("- Реализовать счетчик агара и его отображение");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);        
        label = new JLabel("Лабараторная №4");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Реализовать появление новых врагов по мере исчезания старых");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);        
        label = new JLabel("- Реализовать экран поражения в игре и возможность начать новую игру");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);        
        label = new JLabel("Лабараторная №5");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Сделать,чтобы искусственный интеллект плавал группами, которые могли выбирать стратегии ");        
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- либо они костяком охотятся за игроком, либо загоняют его со всех сторон и поглощают");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("Лабараторная №6");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Показывать список возможностей игры и выбранные модификации в начале запуска приложения.");        
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Сделать предельный размер клетки, больше которого нельзя было бы физически набрать");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
        label = new JLabel("- Сделать чтобы вражеские бактерии в зависимости от своих целей могли отталкивать или притягивать агар.");
	label.setFont(new Font("Verdana", Font.PLAIN, 13));
	mainBox.add(label);
       
        String[] langStrings = { "Ru", "En" };

        langList = new JComboBox(langStrings);
        langList.setSelectedIndex(0);
        langList.addActionListener(this);

        
        mainBox.add(langList);
        
        mainBox.add(createButton("Play", true));

        setContentPane(mainBox);
        pack();

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    /**
     * Create panel with button
     * @param text - text of button
     * @param enabled - is button enabled
     */
    private JPanel createButton(String text, boolean enabled) {
        JPanel pane = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        pane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            JButton btn = new JButton(text);
            btn.setPreferredSize(new Dimension(120,25));
            btn.addActionListener(this);
            btn.setEnabled(enabled);
            btn.setFont(new Font("Verdana", Font.BOLD, 12));

        pane.add(btn);
        
        return pane;
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().getClass() == JButton.class) {
            String lang = (String)langList.getSelectedItem();
            LocalizationUtil.setLang(lang);
            new Thread(this).start();
        } 
        
    }
    
    /**
     * Implementation of function run from Runnable
     */
    @Override
    public void run() {
        LocalizationUtil.getLang();
        GameLoader gameLoader = new GameLoader();
        gameLoader.setup(new MultiScreenGame(), new Dimension(1080, 720), false);
        gameLoader.start();
    }
    
    /**
     * Main endpoint of program
     */
    public static void main(String[] args) {
            new Main();
    }   
}
