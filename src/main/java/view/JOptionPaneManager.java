package view;

import model.enums.JOptionsPaneEnums;

import javax.swing.*;

/**
 * Created by Jack on 20.10.2016.
 */
public class JOptionPaneManager {
    private static JFrame controllingFrame; //needed for dialogs

    public static int showJOptionPane(JOptionsPaneEnums jOptionsPaneEnums) {
        Object[] options = {"Да", "Нет!"};
        switch (jOptionsPaneEnums) {
            case ENUM_HELP:
                JOptionPane.showMessageDialog(controllingFrame,
                        "Войдите под раннее соданым аккаунтом или зарегистрируйтесь.\n"
                                + "Так же Вы можете запустить программу из совего приватного файла тренировок\n"
                                + "При регистрации Вам будет предложено выбрать место хранения приватного файла,\n"
                                + "в котором будут храниться Ваши данные и резальтаты тренировок.");
                break;

            case ENUM_LOGOUT:
                int n = JOptionPane.showOptionDialog(new JFrame(), "Кнопка не активна. Её целесообразность решается.",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                return n;

            case WRITTE_RESULT_CURRENT_GYMNASTIC:
                int m = JOptionPane.showOptionDialog(new JFrame(), "Записать результаты текущего упражнения в таблицу результатов?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                return m;
        }
        return -100500;//this means nothing
    }

}