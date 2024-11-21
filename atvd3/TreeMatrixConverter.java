package atvd3;

public class TreeMatrixConverter {

    private int[][] matrix;
    private int size;

    public TreeMatrixConverter(Binary binaryTree) {
        this.matrix = new int[10][3];
        this.size = 0;
        buildMatrix(binaryTree.getRoot());
    }

    private void buildMatrix(Node node) {
        if (node != null) {
            addNode(node.getValue(), -1, -1);
            buildMatrix(node, 0);
        }
    }

    private void buildMatrix(Node node, int currentIndex) {
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            int leftIndex = size;
            addNode(node.getLeft().getValue(), -1, -1);
            matrix[currentIndex][1] = leftIndex;
            buildMatrix(node.getLeft(), leftIndex);
        }

        if (node.getRight() != null) {
            int rightIndex = size;
            addNode(node.getRight().getValue(), -1, -1);
            matrix[currentIndex][2] = rightIndex;
            buildMatrix(node.getRight(), rightIndex);
        }
    }

    private void addNode(int value, int leftIndex, int rightIndex) {
        if (size == matrix.length) {
            resizeMatrix();
        }
        matrix[size][0] = value;
        matrix[size][1] = leftIndex;
        matrix[size][2] = rightIndex;
        size++;
    }

    private void resizeMatrix() {
        int[][] newMatrix = new int[matrix.length * 2][3];
        System.arraycopy(matrix, 0, newMatrix, 0, matrix.length);
        matrix = newMatrix;
    }

    public void printMatrixWithIndex() {
        System.out.println("ind\tVal\tLef\tRig");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d\t%d\t%d\t%d\n",
                    i,
                    matrix[i][0],
                    matrix[i][1],
                    matrix[i][2]);
        }
    }
}
