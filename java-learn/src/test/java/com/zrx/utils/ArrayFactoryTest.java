package com.zrx.utils;

import com.zrx.algorithm.Equality;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryTest {

    @Test
    void createTwoDimensionsIntArray() {
        Assert.assertTrue(Equality.isEqual(
                ArrayFactory.createTwoDimensionsIntArray("""
                                    [[1,2],[3]]
                        """),
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3}
                }
        ));

        Assert.assertTrue(Equality.isEqual(
                ArrayFactory.createTwoDimensionsIntArray("""
                                    [
                                    [1,

                                    2]
                                    ,
                                    [3]
                                    ]

                        """),
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3}
                }
        ));
    }

    @Test
    void createIntArray() {
        Assert.assertArrayEquals(ArrayFactory.createIntArray("[1,2]"), new int[]{1, 2});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("[11,2]"), new int[]{11, 2});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("[1,22]"), new int[]{1, 22});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("[1]"), new int[]{1});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("[13]"), new int[]{13});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("[1,2,3,4,5]"), new int[]{1, 2, 3, 4, 5});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("[1,\n" +
                "2]"), new int[]{1, 2});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("\n[1,2]\n"), new int[]{1, 2});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("   [1\n\n,\n\n2]  \n "), new int[]{1, 2});
        Assert.assertArrayEquals(ArrayFactory.createIntArray("""
                [
                12
                ,
                43
                ,123
                ]
                """), new int[]{12, 43, 123});
    }
}