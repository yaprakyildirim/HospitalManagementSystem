package front.manager;

import java.awt.event.*;

import Comparator.NameComperator;
import Entity.PatientEntity;
import Factory.DataAccessFactory;
import Service.Impl.PatientServiceImpl;
import front.ComboItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;


public class patientForm extends JPanel {
    public patientForm() {
        initComponents();
    }
    private int patientId = 0;
    private void btnDeleteActionPerformed(ActionEvent e) {
        PatientServiceImpl patientService = new PatientServiceImpl(DataAccessFactory.getRepository("txt", "patients.txt"));
        patientService.deletePatient(patientService.getPatientById(this.patientId));
        clearFields();
        fillTable();
    }

    private void btnSaveActionPerformed(ActionEvent e) {
        PatientServiceImpl patientService = new PatientServiceImpl(DataAccessFactory.getRepository("txt", "patients.txt"));
        PatientEntity patientEntity = null;
        if(this.patientId != 0){
            patientEntity = patientService.getPatientById(this.patientId);
            if(patientEntity == null){
                patientEntity = new PatientEntity();
                this.patientId = 0;
            }
        }else{
            patientEntity = new PatientEntity();
        }
        patientEntity.setName(txName.getText());
        patientEntity.setSurname(txSurname.getText());
        patientEntity.setPhoneNumber(txPhone.getText());
        patientEntity.setPassword(txPassword.getText());
        patientEntity.setEmail(txMail.getText());
        patientEntity.setAddress(txAdress.getText());
        patientEntity.setPayAmount(Integer.parseInt(txAmount.getText()));
        if(cmbStatus.getSelectedIndex() == 0){
            patientEntity.setStatus(true);
        }else{
            patientEntity.setStatus(false);
        }
        if(cmbPaidMethod.getSelectedItem().toString().equals("Cash")){
            patientEntity.setPayMethodCode("PAID_CASH");
        }else{
            patientEntity.setPayMethodCode("PAID_CREDIT_CARD");
        }
        patientService.savePatient(patientEntity);
        fillTable();
        clearFields();
    }

    private void tblCustMouseClicked(MouseEvent e) {
        this.patientId = Integer.parseInt(tblCust.getValueAt(tblCust.getSelectedRow(),0).toString());
        txName.setText(tblCust.getValueAt(tblCust.getSelectedRow(),1).toString());
        txSurname.setText(tblCust.getValueAt(tblCust.getSelectedRow(),2).toString());
        txPhone.setText(tblCust.getValueAt(tblCust.getSelectedRow(),3).toString());
        txPassword.setText(tblCust.getValueAt(tblCust.getSelectedRow(),4).toString());
        if(tblCust.getValueAt(tblCust.getSelectedRow(),5).toString().equals("true")){
            cmbStatus.setSelectedIndex(0);
        }else{
            cmbStatus.setSelectedIndex(1);
        }
        txAdress.setText(tblCust.getValueAt(tblCust.getSelectedRow(),6).toString());
        txMail.setText(tblCust.getValueAt(tblCust.getSelectedRow(),7).toString());
        txAmount.setText(tblCust.getValueAt(tblCust.getSelectedRow(),8).toString());
        if(tblCust.getValueAt(tblCust.getSelectedRow(),9).toString().equals("Cash")){
            cmbPaidMethod.setSelectedIndex(0);
        }else{
            cmbPaidMethod.setSelectedIndex(1);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        tblCust = new JTable();
        txName = new JTextField();
        txSurname = new JTextField();
        txPhone = new JTextField();
        txPassword = new JTextField();
        txMail = new JTextField();
        scrollPane2 = new JScrollPane();
        txAdress = new JTextPane();
        cmbStatus = new JComboBox();
        cmbPaidMethod = new JComboBox();
        txAmount = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        btnSave = new JButton();
        btnDelete = new JButton();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(176, 196, 222));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                    0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                    . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                    red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                                                                                                                                                                                beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== scrollPane1 ========
            {

                //---- tblCust ----
                tblCust.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tblCustMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(tblCust);
            }

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(txAdress);
            }

