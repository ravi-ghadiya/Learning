package com.webster.springboot.documentmanagement.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Long id;

    @Column(name = "doc_name")
    private String docName;

    @Column(name = "doc_type")
    private String docType;

//    @Lob
//    private byte[] data;

    //TODO: string docPath;   --> /resource/document/filename


//    @NotEmpty
//    @Column(name = "download_path")
//    private String downloadPath;

    //    @ManyToOne
//    @JoinColumn(name = "fromuser_documents")
    @Column(name = "user_id")
    private Long userId;


//    @ManyToMany
//    private List<User> toUser;

    public Document() {
    }

    public Document(String docName, String docType, byte[] data) {
        this.docName = docName;
        this.docType = docType;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", docName='" + docName + '\'' +
                ", docType='" + docType + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
