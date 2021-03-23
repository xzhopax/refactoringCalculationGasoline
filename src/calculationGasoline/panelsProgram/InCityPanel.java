package calculationGasoline.panelsProgram;

import calculationGasoline.cars.ActionCar;
import calculationGasoline.cars.Car;
import calculationGasoline.cars.OnBoardComputerCar;
import calculationGasoline.cars.VolkswagenPolo;
import calculationGasoline.stationGas.StationGAS;
import calculationGasoline.workData.Check;
import calculationGasoline.workData.CheckingEnteredData;
import calculationGasoline.workData.DataCounting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Aleksey Ilin
 * <p>
 * class InCityPanel - this is a panel for calculating the cost of gas and money when driving around the city
 */

public class InCityPanel extends JFrame {

    private JPanel panel;
    private JLabel namePanel;
    private JLabel inDate;
    private JLabel inTraffic;
    private JLabel inDistance;
    private JLabel isConditioner;
    private JLabel isDynamicDriving;
    private JLabel inPrice;
    private JLabel authorProgram;
    private JLabel inDateQuestion;
    private JLabel distanceQuestion;
    private JLabel trafficQuestion;
    private JLabel priceQuestion;
    private JLabel errorDate;
    private JLabel errorDistance;
    private JLabel errorTraffic;
    private JLabel errorPrice;
    private JLabel errorButton;
    private JTextField textDate;
    private JTextField textTraffic;
    private JTextField textPrice;
    private JTextField textDistance;
    private JRadioButton conditionerON;
    private JRadioButton conditionerOFF;
    private JRadioButton dynamicDrivingON;
    private JRadioButton dynamicDrivingOFF;
    private JButton start;
    private JButton returnMenu;
    private JTextField textMidGasoline;
    private JLabel inMidGasoline;
    private JLabel midGasolineQuestion;
    private JLabel errorMidGasoline;
    private JRadioButton beMidGasoline;
    private JRadioButton beTraffic;

    Car car = new VolkswagenPolo();
    StationGAS stationGAS = new StationGAS();
    OnBoardComputerCar onBoardComputerCar = new OnBoardComputerCar(car,stationGAS);
    Check check = new CheckingEnteredData();
    DataCounting dataCounting = new DataCounting();






    /**
     * 1.The constructor creates a panel with the specified parameters;
     * 2. allows you to stretch it;
     * 3. sets the name of the panel;
     * 4. makes it visible;
     * 5. adds a panel to a container;
     * <p>
     * 6. sets the action when you click on the cross;
     * <p>
     * 7. through a getter sets the action for the date input field;
     * 8. through a getter sets the action for the distance input field;
     * 9. through the getter sets the action for the traffic input field;
     * 10. through a getter sets the action for the price entry field;
     * <p>
     * 11. combines buttons for turning on and off the air conditioner into a group;
     * 12. setting the values of buttons for the air conditioner from the car class;
     * 13. groups the buttons for the use or absence of dynamic driving;
     * 14. setting button values for dynamic driving from the car class;
     * <p>
     * 15. sets the action when pressing the button for counting the entered values;
     * 16. sets the action when you press the button to return to the main menu.
     */

