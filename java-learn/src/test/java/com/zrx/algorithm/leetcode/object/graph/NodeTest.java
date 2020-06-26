package com.zrx.algorithm.leetcode.object.graph;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 图 测试
 */


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NodeTest {

    Node enter;
    List<Node> nodeList;

    @BeforeAll
    public void init() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.neighbors = List.of(n2, n3, n4);
        n2.neighbors = List.of(n1, n3);
        n3.neighbors = List.of(n1, n2, n4, n5);
        n4.neighbors = List.of(n1, n3);
        n5.neighbors = List.of(n3);

        enter = n1;
        nodeList = List.of(n1, n2, n3, n4, n5);
    }

    @AfterAll
    public void destroy() {
        enter = null;
        nodeList = null;
    }


    @Test
    public void ToStringTest() {
        nodeList.forEach(System.out::println);
    }

    @Test
    public void traversalBFSTest(){
        List<Node> nodes = Node.traversalBFS(enter);
        System.out.println("nodes = " + nodes);
    }

    @Test
    public void traversalDFSTest(){
        List<Node> nodes = Node.traversalDFS(enter);
        System.out.println("nodes = " + nodes);
    }
}