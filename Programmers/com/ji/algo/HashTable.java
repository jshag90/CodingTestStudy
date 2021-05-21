package com.ji.algo;

import java.util.LinkedList;

class HashTable {
	
	public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("sung", "she is pretty");
        h.put("jin", "she is a model");
        h.put("hee", "she is an angel");
        h.put("min", "she is cute");

        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
    }
	
	// 해시테이블에 저장할 데이터를 Node에 담는다.
	class Node {
		String key;
		String value;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}

		String value() {
			return value;
		}

		void value(String value) {
			this.value = value;
		}
	}

	LinkedList<Node>[] data;

	HashTable(int size) {
		this.data = new LinkedList[size];
	}

	int getHashCode(String key) {
		int hashcode = 0;
		for (char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
	}

	int converToIndex(int hashcode) {
		return hashcode % data.length;
	}

	// 인덱스로 배열방을 찾았는데 찾은 곳의 데이터가 여러개 존재하는 경우
	Node searchKey(LinkedList<Node> list, String key) {
		// 배열방이 null이면 null을 반환
		if (list == null)
			return null;
		for (Node node : list) {
			if (node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}

	void put(String key, String value) {
		int hashcode = getHashCode(key);
		int index = converToIndex(hashcode);// 배열방번호
		LinkedList<Node> list = data[index];
		if (list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}
		Node node = searchKey(list, key);
		if (node == null) {
			list.addLast(new Node(key, value));
		} else {
			node.value(value);
		}
	}

	// key를 가지고 value값을 반환
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = converToIndex(hashcode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list, key);
		return node == null ? "Not found" : node.value();
	}

}


