package view;

import model.app_db.factory.DefaultData;
import model.roles.Gymnastic;
import view.view_components.AllResultTableModel;
import view.view_components.components.ButtonTabComponent;
import view.view_components.components.VerticalButton;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import static model.enums.JOptionsPaneEnums.ENUM_LOGOUT;
import static model.enums.JOptionsPaneEnums.WRITTE_RESULT_CURRENT_GYMNASTIC;
import static view.JOptionPaneManager.showJOptionPane;

/**
 * MainFrameTraining
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class MainFrameTraining extends MainFrame {
    private final JTabbedPane pane = new JTabbedPane();

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int sizeWidth = 800;
    private static int sizeHeight = 600;
    private int locationX = (screenSize.width - sizeWidth) / 2;
    private int locationY = (screenSize.height - sizeHeight) / 2;

    private List<Gymnastic> defaultGymnastics = new DefaultData().createListOfDefaultGymnastics();

    public MainFrameTraining() throws HeadlessException {

        setLayout(new BorderLayout());
        setTitle("Sport Application");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);
        //set minimal size of window
        setMinimumSize(new Dimension(800, 600));

        addComponents(getContentPane());
        getRootPane().setBackground(Color.orange);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void addComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        Font font = new Font("Tamoha", Font.BOLD, 16);
//        MenuLookDemo md = new MenuLookDemo();
//        JMenuBar menuBar = md.createMenuBar();
//        menuBar.setBackground(Color.ORANGE.brighter());
//        menuBar.setFont(font);
        MainFrameMenu mfm = new MainFrameMenu();
        JMenuBar menuBar = mfm.createMenuBar();
        menuBar.setBackground(Color.ORANGE.brighter());


        Font fontButtons = new Font("Verdana", Font.PLAIN, 8);

        JButton scs = new VerticalButton("Button 1", false);
        scs.setFont(font);
        scs.setPreferredSize(new Dimension(25, 100));

        JButton scs2 = new VerticalButton("Button 2", false);
        scs2.setFont(font);
        scs.setPreferredSize(new Dimension(25, 100));

        JButton scs3 = new VerticalButton("Button 3", false);
        scs3.setFont(font);
        scs3.setPreferredSize(new Dimension(25, 50));

        JPanel panel = new JPanel(new GridLayout(0, 1));
        //ставим размеры панели
        panel.setPreferredSize(new Dimension(20, 50));
        panel.add(scs);
        panel.add(scs2);
//
        /**
         * Работает на 1 вкладку
         */
         /*
        JTabbedPane pane = new JTabbedPane();
        final int tabNumber = 2;
        pane.removeAll();
        pane.add("Tab1", new JLabel("Tab1"));
        pane.setTabComponentAt(0,
                new ButtonTabComponent(pane));

        pane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);*/
//
        //внутренняя панель для MainFrameTraining
        JPanel innerTrainingPanelForCenter = new JPanel(new BorderLayout());
        //вернхние кнопки логаунт и тд тут же будет окно поиска
        JPanel innerTrainingPanelNorthPanel = new JPanel(new BorderLayout());
        JButton logout = new JButton("LogOut");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = showJOptionPane(ENUM_LOGOUT);
                //проверяем если нисего не было выбрано и был нажат крестик - то просто закрываем диалог и возвращаемся в программу
                if (n == 1 || n == -1) {
                    return;
                } else {
                    dispose();
                    new LoginForm(null, null, null);
                }//todo change null to correct value
            }
        });
        innerTrainingPanelNorthPanel.add(logout, BorderLayout.EAST);
        /**
         * создадим панель всех результатов
         */
        //создадим панель всех результатов
        JTable allResOfCurrentTrainingTable = new JTable(new AllResultTableModel(defaultGymnastics));
        allResOfCurrentTrainingTable.setPreferredSize(new Dimension(400, 200));
        JScrollPane scrollPanelForAllResOfCurrentTrainingTable = new JScrollPane(allResOfCurrentTrainingTable);
        //размер скрола scrollPanelForAllResOfCurrentTrainingTable
        scrollPanelForAllResOfCurrentTrainingTable.setPreferredSize(new Dimension(400, 200));
        scrollPanelForAllResOfCurrentTrainingTable.setBorder(new CompoundBorder(new EmptyBorder(12, 12, 12, 12), new TitledBorder("ТАБЛИЦА ВСЕХ РЕЗУЛЬТАТОВ ТЕКУЩЕЙ ТРЕНИРОВКИ")));
