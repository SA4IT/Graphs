package graphs;

public class Graph {
    private int maxN = 5;//количество вершин
    private int [][] mas;//наличие перехода между вершинами
    Vertex[] vertexList;//массив вершин графа
    private int curN;//счётчик текущей вершины в графе
    private MyStack stack = new MyStack();
    private int count_ways;

    public Graph(){//конструктор графа
        vertexList = new Vertex[maxN];
        mas = new int [maxN][maxN];
        curN = 0;
        count_ways = 0;
    }

    public void addVertex(char name){//добавление вершин
        vertexList[curN++] = new Vertex(name);
    }

    public void addEdge(int start, int end){//добавление рёбер
        mas[start][end] = 1;
    }


    public void printMas(){//для вывода матрицы на вход
        System.out.println("  A B C D E");
        int chr_ascii = 65;
        for(int i =0; i< maxN; i++){
            char chr = (char)chr_ascii;
            System.out.print(chr + " ");
            for(int j =0; j< maxN; j++){
                if (mas[j][i]==1){
                    mas[i][j]=1;
                }
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
            chr_ascii++;
        }
    }


    public int check(int v){//проверка того, что следующая вершина является соседом предыдущей и не посещена
        for (int i =0; i<curN; i++){
            if (mas[v][i] == 1 && vertexList[i].isVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void passInDeep(int index){//метод обхода графа в глубину
        vertexList[index].isVisited = true;
        stack.push(index);

        while(!stack.isEmpty()){
            int neigh = check(stack.peek());

            if (neigh == -1){
                neigh = stack.pop();
            }
            else{
                vertexList[neigh].isVisited = true;
                stack.push(neigh);
                count_ways ++;
            }
        }
        System.out.println("Количество дорог = " + count_ways);

        for (int i = 0; i< curN; i++){
            vertexList[i].isVisited = false;
        }
    }
}
