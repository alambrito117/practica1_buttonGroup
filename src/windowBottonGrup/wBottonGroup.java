package windowBottonGrup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class wBottonGroup extends JFrame implements ActionListener {

    private final static String ACEPTAR = "Aceptar";
    private final static String CANCELAR = "Cancelar";

    public wBottonGroup(String titulo) {
        
       //Creamos los radio buttons
        JRadioButton birdButton = new JRadioButton("Pajarito");
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand("bird");
        birdButton.setSelected(true);

        JRadioButton catButton = new JRadioButton("Gatito");
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand("cat");

        JRadioButton dogButton = new JRadioButton("Perrito");
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand("dog");

        JRadioButton rabbitButton = new JRadioButton("Conejito");
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand("rabbit");

        JRadioButton pigButton = new JRadioButton("Cerdito");
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand("pig");
//creanos el que el buttonGrpup esto es para agrupar los botones
        ButtonGroup btgAnimalitos = new ButtonGroup();

        btgAnimalitos.add(birdButton);
        btgAnimalitos.add(catButton);
        btgAnimalitos.add(dogButton);
        btgAnimalitos.add(rabbitButton);
        btgAnimalitos.add(pigButton);
 //reservamos para los radio panel
        JPanel radioPanel = new JPanel();
        //le indicamos al GridLayou cuantas filas y columnas vamos a querer para el radio panel.
        radioPanel.setLayout(new GridLayout(0,1));
        //agregamos cada unos de los botones ya creados anteriormente al panel
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);
        radioPanel.setBackground(Color.RED);
         // agregamos la img del lorito!
        JLabel picture = new JLabel(new ImageIcon("src/loro.png"));

        JPanel SubPanel1 = new JPanel();
        SubPanel1.setLayout(new GridLayout(1,2));
        SubPanel1.add(radioPanel);
        SubPanel1.add(picture);
        SubPanel1.setBackground(Color.BLUE);
         //creamos los botones salir y aceptar y estos tendrán cierto comportamiento.
        JButton Aceptar = new JButton("ACEPTAR");
        JButton Salir = new JButton("SALIR");
        Aceptar.setActionCommand(ACEPTAR);
        Salir.setActionCommand(CANCELAR);
        Aceptar.addActionListener(this);
        Salir.addActionListener(this);

        JPanel SubPanel2 = new JPanel();
        SubPanel2.setLayout(null);
        //aplicamos ancho, alto, x ,y a los botones
        Aceptar.setBounds(15, 30, 100, 30);
        Salir.setBounds(215, 30, 100, 30);
        //los añadimos al panel 2 para que se puedan acomodar en la parte inferior
        SubPanel2.add(Aceptar);
        SubPanel2.add(Salir);

        GridLayout distGrid = new GridLayout(2,1);
        getContentPane().setLayout(distGrid);
        getContentPane().add(SubPanel1);
        getContentPane().add(SubPanel2);

        pack();

        setTitle(titulo);
    }
    //ponemos el metodo actionPerformed para que nos detecte si el boton fue presionado.
    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento producido por " + e.getActionCommand());
        String comando = e.getActionCommand();
        if(comando.equals(ACEPTAR)) {
            System.out.println("ha precionado el botón aceptar");
        }
        else if(comando.equals(CANCELAR)) {
            System.exit(0);
            System.out.println("Ha precionado el botón salir");
        }
    }

    public static void main (String[] args) {
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        JFrame frame = new wBottonGroup("Agrupar Botones");
        frame.addWindowListener(l);

        frame.pack();
        frame.setVisible(true);
    }
}