/**
 * тестовый собиратель данных с таблицы
 * Test Data Collector
 */
        JButton vvv = new JButton("Собрать данные с табицы");
        vvv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //линкед мап для считывания результатов каждого упражнения в таблицу(линкед - чтобы помнить порядок)
                Map<String, List<Object>> collectionForAllResOfCurrentTraining = new LinkedHashMap<>();
                //запись информации в мапу для каждой колонки, ключ - имя колонки(упражнения), результаты как лист значений мапы
                for (int i = 0; i < allResOfCurrentTrainingTable.getColumnCount(); i++) {
                    //listFormer(ressOfCurrentGimFromTable, i);
                    collectionForAllResOfCurrentTraining.put(allResOfCurrentTrainingTable.getColumnName(i),
                            listFormer(i));
                }
                System.out.println(collectionForAllResOfCurrentTraining.toString());
            }

            //формирователь листа для каждой колонки - тоесть каждого упражнения, считывает инфу с строк данной колонки и сует в лист
            private List<Object> listFormer(int columnindex) {
                List<Object> ressOfCurrentGimFromTable2 = new ArrayList<>();
                for (int i = 0; i < allResOfCurrentTrainingTable.getRowCount(); i++) {
                    ressOfCurrentGimFromTable2.add(allResOfCurrentTrainingTable.getValueAt(i, columnindex));
                }
                return ressOfCurrentGimFromTable2;
            }
        });
        JButton ccc = new JButton("ccc");
        //Панель, где будет таблица всех результатов текущей тренировки и тд
        JPanel innerTrainingPanelForSouth = new JPanel(new BorderLayout());
        innerTrainingPanelForSouth.add(scrollPanelForAllResOfCurrentTrainingTable, BorderLayout.NORTH);
        innerTrainingPanelForSouth.add(vvv, BorderLayout.CENTER);
        innerTrainingPanelForSouth.add(ccc, BorderLayout.SOUTH);

        //создание элемента вкладок для упражнений
        JTabbedPane pane = new JTabbedPane();

