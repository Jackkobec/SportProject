package view;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileTree {
    public JScrollPane init() {
        FileSystemModel fsm = new FileSystemModel();
        File[] froots = File.listRoots();
        // получаем список 'корней' файловой системы.
        // для windows - это имена дисков: a:, c:, d: e:
        // для linux - /
        DefaultMutableTreeNode super_root = new DefaultMutableTreeNode("My Computer");
        // создаем узел являющийся корнем дерева
        for (int i = 0; i < froots.length; i++) {
            File froot = froots[i];
            // для каждого корня файловой системы создается собственный узел дерева JTree
            DefaultMutableTreeNode mroot = new DefaultMutableTreeNode(froot);
            // затем он помещается внутрь корневого узла
            super_root.add(mroot);
            // и вызываем рекурсивную процедуру (да, да это так ужасно),
            // которая заполняет текущий узел (корень файловой системы)
            // некоторым количеством вложенных узлов.
            // глубина сканирования строго ограничена
            addChildrensToNode(0, mroot, froot);
        }

        // содаем графическое представление дерева
        JTree tree = new JTree(super_root);

        // указываем для этого дерева Renderer
        tree.setCellRenderer(
                new TreeCellRenderer() {
                    // заготовка возвращаемого из renderer-а компонента
                    JLabel jLabel = new JLabel("XXX");
                    // todo use non absolute path
                    public final ImageIcon ICON_FILE = new ImageIcon("c:\\tmp\\file.png");
                    public final ImageIcon ICON_DIR = new ImageIcon("c:\\tmp\\dir.png");
                    public final ImageIcon ICON_MYCOMP = new ImageIcon("c:\\tmp\\comp.png");

                    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                                  boolean expanded, boolean leaf, int row, boolean hasFocus) {
                        // опять внимание на параметры метода:
                        // узел дерева -  передается вовсе не пользовательская информация хранящаяся внутри узла,
                        // а именно сам узел.
                        // затем признаки того, выделен ли данный элемент, развернут ли узел,
                        // является ли данный узел конечным листом,
                        // затем координаты узла (номер строки) и наконец получил ли данный элемент фокус ввода
                        DefaultMutableTreeNode mtree = (DefaultMutableTreeNode) value;
                        // в дальшейшем из полученного узла mtree извлекается и используется
                        // пользовательский объект с помощью getUserObject
                        if (mtree.getUserObject() instanceof String) {
                            // особая проверка необходимая для того,
                            // чтобы корректно обработать корневой элемент дерева (хранящий не файл и не каталог)
                            // а, именно, текстовую надпись "My Computer"
                            jLabel.setText(mtree.getUserObject().toString());
                            jLabel.setIcon(ICON_MYCOMP);
                            return jLabel;
                        }
                        File f = (File) mtree.getUserObject();
                        // в противном случае, содержимое узла файл, то мы должны его соответствующим образом отобразить
                        try {
                            // в зависимости от того какое имя данного файла, мы возвращаем соответствующую надпись JLabel.
                            // также изменяем и видимую иконку
                            jLabel.setText(f.getCanonicalPath());
                            jLabel.setIcon(f.isDirectory() ? ICON_DIR : ICON_FILE);
                            return jLabel;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return new JLabel("Ошибка");
                    }
                }
        );

        tree.setLargeModel(true);
        /**
         *   // теперь к дереву нужно добавить слушателей
         */
        // теперь к дереву нужно добавить слушателей
        tree.addTreeExpansionListener(
                new TreeExpansionListener() {
                    public void treeExpanded(TreeExpansionEvent event) {
                        // эти слушатели извещаются когда операция была завершена. Здесь раскрытие узла.
                        JOptionPane.showMessageDialog(tree, event.getPath().getLastPathComponent());
                    }

                    public void treeCollapsed(TreeExpansionEvent event) {
                        // эти слушатели извещаются когда операция была завершена. Здесь свертывание узла.
                        JOptionPane.showMessageDialog(tree, event.getPath().getLastPathComponent());
                    }
                }
        );

        tree.addTreeWillExpandListener(
                new TreeWillExpandListener() {
                    public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
                        // разрешено ли развернуть узел
                        System.out.println("treeWillExpand");
                        if (Math.random() < 0.5)
                            throw new ExpandVetoException(event, "увы, но развернуть узел дерева не возможно");
                    }

                    public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
                        // разрешено ли свернуть узел
                        System.out.println("treeWillCollapse");
                    }
                }
        );
/**
 *   // теперь к дереву нужно добавить слушателей   end
 */
//        JLabel lab_hint = new JLabel("Подсказка");
//        JScrollPane comp = new JScrollPane(lab_hint);

        JScrollPane scrollPaneForTreeFileSelector = new JScrollPane(tree);
        scrollPaneForTreeFileSelector.setSize(100, 50);
        scrollPaneForTreeFileSelector.setBorder(new CompoundBorder(new EmptyBorder(12, 12, 12, 12), new TitledBorder("Выберете место хранения приватного файла")));
        scrollPaneForTreeFileSelector.setBackground(Color.ORANGE);

        return scrollPaneForTreeFileSelector;
    }

    public static final int MAX_LEVELS = 2;
    // данная переменная хранит значение максимального уровня для рекурсивного просмотра каталога

    private static void addChildrensToNode(int level, DefaultMutableTreeNode mroot, File froot) {
        if (level >= MAX_LEVELS) return;
        File[] fall = froot.listFiles();
        if (fall == null) return;
        for (int i = 0; i < fall.length; i++) {
            File file = fall[i];
            DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(file);
            mroot.add(newChild);
            if (file.isDirectory())
                addChildrensToNode(level + 1, newChild, file);
        }
    }
}
