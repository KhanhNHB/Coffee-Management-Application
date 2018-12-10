/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sample.accounts.AccountsDTO;
import sample.bills.BillsDAO;
import sample.bills.infos.BillInfosDAO;
import sample.foods.FoodsDAO;
import sample.foods.FoodsDTO;
import sample.foods.category.FoodCategoryDAO;
import sample.foods.category.FoodCategoryDTO;
import sample.login.Login;
import sample.menus.MenusDAO;
import sample.menus.MenusDTO;
import sample.statistics.StatisticsDAO;
import sample.tableFoods.TableFoodsDAO;
import sample.tableFoods.TableFoodsDTO;

/**
 *
 * @author hello
 */
public class CoffeeApplicationForUser extends javax.swing.JFrame implements ActionListener {

    private StatisticsDAO daoStatistics;

    private BillInfosDAO daoBillInfos;
    private BillsDAO daoBills;

    private List<FoodCategoryDTO> listFoodCategory;
    private FoodCategoryDAO daoFoodCategory;

    private List<FoodsDTO> listFoods;
    private FoodsDAO daoFoods;

    private DefaultTableModel model;
    private Vector<String> headerInfoBill;
    private Vector dataInfoBill;
    private List<MenusDTO> listInfoTable;
    private MenusDAO daoMenus;

    private String idTable;
    private List<TableFoodsDTO> listTableFoods;
    private TableFoodsDAO daoTableFoods;

    private AccountsDTO dtoAccounts;

    /**
     * Creates new form CoffeApplicationForUser
     */
    public CoffeeApplicationForUser() {
        initComponents();
    }