//        for (int i = 0; i < defaultGymnastics.size(); i++) {
//            String title = "Вкладка " + i;
//            pane.add(title, new JLabel(title));//это поле самой вкладки в виде new JLabel
//            pane.setTabComponentAt(i,
//                    new ButtonTabComponent(pane));
//        }
        //циклом создаем вкладки для всех упржнений в данной тренировке
        int i = 0;
        for (Gymnastic gym : defaultGymnastics) {
            String title = gym.getName();
            pane.add(title, panelForGymCreate(gym, allResOfCurrentTrainingTable));//это поле самой вкладки в виде new JLabel
            pane.setTabComponentAt(i,
                    new ButtonTabComponent(pane));//это добавление во вкладку кнопки закрытие как в браузерах, логика в классе ButtonTabComponent
            i++;
        }


        innerTrainingPanelForCenter.add(innerTrainingPanelNorthPanel, BorderLayout.NORTH);
        innerTrainingPanelForCenter.add(pane, BorderLayout.CENTER);
        //добавляем панель скрол с панелью всех результатовм scrollPanelForAllResOfCurrentTrainingTable
        innerTrainingPanelForCenter.add(innerTrainingPanelForSouth, BorderLayout.SOUTH);


        //заполенине самого MainFrameTraining
        contentPane.setBackground(Color.ORANGE.darker());
        contentPane.add(menuBar, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.LINE_START);
        contentPane.add(innerTrainingPanelForCenter, BorderLayout.CENTER);

    }

    public JPanel panelForGymCreate(Gymnastic gym, JTable allResOfCurrentTrainingTable) {
        JPanel panelForThisGym = new JPanel(new BorderLayout());

        panelForThisGym.add(new JLabel("Тут будет некоторое описание самого упражнения или описание использования данного окна"), BorderLayout.NORTH);
        //панель записи текущего результата на текущей тренеровке
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new CompoundBorder(new EmptyBorder(12, 12, 12, 12), new TitledBorder(gym.getName())));
        /**
         *  Лепим таблицу
         * заполняем заголовки табилцы
         */
        CurrentResaltTableModel crmodel = new CurrentResaltTableModel();
        //final JTable[] curentGymnastycResaltsTable = {createjTableHandelsAndData(3)};
        JTable[] curentGymnastycResaltsTable = {new JTable(crmodel)};
        //выделять только 1 ячейку
        // curentGymnastycResaltsTable[0].setCellSelectionEnabled(true);
        //размер таблицы
        curentGymnastycResaltsTable[0].setPreferredSize(new Dimension(200, 50));
        //запрет перемещения колонок между собой перетаскиванием
        curentGymnastycResaltsTable[0].getTableHeader().setReorderingAllowed(false);
        curentGymnastycResaltsTable[0].setFillsViewportHeight(true);
        //scrollPaneForCurrentResTable для отображения таблицы с именами колонок
        JScrollPane scrollPaneForCurrentResTable = new JScrollPane(curentGymnastycResaltsTable[0]);
        //размер скрола
        scrollPaneForCurrentResTable.setPreferredSize(new Dimension(200, 40));

        /**
         * Лепим кнопку и формируем резальтат из введенных значений в curentGymnastycResaltsTable
         *
         */


        /**
         * лепим считчер подходов
         */
        JLabel chooseRepeatLabel = new JLabel("Количество подходов: ");
        JRadioButton setBy12 = new JRadioButton("1-2 подхода");
        JRadioButton setBy5 = new JRadioButton("5 подходов");
        JRadioButton setBy7 = new JRadioButton("7 подходов");

        ButtonGroup selectNumberOfGymnasticSets = new ButtonGroup();
        selectNumberOfGymnasticSets.add(setBy12);
        selectNumberOfGymnasticSets.add(setBy5);
        selectNumberOfGymnasticSets.add(setBy7);

        JPanel chooseRepeatOfSetPanel = new JPanel(new FlowLayout(SwingConstants.HORIZONTAL));
        // chooseRepeatOfSetPanel.setBounds(60, 80, 550, 45);

        JButton setDefaultRepeatOfSets = new JButton("Установить по умолчанию(3)");
        setDefaultRepeatOfSets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Да", "Нет!"};
                int n = JOptionPane.showOptionDialog(new JFrame(), "Установить количество подходов = 3? Данные в текущей таблице подходов будут стерты!",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                //проверяем если нисего не было выбрано и был нажат крестик - то просто закрываем диалог и возвращаемся в программу
                if (n == 1 || n == -1) {
                    return;
                } else
                    tablePanel.setVisible(false);
                JPanel tablePanel2 = panelForGymCreate(gym, allResOfCurrentTrainingTable);
                panelForThisGym.add(tablePanel2, BorderLayout.NORTH);
                panelForThisGym.revalidate();

            }
        });
        setDefaultRepeatOfSets.hide();

        JButton confirmSetButton = new JButton(">Установить");
        chooseRepeatOfSetPanel.add(confirmSetButton);
        confirmSetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String radioButtonText = getSelectedButtonText(selectNumberOfGymnasticSets);
                if (radioButtonText == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "Пожалуйста выберете количество подходов");
                    return;
                }
                switch (radioButtonText) {
                    case "5 подходов":
                        setBy12.setVisible(false);
                        setBy7.setVisible(false);
                        confirmSetButton.setVisible(false);
                        setDefaultRepeatOfSets.setVisible(true);

                        curentGymnastycResaltsTable[0].setModel(new CurrentResaltTableModel(5));
                        curentGymnastycResaltsTable[0].revalidate();
                        break;
                    case "1-2 подхода":
                        setBy5.setVisible(false);
                        setBy7.setVisible(false);
                        confirmSetButton.setVisible(false);
                        setDefaultRepeatOfSets.setVisible(true);

                        curentGymnastycResaltsTable[0].setModel(new CurrentResaltTableModel(2));
                        curentGymnastycResaltsTable[0].revalidate();
                        break;
                    case "7 подходов":
                        setBy12.setVisible(false);
                        setBy5.setVisible(false);
                        confirmSetButton.setVisible(false);
                        setDefaultRepeatOfSets.setVisible(true);

                        curentGymnastycResaltsTable[0].setModel(new CurrentResaltTableModel(7));
                        curentGymnastycResaltsTable[0].revalidate();
                        break;
                }
            }
        });
        JButton writeResultsOfSetsButton = new JButton("Записать результаты");
        writeResultsOfSetsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = showJOptionPane(WRITTE_RESULT_CURRENT_GYMNASTIC);
                //проверяем если нисего не было выбрано и был нажат крестик - то просто закрываем диалог и возвращаемся в программу
                if (n == 1 || n == -1) {
                    return;
                } else {
                    try {
                        //останавливаем редактирование таблицы
                        curentGymnastycResaltsTable[0].getCellEditor().stopCellEditing();


                        Map<String, List<Object>> resultsOfCurrentMap = new HashMap<>();

                        List<Object> resultsOfCurrentTrAttay = new ArrayList<>();
                        resultsOfCurrentTrAttay.clear();
                        for (int i = 0; i < curentGymnastycResaltsTable[0].getColumnCount(); i++) {
                            Object r = curentGymnastycResaltsTable[0].getValueAt(0, i);
                            resultsOfCurrentTrAttay.add(r);
                            System.out.println("i: " + i + ", Obj: " + r.toString());
                        }
                        resultsOfCurrentMap.put(gym.getName(), resultsOfCurrentTrAttay);

                        System.out.println(resultsOfCurrentTrAttay.toString());
                        resultsOfCurrentMap.forEach((s, list) -> System.out.println(s + "" + list));


                        //формируем результат таблицы результатов allResOfCurrentTrainingTable
                        allResOfCurrentTrainingTableWritter(allResOfCurrentTrainingTable, resultsOfCurrentTrAttay,
                                findColumByName(allResOfCurrentTrainingTable, gym));

                        /*if (gym.getName() == "Отжимания") {
                            for (int j = 0, k = 0; j < resultsOfCurrentTrAttay.size()
                                    && k < resultsOfCurrentTrAttay.size(); ++j, ++k) {
                                allResOfCurrentTrainingTable.setValueAt(resultsOfCurrentTrAttay.get(k), j, 0);
                                allResOfCurrentTrainingTable.updateUI();
                            }
                        }
                        if (gym.getName() == "Брусья") {
                            for (int j = 0, k = 0; j < resultsOfCurrentTrAttay.size()
                                    && k < resultsOfCurrentTrAttay.size(); ++j, ++k) {
                                allResOfCurrentTrainingTable.setValueAt(resultsOfCurrentTrAttay.get(k), j, 1);
                                allResOfCurrentTrainingTable.updateUI();
                            }
                        }
                        if (gym.getName() == "Подтягивания") {
                            for (int j = 0, k = 0; j < resultsOfCurrentTrAttay.size()
                                    && k < resultsOfCurrentTrAttay.size(); ++j, ++k) {
                                allResOfCurrentTrainingTable.setValueAt(resultsOfCurrentTrAttay.get(k), j, 2);
                                allResOfCurrentTrainingTable.updateUI();
                            }
                        }
                        if (gym.getName() == "Приседания") {
                            for (int j = 0, k = 0; j < resultsOfCurrentTrAttay.size()
                                    && k < resultsOfCurrentTrAttay.size(); ++j, ++k) {
                                allResOfCurrentTrainingTable.setValueAt(resultsOfCurrentTrAttay.get(k), j, 3);
                                allResOfCurrentTrainingTable.updateUI();
                            }
                        }
                        if (gym.getName() == "Подъемы ног") {
                            for (int j = 0, k = 0; j < resultsOfCurrentTrAttay.size()
                                    && k < resultsOfCurrentTrAttay.size(); ++j, ++k) {
                                allResOfCurrentTrainingTable.setValueAt(resultsOfCurrentTrAttay.get(k), j, 4);
                                allResOfCurrentTrainingTable.updateUI();
                            }
                        }
                        if (gym.getName() == "Борцовский мостик") {
                            for (int j = 0, k = 0; j < resultsOfCurrentTrAttay.size()
                                    && k < resultsOfCurrentTrAttay.size(); ++j, ++k) {
                                allResOfCurrentTrainingTable.setValueAt(resultsOfCurrentTrAttay.get(k), j, 5);
                                allResOfCurrentTrainingTable.updateUI();
                            }
                        }*/


                    } catch (NullPointerException ex) {
                        JOptionPane.showMessageDialog(new JFrame(), "Таблмца не была изменена");
                        return;
                    }
                }
            }
        });

        chooseRepeatOfSetPanel.add(writeResultsOfSetsButton);
        chooseRepeatOfSetPanel.add(chooseRepeatLabel);
        chooseRepeatOfSetPanel.add(setBy12);
        chooseRepeatOfSetPanel.add(setBy5);
        chooseRepeatOfSetPanel.add(setBy7);
        chooseRepeatOfSetPanel.add(confirmSetButton);
        chooseRepeatOfSetPanel.add(setDefaultRepeatOfSets);


        //заполняем панель добавления резальтатов текущей тренировки с переключателем количетсва подходов
        tablePanel.add(new JLabel("ЗАПОЛНИТЕ РЕЗУЛЬТАТЫ ТЕКУЩЕЙ ТРЕНИРОВКИ"), BorderLayout.NORTH);
        tablePanel.add(scrollPaneForCurrentResTable, BorderLayout.CENTER);
        tablePanel.add(chooseRepeatOfSetPanel, BorderLayout.SOUTH);