    protected InCityPanel() {
        this.setBounds(400, 200, 600, 400);// initial window size
        this.setResizable(true); // you can make the window wider
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("расчет затрат бензина в городе");//window title
        setVisible(true);// show panel
        add(getPanel());


        //I catch the program cross to confirm the exit
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                int result = JOptionPane
                        .showConfirmDialog(null,
                                "Закрыть программу?", "Выход из программы",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }// end windowClosing
        });//end anonymous class WindowAdapter (X)

        //when the textDate field loses focus, it checks if the date is correct,
        // if not, it erases the value and asks to re-enter
        getTextDate().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                check.isDateValidInString (getTextDate().getText());
                if (getDate().equals("")) {
                    getErrorDate().setForeground(Color.RED);
                    getErrorDate().setText("Неправильно введена дата");
                    getTextDate().setText("");
                } else {
                    getErrorDate().setText("");
                }

            }// end focusLost
        });//end of field textDate

        //when the textDistance field loses focus, it checks if the distance is correct,
        // if not, it erases the value and asks to re-enter
        getTextDistance().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                // if the string number is double or an integer, then we write it to the variable distance
                if (getTextDistance().getText().matches("(\\d+(\\.?\\d+))")
                        || getTextDistance().getText().matches("\\d+")) {
                    car.setDistance(check.validDoubleInString(getTextDistance().getText()));
                    getErrorDistance().setText("");

                } else {
                    getErrorDistance().setForeground(Color.RED);
                    getErrorDistance().setText("Неправильно введена дистанция");
                    getTextDistance().setText("");
                }
            }// end focusLost
        });//end of field textDistance

        ButtonGroup groupTraffic = new ButtonGroup();
        groupTraffic.add(getBeTraffic());
        groupTraffic.add(getBeMidGasoline());
        getTextMidGasoline().setEnabled(false);
        getTextTraffic().setEnabled(false);

        //put a tick on the traffic field and make it active for entering and disable midGasoline
        beTraffic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getTextTraffic().setEnabled(true);
                getTextMidGasoline().setEnabled(false);
                onBoardComputerCar.setMidGasoline(0);
                getTextMidGasoline().setText("0");
                getBeTraffic().setSelected(true);

                //when the textTraffic field loses focus, it checks if the traffic was entered correctly,
                // if not, it erases the value and asks to enter it again
                getTextTraffic().addFocusListener(new FocusListener() {

                    @Override
                    public void focusGained(FocusEvent e) {
                    }

                    @Override
                    public void focusLost(FocusEvent e) {

                        // if the string number an integer, then we write it to the variable traffic
                        if (getTextTraffic().getText().matches("\\d+")
                                && Integer.parseInt(getTextTraffic().getText()) < 11
                                    && Integer.parseInt(getTextTraffic().getText()) >= 0) {

                            onBoardComputerCar.setTraffic(check.validIntegerInString(getTextTraffic().getText()));
                            getErrorTraffic().setText("");
                            getErrorMidGasoline().setText("");

                        } else {
                            getErrorTraffic().setForeground(Color.RED);
                            getErrorTraffic().setText("Неправильно введен трафик");
                            getTextTraffic().setText("");
                        }

                    }// end focusLost
                });//end of field textTraffic
            } // end actionPerformed
        }); // end beTraffic.addActionListener

        //put a tick on the MidGasoline field and make it active for entering and disable traffic
        beMidGasoline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTextMidGasoline().setEnabled(true);
                getTextTraffic().setEnabled(false);
                onBoardComputerCar.setTraffic(0);
                getTextTraffic().setText("0");
                getBeMidGasoline().setSelected(true);

                //when the TextMidGasoline field loses focus, it checks if the traffic was entered correctly,
                // if not, it erases the value and asks to enter it again
                getTextMidGasoline().addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                    }

                    @Override
                    public void focusLost(FocusEvent e) {

                        // if the string number is double or an integer, then we write it to the variable distance
                        if (getTextMidGasoline().getText().matches("(\\d+(\\.?\\d+))")
                                || getTextMidGasoline().getText().matches("\\d+")) {

                            onBoardComputerCar.setMidGasoline(check.validDoubleInString(getTextMidGasoline().getText()));
                            getErrorMidGasoline().setText("");
                            getErrorTraffic().setText("");

                        } else {
                            getErrorMidGasoline().setForeground(Color.RED);
                            getErrorMidGasoline().setText("Неправильно введен средний расход");
                            getTextMidGasoline().setText("");
                        }
                    }// end focusLost
                });//end of field textMidGasoline
            } // end actionPerformed
        });// end beMidGasoline.addActionListener

        //when the textPrice field loses focus, it checks if the price was entered correctly,
        // if not, it erases the value and asks to re-enter
        getTextPrice().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                // if the string number is double or an integer, then we write it to the variable price
                if (getTextPrice().getText().matches("(\\d+(\\.?\\d+))")
                        || getTextPrice().getText().matches("\\d+")) {
                    stationGAS.setPrice(check.validDoubleInString(getTextPrice().getText()));
                    getErrorPrice().setText("");
                } else {
                    getErrorPrice().setForeground(Color.RED);
                    getErrorPrice().setText("Неправильно введена цена");
                    getTextPrice().setText("");
                }
            }// end focusLost
        });//end of field textPrice

        // combine the conditionerON and conditionerOFF buttons into the group, set the initial value to ON
        ButtonGroup groupConditioner = new ButtonGroup();
        groupConditioner.add(getConditionerON());
        groupConditioner.add(getConditionerOFF());
        getConditionerON().setSelected(true);

        //if the conditionerON button is enabled, then we assign the conditioner variable of the car class (true)
        getConditionerON().addActionListener(e -> car.setConditioner(true));

        //if the conditionerOFF button is enabled, then we assign the conditioner variable of the car class (false)
        getConditionerOFF().addActionListener(e -> car.setConditioner(false));

        //combine the dynamicDrivingON and dynamicDrivingOFF buttons into a group, set the initial value to ON
        ButtonGroup groupDynamicDriving = new ButtonGroup();
        groupDynamicDriving.add(getDynamicDrivingON());
        groupDynamicDriving.add(getDynamicDrivingOFF());
        getDynamicDrivingON().setSelected(true);

        //if the dynamicDrivingON button is enabled, then assign the variable dynamicDriving of the car class (true)
        getDynamicDrivingON().addActionListener(e -> car.setDynamicDriving(true));

        //if the dynamicDrivingOFF button is enabled, then assign the variable dynamicDriving of the car class (false)
        getDynamicDrivingOFF().addActionListener(e -> car.setDynamicDriving(false));

        //when you click on the start button, it checks whether all the fields are filled,
        // if not, then asks to fill in the fields, and if all the fields are filled in correctly,
        // it calculates the result and displays it
        getStart().addActionListener(e -> {
            // write the entered arguments into the method and get the result:
            if (getTextDate().getText().equals("") || getTextDistance().getText().equals("") ||
                    getTextTraffic().getText().equals("") || getTextPrice().getText().equals("")
                    || getTextMidGasoline().getText().equals("")) {
                getErrorButton().setForeground(Color.RED);
                getErrorButton().setText("Заполните все поля");
            } else {
                getErrorButton().setText("");
                onBoardComputerCar.priceInCityGAS(getCar().getDistance(), getCar().getTraffic(), car.getMidGasoline(),
                        getCar().getPrice(), getCar().isConditioner(), getCar().isDynamicDriving());
                JOptionPane.showMessageDialog(null, getCar().reportCity());
                getCar().resetGasAndResultGas();
            }
        });// end button start

        //when you press the returnMenu button and confirm, it closes the current window and returns to the main menu
        getReturnMenu().addActionListener(e -> {//
            int result = JOptionPane.showConfirmDialog
                    (null, "Вы точно хотите вернуться в меню?",
                            "вернуться в меню", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MenuGUI menuGUI = new MenuGUI();
                setVisible(false);
                dispose();
            }
        });// end button returnMenu
    }// end constructor InCityPanel

    // down getter and setter

    protected JTextField getTextDate() {
        return textDate;
    }

    protected JPanel getPanel() {
        return panel;
    }

    protected JTextField getTextDistance() {
        return textDistance;
    }

    protected JTextField getTextTraffic() {
        return textTraffic;
    }

    protected JRadioButton getConditionerON() {
        return conditionerON;
    }

    protected JRadioButton getConditionerOFF() {
        return conditionerOFF;
    }

    protected JRadioButton getDynamicDrivingON() {
        return dynamicDrivingON;
    }

    protected JRadioButton getDynamicDrivingOFF() {
        return dynamicDrivingOFF;
    }

    protected JButton getStart() {
        return start;
    }

    protected JTextField getTextPrice() {
        return textPrice;
    }

    protected JLabel getErrorDate() {
        return errorDate;
    }

    protected JLabel getErrorDistance() {
        return errorDistance;
    }

    protected JLabel getErrorTraffic() {
        return errorTraffic;
    }

    protected JLabel getErrorPrice() {
        return errorPrice;
    }

    protected JLabel getErrorButton() {
        return errorButton;
    }

    protected JButton getReturnMenu() {
        return returnMenu;
    }

    protected JTextField getTextMidGasoline() {
        return textMidGasoline;
    }

    protected JLabel getInMidGasoline() {
        return inMidGasoline;
    }

    protected JLabel getErrorMidGasoline() {
        return errorMidGasoline;
    }

    protected JRadioButton getBeMidGasoline() {
        return beMidGasoline;
    }

    protected JRadioButton getBeTraffic() {
        return beTraffic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}// end class InCityPanel
