package atvd3;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int input = 20;
        String result;
        Binary tree = new Binary();

        while (input != 0) {
            result = showMenu();

            if (result.equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico!");
                result = showMenu();
            } else {
                input = Integer.parseInt(result);

                switch (input) {
                    case 1:
                        String item = JOptionPane.showInputDialog("Digite um número para inserir na árvore!");
                        tree.insert(Integer.parseInt(item));
                        break;
                    case 2:
                        String valueToRemove = JOptionPane.showInputDialog("Digite o valor que você deseja remover!");
                        tree.remove(tree.getRoot(), Integer.parseInt(valueToRemove));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        tree.showRoot();
                        System.out.println();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        System.out.println("Ordem simétrica:");
                        tree.inOrder(tree.getRoot());
                        System.out.println();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        System.out.println("Pré-ordem:");
                        tree.preOrder(tree.getRoot());
                        System.out.println();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Os valores serão exibidos no console!");
                        System.out.println("Pós-ordem:");
                        tree.postOrder(tree.getRoot());
                        System.out.println();
                        break;
                    case 7:
                        TreeMatrixConverter converter = new TreeMatrixConverter(tree);
                        converter.printMatrixWithIndex();
                        break;
                }
            }
        }
    }

    public static String showMenu() {
        String result = JOptionPane.showInputDialog(
                "Digite:" +
                        "\n 1: Para inserir " +
                        "\n 2: Para remover" +
                        "\n 3: Para exibir a raiz" +
                        "\n 4: Para exibir ordem simétrica" +
                        "\n 5: Para exibir pré-ordem" +
                        "\n 6: Para exibir pós-ordem" +
                        "\n 7: Para converter em matriz e exibir" +
                        "\n 0: Para sair"
        );

        if (result == null) {
            result = "";
        }

        return result;
    }
}