/**
 *
 */


        //верхняя панель с таблицей текущей тренировки и перевлючателем количества подходов
        panelForThisGym.add(tablePanel, BorderLayout.NORTH);
        panelForThisGym.add(new JPanel(), BorderLayout.SOUTH);

        return panelForThisGym;
    }

    private JTable createjTableHandelsAndData(int chooseNumberOfRepats) {
        String[] columnHeads = new String[chooseNumberOfRepats];
        for (int i = 0; i < (chooseNumberOfRepats); i++) {
            columnHeads[i] = "Подход " + (i + 1);
        }
        // columnHeads[columnHeads.length - 1] = "Всего";

        //заполняем пустотой чтобы не было нуль эксепшена
        Object[][] data = new Object[1][chooseNumberOfRepats];
        for (int i = 0; i < (chooseNumberOfRepats); i++) {
            data[0][i] = "Test Data";

        }

        return new JTable(data, columnHeads);
    }

    public void allResOfCurrentTrainingTableWritter(JTable allResOfCurrentTrainingTable, List<Object> resultsOfCurrentTrAttay, int numberColumnToWritte) {
        for (int j = 0, k = 0; j < resultsOfCurrentTrAttay.size()
                && k < resultsOfCurrentTrAttay.size(); ++j, ++k) {
            allResOfCurrentTrainingTable.setValueAt(resultsOfCurrentTrAttay.get(k), j, numberColumnToWritte);
            allResOfCurrentTrainingTable.updateUI();
        }
    }

    public int findColumByName(JTable allResOfCurrentTrainingTable, Gymnastic gym) {
        for (int i = 0; i < allResOfCurrentTrainingTable.getColumnCount(); ++i) {
            System.out.println(gym.getName());
            if (gym.getName().equals(allResOfCurrentTrainingTable.getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public void runTest() {
        int tabNumber = 5;
        pane.removeAll();
        for (int i = 0; i < tabNumber; i++) {
            String title = "Tab " + i;
            pane.add(title, new JLabel(title));
            initTabComponent(i);
        }

        pane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        setSize(new Dimension(400, 200));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initTabComponent(int i) {
        pane.setTabComponentAt(i,
                new ButtonTabComponent(pane));
    }

}
