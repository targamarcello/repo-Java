import PacchettoSbusto.Arco;
import PacchettoSbusto.Grafo;
import PacchettoSbusto.Nodo;

import java.util.Arrays;

class GrafoDijkstra extends Grafo {
    public int[] dijkstra(String nodoIniziale) throws Exception {
        int numeroNodi = _nodi.size();
        int[] distanze = new int[numeroNodi];
        boolean[] visitati = new boolean[numeroNodi];

        Arrays.fill(distanze, Integer.MAX_VALUE);
        Nodo nodoPartenza = trovaNodo(nodoIniziale);
        distanze[_nodi.indexOf(nodoPartenza)] = 0;

        for (int i = 0; i < numeroNodi; i++) {
            int nodoCorrente = trovaMinimo(distanze, visitati);
            visitati[nodoCorrente] = true;

            for (Arco arco : _archi) {
                if (arco._origine.equals(_nodi.get(nodoCorrente))) {
                    int indiceDestinazione = _nodi.indexOf(arco._dest);
                    if (!visitati[indiceDestinazione] && distanze[nodoCorrente] + arco._costo < distanze[indiceDestinazione]) {
                        distanze[indiceDestinazione] = distanze[nodoCorrente] + arco._costo;
                    }
                }
            }
        }

        return distanze;
    }

    private int trovaMinimo(int[] distanze, boolean[] visitati) {
        int minimo = Integer.MAX_VALUE;
        int indiceMinimo = -1;

        for (int i = 0; i < distanze.length; i++) {
            if (!visitati[i] && distanze[i] < minimo) {
                minimo = distanze[i];
                indiceMinimo = i;
            }
        }

        return indiceMinimo;
    }
}
