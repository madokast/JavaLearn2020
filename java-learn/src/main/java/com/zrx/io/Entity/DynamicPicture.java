package com.zrx.io.Entity;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Description
 * 动态纯色图片
 * 宽度
 * 高度
 * rgb 表示的颜色
 * 或 color 表示的颜色
 * 图片文字 info
 * Data
 * 2020/5/30-17:11
 *
 * @author zrx
 * @version 1.0
 */


public class DynamicPicture {
    private final static Logger LOGGER = LoggerFactory.getLogger(DynamicPicture.class);

    public static final int WIDTH = 400;

    public static final int HEIGHT = 400;

    public static final Map<String, Color> COLORS = new HashMap<>();

    static {
        COLORS.put("white", Color.white);
        COLORS.put("black", Color.black);
        COLORS.put("blue", Color.blue);
        COLORS.put("green", Color.green);
        COLORS.put("yellow", Color.yellow);
        COLORS.put("orange", Color.orange);
        COLORS.put("pink", Color.pink);
        COLORS.put("red", Color.red);
    }

    /**
     * 宽度 像素
     */
    private Integer width;

    /**
     * 高度 像素
     */
    private Integer height;

    /**
     * rgb 背景颜色
     */
    private Integer r;

    /**
     * rgb 背景颜色
     */
    private Integer g;

    /**
     * rgb 背景颜色
     */
    private Integer b;

    /**
     * 颜色
     * 优先使用rgb颜色
     */
    private String color;

    /**
     * 图片文字 英文
     */
    private String info;



    /**
     * 计算属性
     * 返回图片背景颜色
     * 如果 rgb 颜色合法，则优先返回 rgb 颜色
     * 否则 如果 color 颜色合法，则返回 color 颜色
     * 否则 返回随机颜色
     *
     * @return 图片背景颜色
     */
    @NotNull
    public Color getBackgroundColor() {
        if (r != null && g != null && b != null) {
            if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                return new Color(r, g, b);
            } else {
                LOGGER.warn("图片rgb参数非法 r{} g{} b{}", r, g, b);
            }
        } else if (color != null) {
            String c = color.toLowerCase(Locale.ENGLISH);
            if (COLORS.containsKey(c)) {
                return COLORS.get(c);
            } else {
                LOGGER.warn("图片颜色非法 color={}", color);
            }
        }

        return new Color(
                ThreadLocalRandom.current().nextInt(255),
                ThreadLocalRandom.current().nextInt(255),
                ThreadLocalRandom.current().nextInt(255)
        );
    }

    @Override
    public String toString() {
        return "DynamicPicture{" +
                "width=" + width +
                ", height=" + height +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", color='" + color + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    @NotNull
    public Integer getWidth() {
        return width == null ? WIDTH : width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @NotNull
    public Integer getHeight() {
        return height == null ? HEIGHT : height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Deprecated
    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    @Deprecated
    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    @Deprecated
    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Deprecated
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
