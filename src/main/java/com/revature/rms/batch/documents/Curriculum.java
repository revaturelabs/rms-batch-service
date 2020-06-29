package com.revature.rms.batch.documents;

import com.revature.rms.core.exceptions.EnumMappingException;

import java.util.Arrays;

public enum Curriculum {

    JAVA_MSA("Full Stack Java/Angular with Microservices"),
    JAVA_REACT("Full Stack Java/React with Microservices"),
    JTA("Full Stack Java with Test Automation"),
    C_SHARP("C#"),
    PEGA("PEGA"),
    BIG_DATA("Big Data with Hadoop");

    private String curriculumName;

    Curriculum(String name) {
        this.curriculumName = name;
    }

    public static Curriculum findCurriculumByName(String name) {
        return Arrays.stream(Curriculum.values())
                .filter(curriculum -> curriculum.curriculumName.equals(name))
                .findFirst()
                .orElseThrow(EnumMappingException::new);
    }

}