    public CoffeeApplicationForUser(AccountsDTO dtoAccounts) {
        initComponents();
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.dtoAccounts = dtoAccounts;

        loadWelcome();
        loadTableFood();
        loadCategory();

        String idFoodCategory = this.listFoodCategory.get(0).getId();
        loadFoodListByCategoryById(idFoodCategory);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableWrapperOption = new javax.swing.JTabbedPane();
        pnlWelcome = new javax.swing.JPanel();
        txtWelcome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pnlLoadFirst = new javax.swing.JPanel();
        scrollTableList = new javax.swing.JScrollPane();
        pnlTableList = new javax.swing.JPanel();
        pnlDetailsTable = new javax.swing.JPanel();
        pnlOrders = new javax.swing.JPanel();
        cboCategory = new javax.swing.JComboBox<>();
        cboFood = new javax.swing.JComboBox<>();
        spiFoodCount = new javax.swing.JSpinner();
        btnAddFood = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlDetails = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfoBill = new javax.swing.JTable();
        pnlPay = new javax.swing.JPanel();
        spiDiscount = new javax.swing.JSpinner();
        btnPay = new javax.swing.JButton();
        cboMoveTable = new javax.swing.JComboBox<>();
        txtTotalPrice = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSwapTable = new javax.swing.JButton();
        pnlInfoAccount = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tableWrapperOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableWrapperOptionMouseClicked(evt);
            }
        });

        pnlWelcome.setBackground(new java.awt.Color(255, 255, 255));

        txtWelcome.setEditable(false);
        txtWelcome.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        txtWelcome.setForeground(new java.awt.Color(102, 0, 102));
        txtWelcome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtWelcome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sample/application/images.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlWelcomeLayout = new javax.swing.GroupLayout(pnlWelcome);
        pnlWelcome.setLayout(pnlWelcomeLayout);
        pnlWelcomeLayout.setHorizontalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
            .addComponent(txtWelcome)
        );
        pnlWelcomeLayout.setVerticalGroup(
            pnlWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWelcomeLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );

        tableWrapperOption.addTab("Welcome", pnlWelcome);

        scrollTableList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTableList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollTableList.setAutoscrolls(true);
        scrollTableList.setMaximumSize(new java.awt.Dimension(400, 450));
        scrollTableList.setMinimumSize(new java.awt.Dimension(400, 450));
        scrollTableList.setPreferredSize(new java.awt.Dimension(400, 450));

        pnlTableList.setAutoscrolls(true);
        pnlTableList.setMaximumSize(new java.awt.Dimension(0, 0));
        pnlTableList.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlTableList.setPreferredSize(new java.awt.Dimension(400, 1200));
        pnlTableList.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 9, 9));
        scrollTableList.setViewportView(pnlTableList);

        cboCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCategoryItemStateChanged(evt);
            }
        });

        spiFoodCount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spiFoodCount.setModel(new javax.swing.SpinnerNumberModel(1, -100, 100, 1));
        spiFoodCount.setMaximumSize(new java.awt.Dimension(29, 20));

        btnAddFood.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sample/application/plus.png"))); // NOI18N
        btnAddFood.setText("Thêm đồ");
        btnAddFood.setMaximumSize(new java.awt.Dimension(100, 100));
        btnAddFood.setMinimumSize(new java.awt.Dimension(100, 100));
        btnAddFood.setPreferredSize(new java.awt.Dimension(100, 100));
        btnAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFoodActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Mục:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Danh sách:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Số lượng");

        javax.swing.GroupLayout pnlOrdersLayout = new javax.swing.GroupLayout(pnlOrders);
        pnlOrders.setLayout(pnlOrdersLayout);
        pnlOrdersLayout.setHorizontalGroup(
            pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdersLayout.createSequentialGroup()
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCategory, 0, 165, Short.MAX_VALUE)
                    .addComponent(cboFood, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spiFoodCount, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlOrdersLayout.setVerticalGroup(
            pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrdersLayout.createSequentialGroup()
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboCategory)
                    .addGroup(pnlOrdersLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboFood)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(btnAddFood, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrdersLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spiFoodCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblInfoBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblInfoBill);

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        spiDiscount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        spiDiscount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        spiDiscount.setMaximumSize(new java.awt.Dimension(29, 20));

        btnPay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sample/application/pay-per-click.png"))); // NOI18N
        btnPay.setText("Thanh toán");
        btnPay.setMaximumSize(new java.awt.Dimension(100, 100));
        btnPay.setMinimumSize(new java.awt.Dimension(100, 100));
        btnPay.setPreferredSize(new java.awt.Dimension(100, 100));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        txtTotalPrice.setForeground(new java.awt.Color(255, 0, 0));
        txtTotalPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalPrice.setText("0");
        txtTotalPrice.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("%");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Giảm giá");

        btnSwapTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSwapTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sample/application/cursor.png"))); // NOI18N
        btnSwapTable.setText("Chuyển bàn");
        btnSwapTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPayLayout = new javax.swing.GroupLayout(pnlPay);
        pnlPay.setLayout(pnlPayLayout);
        pnlPayLayout.setHorizontalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPayLayout.createSequentialGroup()
                .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboMoveTable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSwapTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPayLayout.createSequentialGroup()
                        .addComponent(spiDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );
        pnlPayLayout.setVerticalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPayLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPayLayout.createSequentialGroup()
                        .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSwapTable)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMoveTable)
                            .addComponent(spiDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalPrice))))
        );

        javax.swing.GroupLayout pnlDetailsTableLayout = new javax.swing.GroupLayout(pnlDetailsTable);
        pnlDetailsTable.setLayout(pnlDetailsTableLayout);
        pnlDetailsTableLayout.setHorizontalGroup(
            pnlDetailsTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDetailsTableLayout.setVerticalGroup(
            pnlDetailsTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsTableLayout.createSequentialGroup()
                .addComponent(pnlOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlLoadFirstLayout = new javax.swing.GroupLayout(pnlLoadFirst);
        pnlLoadFirst.setLayout(pnlLoadFirstLayout);
        pnlLoadFirstLayout.setHorizontalGroup(
            pnlLoadFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoadFirstLayout.createSequentialGroup()
                .addComponent(scrollTableList, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetailsTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLoadFirstLayout.setVerticalGroup(
            pnlLoadFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTableList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDetailsTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tableWrapperOption.addTab("Bàn ăn", pnlLoadFirst);

        javax.swing.GroupLayout pnlInfoAccountLayout = new javax.swing.GroupLayout(pnlInfoAccount);
        pnlInfoAccount.setLayout(pnlInfoAccountLayout);
        pnlInfoAccountLayout.setHorizontalGroup(
            pnlInfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1156, Short.MAX_VALUE)
        );
        pnlInfoAccountLayout.setVerticalGroup(
            pnlInfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        tableWrapperOption.addTab("Thông tin tài khoản", pnlInfoAccount);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableWrapperOption)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableWrapperOption)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCategoryItemStateChanged
        // TODO add your handling code here:
        int pos = cboCategory.getSelectedIndex();
        String idFoodCategory = this.listFoodCategory.get(pos).getId();
        loadFoodListByCategoryById(idFoodCategory);
    }//GEN-LAST:event_cboCategoryItemStateChanged

    private void btnAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFoodActionPerformed
        daoBills = new BillsDAO();
        daoBillInfos = new BillInfosDAO();
        daoTableFoods = new TableFoodsDAO();
        int idTableFood = Integer.parseInt(this.idTable);
        int idFood = 0;
        int count = (int) spiFoodCount.getValue();
        int discount = (int) spiDiscount.getValue();
        boolean result;
        String foodName = (String) cboFood.getSelectedItem();
        for (FoodsDTO items : listFoods) {
            if (items.getName().equals(foodName)) {
                idFood = items.getId();
                break;
            }
        }
        try {
            daoBills.updateBills(getDate(), null, idTableFood, 0, discount);
            result = daoBillInfos.insertBillInfo(idTableFood, idFood, count);
            if (result) {
                spiFoodCount.setValue(1);
                loadInfoBill(this.idTable);
                if (tblInfoBill.getRowCount() > 0) {
                    daoTableFoods.updateStatusForTableAfterPay(idTableFood, "Có người");
                } else {
                    daoTableFoods.updateStatusForTableAfterPay(idTableFood, "Trống");
                }
                loadTableFood();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CoffeeApplicationForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddFoodActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        daoBillInfos = new BillInfosDAO();
        daoTableFoods = new TableFoodsDAO();
        daoStatistics = new StatisticsDAO();
        int row = tblInfoBill.getRowCount();
        int idTable = Integer.parseInt(this.idTable);
        int discount = (int) spiDiscount.getValue();
        float totalPrice = (float) txtTotalPrice.getValue();
        float finalTotalPrice = totalPrice - (totalPrice / 100) * discount;
        try {
            if (row > 0) {
                int response = JOptionPane.showConfirmDialog(this,
                        "Bạn có muốn thanh toán hóa đơn cho Bàn " + idTable + ".\n Tổng tiền - (Tổng tiền / 100) x Giảm giá = \n=>"
                        + totalPrice + " - (" + totalPrice + " / 100) x " + discount + " = " + finalTotalPrice,
                        "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    try {
                        daoBills = new BillsDAO();
                        boolean result = daoBills.checkOut(getDate(), idTable, discount, finalTotalPrice);
                        if (result) {
                            daoStatistics.insertBillInfoAtStatistic("Bàn " + this.idTable, getDate(), getDate(), discount, finalTotalPrice);
                            result = daoBillInfos.deleteBillInfo(idTable);
                            daoTableFoods.updateStatusForTableAfterPay(idTable, "Trống");
                            if (result) {
                                spiFoodCount.setValue(1);
                                loadInfoBill(this.idTable);
                                loadTableFood();
                            }
                        } else {
                            System.out.println("Check fail.");
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(CoffeeApplicationForAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    spiDiscount.setValue(0);
                    txtTotalPrice.setValue(0);
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn để thanh toán.");
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnSwapTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapTableActionPerformed
        int idTable = cboMoveTable.getSelectedIndex();
        String toTableName = (String) cboMoveTable.getSelectedItem();
        String fromTableName = "Bàn " + this.idTable;
        if (this.idTable == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần chuyển.");
        } else {
            if (fromTableName.equals(toTableName)) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần chuyển.");
            } else {
                int response = JOptionPane.showConfirmDialog(this, "Bạn có muốn chuyển từ " + fromTableName + " qua " + toTableName,
                        "Chuyển bàn", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    daoBillInfos = new BillInfosDAO();
                    daoTableFoods = new TableFoodsDAO();
                    try {
                        String statusTableClick = daoTableFoods.getStatusTable(Integer.parseInt(this.idTable));
                        String statusTableCboMoveTable = daoTableFoods.getStatusTable(idTable + 1);
                        if (statusTableClick.equals("Trống") && statusTableCboMoveTable.equals("Có người")) {
                            daoBillInfos.swapTable(Integer.parseInt(this.idTable), idTable + 1);
                        } else {
                            daoBillInfos.swapTable(idTable + 1, Integer.parseInt(this.idTable));
                        }
                        loadTableFood();
                        loadInfoBill(this.idTable);
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(CoffeeApplicationForAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSwapTableActionPerformed

    private void tableWrapperOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableWrapperOptionMouseClicked
        int pos = tableWrapperOption.getSelectedIndex();
        if (pos == 2) { // info
            this.dispose();
            new InfoAccount(this.dtoAccounts);
        }
    }//GEN-LAST:event_tableWrapperOptionMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        new Login();
    }//GEN-LAST:event_formWindowClosing

    private java.sql.Date getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        java.util.Date currentDate = new Date(sdf.format(d));
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        return date;
    }

    private void loadWelcome() {
        txtWelcome.setText(this.dtoAccounts.getFullname());
    }

    private void loadCategory() {
        try {
            daoFoodCategory = new FoodCategoryDAO();
            listFoodCategory = daoFoodCategory.loadListCategory();
            cboCategory.removeAllItems();
            for (FoodCategoryDTO foodCategoryDTO : listFoodCategory) {
                cboCategory.addItem(foodCategoryDTO.getName());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CoffeeApplicationForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadFoodListByCategoryById(String idFoodCategory) {
        try {
            daoFoods = new FoodsDAO();
            listFoods = daoFoods.loadListFoodByIdFoodCategory(idFoodCategory);
            cboFood.removeAllItems();
            if (listFoods != null) {
                for (FoodsDTO dto : listFoods) {
                    cboFood.addItem(dto.getName());
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CoffeeApplicationForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTableFood() {
        try {
            daoTableFoods = new TableFoodsDAO();
            listTableFoods = daoTableFoods.loadTableList();
            if (listTableFoods != null) {
                pnlTableList.removeAll();
                cboMoveTable.removeAllItems();
                for (TableFoodsDTO listTableFood : listTableFoods) {
                    JButton button = new JButton();
                    button.setPreferredSize(new Dimension(TableFoodsDAO.tableWidth, TableFoodsDAO.tableWidth));
                    button.setText("<html><center><h3>" + listTableFood.getName()
                            + "</h3>" + listTableFood.getStatus() + "</center></html>");
                    switch (listTableFood.getStatus()) {
                        case "Trống":
                            button.setBackground(Color.GREEN);
                            break;
                        default:
                            button.setBackground(Color.RED);
                            break;
                    }
                    pnlTableList.add(button);
                    cboMoveTable.addItem(listTableFood.getName());
                    button.addActionListener(this);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Danh sách bàn không tồn tại.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Coffee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nameButton = ae.getActionCommand();
        this.idTable = nameButton.substring(22, 24);
        loadInfoBill(this.idTable);
    }

    private void loadInfoBill(String idTable) {
        headerInfoBill = new Vector<>();
        dataInfoBill = new Vector();
        daoMenus = new MenusDAO();
        float totalPrice = 0;
        try {
            tblInfoBill.removeAll();
            headerInfoBill.add("Tên sản phẩm");
            headerInfoBill.add("Số lượng");
            headerInfoBill.add("Đơn giá");
            headerInfoBill.add("Thành tiền");
            listInfoTable = daoMenus.loadInfoTable(idTable);
            if (listInfoTable != null) {
                for (MenusDTO menusDTO : listInfoTable) {
                    Vector row = new Vector();
                    row.add(menusDTO.getName());
                    row.add(menusDTO.getQuatity());
                    row.add(menusDTO.getPrice());
                    row.add(menusDTO.getTotalPrice());
                    totalPrice += menusDTO.getTotalPrice();
                    dataInfoBill.add(row);
                }
            }
            model = (DefaultTableModel) tblInfoBill.getModel();
            model.setDataVector(dataInfoBill, headerInfoBill);
            txtTotalPrice.setValue(totalPrice);
            tblInfoBill.updateUI();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CoffeeApplicationForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CoffeeApplicationForUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoffeeApplicationForUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoffeeApplicationForUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoffeeApplicationForUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoffeeApplicationForUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFood;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnSwapTable;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboFood;
    private javax.swing.JComboBox<String> cboMoveTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlDetailsTable;
    private javax.swing.JPanel pnlInfoAccount;
    private javax.swing.JPanel pnlLoadFirst;
    private javax.swing.JPanel pnlOrders;
    private javax.swing.JPanel pnlPay;
    private javax.swing.JPanel pnlTableList;
    private javax.swing.JPanel pnlWelcome;
    private javax.swing.JScrollPane scrollTableList;
    private javax.swing.JSpinner spiDiscount;
    private javax.swing.JSpinner spiFoodCount;
    private javax.swing.JTabbedPane tableWrapperOption;
    private javax.swing.JTable tblInfoBill;
    private javax.swing.JFormattedTextField txtTotalPrice;
    private javax.swing.JTextField txtWelcome;
    // End of variables declaration//GEN-END:variables
}
