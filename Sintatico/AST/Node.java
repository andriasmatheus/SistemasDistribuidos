package Sintatico.AST;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public String data;
    public List<Node> children;
    public String enter;
    public String exit;

    public Node (String data){
        this.data = data;
        children = new ArrayList<>();
        enter = "";
        exit = " ";
    }

    public void addChild(Node child){
        children.add(child);
    }

    public Node addChild(String data){
        Node child = new Node(data);
        children.add(child);
        return child;
    }

    public List <Node> getChildren(){
        return children;
    }

    public boolean isLeaf(){
        return children.isEmpty();
    }

}