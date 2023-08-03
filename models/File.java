package com.dea.codingdojo.blogplatform.models;

import lombok.Data;

@Data
public class File {

    private Long id;
    private String fileName;
    private String fileType;
    private byte[] fileData;

}
