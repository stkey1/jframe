/**
 * Data added via textboxes and button on table
 * and datas showed on table dynamically
 * @version 1.2
 * @throws not setted bugs
 * @return sent datas on table so anything is returned
 * @author stkey
 * @since 09/11/2022
 */
package stkey;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableDemo {
    private JTextField textid;
    private JTextField textisim;
    private JTextField textmaas;
    private JButton buttonKaydet;
    private JTable jtable;

    public void baslat() {
        //frame created
        JFrame frame = new JFrame();
        //added jframe parts
        frame.add(textid);
        frame.add(textisim);
        frame.add(textmaas);
        frame.add(buttonKaydet);
        frame.add(jtable);
        //setted size and location of parts here
        textid.setBounds(140, 400, 500, 30);
        textisim.setBounds(140, 430, 500, 30);
        textmaas.setBounds(140, 460, 500, 30);
        buttonKaydet.setBounds(140, 490, 500, 30);
        buttonKaydet.setText("KAYDET");
        jtable.setBounds(140, 0, 500, 60);
        //setted header
        JTableHeader header = jtable.getTableHeader();
        header.setBackground(Color.RED);
        JScrollPane pane = new JScrollPane(jtable);
        //Panel created and setted features
        JPanel panel = new JPanel();
        panel.add(pane);
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setVisible(true);
        DefaultTableModel defaultTableModel = (DefaultTableModel)jtable.getModel();
        //Added columns names
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("ISIM");
        defaultTableModel.addColumn("MAAS");
        //Added button click listener methods
        buttonKaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //Controlled whether texts are blank
                if (textid.getText().equalsIgnoreCase("") || textisim.getText().equalsIgnoreCase("") || textmaas.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurunuz!");
                } else {
                    //new datas added on table in here
                    String data[] = {textid.getText(), textisim.getText(), textmaas.getText()};

                    defaultTableModel.addRow(data);

                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları başarılı şekilde dolduruldu!");
                    //texts are emptied again
                    textid.setText("");
                    textisim.setText("");
                    textmaas.setText("");
                }
            }
        });
    }
}
