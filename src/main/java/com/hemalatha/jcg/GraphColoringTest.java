package com.hemalatha.jcg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphColoringTest {

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		a.neighbours.add(b);
		b.neighbours.add(a);
		b.neighbours.add(c);
		c.neighbours.add(b);
		color(Arrays.asList(a,b,c));
		for(Node n: Arrays.asList(a,b,c)){
			System.out.println();
			System.out.print(n.getLabel()+":"+n.getColor()+"-----");
			n.getNeighbours().stream().forEach(e-> System.out.print(e.getLabel()+":"+e.getColor()+"-----"));

		}

	}


	public static void color(List<Node> graphNodes){
		for(Node n: graphNodes){


			Set<Color> illegalColors = findIllegalColors(n.getNeighbours());

			for(Color c: Color.values()){
				if( !illegalColors.contains(c)){
					n.setColor(c);
					break;
				}
			}
		}
	}

	private static Set<Color> findIllegalColors(Set<Node> neighbours) {
		Set<Color> colorSet = new HashSet<>();
		for(Node n:neighbours){
			colorSet.add(n.getColor());
		}
		return colorSet;
	}

	static class Node{
           private int label;
           private Set<Node> neighbours = new HashSet<>();
           private Color color;

		public Node(int label) {
			this.label = label;
		}

		public int getLabel() {
			return label;
		}

		public void setLabel(int label) {
			this.label = label;
		}

		public Set<Node> getNeighbours() {
			return neighbours;
		}

		public void setNeighbours(Set<Node> neighbours) {
			this.neighbours = neighbours;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
	}


	enum Color {
		RED,
		GREEN,
		YELLOW,
		BLUE;
	}
}



