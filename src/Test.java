class Node{
    Node leftNode;
    Node rightNode;
    int value;
    Node(int x){
        this.value=x;
    }
}
class BnaryTree{
    Node rootNode;
    public BnaryTree(){}
    public BnaryTree(int [] data){
        for(int i=0;i<data.length;i++){
            this.Add_Node_To_Tree(data[i]);
        }
        print(rootNode);

    }
    void Add_Node_To_Tree(int value){
        Node currentNode = rootNode;
        if(rootNode == null){
            rootNode = new Node(value);
            return;
        }
        while (true){
            if(value<currentNode.value){
                if(currentNode.leftNode==null){
                    currentNode.leftNode=new Node(value);
                    return;
                }else {
                    currentNode=currentNode.leftNode;
                }
            }else {
                if(currentNode.rightNode==null){
                    currentNode.rightNode=new Node(value);
                    return;
                }else {
                    currentNode=currentNode.rightNode;
                }
            }
        }
    }
    void print(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        this.print(node.leftNode);
        this.print(node.rightNode);
    }


}
public class Test {
    private BnaryTree bnaryTree ;
    public static void main(String [] args){
        int [] pre={5,3,2,4,8,6,10};
        int [] mid={2,3,4,5,6,8,10};
        //new BnaryTree(pre);
        //System.out.println();
        //new BnaryTree(mid);
        Test test = new Test();
        test.initTree(pre,mid);
        //test.print(node);
    }
    public  void initTree(int [] preOrder, int [] inOrder){
        bnaryTree.rootNode=initTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
        //return bnaryTree.rootNode;
    }
    public Node initTree(int[] preOrder,int start1,int end1,int[] inOrder,int start2,int end2){
        if(start1>end1||start2>end2){
            return null;
        }
        int rootData = preOrder[start1];
        Node head =new Node(rootData);
        //找到根节点所在位置
        int rootIndex =findIndexInArray(inOrder,rootData,start2, end2);
        //构建左子树
        Node left = initTree(preOrder,start1+1,start1+rootIndex-start2, inOrder,start2,rootIndex-1);
        //构建右子树
        Node right =initTree(preOrder,start1+rootIndex-start2+1,end1,inOrder,rootIndex+1,end2);
        head.leftNode=left;
        head.rightNode=right;
        return head;

    }

    public int findIndexInArray(int[] a,int x ,int begin , int end){
        for(int i=begin;i<=end;i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }
    void print(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        this.print(node.leftNode);
        this.print(node.rightNode);
    }

}

