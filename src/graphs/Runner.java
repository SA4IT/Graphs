package graphs;

public class Runner {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');//0
        graph.addVertex('B');//1
        graph.addVertex('C');//2
        graph.addVertex('D');//3
        graph.addVertex('E');//4


        graph.addEdge(0,1);//AB
        graph.addEdge(1,2);//BC
        graph.addEdge(1,3);//BD

        System.out.println();
        System.out.println("На вход была введена следующая матрица значений графа: ");
        System.out.println();

        graph.printMas();
        System.out.println();

        graph.passInDeep(0);//начинаем с вершины А

    }
}