            //---- label1 ----
            label1.setText("Name");

            //---- label2 ----
            label2.setText("Surname");

            //---- label3 ----
            label3.setText("Phone");

            //---- label4 ----
            label4.setText("Password");

            //---- label5 ----
            label5.setText("Email");

            //---- label6 ----
            label6.setText("Adress");

            //---- btnSave ----
            btnSave.setText("Save");
            btnSave.addActionListener(e -> btnSaveActionPerformed(e));

            //---- btnDelete ----
            btnDelete.setText("Delete");
            btnDelete.addActionListener(e -> btnDeleteActionPerformed(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 839, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                            .addComponent(label1)
                                                            .addComponent(label2)
                                                            .addComponent(label3)
                                                            .addComponent(label4)
                                                            .addComponent(label5)
                                                            .addComponent(label6))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txName)
                                                            .addComponent(txSurname)
                                                            .addComponent(txPhone)
                                                            .addComponent(txPassword)
                                                            .addComponent(txMail)
                                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(panel1Layout.createSequentialGroup()
                                                                    .addComponent(cmbPaidMethod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(txAmount))))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(31, 31, 31)
                                                    .addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                                    .addGap(20, 20, 20))
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(26, 26, 26)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label1))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label2))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label3))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label4))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label5))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label6))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cmbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(cmbPaidMethod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(btnSave)
                                                            .addComponent(btnDelete))))
                                    .addContainerGap(13, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        fillTable();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable tblCust;
    private JTextField txName;
    private JTextField txSurname;
    private JTextField txPhone;
    private JTextField txPassword;
    private JTextField txMail;
    private JScrollPane scrollPane2;
    private JTextPane txAdress;
    private JComboBox cmbStatus;
    private JComboBox cmbPaidMethod;
    private JTextField txAmount;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton btnSave;
    private JButton btnDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void clearFields(){
        txName.setText("");
        txSurname.setText("");
        txPhone.setText("");
        txPassword.setText("");
        txMail.setText("");
        txAdress.setText("");
        txAmount.setText("");
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    private void fillTable(){
        Object columnList[] = {"Id","Name","Surname","phoneNum","password","isActive","address","email","amount","method"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnList);
        PatientServiceImpl patientService = new PatientServiceImpl(DataAccessFactory.getRepository("txt", "patients.txt"));
        ArrayList<PatientEntity> patientEntityArrayList = patientService.getAllPatients();
        Collections.sort(patientEntityArrayList,new NameComperator());
        Iterator itr = patientEntityArrayList.iterator();
        Object rowData[] = new Object[10];
        while(itr.hasNext()){
            PatientEntity patientEntity = (PatientEntity)itr.next();
            rowData[0] = patientEntity.getId();
            rowData[1] = patientEntity.getName();
            rowData[2] = patientEntity.getSurname();
            rowData[3] = patientEntity.getPhoneNumber();
            rowData[4] = patientEntity.getPassword();
            rowData[5] = patientEntity.isStatus();
            rowData[6] = patientEntity.getAddress();
            rowData[7] = patientEntity.getEmail();
            rowData[8] = patientEntity.getPayAmount();
            if(patientEntity.getPayMethodCode().equals("PAID_CASH")){
                rowData[9] = "Cash";
            }else if(patientEntity.getPayMethodCode().equals("PAID_CREDIT_CARD")){
                rowData[9] = "Credit Card";
            }else{
                rowData[9] = "Not paid";
            }
            model.addRow(rowData);
        }
        tblCust.setModel(model);
        cmbStatus.addItem(new ComboItem("Active","1"));
        cmbStatus.addItem(new ComboItem("Passive","0"));
        cmbPaidMethod.addItem(new ComboItem("Cash","PAID_CASH"));
        cmbPaidMethod.addItem(new ComboItem("Credit Card","PAID_CREDIT_CARD"));
    }
}
