import java.util.*;

public class Bellman {
    private int D[];
    private int num_ver;
    public final int max_value = 999;

    public Bellman(int num_ver) {
        this.num_ver = num_ver;
        D = new int[num_ver + 1];
    }

    public void BellmanFordEvaluation(int source, int A[][]) {
        for(int node=1;node<=num_ver;node++){
            D[node]=max_value;
        }
        D[source]=0;

        for (int node = 1; node <= num_ver-1;node++) {
            for(int sn=1;sn<=num_ver;sn++){
                for(int dn=1;dn<=num_ver;dn++){
                    if(A[sn][dn]!=max_value)
                        if(D[dn] > D[sn]+A[sn][dn]);
                            D[dn]=D[sn]+A[sn][dn];
                }
            }
        }

        for(int sn=1;sn<=num_ver;sn++){
            for(int dn=1;dn<=num_ver;dn++){
                if(A[sn][dn]!=max_value){
                    if(D[dn]>D[sn]+A[sn][dn]){
                        System.out.println("The graph contains negative edge cycle");                        
                    }
                }
            }
        }
        for(int vertex=1;vertex<=num_ver;vertex++){
            System.out.println("The distance of source "+source+" to "+vertex +" is "+D[vertex]);
        }
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_ver = 0;
        int source;
        System.out.println("Enter the number of vertice");
        num_ver = sc.nextInt();
        int[][] A = new int[num_ver + 1][num_ver + 1];
        System.out.println("Enter the adjacency matrix");
        for (int sn = 1; sn <= num_ver; sn++) {
            for (int dn = 1; dn <= num_ver; dn++) {
                A[sn][dn] = sc.nextInt();
                if (sn == dn) {
                    A[sn][dn] = 0;
                    continue;
                }
                if (A[sn][dn] == 0) {
                    A[sn][dn] = max_value;
                }
            }
        }
        System.out.println("Enter the source vertex");
        source = sc.nextInt();
        Bellman b = new Bellman(num_ver);
        b.BellmanFordEvaluation(source, A);
        sc.close();
    }
}
