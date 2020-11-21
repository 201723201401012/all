package cc.insistor.controller;

import java.util.UUID;

/**
 * @author cc
 * 测试语句
 */
public class Main {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
    }

}
