package AboutBinaryTree;

import java.util.*;

public class PrintBinaryTreeFromTopToBottom {
    public static  void main(String [] args){
        int [] data={8,6,10,5,7,9,11};
        BnaryTree bnaryTree= new BnaryTree(data);
        PrintBinaryTreeFromTopToBottom printBinaryTreeFromTopToBottom=new PrintBinaryTreeFromTopToBottom();
        ArrayList<Integer> list=printBinaryTreeFromTopToBottom.PrintFromTopToBottom(bnaryTree.rootNode);
        System.out.println();
        System.out.println(list);
    }
    public ArrayList<Integer> PrintFromTopToBottom(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        if(root==null){
            return list ;
        }
        queue.add(root);
        while (queue.size()!=0){
            Node temp = queue.remove(0);
            if(temp.leftNode!= null){
                queue.add(temp.leftNode);
            }
            if(temp.rightNode!=null){
                queue.add(temp.rightNode);
            }
            list.add(temp.value);
        }
        return list;
        }

}

