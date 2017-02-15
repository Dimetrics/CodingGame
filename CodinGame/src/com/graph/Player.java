package com.graph;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // the total number of nodes in the level,
								// including the gateways
		int L = in.nextInt(); // the number of links
		int E = in.nextInt(); // the number of exit gateways
		for (int i = 0; i < L; i++) {
			int N1 = in.nextInt(); // N1 and N2 defines a link between these
									// nodes
			int N2 = in.nextInt();
		}
		for (int i = 0; i < E; i++) {
			int EI = in.nextInt(); // the index of a gateway node
		}

		// game loop
		while (true) {
			int SI = in.nextInt(); // The index of the node on which the Skynet
									// agent is positioned this turn

			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");

			// Example: 0 1 are the indices of the nodes you wish to sever the
			// link between
			System.out.println("0 1");
		}
	}
}
//---------------------------------список----------------------------------------

class Queue {
	private final int SIZE;
	private int [] queArray;
	private int front;
	private int rear;
	//
	public Queue(int n)
	{
		SIZE = n;
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	public void insert(int j)
	{
		if (rear ==SIZE-1)
		{
			rear = -1;
		}
		queArray[++rear] = j;
	}
	//
	public int remove ()
	{
		int temp = queArray[front++];
		if (front == SIZE)
		{
			front = 0;
		}
		return temp;
	}
	public boolean isEmpty()
	{
		return (rear+1==front||front+SIZE-1 ==rear);
	}
}
//------------------------узел---------------------------------------------------
class Node
{
	public boolean wasVisited;
	public int distance;
	public Node()
	{
		wasVisited = false;
	}
}
//----------------------------граф с поиском в ширину-----------------------------
class Graph
{
	private final int MAX_NODES;
	private Node nodeList[];
	private int adjMat[][];
	private int nNode;
	private Queue theQueue;
	public Graph (int nodes)
	{
		MAX_NODES = nodes;
		nodeList = new Node[MAX_NODES];
		theQueue = new Queue(nodes);
		nNode = 0;
		//
		for(int j = 0; j < MAX_NODES; j++)
			for (int k = 0; k <MAX_NODES;k++)
				adjMat[j][k]=0;
	}
	//добавляем узел
	public void addNode()
	{
		nodeList[nNode++] = new Node();
	}
	//добавляем связь
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	//delete connection
	public void deleteEdge(int start, int end)
	{
		adjMat[start][end]=0;
		adjMat[end][start] = 0;
	}
	
	
}