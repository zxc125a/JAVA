package util;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Administrator
 */
public class ChooseDateDialog extends JDialog implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p;
    JScrollPane jsp;
    JLabel YearLabel, MonthLabel;
    JComboBox MonthComboBox;
    JButton OkButton;
    JTable DateTable;
    JSpinner YearSpinner;
    Calendar calendar;
    CalendarBean calendarBean1;

    int year, month;
    String rili[][];
    String day = "";
    String name[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    String all = "";
    JTextField tf;
    String date;

    public ChooseDateDialog(JTextField tf) {
        p = new JPanel();
        this.tf = tf;
        p.setLayout(null);
        YearLabel = new JLabel("YEAR：");
        YearLabel.setBounds(0, 0, 45, 25);
        MonthLabel = new JLabel("MONTH：");
        MonthLabel.setBounds(120, 0, 55, 25);
        MonthComboBox = new JComboBox();
        YearSpinner = new JSpinner();
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        YearSpinner.setValue(year);
        YearSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //加逻辑代码
            	year =  (Integer) YearSpinner.getValue();
                month = MonthComboBox.getSelectedIndex() + 1;
                calendarBean1.setYear(year);
                calendarBean1.setMonth(month);
                rili = calendarBean1.getCalendar();
                System.out.println(year + "|" + month);
                p.remove(jsp);
                DateTable = new JTable(rili, name); //使用数组rili和name创建table             
                DateTable = new JTable(rili, name);
                DateTable.setColumnSelectionAllowed(true);
                DateTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                DateTable.getTableHeader().setReorderingAllowed(false);
                jsp = new JScrollPane(DateTable);
                p.add(jsp);
                jsp.setBounds(0, 30, 290, 125);
            }
        });
        YearSpinner.setBounds(45, 0, 65, 25);
        for (int i = 1; i < 13; i++) {
            MonthComboBox.addItem(new Integer(i));
        }
        MonthComboBox.setSelectedIndex(calendar.get(Calendar.MONTH));
        MonthComboBox.setBounds(170, 0, 45, 25);
        int year1 = calendar.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH);
        calendarBean1 = new CalendarBean();
        calendarBean1.setYear(year1);
        calendarBean1.setMonth(month1 + 1);
        String rili[][];
        String name[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        rili = calendarBean1.getCalendar();
        DateTable = new JTable(rili, name);
        DateTable.setColumnSelectionAllowed(true);
        DateTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DateTable.getTableHeader().setReorderingAllowed(false);
        jsp = new JScrollPane(DateTable);
        jsp.setBounds(0, 30, 290, 125);
        OkButton = new JButton("确定");
        OkButton.setBounds(220, 0, 60, 25);
        OkButton.addActionListener(this);
        p.add(YearLabel);
        p.add(MonthLabel);
        p.add(MonthComboBox);
        p.add(YearSpinner);
        p.add(OkButton);
        p.add(jsp);
        this.add(p);
        this.setSize(310, 200);
        setResizable(false);
        setLocationRelativeTo(null);
    
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == OkButton) {
        	//Integer year =  (Integer) YearSpinner.getValue();
           // int month = MonthComboBox.getSelectedIndex() + 1;
            int rows[] = DateTable.getSelectedRows();
            int columns[] = DateTable.getSelectedColumns();
            if (rows.length > 1 || columns.length > 1) {
                JOptionPane.showMessageDialog(this, "不能选择多个日期!", "错误", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (int i = 0; i < rows.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        day = (String) DateTable.getValueAt(rows[i], columns[j]);
                    }
                }
            }
            if (Check.isEmpty(day)) {
                JOptionPane.showMessageDialog(this, "您还没选择日期!", "错误", JOptionPane.INFORMATION_MESSAGE);
            } else {
                date = YearSpinner.getValue() + "-" + (MonthComboBox.getSelectedIndex() + 1) + "-" + day;
                day = "";
                getText(tf);
                this.setVisible(false);
            }
        }
        if (e.getSource() == MonthComboBox) {
            Integer year =  (Integer) YearSpinner.getValue();
            int month = MonthComboBox.getSelectedIndex() + 1;
            calendarBean1.setYear(year);
            calendarBean1.setMonth(month);
            rili = calendarBean1.getCalendar();
           // System.out.println(year + "|" + month);
            p.remove(jsp);
            DateTable = new JTable(rili, name); //使用数组rili和name创建table             
            DateTable.setColumnSelectionAllowed(true);
            DateTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            DateTable.getTableHeader().setReorderingAllowed(false);
            jsp = new JScrollPane(DateTable);
            p.add(jsp);
            jsp.setBounds(0, 30, 290, 125);
        }
    }

    public void getText(JTextField tf) {
       // System.out.println(date);
        tf.setText(date);
    }

}