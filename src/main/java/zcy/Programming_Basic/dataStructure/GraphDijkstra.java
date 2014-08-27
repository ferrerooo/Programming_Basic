package zcy.Programming_Basic.dataStructure;

public class GraphDijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*
 * 
#include <iostream>
#include <list>
using namespace std;
#define MAX_SIZE 10

enum GraphType { DG, UDG };

struct Edge{
	int verIndex;
	Edge *nextEdge;
	int weight;
};
struct VNode{
	char data;
	Edge *firstEdge;
};
struct Graph {
	VNode *vertices;
	int verNum;
	int edgeNum;
	GraphType gtype;
};

#define MAX_DISTANCE 1000
struct minPath{
	int preVerIndex;
	int distance;
	bool added;
};
minPath mt[MAX_SIZE];
void updateMTDij(Graph *g, int lastChangedIndex) {
	mt[lastChangedIndex].added = true;

	for(Edge *edge = g->vertices[lastChangedIndex].firstEdge; edge!=NULL; edge=edge->nextEdge) {
		if (mt[edge->verIndex].distance > mt[lastChangedIndex].distance+edge->weight) {
			mt[edge->verIndex].distance = mt[lastChangedIndex].distance+edge->weight;
			mt[edge->verIndex].preVerIndex = lastChangedIndex;
		}
	}
}
int getMinMTDij(Graph *g) {
	int minDis = MAX_DISTANCE;
	int minIndex = -1;
	for (int i=0;i<g->verNum;i++) {
		if (mt[i].added == false && mt[i].distance<minDis) {
			minDis = mt[i].distance;
			minIndex = i;
		}
	}
	return minIndex;
}
// running time O(ElgV)
void shortestPath(Graph *g) {
	//init
	for (int i=0;i<g->verNum;i++) {
		mt[i].preVerIndex = -1;
		mt[i].distance = MAX_DISTANCE;
		mt[i].added = false;
	}
	// add the first vertice
	mt[0].distance = 0;
	mt[0].preVerIndex = 0;
	mt[0].added = true;
	updateMTDij(g, 0);
	int lastChangedIndex = 0;

	for (int i=1; i<g->verNum;i++) {
		lastChangedIndex = getMinMTDij(g);
		cout << g->vertices[mt[lastChangedIndex].preVerIndex].data << "-" << g->vertices[lastChangedIndex].data << endl;
		updateMTDij(g, lastChangedIndex);
	}
}
 * 
 * 
 * */

