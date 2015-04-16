/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

//import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import databaseproject.getInfo.Constants;
import databaseproject.getInfo.DataCollectorFromDB;
import databaseproject.item.OrderInfoItem;
import databaseproject.item.ProductInfoItem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Fahad_G4
 */
public class ByerView extends javax.swing.JFrame {

    DataCollectorFromDB dDFDb;
    ArrayList<ProductInfoItem> allProductInfoItems;

    public ByerView() {
        initComponents();

        init();

        listener();
    }

    public void listener() {
        orderRunSideByerB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout sb = (CardLayout) (middleBarMainPanel.getLayout());
                sb.show(middleBarMainPanel, "card2");
                System.out.println("1");
                setValueToPendingOrderTable(Constants.runningOrder);
            }
        });
        orderPenSideByerB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout sb = (CardLayout) (middleBarMainPanel.getLayout());
                sb.show(middleBarMainPanel, "card2");
                System.out.println("2");
                setValueToPendingOrderTable(Constants.pendingOrder);
            }
        });
        orderHisSideByerB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout sb = (CardLayout) (middleBarMainPanel.getLayout());
                sb.show(middleBarMainPanel, "card2");
                System.out.println("3");
                setValueToPendingOrderTable(Constants.finishedOrder);

            }
        });
        orderAddSideByerB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout sb = (CardLayout) (middleBarMainPanel.getLayout());
                sb.show(middleBarMainPanel, "card4");
                setValueToComponent();


            }
        });

        addMidByerB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int selection = addProductTypeMidByerCombo.getSelectedIndex();
                ProductInfoItem productInfoItem = allProductInfoItems.get(selection);

                int amount = Integer.parseInt(addProductAmountMidByerEd.getText().toString());
                String estimatedDate = addProductMidByerDate.getDateFormatString();
                String order_detail = addOrderMidByerDetailArea.getText().toString();
                dDFDb.insertOrderData(productInfoItem, amount, estimatedDate, order_detail);


            }
        });

        orderByerTable.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = orderByerTable.rowAtPoint(evt.getPoint());
                int col = orderByerTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println(orderByerTable.getValueAt(row, 0));
                    setValueInDetailField(row);

                }
            }
        });

    }

    public void setValueInDetailField(int row) {
        ArrayList<ProductInfoItem> productInfoItems = dDFDb.getProductInfoByProductIDInfo(Integer.parseInt(orderByerTable.getValueAt(row, 0).toString()));
        try {
            productDetailByerImagePanel.removeAll();
            addImageToJPanel(new File(productInfoItems.get(0).getProduct_image()));
        } catch (IOException ex) {
            Logger.getLogger(ByerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        productNameByerEd.setText(productInfoItems.get(0).getProduct_image());
        productPriceByerEd.setText(String.valueOf(productInfoItems.get(0).getProduct_price()));
        productTypeByerEd.setText(String.valueOf(productInfoItems.get(0).getId_product_type()));
        orderDescByerEd.setText(orderInfoItems.get(row).getOrder_detail());
    }

    private void addImageToJPanel(File file) throws IOException {
        setSize(1200, 700);
        setVisible(true);
        Image image = ImageIO.read(file);
        Image scaledImage = image.getScaledInstance(productDetailByerImagePanel.getWidth(), productDetailByerImagePanel.getHeight(), Image.SCALE_SMOOTH);
        ImagePanel im = new ImagePanel(scaledImage);
        productDetailByerImagePanel.add(im);
        setSize(1200, 600);
        //jPanel1.setSize(700, 700);

    }

    private void setValueToComponent() {
        setValueToAddOrderLayout();
        // setValueToPendingOrderTable(Constants.runningOrder);

    }

    private void init() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setSize(1200, 600);
        dDFDb = new DataCollectorFromDB();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        middleBarMainPanel = new javax.swing.JPanel();
        middleAddOrderPane = new javax.swing.JPanel();
        addMidByerB = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addOrderMidByerDetailArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        addProductTypeMidByerCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        addProductAmountMidByerEd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addProductPriceMidByerEd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addProductMidByerDate = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        middleTablePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderByerTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        productDetailByerImagePanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        productNameByerEd = new javax.swing.JTextField();
        productTypeByerEd = new javax.swing.JTextField();
        productPriceByerEd = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderDescByerEd = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sideBarMainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        orderHisSideByerB = new javax.swing.JButton();
        orderRunSideByerB = new javax.swing.JButton();
        orderPenSideByerB = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        byerListSideByerB = new javax.swing.JButton();
        topBarMainPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        orderAddSideByerB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        middleBarMainPanel.setLayout(new java.awt.CardLayout());

        middleAddOrderPane.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(204, 204, 204)));

        addMidByerB.setText("Submit");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setText("Order Decription");

        addOrderMidByerDetailArea.setColumns(20);
        addOrderMidByerDetailArea.setRows(5);
        jScrollPane2.setViewportView(addOrderMidByerDetailArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Product Name: ");

        jLabel3.setText("Product Amount:");

        jLabel5.setText("Total Price");

        jLabel4.setText("Finishing Estimated Date");

        addProductMidByerDate.setDateFormatString("yyyy-m-dd");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(addProductTypeMidByerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(addProductAmountMidByerEd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(addProductPriceMidByerEd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(addProductMidByerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addProductTypeMidByerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductAmountMidByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductPriceMidByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addProductMidByerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout middleAddOrderPaneLayout = new javax.swing.GroupLayout(middleAddOrderPane);
        middleAddOrderPane.setLayout(middleAddOrderPaneLayout);
        middleAddOrderPaneLayout.setHorizontalGroup(
            middleAddOrderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middleAddOrderPaneLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(middleAddOrderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(middleAddOrderPaneLayout.createSequentialGroup()
                        .addComponent(addMidByerB, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(middleAddOrderPaneLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        middleAddOrderPaneLayout.setVerticalGroup(
            middleAddOrderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middleAddOrderPaneLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(middleAddOrderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(addMidByerB)
                .addGap(54, 54, 54))
        );

        middleBarMainPanel.add(middleAddOrderPane, "card4");

        middleTablePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Order List: ");

        orderByerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Type", "Amount", "Price", "Estimated Date"
            }
        ));
        jScrollPane1.setViewportView(orderByerTable);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout productDetailByerImagePanelLayout = new javax.swing.GroupLayout(productDetailByerImagePanel);
        productDetailByerImagePanel.setLayout(productDetailByerImagePanelLayout);
        productDetailByerImagePanelLayout.setHorizontalGroup(
            productDetailByerImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        productDetailByerImagePanelLayout.setVerticalGroup(
            productDetailByerImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        jLabel8.setText("Product Name");

        jLabel9.setText("Price");

        jLabel10.setText("Priduct Type");

        orderDescByerEd.setColumns(20);
        orderDescByerEd.setRows(5);
        jScrollPane3.setViewportView(orderDescByerEd);

        jLabel11.setText("Description");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productPriceByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productTypeByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productNameByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(productDetailByerImagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(productDetailByerImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(productNameByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(productTypeByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(productPriceByerEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout middleTablePanelLayout = new javax.swing.GroupLayout(middleTablePanel);
        middleTablePanel.setLayout(middleTablePanelLayout);
        middleTablePanelLayout.setHorizontalGroup(
            middleTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middleTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(middleTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        middleTablePanelLayout.setVerticalGroup(
            middleTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(middleTablePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(middleTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(middleTablePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        middleBarMainPanel.add(middleTablePanel, "card2");

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        middleBarMainPanel.add(jPanel2, "card3");

        sideBarMainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        sideBarMainPanel.setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        orderHisSideByerB.setText("Oreder History");

        orderRunSideByerB.setText("Running Order");

        orderPenSideByerB.setText("Pending Order");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setText("Byer");

        byerListSideByerB.setText("Byer List");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderPenSideByerB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderHisSideByerB)
                            .addComponent(orderRunSideByerB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(byerListSideByerB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel6)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addGap(75, 75, 75)
                .addComponent(orderRunSideByerB)
                .addGap(44, 44, 44)
                .addComponent(orderHisSideByerB)
                .addGap(48, 48, 48)
                .addComponent(orderPenSideByerB)
                .addGap(43, 43, 43)
                .addComponent(byerListSideByerB)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        sideBarMainPanel.add(jPanel1, "card5");

        topBarMainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        topBarMainPanel.setLayout(new java.awt.CardLayout());

        orderAddSideByerB.setText("Add Order");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(orderAddSideByerB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(709, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(orderAddSideByerB)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        topBarMainPanel.add(jPanel3, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sideBarMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(middleBarMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topBarMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topBarMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middleBarMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            .addComponent(sideBarMainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception e) {
            System.out.println("An Exception occured: " + e);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ByerView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMidByerB;
    private javax.swing.JTextArea addOrderMidByerDetailArea;
    private javax.swing.JTextField addProductAmountMidByerEd;
    private com.toedter.calendar.JDateChooser addProductMidByerDate;
    private javax.swing.JTextField addProductPriceMidByerEd;
    private javax.swing.JComboBox addProductTypeMidByerCombo;
    private javax.swing.JButton byerListSideByerB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel middleAddOrderPane;
    private javax.swing.JPanel middleBarMainPanel;
    private javax.swing.JPanel middleTablePanel;
    private javax.swing.JButton orderAddSideByerB;
    private javax.swing.JTable orderByerTable;
    private javax.swing.JTextArea orderDescByerEd;
    private javax.swing.JButton orderHisSideByerB;
    private javax.swing.JButton orderPenSideByerB;
    private javax.swing.JButton orderRunSideByerB;
    private javax.swing.JPanel productDetailByerImagePanel;
    private javax.swing.JTextField productNameByerEd;
    private javax.swing.JTextField productPriceByerEd;
    private javax.swing.JTextField productTypeByerEd;
    private javax.swing.JPanel sideBarMainPanel;
    private javax.swing.JPanel topBarMainPanel;
    // End of variables declaration//GEN-END:variables

    private void setValueToAddOrderLayout() {
        allProductInfoItems = dDFDb.getProductInfo();
        System.out.println("product size:" + allProductInfoItems.size());
        addProductTypeMidByerCombo.removeAllItems();
        for (int i = 0; i < allProductInfoItems.size(); i++) {
            addProductTypeMidByerCombo.addItem(allProductInfoItems.get(i).getProduct_name());
        }

        addProductMidByerDate.setDate(new Date());
    }
    DefaultTableModel dt;
    ArrayList<OrderInfoItem> orderInfoItems=null;
    
    private void setValueToPendingOrderTable(int id_order_type) {
        String SubjectTabHeader[] = {"ID", "Product Type", "Amount", "Price", "Estimated Date"};
        Object[][] Viewdata = {};
        dt = new DefaultTableModel(Viewdata, SubjectTabHeader);
        dt.setColumnCount(5);
        dt.setRowCount(15);
//{"id_order_info","id_user","id_order_type","product_amount","order_estimated_date","id_product","order_detail","id_order_status"};
        orderByerTable.setModel(dt);

        orderByerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        orderByerTable.getColumnModel().getColumn(1).setPreferredWidth(200);

        orderByerTable.setRowHeight(25);
        orderByerTable.setShowVerticalLines(true);
        orderByerTable.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 15));

        
        orderInfoItems = dDFDb.getOrderInfo(id_order_type);
        
        //String TSubquery = "SELECT * FROM `tbl_subjects`";
        for (int i = 0; i < orderInfoItems.size(); i++) {
            ArrayList<ProductInfoItem> productInfoItems = dDFDb.getProductInfoByProductIDInfo(orderInfoItems.get(i).getId_product());

            orderByerTable.setValueAt(orderInfoItems.get(i).getId_order_info(), i, 0);
            orderByerTable.setValueAt(productInfoItems.get(0).getProduct_name(), i, 1);
            orderByerTable.setValueAt(orderInfoItems.get(i).getProduct_amount(), i, 2);
            orderByerTable.setValueAt(productInfoItems.get(0).getProduct_price(), i, 3);
            orderByerTable.setValueAt(orderInfoItems.get(i).getOrder_estimated_date(), i, 4);
        }






    }
}
