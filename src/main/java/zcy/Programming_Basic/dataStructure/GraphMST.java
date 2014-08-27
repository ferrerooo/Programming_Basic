package zcy.Programming_Basic.dataStructure;

public class GraphMST {

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

void updateMT(Graph *g, int lastChangedIndex) {
	mt[lastChangedIndex].distance = 0;
	for (Edge *edge=g->vertices[lastChangedIndex].firstEdge; edge!=NULL; edge=edge->nextEdge) {
		if (edge->weight < mt[edge->verIndex].distance) {
			mt[edge->verIndex].distance = edge->weight;
			mt[edge->verIndex].preVerIndex = lastChangedIndex;
		}
	}
}
int getMinMT(Graph *g) {
	int minDis = MAX_DISTANCE;
	int minIndex = 0;
	for (int i=0;i<g->verNum;i++) {
		if (mt[i].distance!=0 && mt[i].distance<minDis) {
			minDis = mt[i].distance;
			minIndex = i;
		}
	}

	return minIndex;
}

// running time O(ElgV)
void MST(Graph *g) {
	// init
	for (int i=0;i<g->verNum;i++) {
		mt[i].preVerIndex = -1;
		mt[i].distance = MAX_DISTANCE;
	}
	//add the first vertice
	mt[0].preVerIndex = 0;
	mt[0].distance = 0;
	updateMT(g, 0);
	int lastChangedIndex = 0;

	for (int i=0;i<g->verNum-1;i++) {
		updateMT(g, lastChangedIndex);
		int vind = getMinMT(g);
		cout << g->vertices[mt[vind].preVerIndex].data << "-" << g->vertices[vind].data << endl;
		lastChangedIndex = vind;
	}
}
 * 
 * 
 * */
