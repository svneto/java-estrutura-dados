package atvd4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

	private int numVertices;
	private List<List<Integer>> adjacencyList;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyList = new ArrayList<>(numVertices);

		for (int i = 0; i < numVertices; i++) {
			this.adjacencyList.add(new LinkedList<>());
		}
	}

	public void addEdge(int v, int w) {
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v);
	}

	public void buscaEmLargura(int startVertex) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[numVertices];

		visited[startVertex] = true;
		queue.add(startVertex);

		System.out.println("Busca em Largura começando no vértice " + startVertex + ":");

		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			System.out.print(currentVertex + " ");

			for (Integer neighbor : adjacencyList.get(currentVertex)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
		System.out.println();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numVertices; i++) {
			sb.append("Vértice: ").append(i).append(":\n");
			for (Integer neighbor : adjacencyList.get(i)) {
				sb.append(" -> ").append(neighbor).append("\n");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);

		grafo.addEdge(0, 1);
		grafo.addEdge(0, 4);
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);

		System.out.println(grafo.toString());
	}
}
