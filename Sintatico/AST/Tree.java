package Sintatico.AST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tree {

    Node root;

    public Tree (Node root){
        this.root = root;
    }

    public void simpleWalk (){
        System.out.println(" " + root.data + " ");

        for (Node child: root.getChildren()) {
            simpleWalk(child);
        }
    }

    public void simpleWalk (Node node){
        System.out.println(" " + node.data + " ");

        for (Node child: node.getChildren()) {
            simpleWalk(child);
        }
    }

    public void walk(){
        System.out.println(root.enter);
        if (root.isLeaf())
            System.out.println(" " + root.data + " ");
        for (Node child: root.getChildren())
            walk(child);

        System.out.println(root.exit);
    }

    public void walk(Node node){
        System.out.println(node.enter);
        if (node.isLeaf())
            System.out.println(" " + node.data + " ");
        for (Node child: node.getChildren())
            walk(child);

        System.out.println(node.exit);
    }

    public void writeInFile(Node node, BufferedWriter file) throws IOException{
        file.write(node.enter);
        if (node.isLeaf())
            file.write(node.data);
        for (Node child: node.getChildren())
            writeInFile(child, file);

        file.write(node.exit);
    }

    public void createOutputFile() throws IOException{
        BufferedWriter saida = new BufferedWriter(new FileWriter("output.c"));
        
        saida.write(root.data);
        for (Node child: root.getChildren())
            writeInFile(child, saida);
        saida.close();
    }
}