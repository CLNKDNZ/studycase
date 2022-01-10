package com.hpsiemlak.studycase;

import com.couchbase.client.java.Cluster;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DBSetupRunner implements CommandLineRunner {


    @Autowired
    private Cluster cluster;

    @Override
    public void run(String... args) throws InterruptedException {
//        Thread.sleep(62000);
        InititDatabase();
    }

    private final void InititDatabase() {

        try {
            cluster.queryIndexes().createPrimaryIndex("hepsiemlak");
            System.out.println("Created primary index hepsiemlak");
        } catch (Exception e) {
            System.out.println("Primary index already exists on bucket hepsiemlak");
            e.printStackTrace();
        }

    }


}
