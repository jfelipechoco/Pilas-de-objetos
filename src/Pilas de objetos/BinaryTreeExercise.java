public class BinaryTreeExercise {
    // Clase interna para representar un nodo del árbol
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Método para calcular la altura del árbol
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Método para contar el número de nodos en el árbol
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Método para verificar si el árbol está balanceado
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return Math.abs(leftHeight - rightHeight) <= 1 &&
               isBalanced(root.left) &&
               isBalanced(root.right);
    }

    // Método para encontrar el valor máximo en el árbol
    public static int findMaxValue(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("El árbol está vacío");
        }
        
        int maxValue = root.value;
        
        if (root.left != null) {
            maxValue = Math.max(maxValue, findMaxValue(root.left));
        }
        
        if (root.right != null) {
            maxValue = Math.max(maxValue, findMaxValue(root.right));
        }
        
        return maxValue;
    }

    // Método para realizar un recorrido en orden (inorder traversal)
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

    // Método main para demostrar las operaciones del árbol
    public static void main(String[] args) {
        // Construir un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);

        // Demostrar operaciones del árbol
        System.out.println("Altura del árbol: " + getHeight(root));
        System.out.println("Número de nodos: " + countNodes(root));
        System.out.println("¿Está balanceado? " + isBalanced(root));
        System.out.println("Valor máximo: " + findMaxValue(root));
        
        System.out.print("Recorrido en orden: ");
        inorderTraversal(root);
    }
}