package com.example.todolist;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TodolistApplicationTests {

    @Test
    void contextLoads() {
    }

    private static final String ALGORITHM = "PBEWithMD5AndDES";

    private StringEncryptor jasyptStringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("todo");
        config.setAlgorithm(ALGORITHM);
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    @Test
    void ut1001_stringEncryptor() throws Exception {
        final String source = "admin1234";
        StringEncryptor encryptor = jasyptStringEncryptor();
        System.out.println("ENC :" + encryptor.encrypt(source));
        assertEquals(source, encryptor.decrypt(encryptor.encrypt(source)));

        final String source2 = "admin";
        StringEncryptor encryptor2 = jasyptStringEncryptor();
        System.out.println("ENC :" + encryptor2.encrypt(source2));
        assertEquals(source2, encryptor2.decrypt(encryptor.encrypt(source2)));
    }
}
